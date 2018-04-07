/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
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
    
    private Conexion miConexion = new Conexion();
    
    public DefaultTableModel vuelosConsulta() {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("select idVuelo as Número, CiuOrigen as Origen, CiuDestino as Destino from vuelo;");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                //--- Establecer como cabeceras el nombre de las columnas ---//
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(resultadoMd.getColumnLabel(i));
                }
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                //modelo.isCellEditable(cantidadColumnas, cantidadColumnas)
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel vuelosConsultaBuscar(String palabra) {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("select idVuelo as Número, CiuOrigen as Origen, CiuDestino as Destino from vuelo where CiuOrigen LIKE '%"+palabra+"%' OR CiuDestino LIKE '%"+palabra+"%';");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                //--- Establecer como cabeceras el nombre de las columnas ---//
                for (int i = 1; i <= cantidadColumnas; i++) {
                    modelo.addColumn(resultadoMd.getColumnLabel(i));
                }
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    modelo.addRow(fila);
                }
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
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
    
    public DefaultTableModel tripulacionConsulta() {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("select idTripulacion, Puesto, Nombre, idVuelo, numTripulacion from tripulacion order by idTripulacion;");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Código");
                modelo.addColumn("Puesto");
                modelo.addColumn("Nombre");
                modelo.addColumn("No. vuelo");
                modelo.addColumn("No. tripulación");
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    
                    int tripulacion = Integer.parseInt(fila[4].toString());
                    if(tripulacion < 1)
                        fila[4] = "Sin tripulación";
                    
                    int vuelo = Integer.parseInt(fila[3].toString());
                    if(vuelo < 1)
                        fila[3] = "Sin vuelo";
                    
                    modelo.addRow(fila);
                }
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel tripulacionConsultaPrecisa(String palabra) {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("select idTripulacion, Puesto, Nombre, idVuelo, numTripulacion from tripulacion where Puesto = '"+palabra+"' order by idTripulacion;");
                if(palabra.equals("Azafata(o)")){
                    resultado = s.executeQuery("select idTripulacion, Puesto, Nombre, idVuelo, numTripulacion from tripulacion where Puesto = '"+palabra+"' OR Puesto =  'Azafata' order by idTripulacion;");
                }
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Código");
                modelo.addColumn("Puesto");
                modelo.addColumn("Nombre");
                modelo.addColumn("No. vuelo");
                modelo.addColumn("No. tripulación");
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    
                    int tripulacion = Integer.parseInt(fila[4].toString());
                    if(tripulacion < 1)
                        fila[4] = "Sin tripulación";
                    
                    int vuelo = Integer.parseInt(fila[3].toString());
                    if(vuelo < 1)
                        fila[3] = "Sin vuelo";
                    
                    modelo.addRow(fila);
                }
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel tripulacionConsultaBuscar(String palabra) {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("select idTripulacion, Puesto, Nombre, idVuelo, numTripulacion from tripulacion "
                        + "where Nombre LIKE '%"+palabra+"%';");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Código");
                modelo.addColumn("Puesto");
                modelo.addColumn("Nombre");
                modelo.addColumn("No. vuelo");
                modelo.addColumn("No. tripulación");
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    
                    int tripulacion = Integer.parseInt(fila[4].toString());
                    if(tripulacion < 1)
                        fila[4] = "Sin tripulación";
                    int vuelo = Integer.parseInt(fila[3].toString());
                    if(vuelo < 1)
                        fila[3] = "Sin vuelo";
                    
                    modelo.addRow(fila);
                }
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel usuariosConsulta() {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                //=============================================================================================================LUEGO LO CAMBIO POR TIPO > 1======================//
                ResultSet resultado = s.executeQuery("select idCliente, NombreCli, CiudadCli, NacionalidadCli, Tipo from cliente where Tipo > 0 order by idCliente;");//Cambiar por NombreCli
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Código");
                modelo.addColumn("Nombre");
                modelo.addColumn("Ciudad");
                modelo.addColumn("Nacionalidad");
                modelo.addColumn("Tipo");
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    
                    int tipo = Integer.parseInt(fila[4].toString());
                    switch(tipo){
                        case 2:
                            fila[4] = "Trabajador";
                            break;
                        case 3:
                            fila[4] = "Cliente";
                            break;
                    }
                    
                    modelo.addRow(fila);
                }
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel usuariosConsultaPrecisa(int tipo) {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("select idCliente, NombreCli, CiudadCli, NacionalidadCli, Tipo from cliente where Tipo = "+tipo+" order by idCliente;");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Código");
                modelo.addColumn("Nombre");
                modelo.addColumn("Ciudad");
                modelo.addColumn("Nacionalidad");
                modelo.addColumn("Tipo");
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    
                    switch(tipo){
                        case 2:
                            fila[4] = "Trabajador";
                            break;
                        case 3:
                            fila[4] = "Cliente";
                            break;
                    }
                    
                    modelo.addRow(fila);
                }
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel usuariosConsultaBuscar(String palabra) {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("select idCliente, NombreCli, CiudadCli, NacionalidadCli, Tipo from cliente "
                        + "where NombreCli LIKE '%"+palabra+"%' order by idCliente;");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                modelo.addColumn("Código");
                modelo.addColumn("Nombre");
                modelo.addColumn("Ciudad");
                modelo.addColumn("Nacionalidad");
                modelo.addColumn("Tipo");
                
                //--- Creando las filas para el JTable ---//
                while (resultado.next()) {                    
                    Object[] fila = new Object[cantidadColumnas];
                    for (int i = 0; i < cantidadColumnas; i++) {
                        fila[i] = resultado.getObject(i+1);
                    }
                    
                    int tipo = Integer.parseInt(fila[4].toString());
                    switch(tipo){
                        case 2:
                            fila[4] = "Trabajador";
                            break;
                        case 3:
                            fila[4] = "Cliente";
                            break;
                    }
                    
                    modelo.addRow(fila);
                }
                return modelo;
                
            } finally {
                //--- Cerrar objeto de ResultSet ---//
                miConexion.cerrarConexion(con);
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel VentasConsulta() {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT v.`idVenta`, c.`NombreCli`, vu.`CiuOrigen`, vu.`CiuDestino`, v.`Total` "
                    + "FROM ventas v "
                    + "INNER JOIN cliente c ON v.`idCliente` = c.`idCliente` "
                    + "INNER JOIN boleto b ON b.`NumBoleto` = v.`NumBoleto` "
                    + "INNER JOIN vuelo vu ON vu.`idVuelo` = b.`idVuelo`;");
            ResultSetMetaData rSMd = rS.getMetaData();
            
              model.addColumn("#");
              model.addColumn("Nombre");
              model.addColumn("Vuelo origen");
              model.addColumn("Vuelo destino");
              model.addColumn("Total ($MXN)");
            
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
    
    public DefaultTableModel VentasConsultaPrecisa(String palabra) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT v.`idVenta`, c.`NombreCli`, vu.`CiuOrigen`, vu.`CiuDestino`, v.`Total` "
                    + "FROM ventas v "
                    + "INNER JOIN cliente c ON v.`idCliente` = c.`idCliente` "
                    + "INNER JOIN boleto b ON b.`NumBoleto` = v.`NumBoleto` "
                    + "INNER JOIN vuelo vu ON vu.`idVuelo` = b.`idVuelo` "
                    + "WHERE v.`MetodoPago` = '"+palabra+"';");
            ResultSetMetaData rSMd = rS.getMetaData();
            
              model.addColumn("#");
              model.addColumn("Nombre");
              model.addColumn("Vuelo origen");
              model.addColumn("Vuelo destino");
              model.addColumn("Total ($MXN)");
            
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
    
    public DefaultTableModel VentasConsultaBuscar(String palabra) {
        DefaultTableModel model = new DefaultTableModel();
        Connection connection = null;
        try {
            connection = miConexion.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT v.`idVenta`, c.`NombreCli`, vu.`CiuOrigen`, vu.`CiuDestino`, v.`Total` "
                    + "FROM ventas v "
                    + "INNER JOIN cliente c ON v.`idCliente` = c.`idCliente` "
                    + "INNER JOIN boleto b ON b.`NumBoleto` = v.`NumBoleto` "
                    + "INNER JOIN vuelo vu ON vu.`idVuelo` = b.`idVuelo` "
                    + "WHERE c.`NombreCli` LIKE '%"+palabra+"%';");
            ResultSetMetaData rSMd = rS.getMetaData();
            
              model.addColumn("#");
              model.addColumn("Nombre");
              model.addColumn("Vuelo origen");
              model.addColumn("Vuelo destino");
              model.addColumn("Total ($MXN)");
            
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
     * @return Arreglo de nombres de asientos
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
