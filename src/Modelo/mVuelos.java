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
    
    public boolean vueloAgregar(String CiuOrigen, String CiuDestino, int idEscalas, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada) //String CiuOrigen, String CiuDestino, int idEscalas, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada
    {
        System.out.println("CiuOrigen"+CiuOrigen);
        System.out.println("CiuDestino"+CiuDestino);
        System.out.println("idEscalas"+idEscalas);
        System.out.println("idTripulacion"+idTripulacion);
        System.out.println("Fecha"+Fecha);
        System.out.println("HoraSalida"+HoraSalida);
        System.out.println("HoraLlegada"+HoraLlegada);
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
    
}
