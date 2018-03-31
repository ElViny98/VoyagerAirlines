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
public class mVuelos {
    private Conexion miConexion = new Conexion();
    
    public boolean vueloAgregar(String CiuOrigen, String CiuDestino, String Escala, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada) //String CiuOrigen, String CiuDestino, int idEscalas, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada
    {
//        System.out.println("CiuOrigen"+CiuOrigen);
//        System.out.println("CiuDestino"+CiuDestino);
//        System.out.println("idEscalas"+idEscalas);
//        System.out.println("idTripulacion"+idTripulacion);
//        System.out.println("Fecha"+Fecha);
//        System.out.println("HoraSalida"+HoraSalida);
//        System.out.println("HoraLlegada"+HoraLlegada);

        agregarEscala(Escala);
        int idEscalas = ultimaEscala();
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO vuelo (CiuOrigen, CiuDestino, idEscalas, idTripulacion, Fecha, HoraSalida, HoraLlegada) values('"+CiuOrigen+"', '"+CiuDestino+"', "+idEscalas+", "+idTripulacion+", '"+Fecha+"', '"+HoraSalida+"', '"+HoraLlegada+"');");
            miConexion.cerrarConexion(con);
            System.out.println("Agregado");
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
        //System.out.println("Entrar");
        //return true;
    }
    //===Para agregar la escala a la BD===//
    public void agregarEscala(String nombreEscala){
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO escalas (Ciudad) values('"+nombreEscala+"');");
            miConexion.cerrarConexion(con);
            System.out.println("Escala agregada");
        } catch (SQLException ex) {
            System.out.println("Escala no agregada");
        }
    }
    //===Para elegir la última escala agregada===//
    public int ultimaEscala(){
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM escalas ORDER BY idEscalas DESC LIMIT 1;");
            
            while (resultado.next()) {                    
                Object fila = new Object();
                int id = 0;
                id = resultado.getInt(1);
                System.out.println("Valor de id: "+id);
                return id;
            }
        } catch (SQLException ex) {
            System.out.println("Ocurre error");
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Llega al final");
        return 0;
    }
    /*
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
                ResultSet resultado = s.executeQuery("select idUsuario as ID, nomUsuario as Nombre, clave as Password from usuarios order by nomUsuario;");
                
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
    */
}
