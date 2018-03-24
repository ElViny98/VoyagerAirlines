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
import javax.swing.ImageIcon;

public class cLogin implements ActionListener{
    vLogin vL = new vLogin();
    mLogin mL = new mLogin();
    Sesion sesion;
    
    public cLogin(mLogin mlogin, vLogin vlogin) {
        this.vL = vlogin;
        this.mL = mlogin;
        
        this.vL.btnEntrar.addActionListener(this);
        this.vL.btnRegistro.addActionListener(this);
    }
    
    public void iniciarVista() {
        ImageIcon logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon logo2 = new ImageIcon(logo.getImage().getScaledInstance(vL.lblLogo.getWidth(), vL.lblLogo.getHeight(), Image.SCALE_DEFAULT));
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
                            this.vL.setVisible(false);
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
                    System.out.println("El usuario no existe");
                    break;
                    
                case 3:
                    System.out.println("Error de conexión");
                    break;
                    
                case 4:
                    System.out.println("Contraseña incorrecta");
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
    }
}
