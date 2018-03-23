package Controlador;

import Vista.vLogin;
import Modelo.mLogin;
import Modelo.Sesion;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class cLogin implements ActionListener{
    vLogin vL = new vLogin();
    mLogin mL = new mLogin();
    Sesion sesion;
    
    public cLogin(mLogin mlogin, vLogin vlogin) {
        this.vL = vlogin;
        this.mL = mlogin;
        
        vL.btnEntrar.addActionListener(this);
    }
    
    public void iniciarVista() {
        ImageIcon logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon logo2 = new ImageIcon(logo.getImage().getScaledInstance(vL.lblLogo.getWidth(), vL.lblLogo.getHeight(), Image.SCALE_DEFAULT));
        this.vL.lblLogo.setIcon(logo2);
        
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
                    System.out.println("Bienvenido: " + sesion.getNombre());
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
    }
}
