/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author David
 */
public class mVuelos {
    private Conexion miConexion = new Conexion();
    
    public boolean vueloAgregar(String CiuOrigen, String CiuDestino, int idEscalas, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada)
    {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "insert into vuelo(CiuOrigen, CiuDestino, idEscalas, idTripulacion, Fecha, HoraSalida, HoraLlegada) "
                    + "values ("+CiuOrigen+", '"+CiuDestino+"', '"+idEscalas+"', '"+idTripulacion+"', '"+Fecha+"', '"+HoraSalida+"', '"+HoraLlegada+"');");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
}
