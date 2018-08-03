package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mLogin extends Sesion{
    Conexion con = new Conexion();
    int idCliente;
    
    public int iniciarSesion(String usuario, String pass) {
        try {
            Connection connection = con.abrirConexion();
            Statement st = connection.createStatement();
            try {
                ResultSet rS = st.executeQuery("SELECT usuario, contra, tipo, nombreCli, idCliente FROM cliente WHERE usuario = '" + usuario + "';");
                rS.next();
                String u = rS.getString(1);
                String p = rS.getString(2);
                String tipo = rS.getString(3);
                String id = rS.getString(5);
                String nombre = rS.getString(4);
                
                this.setSesion(Integer.parseInt(id), Integer.parseInt(tipo), 
                        nombre, u);
                
                if(!pass.equals(p)) {
                    return 4;
                }
            }catch(SQLException ex) {
                Logger.getLogger(mLogin.class.getName()).log(Level.SEVERE, null, ex);
                return 2;
            }
        } catch (SQLException ex) {
            Logger.getLogger(mLogin.class.getName()).log(Level.SEVERE, null, ex);
            return 3;
        }
        return 1;
    }
    
    public int buscarUsuario(String usuario) {
        try {
            Connection connection = con.abrirConexion();
            Statement st = connection.createStatement();
            try {
                ResultSet rS = st.executeQuery("SELECT idCliente FROM cliente WHERE usuario = '" + usuario + "';");
                rS.next();
                int id = Integer.parseInt(rS.getString(1));
                con.cerrarConexion(connection);
                return id;
            }catch(SQLException e) {
                Logger.getLogger(mLogin.class.getName()).log(Level.SEVERE, null, e);
                con.cerrarConexion(connection);
                return 0;
            }
        }catch(SQLException e) {
            Logger.getLogger(mLogin.class.getName()).log(Level.SEVERE, null, e);
            return -1;
        }
    }
}
