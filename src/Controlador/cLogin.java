package Controlador;

import Vista.vLogin;
import Modelo.mLogin;
import Modelo.mAdmin;
import Vista.vAdmin;
import Modelo.Sesion;
import Modelo.mRegistro;
import Vista.vRegistro;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class cLogin implements ActionListener{
    vLogin vL = new vLogin();
    mLogin mL = new mLogin();
    int id;
    Sesion sesion;
    
    public cLogin(mLogin mlogin, vLogin vlogin) {
        this.vL = vlogin;
        this.mL = mlogin;
        
        this.vL.btnEntrar.addActionListener(this);
        this.vL.btnRegistro.addActionListener(this);
        this.vL.btnOlvido.addActionListener(this);
        this.vL.btnVolver.addActionListener(this);
        this.vL.btnBuscar.addActionListener(this);
        this.vL.btnCambiar.addActionListener(this);
        this.vL.btnCancelar.addActionListener(this);
    }
    
    public void iniciarVista() {
        ImageIcon logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon logo2 = new ImageIcon(logo.getImage().getScaledInstance(vL.lblLogo.getWidth(), vL.lblLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon l3 = new ImageIcon(getClass().getResource("/icons/volver.png"));
        ImageIcon logo3 = new ImageIcon(l3.getImage().getScaledInstance(vL.btnVolver.getWidth(), vL.btnVolver.getHeight(), Image.SCALE_DEFAULT));
        
        this.vL.pnlContra.setVisible(false);
        this.vL.pnlRecuperar.setVisible(false);
        this.vL.btnVolver.setIcon(logo3);
        this.vL.lblLogo.setIcon(logo2);
        
        this.vL.setIconImage(new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage());
        this.vL.setResizable(false);
        this.vL.setTitle("Inicio de sesión");
        this.vL.setVisible(true);
        this.vL.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vL.btnEntrar) {
            //Posibles resultados del inicio de sesión
            switch(mL.iniciarSesion(vL.txtUsuario.getText(), vL.txtPass.getText())) {
                case 1:
                    System.out.println("Usuario correcto");
                    this.sesion = mL.getSesion();
                    //Switch para controlar el tipo de usuario
                    switch(this.sesion.getId()) {
                        case 1:
                            mAdmin mA = new mAdmin();
                            vAdmin vA = new vAdmin();
                            cAdmin cA = new cAdmin(mA, vA, this.sesion);
                            this.vL.dispose();
                            cA.iniciarVistaAdmin();
                            break;
                            
                        case 2:
                            System.out.println("Usuario común");
                            break;
                            
                        case 3:
                            System.out.println("Punto de venta");
                            break;
                    }
                    break;
                    
                case 2:
                    this.vL.lblMsj.setText("No existe un usuario con ese correo.");
                    break;
                    
                case 3:
                    this.vL.lblMsj.setText("Error de conexión.");
                    break;
                    
                case 4:
                    this.vL.lblMsj.setText("Contraseña incorrecta.");
                    break;
            }
        }
        if(e.getSource() == vL.btnRegistro) {
            mRegistro mR = new mRegistro();
            vRegistro vR = new vRegistro();
            cRegistro cR = new cRegistro(mR, vR, this.vL);
            this.vL.setVisible(false);
            cR.iniciarVista();
        }
        
        if(e.getSource() == vL.btnOlvido) {
            this.vL.pnlInicio.setVisible(false);
            this.vL.pnlContra.setVisible(true);
        }
        
        if(e.getSource() == vL.btnVolver) {
            this.vL.pnlContra.setVisible(false);
            this.vL.pnlInicio.setVisible(true);
        }
        
        if(e.getSource() == vL.btnBuscar) {
            if(this.vL.txtBuscar.getText().equals("")) {
                this.vL.lblMsjContra.setText("El campo es obligatorio");
            }
            else {
                id = this.mL.buscarUsuario(this.vL.txtBuscar.getText());
                if(id>0) {
                    this.vL.lblUsuario.setText("Actualizar contraseña para " + this.vL.txtBuscar.getText());
                    this.vL.txtBuscar.setText("");
                    this.vL.pnlContra.setVisible(false);
                    this.vL.pnlRecuperar.setVisible(true);
                }
                else if(id == 0) {
                    this.vL.txtBuscar.requestFocus();
                    this.vL.txtBuscar.setSelectionStart(0);
                    this.vL.txtBuscar.setSelectionEnd(this.vL.txtBuscar.getText().length());
                    this.vL.lblMsjContra.setText("No existe un usuario con ese correo");
                }
                else {
                    this.vL.lblMsjContra.setText("Error de conexión");
                }
            }
        }
        
        if(e.getSource() == vL.btnCambiar) {
            if(this.vL.txtPass1.getText().equals("") || this.vL.txtPass2.getText().equals(""))
                this.vL.lblRecuperar.setText("Favor de completar los campos");
            
            else if(!this.vL.txtPass1.getText().equals(this.vL.txtPass2.getText())) {
                this.vL.lblRecuperar.setText("Las contraseñas no coinciden.");
            }
            else {
                int op = this.mL.actualizarContra(id, this.vL.txtPass1.getText());
                switch (op) {
                    case 3:
                        this.vL.lblRecuperar.setText("La nueva contraseña no puede ser la misma que la actual.");
                        break;
                        
                    case 2:
                        this.vL.lblRecuperar.setText("Error de conexión.");
                        break;
                        
                    case 1:
                        this.vL.pnlRecuperar.setVisible(false);
                        this.vL.pnlInicio.setVisible(true);
                        this.vL.lblRecuperar.setText("");
                        this.vL.lblMsj.setText("Se recuperó la contraseña correctamente.");
                        break;
                        
                    default:
                        break;
                }
            }
        }
        
        if(e.getSource() == this.vL.btnCancelar) {
            this.vL.pnlRecuperar.setVisible(false);
            this.vL.pnlInicio.setVisible(true);
        }
    }
}
