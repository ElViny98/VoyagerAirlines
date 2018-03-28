package Controlador;

import Modelo.mRegistro;
import Vista.vLogin;
import Vista.vRegistro;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class cRegistro implements ActionListener{
    mRegistro mR = new mRegistro();
    vRegistro vR = new vRegistro();
    vLogin vL = new vLogin();
    
    public cRegistro(mRegistro mR, vRegistro vR, vLogin vL) {
        this.mR = mR;
        this.vR = vR;
        this.vL = vL;
        vR.btnRegistrar.addActionListener(this);
        vR.btnVolver.addActionListener(this);
    }
    
    public void iniciarVista() {
        ImageIcon lg = new ImageIcon(getClass().getResource("/img/avion_logo.png"));
        ImageIcon logo = new ImageIcon(lg.getImage().getScaledInstance(this.vR.lblLogo.getWidth(), this.vR.lblLogo.getHeight(), Image.SCALE_DEFAULT));
        this.vR.lblLogo.setIcon(logo);
        
        this.vR.setIconImage(new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage());
        this.vR.setTitle("Registro");
        this.vR.setLocationRelativeTo(null);
        this.vR.setResizable(false);
        this.vR.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vR.btnRegistrar) {
            if(this.vR.txtCiudad.getText().equals("") || this.vR.txtCorreo.getText().equals("")
                    || this.vR.txtFecha.getText().equals("") || this.vR.txtNacion.getText().equals("")
                    || this.vR.txtNombre.getText().equals("") || this.vR.txtPass.getText().equals("")
                    || this.vR.txtPass2.getText().equals("")) {
                this.vR.lblMsj.setText("Favor de rellenar todos los campos");
                return;
            }
            if(!this.vR.txtPass.getText().equals(this.vR.txtPass2.getText())) {
                this.vR.lblMsj.setText("Las contraseñas no coinciden");
            }
            else {   
                switch(this.mR.registrarse(this.vR.txtNombre.getText(), this.vR.txtNacion.getText(),
                        this.vR.txtCiudad.getText(), this.vR.txtFecha.getText(), 
                        this.vR.txtCorreo.getText(), this.vR.txtPass.getText())){

                    case 1:
                        System.out.println("Registrado");
                        break;

                    case 2:
                        this.vR.lblMsj.setText("Este correo ya se encuentra en uso.");
                        break;

                    case 3:
                        this.vR.lblMsj.setText("Ocurrió un error al conectar con el servidor");
                        break;

                    case 4:
                        this.vR.lblMsj.setText("El formato de fecha capturado es inválido.");
                        break;
                }
            }
        }
        if(e.getSource() == this.vR.btnVolver) {
            this.vR.dispose();
            this.vL.setVisible(true);
        }
    }
}
