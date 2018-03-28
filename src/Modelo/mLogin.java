package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mLogin {
    Conexion con = new Conexion();
    int idCliente;
    private Sesion s;
    
    /**
     * Valores de retorno: <br>
     * 1 - Exito<br>
     * 2 - Usuario inexistente<br>
     * 3 - Conexión incorrecta<br>
     * 4 - Contraseña incorrecta<br>
     * @param usuario El correo electrónico del usuario
     * @param pass Contraseña de inicio de sesión
     * @return Valores
     */
    public int iniciarSesion(String usuario, String pass) {
        try {
            Connection connection = con.abrirConexion();
            Statement st = connection.createStatement();
            try {
                ResultSet rS = st.executeQuery("SELECT usuario, contra, tipo, nombreCli FROM cliente WHERE usuario = '" + usuario + "';");
                rS.next();
                String u = rS.getString(1);
                String p = rS.getString(2);
                String id = rS.getString(3);
                
                s = new Sesion(Integer.parseInt(id), rS.getString(4), u);
                
                if(!pass.equals(p)) {
                    return 4;
                }
            }catch(SQLException ex) {
                return 2;
            }
        } catch (SQLException ex) {
            return 3;
        }
        return 1;
    }
    
    public Sesion getSesion() {
        return this.s;
    }
    
    /**
     * Método para buscar el usuario al que se actualizará su contraseña
     * @param usuario El correo del usuario
     * @return >0 Si el correo existe<br>
     * 0 Si el correo no existe<br>
     * -1 Si falló la conexión 
     */
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
    
    /**
     * 
     * @param id ID Del usuario 
     * @param pass Contraseña nueva
     * @return 1 Si se completó con exito<br>
     * 2 Si falló la conexión
     * 3 Si la contraseña es igual a la actual
     */
    public int actualizarContra(int id, String pass) {
        try {
            Connection connection = con.abrirConexion();
            Statement st = connection.createStatement();
            ResultSet rS = st.executeQuery("SELECT contra FROM cliente WHERE idCliente = " + id);
            rS.next();
            if(pass.equals(rS.getString(1))) {
                con.cerrarConexion(connection);
                return 3;
            }
            st.execute("UPDATE cliente SET contra = '" + pass + "' WHERE idCliente = " + id);
        }catch(SQLException e) {
            return 2;
        }
        return 1;
    }
}
