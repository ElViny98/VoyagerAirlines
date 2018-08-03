package controlador;

import java.awt.Color;
import vista.*;
import modelo.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class cLogin implements ActionListener{
    //=====Para la interfaz de iniciar sesión=====//
    vLogin vLogin = new vLogin();
    mLogin mLogin = new mLogin();
    Sesion sesion;
    //=====Variable para mostrar o esconder contraseña=====//
    boolean mostrar;
    
    public cLogin(vLogin vLogin) {
        this.vLogin = vLogin;
        this.mostrar=true;
        
        this.vLogin.btnIniciar.addActionListener(this);
        this.vLogin.btnRegistrar.addActionListener(this);
        this.vLogin.btnMostrar.addActionListener(this);
        this.vLogin.btnSalir.addActionListener(this);
        this.vLogin.btnMinimizar.addActionListener(this);
    }
    
    public void iniciarVista(){
        ImageIcon iconLogo = new ImageIcon(getClass().getResource(("/icons/icon-avion-2.png")));
        ImageIcon logo = new ImageIcon(iconLogo.getImage().getScaledInstance(vLogin.lblLogoIcon.getWidth(), vLogin.lblLogoIcon.getHeight(), Image.SCALE_DEFAULT));
        vLogin.lblLogoIcon.setIcon(logo);
        
        ImageIcon iconUser = new ImageIcon(getClass().getResource(("/icons/usuario.png")));
        ImageIcon user = new ImageIcon(iconUser.getImage().getScaledInstance(vLogin.lblUsuarioIcon.getWidth()-5, vLogin.lblUsuarioIcon.getHeight()-5, Image.SCALE_DEFAULT));
        vLogin.lblUsuarioIcon.setIcon(user);
        
        ImageIcon iconPass = new ImageIcon(getClass().getResource(("/icons/password.png")));
        ImageIcon pass = new ImageIcon(iconPass.getImage().getScaledInstance(vLogin.lblPassIcon.getWidth()-5, vLogin.lblPassIcon.getHeight()-5, Image.SCALE_DEFAULT));
        vLogin.lblPassIcon.setIcon(pass);
        
        ImageIcon iconMostrar = new ImageIcon(getClass().getResource(("/icons/visible.png")));
        ImageIcon mostrar = new ImageIcon(iconMostrar.getImage().getScaledInstance(vLogin.btnMostrar.getWidth(), vLogin.btnMostrar.getHeight(), Image.SCALE_DEFAULT));
        vLogin.btnMostrar.setIcon(mostrar);
        
        ImageIcon iconExit = new ImageIcon(getClass().getResource(("/icons/exit-2.png")));
        ImageIcon exit = new ImageIcon(iconExit.getImage().getScaledInstance(vLogin.btnSalir.getWidth(), vLogin.btnSalir.getHeight(), Image.SCALE_DEFAULT));
        vLogin.btnSalir.setIcon(exit);
        
        ImageIcon iconMinimizar = new ImageIcon(getClass().getResource(("/icons/minimizar-2.png")));
        ImageIcon minimizar = new ImageIcon(iconMinimizar.getImage().getScaledInstance(vLogin.btnMinimizar.getWidth(), vLogin.btnMinimizar.getHeight(), Image.SCALE_DEFAULT));
        vLogin.btnMinimizar.setIcon(minimizar);
        
        //=====Método para agregar placeholder al campo de usuario=====//
        vLogin.txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        
        //=====Método para agregar placeholder al campo de contraseña=====//
        vLogin.txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        
        vLogin.progreso.setVisible(false);
        
        this.vLogin.setIconImage(new ImageIcon(getClass().getResource("/icons/avion-3.png")).getImage());
        this.vLogin.setTitle("Inicio de sesión");
        this.vLogin.setVisible(true);
        this.vLogin.setLocationRelativeTo(null);
    }
    
    //===========Métodos para colocar placeholder al campo de nombre==========//
    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vLogin.txtUsuario.getText().equals("Usuario")){
            vLogin.txtUsuario.setText("");
            vLogin.separadorUser.setForeground(new java.awt.Color(0,105,92));
        }
    }                                          
    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vLogin.txtUsuario.getText().equals("")){
            vLogin.txtUsuario.setText("Usuario");
            vLogin.separadorUser.setForeground(new java.awt.Color(47,182,172));
        }
    }
    
    //========Métodos para colocar placeholder al campo de contraseña=======//
    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vLogin.txtPass.getText().equals("**********")){
            vLogin.txtPass.setText("");
            vLogin.separadorPass.setForeground(new java.awt.Color(0,105,92));
        }
    }                                          
    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vLogin.txtPass.getText().equals("")){
            vLogin.txtPass.setText("**********");
            vLogin.separadorPass.setForeground(new java.awt.Color(47,182,172));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vLogin.btnSalir == e.getSource())
            System.exit(0);
        else if(this.vLogin.btnMinimizar == e.getSource())
            this.vLogin.setExtendedState(1);
        else if(this.vLogin.btnMostrar == e.getSource())
        {
            if(this.mostrar == false)
            {
                vLogin.txtPass.setEchoChar('•');
                ImageIcon iconMostrar = new ImageIcon(getClass().getResource(("/icons/visible.png")));
                ImageIcon mostrar = new ImageIcon(iconMostrar.getImage().getScaledInstance(vLogin.btnMostrar.getWidth(), vLogin.btnMostrar.getHeight(), Image.SCALE_DEFAULT));
                vLogin.btnMostrar.setIcon(null);
                vLogin.btnMostrar.setIcon(mostrar);
                this.mostrar=true;
            }
            else
            {
                vLogin.txtPass.setEchoChar((char)0);
                ImageIcon iconHidden = new ImageIcon(getClass().getResource(("/icons/no-visible.png")));
                ImageIcon mostrar = new ImageIcon(iconHidden.getImage().getScaledInstance(vLogin.btnMostrar.getWidth(), vLogin.btnMostrar.getHeight(), Image.SCALE_DEFAULT));
                vLogin.btnMostrar.setIcon(null);
                vLogin.btnMostrar.setIcon(mostrar);
                this.mostrar=false;
            }
        }
        else if(this.vLogin.btnIniciar == e.getSource())
        {
            //Posibles resultados del inicio de sesión
            switch(mLogin.iniciarSesion(this.vLogin.txtUsuario.getText(), this.vLogin.txtPass.getText())) {
                case 1:
                    System.out.println("Usuario correcto");
                    this.sesion = mLogin.getSesion();
                    //Switch para controlar el tipo de usuario
                    switch(this.sesion.getTipo()) {
                        case 1:
                            vMenuAdmin vMenuAdmin = new vMenuAdmin();
                            cMenuAdmin cMenuAdmin = new cMenuAdmin(vMenuAdmin);
                            this.vLogin.dispose();
                            cMenuAdmin.iniciarVista();
                            /*mAdmin mA = new mAdmin();
                            vAdmin vA = new vAdmin();
                            cAdmin cA = new cAdmin(vA, mA, this.sesion);
                            this.vLogin.dispose();
                            cA.iniciarVista();*/
                            break;
                            
                        case 2:
                            /*mUsuario mU = new mUsuario();
                            vUsuario vU = new vUsuario();
                            cUsuario cU = new cUsuario(mU, vU, this.sesion);
                            this.vLogin.dispose();
                            cU.iniciarVista();*/
                            break;
                            
                        case 3:
                            /*mVentas mV = new mVentas();
                            vPVentas vPV = new vPVentas();
                            cVentas cV = new cVentas(mV, vPV, this.sesion);
                            this.vLogin.dispose();
                            cV.iniciarAgregar();*/
                            break;
                    }
                    break;
                    
                case 2:
                    this.vLogin.lblMensajeLogin.setText("No existe un usuario con ese correo.");
                    break;
                    
                case 3:
                    this.vLogin.lblMensajeLogin.setText("Error de conexión.");
                    break;
                    
                case 4:
                    this.vLogin.lblMensajeLogin.setText("Contraseña incorrecta.");
                    break;
            }
        }
    }
    
}
