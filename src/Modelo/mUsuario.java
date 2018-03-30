package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            ResultSet rS = st.executeQuery("SELECT ciuOrigen, ciuDestino, Fecha, HoraSalida, idVuelo FROM vuelo WHERE Fecha Between"
                    + " '" + fecha + "' and '" + semana + "' ORDER BY Fecha Asc;");
            ResultSetMetaData rSMd = rS.getMetaData();
            
            modelo.addColumn("Origen");
            modelo.addColumn("Destino");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora de salida");
            modelo.addColumn("ID");
            
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
                rS = st.executeQuery("SELECT ciuOrigen, ciuDestino, Fecha, HoraSalida, idVuelo FROM vuelo WHERE Fecha Between"
                        + " '" + fecha + "' and '" + rango + "' AND ciuDestino = '" + ciudad + "' ORDER BY Fecha Asc;");
            }
            else {
                rS = st.executeQuery("SELECT ciuOrigen, ciuDestino, Fecha, HoraSalida, idVuelo FROM vuelo WHERE Fecha Between"
                        + " '" + fecha + "' and '" + rango + "' ORDER BY Fecha Asc;");
            }
            ResultSetMetaData rSMd = rS.getMetaData();
            modelo.addColumn("Origen");
            modelo.addColumn("Destino");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora de salida");
            modelo.addColumn("ID");
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
}
