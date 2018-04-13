package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class mUsuario extends Sesion{
    Conexion con = new Conexion();
    
    public DefaultTableModel getVuelos() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        
        
        String fecha = fmt.format(date);
        String semana = String.valueOf(date.plusWeeks(1));
        
        DefaultTableModel modelo = new DefaultTableModel();
        Connection connection = null;
        
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT DISTINCT ciuOrigen, ciuDestino, Fecha, HoraSalida, vuelo.idVuelo, idAvion, Precio FROM vuelo, avion WHERE vuelo.Fecha Between"
                    + " '" + fecha + "' and '" + semana + "' AND vuelo.idVuelo = avion.idVuelo ORDER BY Fecha Asc;");
            ResultSetMetaData rSMd = rS.getMetaData();
            
            modelo.addColumn("Origen");
            modelo.addColumn("Destino");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora de salida");
            modelo.addColumn("ID");
            modelo.addColumn("idAvion");
            modelo.addColumn("Precio");
            
            while(rS.next()) {
                Object filas[] = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    if(i == 2) {
                        filas[i] = String.valueOf(rS.getObject(i + 1));
                    }
                    else
                        filas[i] = rS.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
            con.cerrarConexion(connection);
        } catch (SQLException ex) {
            Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
    
    public DefaultComboBoxModel getOrigenes() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Connection connection = null;
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT DISTINCT ciuDestino FROM vuelo ORDER BY ciuDestino Asc");
            model.addElement("Seleccionar...");
            while(rS.next()) {
                model.addElement(rS.getObject(1));
            }
            con.cerrarConexion(connection);
        } catch (SQLException ex) {
            Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel setVuelosCiudad(String ciudad, String fechas) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        
        String fecha = fmt.format(date);
        String rango = null;
        if(fechas == null || fechas.equals("Una semana")) {
            rango = String.valueOf(fmt.format(date.plusWeeks(1)));
        }
        else if(fechas.equals("Dos semanas")) {
            rango = String.valueOf(fmt.format(date.plusWeeks(2)));
        }
        else if(fechas.equals("Un mes")) {
            rango = String.valueOf(fmt.format(date.plusMonths(1)));
        }
        
        DefaultTableModel modelo = new DefaultTableModel();
        Connection connection = null;
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS;
            if(!ciudad.equals("Seleccionar...")) {
                rS = st.executeQuery("SELECT DISTINCT ciuOrigen, ciuDestino, Fecha, HoraSalida, vuelo.idVuelo, idAvion FROM vuelo, avion WHERE Fecha Between"
                        + " '" + fecha + "' and '" + rango + "' AND ciuDestino = '" + ciudad + "' AND vuelo.idVuelo = avion.idVuelo ORDER BY Fecha Asc;");
            }
            else {
                rS = st.executeQuery("SELECT DISTINCT ciuOrigen, ciuDestino, Fecha, HoraSalida, vuelo.idVuelo, idAvion FROM vuelo, avion WHERE Fecha Between"
                        + " '" + fecha + "' and '" + rango + "' AND vuelo.idVuelo = avion.idVuelo ORDER BY Fecha Asc;");
            }
            ResultSetMetaData rSMd = rS.getMetaData();
            modelo.addColumn("Origen");
            modelo.addColumn("Destino");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora de salida");
            modelo.addColumn("ID");
            modelo.addColumn("idAvion");
            while(rS.next()) {
                Object filas[] = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    if(i == 2) {
                        filas[i] = String.valueOf(rS.getObject(i + 1));
                    }
                    else
                        filas[i] = rS.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return modelo;
    }
    
    /**
     * 0: Nacionalidad
     * 1: Ciudad
     * 2: Contraseña
     * 3: Fecha de nacimiento
     * @param id id del usuario
     * @return Lista con la nacionalidad, la ciudad y la contraseña
     */
    public ArrayList<String> getDatosPerfil(int id) {
        Connection connection = null;
        ArrayList<String> datos = new ArrayList<>();
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT NacionalidadCli, CiudadCli, Contra, FechaNac FROM Cliente WHERE idCliente = " + id + ";");
            int x = 1;
            rS.next();
            while(x<5) {
                datos.add(String.valueOf(rS.getObject(x)));
                x++;
            }
            rS.first();
            try {
                ResultSet rS2 = st.executeQuery("SELECT Numero FROM tarjeta WHERE idCliente = " + id + ";");
                rS2.next();
                datos.add(String.valueOf(rS2.getObject(1)));
            }catch(SQLException ex) {
                con.cerrarConexion(connection);
                Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex);
                return datos;
            }
            System.out.println(datos);
            con.cerrarConexion(connection);
        }catch(SQLException ex) {
            Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion(connection);
        }
        return datos;
    }
    
    /**
     * Función para actualizar los datos en la ventana perfil
     * @param mod El dato a modificar
     * @param dato 1 para modificar la ciudad. 2 para modificar el correo. 3 para modificar la contraseña
     * @param id El id del usuario
     * @return 1 si se completó con éxito, 0 si no
     */
    public int cambiarDatos(String mod, int dato, int id) {
        Connection connection = null;
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            if(dato == 1) {
                st.executeUpdate("UPDATE Cliente SET CiudadCli = '" + mod +"' WHERE idCliente = " + id + ";");
            }
            else if(dato == 2) {
                st.executeUpdate("UPDATE Cliente SET Usuario = '" + mod + "' WHERE idCliente = " + id + ";");
            }
            else {
                st.executeUpdate("UPDATE Cliente SET Contra = '" + mod + "' WHERE idCliente = " + id + ";");
            }
            con.cerrarConexion(connection);
        }catch(SQLException ex) {
           Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex); 
           return 0;
        }finally {
            con.cerrarConexion(connection);
        }
        return 1;
    }
}
