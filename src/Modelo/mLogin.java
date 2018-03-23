package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mLogin {
    Conexion con = new Conexion();
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
}
