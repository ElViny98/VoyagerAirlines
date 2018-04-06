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
    
    public boolean editarUsuario(int idCliente, String NombreCli, String NacionalidadCli, String CiudadCli, String FechaNac, String Usuario, String Contra, int Tipo){
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
            "update cliente set NombreCli = '"+NombreCli+"', NacionalidadCli = '"+NacionalidadCli+"', CiudadCli = '"+CiudadCli+"', FechaNac = '"+fechaNac+"', Edad = "+edad+", Usuario = '"+Usuario+"', Contra = '"+Contra+"', Tipo = "+Tipo
                    + " where idCliente = "+idCliente+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            System.out.println("No agregado");
            return false;
        }
    }
    
    public String[] consultaUsuarioEspecifico(int idBuscar){
        String[] datos = new String[9];
        String idCliente = "", NombreCli = "", NacionalidadCli = "", CiudadCli = "", FechaNac = "", Edad = "", Usuario = "", Contra = "", Tipo = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM cliente WHERE idCliente = "+idBuscar+";");
            
            resultado.next();
            
            idCliente = resultado.getString("idCliente");
            NombreCli = resultado.getString("NombreCli");
            NacionalidadCli = resultado.getString("NacionalidadCli");
            CiudadCli = resultado.getString("CiudadCli");
            FechaNac = resultado.getString("FechaNac");
            Edad = resultado.getString("Edad");
            Usuario = resultado.getString("Usuario");
            Contra = resultado.getString("Contra");
            Tipo = resultado.getString("Tipo");
            
            datos[0] = idCliente;
            datos[1] = NombreCli;
            datos[2] = NacionalidadCli;
            datos[3] = CiudadCli;
            datos[4] = FechaNac;
            datos[5] = Edad;
            datos[6] = Usuario;
            datos[7] = Contra;
            datos[8] = Tipo;
            
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public boolean eliminarUsuario(int idCliente)
    {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from cliente where idCliente = "+idCliente+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
