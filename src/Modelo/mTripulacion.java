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
public class mTripulacion {
    private Conexion miConexion = new Conexion();
    
    public boolean tripulacionAgregar(String Nombre, String Puesto, int numTripulacion)
    {   
        int idVuelo = consultaVueloTripulacion(numTripulacion);
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO tripulacion (Nombre, Puesto, idVuelo, numTripulacion) values('"+Nombre+"', '"+Puesto+"', "+idVuelo+", "+numTripulacion+");");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
    }
    
    public int consultaVueloTripulacion(int idBuscar){
        int idVuelo = 0;
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM tripulacion WHERE numTripulacion = "+idBuscar+" && idVuelo > 0;");
            
            if(resultado.next())
                idVuelo = resultado.getInt("idVuelo");
            else
                idVuelo = 0;
            
            return idVuelo;
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idVuelo;
    }
    
    public String[] consultaTripulacionEspecifico(int idBuscar){
        String[] datos = new String[5];
        String idTripulacion = "", Nombre = "", Puesto = "", idVuelo = "", numTripulacion = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM tripulacion WHERE idTripulacion = "+idBuscar+";");
            
            resultado.next();
            
            idTripulacion = resultado.getString("idTripulacion");
            Nombre = resultado.getString("Nombre");
            Puesto = resultado.getString("Puesto");
            idVuelo = resultado.getString("idVuelo");
            numTripulacion = resultado.getString("numTripulacion");
            
            datos[0] = idTripulacion;
            datos[1] = Nombre;
            datos[2] = Puesto;
            datos[3] = idVuelo;
            datos[4] = numTripulacion;
            
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    //===Para editar miembro de tripulación específico===//
    public boolean editarTripulacion(int idTripulacion, String Nombre, String Puesto, int numTripulacion){
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update tripulacion set Nombre = '"+Nombre+"', Puesto = '"+Puesto+"', numTripulacion = '"+numTripulacion+"'"
                    + "where idTripulacion = "+idTripulacion+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean tripulacionEliminar(int idTripulacion)
    {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from tripulacion where idTripulacion = "+idTripulacion+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
