package Controlador;

import Modelo.*;
import Vista.*;
import Vista.vAdmin;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        mLogin mL = new mLogin();
        vLogin vL = new vLogin();
        cLogin cL = new cLogin(mL, vL);
        cL.iniciarVista();
        
//        mAdmin admin = new mAdmin();
//        admin.bestVentas();

        //Para hacer pruebas rápidas//
//        mUser usuario = new mUser();
//        usuario.editarUsuario(28, "asdasdsad", "WSSSS", "Aqs", "15-07-1998", "Nuevo", "123", 2);
    }
}
