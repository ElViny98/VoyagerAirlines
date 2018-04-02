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
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //===Para elegir el vuelo que se va a editar===//
    public String[] consultaVueloEspecifico(int idBuscar){
        String[] datos = new String[8];
        String idVuelo, CiuOrigen, CiuDestino, idEscalas, idTripulacion, Fecha, HoraSalida, HoraLlegada;
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM vuelo WHERE idVuelo = "+idBuscar+";");
            
            resultado.next();
            
            idVuelo = resultado.getString("idVuelo");
            CiuOrigen = resultado.getString("CiuOrigen");
            CiuDestino = resultado.getString("CiuDestino");
            idEscalas = resultado.getString("idEscalas");
            idTripulacion = resultado.getString("idTripulacion");
            Fecha = resultado.getString("Fecha");
            HoraSalida = resultado.getString("HoraSalida");
            HoraLlegada = resultado.getString("HoraLlegada");

            datos[0] = idVuelo;
            datos[1] = CiuOrigen;
            datos[2] = CiuDestino;
            datos[3] = idEscalas;
            datos[4] = idTripulacion;
            datos[5] = Fecha;
            datos[6] = HoraSalida;
            datos[7] = HoraLlegada;
            for (int i = 0; i < 8; i++) {
                System.out.println("datos: "+datos[i]);
            }
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
}
