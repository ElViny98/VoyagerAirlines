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
    
    public boolean vueloAgregar(String CiuOrigen, String CiuDestino, String Escala, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada)
    {
        int idEscalas;
        //===No se agregaron escalas===//
        if(Escala.equals("0")){
            idEscalas = 0;
        }
        //===Sí se agregaron escalas===//
        else{
            agregarEscala(Escala);
            idEscalas = ultimaEscala();
        }
        
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
                id = resultado.getInt(1);//Selecciona el número de la columna en la BD
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    //===Para elegir el vuelo que se va a editar===//
    public String[] consultaVueloEspecifico(int idBuscar){
        System.out.println("Entra");
        String[] datos = new String[9];
        String idVuelo = "", CiuOrigen = "", CiuDestino = "", idEscalas = "", idTripulacion = "", 
                Fecha = "", HoraSalida = "", HoraLlegada = "", nomEscala = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM vuelo WHERE idVuelo = "+idBuscar+";");
            
            resultado.next();
            
            idVuelo = resultado.getString("idVuelo");
            CiuOrigen = resultado.getString("CiuOrigen");
            CiuDestino = resultado.getString("CiuDestino");
            idEscalas = resultado.getString("idEscalas");
            if(resultado.getString("idTripulacion")!=null) 
                idTripulacion = resultado.getString("idTripulacion");
            else 
                idTripulacion = "Not found";
            
            Fecha = resultado.getString("Fecha");
            HoraSalida = resultado.getString("HoraSalida");
            HoraLlegada = resultado.getString("HoraLlegada");
            if(!idEscalas.equals("0")){
                nomEscala = consultaEscalaEspecifico(Integer.parseInt(idEscalas));
            }
            
            datos[0] = idVuelo;
            datos[1] = CiuOrigen;
            datos[2] = CiuDestino;
            datos[3] = idEscalas;
            datos[4] = idTripulacion;
            datos[5] = Fecha;
            datos[6] = HoraSalida;
            datos[7] = HoraLlegada;
            datos[8] = nomEscala;
            return datos;
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    //===Para elegir la escala del vuelo que se va a editar===//
    public String consultaEscalaEspecifico(int idEscalas){
        String dato = "";
        try {
            Connection con = miConexion.abrirConexion();
            Statement s = con.createStatement();
            ResultSet resultado = s.executeQuery("SELECT * FROM escalas WHERE idEscalas = "+idEscalas+";");
            
            if(resultado.next())
                dato = resultado.getString("Ciudad");
            else
                dato = "Not Found";
            
            return dato;
        } catch (SQLException ex) {
            Logger.getLogger(mVuelos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dato;
    }
    //===Para editar un vuelo específico===//
    public boolean vueloEditar(int tipoEditar, int idVuelo, int idEscalas, String CiuOrigen, String CiuDestino, String Escala, int idTripulacion, String Fecha, String HoraSalida, String HoraLlegada)
    {
        //===No tenía escala originalmente===//
        if(tipoEditar == 0){
            //===No tenía escala, y sigue sin tener escala===//
            if(Escala.equals("0")){
               idEscalas = 0; 
            }
            //===No tenía escala, pero ahora ya tiene===//
            else{
                agregarEscala(Escala);
                idEscalas = ultimaEscala();
            }
        }
        //===Sí tenía escala originalmente===//
        else if(tipoEditar ==1){
            //===Sí tenía escala, pero ahora ya no tiene===//
            if(Escala.equals("0")){
                escalaEliminar(idEscalas);
                idEscalas = 0;
            }
            //===Sí tenía escala, y sigue teniendo===//
            else{
                editarEscala(Escala, idEscalas);
            }
        }
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update vuelo set CiuOrigen = '"+CiuOrigen+"', CiuDestino = '"+CiuDestino+"', idEscalas = '"+idEscalas+"', idTripulacion = '"+idTripulacion+"', Fecha = '"+Fecha+"', HoraSalida = '"+HoraSalida+"', HoraLlegada = '"+HoraLlegada+"'"
                    + "where idVuelo = "+idVuelo+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    //===Para editar la escala de un vuelo específico===//
    public void editarEscala(String nombreEscala, int idEscalas){
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "update escalas set Ciudad = '"+nombreEscala+"'"
                    + "where idEscalas = "+idEscalas+";");
            miConexion.cerrarConexion(con);
        } catch (SQLException ex) {
        }
    }
    
    public boolean vueloEliminar(int tipoEliminar, int idVuelo, int idEscalas)
    {
        //===Sí tenía escala===//
        if(tipoEliminar == 1){
                escalaEliminar(idEscalas);
        }
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from vuelo where idVuelo = "+idVuelo+";");
            miConexion.cerrarConexion(con);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public void escalaEliminar(int idEscala)
    {
        try {
            //--- Abriendo la base de datos ---//
            Connection con = miConexion.abrirConexion();
            //--- Para ejecutar la consulta ---//
            Statement s = con.createStatement();
            int registro = s.executeUpdate(
            "delete from escalas where idEscalas = "+idEscala+";");
            miConexion.cerrarConexion(con);
        } catch (SQLException ex) {
        }
    }
}
