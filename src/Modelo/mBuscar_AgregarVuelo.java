/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class mBuscar_AgregarVuelo {
    private Conexion miConexion = new Conexion();
    
    public DefaultTableModel avionConsulta() {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("SELECT idAvion FROM avion ORDER BY idAvion ASC;");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                //--- Establecer como cabeceras el nombre de las columnas ---//
                modelo.addColumn("No. de avión");
                
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
    
    public DefaultTableModel datosAvionConsulta(int idAvion) {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("SELECT NombreAvion, Capacidad FROM avion WHERE idAvion = "+idAvion+";");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                //--- Establecer como cabeceras el nombre de las columnas ---//
                modelo.addColumn("Nombre de avión");
                modelo.addColumn("Capacidad");
                
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
                ResultSet resultado = s.executeQuery("SELECT DISTINCT numTripulacion FROM tripulacion ");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                //--- Establecer como cabeceras el nombre de las columnas ---//
                modelo.addColumn("No. de tripulación");
                
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
    
    public DefaultTableModel datosTripulacionConsulta(int numTripulacion) {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Generar consultas ---//
            Statement s = con.createStatement();
            //--- Establecer el modelo a la JTable ---//
            DefaultTableModel modelo;
            try {
                //--- Ejecutar la consulta ---//
                ResultSet resultado = s.executeQuery("SELECT Puesto, Nombre FROM tripulacion  WHERE numTripulacion="+numTripulacion+" ORDER BY Puesto DESC;");
                
                //--- Establecer el modelo a la JTable ---//
                modelo = new DefaultTableModel();
                
                //--- Obteniendo la información de las columnas que están siendo consultadas ---//
                ResultSetMetaData resultadoMd = resultado.getMetaData();
                
                //--- La cantidad de columnas que tiene la consulta ---//
                int cantidadColumnas = resultadoMd.getColumnCount();
                
                //--- Establecer como cabeceras el nombre de las columnas ---//
                modelo.addColumn("Puesto");
                modelo.addColumn("Nombre");
                
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
}
