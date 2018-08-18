package main;

import controlador.*;
import modelo.*;
import vista.*;

public class main {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        vLogin vLogin = new vLogin();
        vMenuAdmin vMenuAdmin = new vMenuAdmin();
        vAdmin vAdmin = new vAdmin();
        mAdmin mAdmin = new mAdmin();
        Sesion sesion = new Sesion();
        
        cLogin cLogin = new cLogin(vLogin);
        cLogin.iniciarVista();
        cMenuAdmin cMenuAdmin = new cMenuAdmin(vMenuAdmin);
        //cMenuAdmin.iniciarVista();
        cAdmin cAdmin = new cAdmin(vAdmin, mAdmin, sesion, 1);
        //cAdmin.iniciarVista();
        //mAdmin mAdmin = new mAdmin();
        //mAdmin.vueloAgregar("asd", "asd", "", 3, "1998-07-14", "10:00:00", "10:00:00", 200.0);
    }
}
