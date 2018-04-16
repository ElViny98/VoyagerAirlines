/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class mAdmin {
    
    private final Conexion miConexion = new Conexion();
    
    public DefaultTableModel vuelosConsulta(String condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            if(condicion.equals("")){
                rS = st.executeQuery("SELECT v.`idVuelo`, CONCAT(v.`CiuOrigen`, ' - ', v.`CiuDestino`), v.`Fecha`, v.`HoraSalida` "
                    + "FROM vuelo v;");
            }
            else{
                rS = st.executeQuery("SELECT v.`idVuelo`, CONCAT(v.`CiuOrigen`, ' - ', v.`CiuDestino`), v.`Fecha`, v.`HoraSalida` "
                    + "FROM vuelo v "
                    + "WHERE v.`CiuOrigen` LIKE '%"+condicion+"%' || v.`CiuDestino` LIKE '%"+condicion+"%';");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("#");
            model.addColumn("Vuelo");
            model.addColumn("Fecha");
            model.addColumn("Hora de salida");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public DefaultTableModel tablaAviones() {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT * FROM avion");
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Id");
            model.addColumn("Capacidad");
            model.addColumn("Estado");
            model.addColumn("Nombre avión");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                int estado = Integer.parseInt(x[2].toString());
                switch (estado) {
                    case 1:
                        x[2] = "Listo";
                        break;
                        
                    case 2:
                        x[2] = "En vuelo";
                        break;
                        
                    case 3:
                        x[2] = "Fuera de servicio";
                        break;
                        
                    default:
                        break;
                }
                
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public DefaultTableModel tripulacionConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            //Si el arreglo está vacío//
            if(condicion[0].equals("") && condicion[1].equals("")){
                rS = st.executeQuery("SELECT * "
                    + "FROM tripulacion t;");
            }
            //Si al menos una posición del arreglo tiene algo//
            else{
                //Si las dos posiciones tienen algo//
                if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "t.`Nombre` LIKE '%"+condicion[1]+"%' && t.`Puesto` = '"+condicion[0]+"'";
                }
                //Si la primera posición no está vacía//
                else if(!condicion[1].equals("")){
                    condicionFinal = "t.`Nombre` LIKE '%"+condicion[1]+"%'";
                }
                //Si la segunda posición no está vacía//
                else if(!condicion[0].equals("")){
                    condicionFinal = "t.`Puesto` = '"+condicion[0]+"'";
                }
                rS = st.executeQuery("SELECT * "
                    + "FROM tripulacion t "
                    + "WHERE "+condicionFinal+";");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Código");
            model.addColumn("Nombre");
            model.addColumn("Puesto");
            model.addColumn("No. vuelo");
            model.addColumn("No. tripulación");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public DefaultTableModel usuariosConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            //Si el arreglo está vacío//
            if(condicion[0].equals("") && condicion[1].equals("")){
                rS = st.executeQuery("SELECT idCliente, NombreCli, CiudadCli, NacionalidadCli, Tipo "
                    + "FROM cliente "
                    + "WHERE Tipo > 0 "
                    + "ORDER BY idCliente;");
            }
            //Si al menos una posición del arreglo tiene algo//
            else{
                //Si las dos posiciones tienen algo//
                if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "`NombreCli` LIKE '%"+condicion[1]+"%' && `Tipo` = "+Integer.parseInt(condicion[0])+"";
                }
                //Si la primera posición no está vacía//
                else if(!condicion[1].equals("")){
                    condicionFinal = "`NombreCli` LIKE '%"+condicion[1]+"%'";
                }
                //Si la segunda posición no está vacía//
                else if(!condicion[0].equals("")){
                    condicionFinal = "`Tipo` = "+Integer.parseInt(condicion[0])+"";
                }
                rS = st.executeQuery("SELECT idCliente, NombreCli, CiudadCli, NacionalidadCli, Tipo "
                    + "FROM cliente "
                    + "WHERE "+condicionFinal+" "
                    + "ORDER BY idCliente;");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("Código");
            model.addColumn("Nombre");
            model.addColumn("Ciudad");
            model.addColumn("Nacionalidad");
            model.addColumn("Tipo");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public DefaultTableModel VentasConsulta(String[] condicion) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        String condicionFinal = "";
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = null;
            //Si el arreglo está vacío//
            if(condicion[0].equals("") && condicion[1].equals("")){
                rS = st.executeQuery("SELECT v.`idVenta`, c.`NombreCli`, CONCAT(vu.`CiuOrigen`, ' - ', vu.`CiuDestino`), v.`Total`, v.`fecha` "
                    + "FROM ventas v "
                    + "INNER JOIN cliente c ON v.`idCliente` = c.`idCliente` "
                    + "INNER JOIN vuelo vu ON vu.`idVuelo` = b.`idVuelo`;");
            }
            //Si al menos una posición del arreglo tiene algo//
            else{
                //Si las dos posiciones tienen algo//
                if(!condicion[0].equals("") && !condicion[1].equals("")){
                    condicionFinal = "c.`NombreCli` LIKE '%"+condicion[1]+"%' && v.`MetodoPago` = '"+condicion[0]+"'";
                }
                //Si la primera posición no está vacía//
                else if(!condicion[1].equals("")){
                    condicionFinal = "c.`NombreCli` LIKE '%"+condicion[1]+"%'";
                }
                //Si la segunda posición no está vacía//
                else if(!condicion[0].equals("")){
                    condicionFinal = "v.`MetodoPago` = '"+condicion[0]+"'";
                }
                rS = st.executeQuery("SELECT v.`idVenta`, c.`NombreCli`, CONCAT(vu.`CiuOrigen`, ' - ', vu.`CiuDestino`), v.`Total`, v.`fecha` "
                    + "FROM ventas v "
                    + "INNER JOIN cliente c ON v.`idCliente` = c.`idCliente` "
                    + "INNER JOIN boleto b ON b.`NumBoleto` = v.`NumBoleto` "
                    + "INNER JOIN vuelo vu ON vu.`idVuelo` = b.`idVuelo` "
                    + "WHERE "+condicionFinal+";");
            }
            
            ResultSetMetaData rSMd = rS.getMetaData();
            
            model.addColumn("#");
            model.addColumn("Nombre");
            model.addColumn("Vuelo");
            model.addColumn("$MXN$");
            model.addColumn("Fecha");
            
            while(rS.next()) {
                Object[] x = new Object[rSMd.getColumnCount()];
                for(int i=0; i<rSMd.getColumnCount(); i++) {
                    x[i] = rS.getObject(i + 1);
                }
                model.addRow(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return model;
    }
    
    public String[] bestVentas() {
        String[] ventas = new String[6];
        String CiuDestino = "", cantidad = "";
        Connection connection = null;
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet resultado = st.executeQuery("SELECT vu.`CiuDestino`, COUNT(vu.`CiuDestino`) AS cantidad "
                    + "FROM ventas v "
                    + "INNER JOIN boleto b ON b.`NumBoleto` = v.`NumBoleto` "
                    + "INNER JOIN vuelo vu ON b.`idVuelo` = vu.`idVuelo` "
                    + "WHERE vu.`CiuOrigen` LIKE '%Mazatlán%' "
                    + "GROUP BY vu.`CiuDestino` "
                    + "ORDER BY cantidad DESC, vu.`CiuDestino` ASC "
                    + "LIMIT 3;");
            
            if(resultado.next()){
                ventas[0] = resultado.getString("CiuDestino");
                ventas[1] = resultado.getString("cantidad");
                if(resultado.next()){
                    ventas[2] = resultado.getString("CiuDestino");
                    ventas[3] = resultado.getString("cantidad");
                    if(resultado.next()){
                        ventas[4] = resultado.getString("CiuDestino");
                        ventas[5] = resultado.getString("cantidad");
                    }
                    else{
                        for (int i = 4; i < 6; i++) 
                            ventas[i] = "";
                    }
                }
                else{
                    for (int i = 2; i < 6; i++) 
                        ventas[i] = "";
                }
            }
            else{
                for (int i = 0; i < 6; i++) 
                    ventas[i] = "";
            }
            
            return ventas;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            miConexion.cerrarConexion(connection);
        }
        return ventas;
    }
    
    /**
     * Consulta los asientos
     * @param idVuelo El id del vuelo para los asientos
     * @return Pila de nombres de asientos
     */
    public Stack<String> consultarAsientos(int idVuelo) {
        String result[] = null;
        Stack<String> resultados = new Stack<>();
        try {
            Connection connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT Asiento FROM boleto WHERE idVuelo = " + idVuelo);
            ResultSetMetaData rSMd = rS.getMetaData();
            result = new String[rSMd.getColumnCount() + 1];
            int x = 1;
            while(rS.next()) {
                resultados.push(String.valueOf(rS.getObject(1)));
                x++;
            }
            miConexion.cerrarConexion(connection);
            return resultados;
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultados;
    }
    
    public String getNombreCliente(String asiento, int idVuelo) {
        try {
            Connection connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT DISTINCT nombreCli FROM Cliente, Boleto WHERE"
                    + " boleto.idVuelo = " + idVuelo + " AND boleto.Asiento = '" + asiento + "'"
                            + " AND boleto.idCliente = Cliente.idCliente;");
            rS.next();
            return String.valueOf(rS.getObject(1));
        } catch (SQLException ex) {
            Logger.getLogger(mAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
