    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controlador.cAdmin;
import Modelo.mAdmin;
import Vista.vAdmin;

/**
 *
 * @author David
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        mAdmin modelo = new mAdmin();
        vAdmin vista = new vAdmin();
        cAdmin controlador = new cAdmin((modelo), vista);
        controlador.iniciarVistaAdmin();
    }
    
}
