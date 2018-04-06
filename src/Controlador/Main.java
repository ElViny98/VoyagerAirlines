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
        //cL.iniciarVista();
        
        
        mUser usuario = new mUser();
        usuario.usuarioAgregar("David", "Mexicano", "Mazatlán", "1998-07-15", "Destroyer", "123", 1);
//        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate fechaNac = LocalDate.parse("15-07-1998", fmt);
//        LocalDate ahora = LocalDate.now();
//
//        Period periodo = Period.between(fechaNac, ahora);
//        System.out.printf("Tu edad es: %s años, %s meses y %s días",
//                            periodo.getYears(), periodo.getMonths(), periodo.getDays());

        //Para hacer pruebas rápidas//
        //mVuelos vuelo = new mVuelos();
        //vuelo.consultaVueloEspecifico(9);
        //vAdmin vistaAdmin = new vAdmin();
        //mAdmin modeloAdmin = new mAdmin();
        //cAdmin cA = new cAdmin(modeloAdmin, vistaAdmin);
        //cA.iniciarVistaAdmin();
//        mVuelos prueba = new mVuelos();
//        prueba.consultaVueloEspecifico(5);
    }
}
