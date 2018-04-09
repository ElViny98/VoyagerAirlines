package Controlador;

import Vista.vAlertaPerfil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Vinicio
 */
public class cAlertasPerfil implements ActionListener{
    vAlertaPerfil vA;
    public cAlertasPerfil(vAlertaPerfil vA) {
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
    }
}
