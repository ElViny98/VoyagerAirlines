package Controlador;

import Modelo.*;
import Vista.*;
import Vista.vAdmin;

public class Main {
    
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
        
        mLogin mL = new mLogin();
        vLogin vL = new vLogin();
        cLogin cL = new cLogin(mL, vL);
        cL.iniciarVista();
    }
}
