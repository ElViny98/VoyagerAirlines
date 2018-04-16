/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Bryan
 */
public class mVentas extends Sesion{
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
            ResultSet rS = st.executeQuery("SELECT idVuelo, ciuOrigen, ciuDestino, Fecha, HoraSalida, Precio FROM vuelo WHERE Fecha >="
                    + " '" + fecha + "' ORDER BY Fecha Asc;");
            ResultSetMetaData rSMd = rS.getMetaData();
            
            modelo.addColumn("ID");
            modelo.addColumn("Origen");
            modelo.addColumn("Destino");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora de salida");
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
            ResultSet rS = st.executeQuery("SELECT DISTINCT CiuOrigen FROM vuelo ORDER BY CiuOrigen Asc");
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
    
    public DefaultComboBoxModel getDestinos() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        Connection connection = null;
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT DISTINCT CiuDestino FROM vuelo ORDER BY CiuDestino Asc");
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
        
    public DefaultTableModel getVuelosCompraR(String fechaida, String cuiOrigen, String ciuDestino) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        
        
        String fecha = fmt.format(date);
        String semana = String.valueOf(date.plusWeeks(1));
        
        DefaultTableModel modelo = new DefaultTableModel();
        Connection connection = null;
        
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT idVuelo, ciuOrigen, ciuDestino, Fecha, HoraSalida FROM vuelo WHERE Fecha ="
                    + " '" + fechaida + "' " + "AND " + "ciuOrigen=" + " '" + cuiOrigen + "' " + "AND " + "ciuDestino=" + " '" + ciuDestino + "' ORDER BY Fecha Asc;");
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            modelo.addColumn("ID");
            modelo.addColumn("Origen");
            modelo.addColumn("Destino");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora de salida"); 
 
                
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
    
    public DefaultTableModel getVuelosCompraRRegreso(String fechaRegreso, String cuiOrigen, String ciuDestino) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        
        
        String fecha = fmt.format(date);
        String semana = String.valueOf(date.plusWeeks(1));
        
        DefaultTableModel modelo = new DefaultTableModel();
        Connection connection = null;
        
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT idVuelo, ciuOrigen, ciuDestino, Fecha, HoraSalida FROM vuelo WHERE Fecha ="
                    + " '" + fechaRegreso + "' " + "AND " + "ciuOrigen=" + " '" + ciuDestino + "' " + "AND " + "ciuDestino=" + " '" + cuiOrigen + "' ORDER BY Fecha Asc;");
            
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            modelo.addColumn("ID");
            modelo.addColumn("Origen");
            modelo.addColumn("Destino");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora de salida"); 
 
                
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
    
    public void IngresarBoletos(String nombreEscala){
        try {
            //--- Abriendo la base de datos ---//
            Connection conex = con.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = conex.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO escalas (Ciudad) values('"+nombreEscala+"');");
            con.cerrarConexion(conex);
        } catch (SQLException ex) {
            System.out.println("Escala no agregada");
        }
    }
    
    public int reservarBoleto(int idVuelo, int idCliente, int idVenta, ArrayList<String> asientos) {
        Connection connection;
        String sqlInsert = "INSERT INTO boleto VALUES("
                + idVuelo + ", " + idCliente + ", null, '"
                + asientos.get(0) + "', 0, " + idVenta + ")";
        
        for(int i = 1; i<asientos.size(); i++) {
            sqlInsert = sqlInsert + ", (" + idVuelo + ", " + idCliente + ", null, '"
                    + asientos.get(i) + "', 0, " + idVenta + ")";
        }
        
        sqlInsert = sqlInsert + ";";
        System.out.println(sqlInsert);
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            st.executeUpdate(sqlInsert);
        } catch (SQLException ex) {
            Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
        
    }
    
    /**
     * 
     * @param total cantidad a pagar
     * @param idCliente id del cliente
     * @param tipoPago Efectivo o con tarjeta
     * @return >1 si la operación se realizó con éxito
     */
    public int realizarCompra(double total, int idCliente, int tipoPago) {
        Connection connection;
        int nextId = 0;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        String tipo;
        if(tipoPago == 1)
            tipo = "Tarjeta";
        else
            tipo = "Efectivo";
        
        String fecha = fmt.format(date);
        try {
            connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'voyager' AND TABLE_NAME = 'ventas';");
            rS.next();
            nextId = Integer.parseInt(String.valueOf(rS.getObject(1)));
            st.execute("INSERT INTO ventas VALUES (null, '" + tipo + "', " + total + ", " + idCliente + ", '" + fecha + "');");
        } catch (SQLException ex) {
            Logger.getLogger(mUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return nextId;
    }
}
