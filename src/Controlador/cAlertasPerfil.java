package Controlador;

import Modelo.mLogin;
import Modelo.mUsuario;
import Vista.vAlertaPerfil;
import Vista.vLogin;
import Vista.vUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Vinicio
 */
public class cAlertasPerfil implements ActionListener{
    vAlertaPerfil vA;
    vUsuario vU;
    mUsuario mU;
    
    public cAlertasPerfil(vAlertaPerfil vA, mUsuario mU, vUsuario vU) {
        this.mU = mU;
        this.vU = vU;
        this.vA = vA;
        this.vA.btnAceptar.addActionListener(this);
        this.vA.btnCancelarPerf.addActionListener(this);
        this.vA.btnCerrar.addActionListener(this);
    }
    
    public void iniciarVista() {
        this.vA.setBackground(new java.awt.Color(255, 255, 255));
        this.vA.setVisible(true);
        this.vA.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.vA.btnCancelarPerf || e.getSource() == this.vA.btnCerrar) {
           this.vA.dispose();
       }
       if(e.getSource() == this.vA.btnAceptar) {
           this.mU.borrarPerfil(this.mU.getId());
           this.mU.destruirSesion();
           vLogin vL = new vLogin();
           mLogin mL = new mLogin();
           this.vU.dispose();
           cLogin cL = new cLogin(mL, vL);
           cL.iniciarVista();
       }
    }
}
