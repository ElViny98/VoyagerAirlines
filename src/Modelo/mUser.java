/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Conexion;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author David
 */
public class mUser {
    private Conexion miConexion = new Conexion();
    
    public boolean usuarioAgregar(String NombreCli, String NacionalidadCli, String CiudadCli, String FechaNac, String Usuario, String Contra, int Tipo)
    {
        LocalDate fechaNac, ahora;
        Period periodo = null;
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
            fechaNac = LocalDate.parse(FechaNac, fmt);
            ahora = LocalDate.now();

            periodo = Period.between(fechaNac, ahora);
            
        } catch (DateTimeParseException e) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
            fechaNac = LocalDate.parse(FechaNac, fmt);
            ahora = LocalDate.now();

            periodo = Period.between(fechaNac, ahora);
        }
        
        int edad = periodo.getYears();
        
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "INSERT INTO cliente (NombreCli, NacionalidadCli, CiudadCli, FechaNac, Edad, Usuario, Contra, Tipo) "
                    + "values('"+NombreCli+"', '"+NacionalidadCli+"', '"+CiudadCli+"', '"+fechaNac+"', "+edad+", '"+Usuario+"', '"+Contra+"', "+Tipo+");");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
    }
    
}
