/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class mRegistro {
    Conexion con = new Conexion();
    
    /**
     *
     * @param datos Datos a insertar en orden EL PARAMETRO NO SE PASA COMO ARREGLO
     * La consulta se construye en el siguiente orden: <br>
     * 0: Nombre completo<br>
     * 1: Nacionalidad<br>
     * 2: Ciudad<br>
     * 3: Fecha de nacimiento<br>
     * 4: Correo electrónico<br>
     * 5: Contraseña <br>
     * El dato "tipo" se ajusta automaticamente en 2, ya que se está registrando
     * un nuevo usuario.
     * @return 1: Registro exitoso<br>
     * 2: Correo ya existente<br>
     * 3: Error de conexión<br>
     * 4: Error de formato de fecha
    */
    public int registrarse(String... datos){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fNac = LocalDate.parse(datos[3]);
        LocalDate act = LocalDate.now();
        
        Period pr = Period.between(fNac, act);
        int edad = pr.getYears();
        
        //String que se concatenará con el query
        String insertar = "(NULL, '" + datos[0] + "', '" + datos[1]
        + "', '" + datos[2] + "', '" + datos[3] + "', " + edad + ", '" + datos[4]
        + "', '" + datos[5] + "', 2);";
        
        try {
            Connection connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT usuario FROM cliente");
            while(rS.next()) {
                if(datos[4].equals(rS.getString(1))) {
                    con.cerrarConexion(connection);
                    return 2;
                }
            }
            try {
                System.out.println(insertar);
                st.execute("INSERT INTO Cliente VALUES " + insertar);
            }catch(SQLException e) {
                Logger.getLogger(mRegistro.class.getName()).log(Level.SEVERE, null, e);
                con.cerrarConexion(connection);
                return 4;
            }
            con.cerrarConexion(connection);
        }catch(SQLException e) {
            Logger.getLogger(mRegistro.class.getName()).log(Level.SEVERE, null, e);
            return 3;
        }
        return 1;
    }
}
