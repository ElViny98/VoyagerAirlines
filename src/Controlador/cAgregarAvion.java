package Controlador;

import Modelo.mAdmin;
import Vista.vAgregarAvion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cAgregarAvion implements ActionListener{
    vAgregarAvion vAA;
    mAdmin mA;
    
    public cAgregarAvion(vAgregarAvion vAA, mAdmin mA) {
        this.vAA = vAA;
        this.mA = mA;
        this.vAA.btnAgregar.addActionListener(this);
    }
    
    public void iniciarVista() {
        this.vAA.setTitle("Agregar avión");
        this.vAA.setResizable(false);
        this.vAA.setVisible(true);
        this.vAA.setLocationRelativeTo(null);
        this.vAA.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vAA.btnAgregar) {
            String nombre = this.vAA.txtNombreAvion.getText();
            int capacidad = Integer.parseInt(this.vAA.txtCapacidad.getText());
            if(!nombre.equals("") || capacidad > 0)
                mA.agregarAvion(nombre, capacidad);
            else
                this.vAA.lblErrorMsj.setText("Rellenar todos los campos");
        }
    }
    
}
