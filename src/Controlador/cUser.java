/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Modelo.*;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class cUser implements ActionListener, MouseListener {
    //==========================Variables a utilizar==========================//
    private int idBuscar, observar = 0;
    private String[] datos;
    //======================Para la ventana de tripulacion====================//
    private vAgregarUsuario vUsuario;
    private mUser modeloUsuario = new mUser();
    //============================Para las alertas============================//
    private vAlerta alerta = new vAlerta();
    public cUser (vAgregarUsuario vUsuario, int opcion, int idBuscar){
        //==========Íconos//==========//
        ImageIcon user = new ImageIcon(getClass().getResource(("/img/user.png")));
        ImageIcon flag = new ImageIcon(getClass().getResource(("/icons/flag.png")));
        ImageIcon city = new ImageIcon(getClass().getResource(("/icons/city.png")));
        ImageIcon birthday = new ImageIcon(getClass().getResource(("/icons/calendar.png")));
        ImageIcon password = new ImageIcon(getClass().getResource(("/img/password.png")));
        ImageIcon hidden = new ImageIcon(getClass().getResource(("/icons/hidden.png")));
        //==========Imágenes de tamaño específico==========//
        ImageIcon usuario = new ImageIcon(user.getImage().getScaledInstance(vUsuario.lblImgNombre.getWidth(), vUsuario.lblImgNombre.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon bandera = new ImageIcon(flag.getImage().getScaledInstance(vUsuario.lblImgNacionalidad.getWidth(), vUsuario.lblImgNacionalidad.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon ciudad = new ImageIcon(city.getImage().getScaledInstance(vUsuario.lblImgCiudad.getWidth(), vUsuario.lblImgCiudad.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon nacimiento = new ImageIcon(birthday.getImage().getScaledInstance(vUsuario.lblImgNacimiento.getWidth(), vUsuario.lblImgNacimiento.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon contra = new ImageIcon(password.getImage().getScaledInstance(vUsuario.lblImgPass.getWidth(), vUsuario.lblImgPass.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon passHidden = new ImageIcon(hidden.getImage().getScaledInstance(vUsuario.btnMirar.getWidth(), vUsuario.btnMirar.getHeight(), Image.SCALE_DEFAULT));
        //==========Enviar imagen a componente==========//
        vUsuario.lblImgNombre.setIcon(usuario);
        vUsuario.lblImgNacionalidad.setIcon(bandera);
        vUsuario.lblImgCiudad.setIcon(ciudad);
        vUsuario.lblImgNacimiento.setIcon(nacimiento);
        vUsuario.lblImgUsuario.setIcon(usuario);
        vUsuario.lblImgPass.setIcon(contra);
        vUsuario.btnMirar.setIcon(passHidden);
        
        switch(opcion){
            //==========Ventana de agregar==========//
            case 1:
                this.vUsuario = vUsuario;
                
                this.vUsuario.btnAceptarUsuario.addActionListener(this);
                this.vUsuario.btnSalirAgregar.addActionListener(this);
                this.vUsuario.btnLimpiarCamposUsuario.addActionListener(this);
                this.vUsuario.btnMirar.addActionListener(this);
                
                
                break;
            //===Ventana de editar===//
            case 2:
                this.vUsuario = vUsuario;
                this.idBuscar = idBuscar;
                
                this.vUsuario.btnAceptarUsuario.addActionListener(this);
                this.vUsuario.btnSalirAgregar.addActionListener(this);
                this.vUsuario.btnLimpiarCamposUsuario.addActionListener(this);
                this.vUsuario.btnMirar.addActionListener(this);
                
                this.vUsuario.lblTituloUsuario.setText("Editar usuario");
                this.datos = modeloUsuario.consultaUsuarioEspecifico(this.idBuscar);
                
                this.vUsuario.txtNombreUsuario.setText(datos[1]);
                this.vUsuario.txtNacionalidadUsuario.setText(datos[2]);
                this.vUsuario.txtCiudadUsuario.setText(datos[3]);
                this.vUsuario.txtNacimientoUsuario.setText(datos[4]);
                this.vUsuario.txtUserName.setText(datos[6]);
                this.vUsuario.txtPassUsuario.setText(datos[7]);
                switch(Integer.parseInt(datos[8])){
                    case 1:
                        this.vUsuario.radioAdmin.setSelected(true);
                        break;
                    case 2:
                        this.vUsuario.radioTrabajador.setSelected(true);
                        break;
                    case 3:
                        this.vUsuario.radioCliente.setSelected(true);
                        break;
                    default:
                        this.vUsuario.radioAdmin.setSelected(true);
                        break;
                }
                
                break;
            case 3:
                break;
        }
        
        //=====Método para agregar placeholder al campo de nombre=====//
        vUsuario.txtNombreUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de nacionalidad====//
        vUsuario.txtNacionalidadUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNacionalidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNacionalidadFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de ciudad=====//
        vUsuario.txtCiudadUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCiudadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCiudadFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de nacimiento====//
        vUsuario.txtNacimientoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNacimientoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNacimientoFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de usuario=====//
        vUsuario.txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de contraseña====//
        vUsuario.txtPassUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        
    }
    
    //=========Método para iniciar la ventana para agregar un usuario=========//
    public void iniciarAgregar(){
        vUsuario.pack();
        vUsuario.setLocationRelativeTo(null);
        vUsuario.setVisible(true);
    }
    
    public void limpiarCamposUsuario(){
        vUsuario.txtCiudadUsuario.setText("Ciudad");
        vUsuario.txtNacimientoUsuario.setText("Nacimiento");
        vUsuario.txtNacionalidadUsuario.setText("Nacionalidad");
        vUsuario.txtNombreUsuario.setText("Apellido, Nombre");
        vUsuario.txtPassUsuario.setText("Contraseña");
        vUsuario.txtUserName.setText("Usuario");
        this.vUsuario.tipoUsuario.clearSelection();
    }
    
    //===========Métodos para colocar placeholder al campo de nombre==========//
    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vUsuario.txtNombreUsuario.getText().equals("Apellido, Nombre")){
            vUsuario.txtNombreUsuario.setText("");
        }
    }                                          
    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vUsuario.txtNombreUsuario.getText().equals("")){
            vUsuario.txtNombreUsuario.setText("Apellido, Nombre");
        }
    }
    
    //========Métodos para colocar placeholder al campo de nacionalidad=======//
    private void txtNacionalidadFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vUsuario.txtNacionalidadUsuario.getText().equals("Nacionalidad")){
            vUsuario.txtNacionalidadUsuario.setText("");
        }
    }                                          
    private void txtNacionalidadFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vUsuario.txtNacionalidadUsuario.getText().equals("")){
            vUsuario.txtNacionalidadUsuario.setText("Nacionalidad");
        }
    }
    
    //===========Métodos para colocar placeholder al campo de ciudad==========//
    private void txtCiudadFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vUsuario.txtCiudadUsuario.getText().equals("Ciudad")){
            vUsuario.txtCiudadUsuario.setText("");
        }
    }                                          
    private void txtCiudadFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vUsuario.txtCiudadUsuario.getText().equals("")){
            vUsuario.txtCiudadUsuario.setText("Ciudad");
        }
    }
    
    //=========Métodos para colocar placeholder al campo de nacimineto========//
    private void txtNacimientoFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vUsuario.txtNacimientoUsuario.getText().equals("Nacimiento")){
            vUsuario.txtNacimientoUsuario.setText("");
        }
    }                                          
    private void txtNacimientoFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vUsuario.txtNacimientoUsuario.getText().equals("")){
            vUsuario.txtNacimientoUsuario.setText("Nacimiento");
        }
    }
    
    //==========Métodos para colocar placeholder al campo de usuario==========//
    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vUsuario.txtUserName.getText().equals("Usuario")){
            vUsuario.txtUserName.setText("");
        }
    }                                          
    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vUsuario.txtUserName.getText().equals("")){
            vUsuario.txtUserName.setText("Usuario");
        }
    }
    
    //===========Métodos para colocar placeholder al campo de origen==========//
    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(vUsuario.txtPassUsuario.getText().equals("Contraseña")){
            vUsuario.txtPassUsuario.setText("");
        }
    }                                          
    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(vUsuario.txtPassUsuario.getText().equals("")){
            vUsuario.txtPassUsuario.setText("Contraseña");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vUsuario.btnLimpiarCamposUsuario == e.getSource()){
            limpiarCamposUsuario();
        }
        else if(vUsuario.btnSalirAgregar == e.getSource()){
            vUsuario.dispose();
        }
        else if(vUsuario.btnMirar == e.getSource()){
            if(this.observar == 1){
                vUsuario.txtPassUsuario.setEchoChar('*');
                ImageIcon hidden = new ImageIcon(getClass().getResource(("/icons/hidden.png")));
                ImageIcon passHidden = new ImageIcon(hidden.getImage().getScaledInstance(vUsuario.btnMirar.getWidth(), vUsuario.btnMirar.getHeight(), Image.SCALE_DEFAULT));
                vUsuario.btnAceptarUsuario.setIcon(null);
                vUsuario.btnMirar.setIcon(passHidden);
                this.observar = 0;
            }
            else if(this.observar == 0){
                vUsuario.txtPassUsuario.setEchoChar((char)0);
                ImageIcon show = new ImageIcon(getClass().getResource(("/icons/show.png")));
                ImageIcon passShow = new ImageIcon(show.getImage().getScaledInstance(vUsuario.btnMirar.getWidth(), vUsuario.btnMirar.getHeight(), Image.SCALE_DEFAULT));
                vUsuario.btnAceptarUsuario.setIcon(null);
                vUsuario.btnMirar.setIcon(passShow);
                this.observar = 1;
            }
            
        }
        else if(vUsuario.btnAceptarUsuario == e.getSource()){
            //===Revisar que se hayan completado los campos obligatorios===//
            if(vUsuario.txtNombreUsuario.getText().equals("Apellido, Nombre") || vUsuario.txtNacionalidadUsuario.getText().equals("Nacionalidad") || vUsuario.txtCiudadUsuario.getText().equals("Ciudad") || vUsuario.txtNacimientoUsuario.getText().equals("Nacimiento") || vUsuario.txtUserName.getText().equals("Usuario") || vUsuario.txtPassUsuario.getText().equals("Contraseña") || (!vUsuario.radioAdmin.isSelected() && !vUsuario.radioTrabajador.isSelected() && !vUsuario.radioCliente.isSelected())){
                cAlertas mostrarAlerta = new cAlertas(alerta);
                mostrarAlerta.agregarContenido(2, "¡RELLENAR LOS CAMPOS!");
                mostrarAlerta.iniciarAlerta();
            }
            else{
                //===Acción para la ventana editar===//
                if(this.idBuscar>=1)
                {
                    int Tipo = 0;
                    if(vUsuario.radioAdmin.isSelected())
                        Tipo = 1;
                    else if(vUsuario.radioTrabajador.isSelected())
                        Tipo = 2;
                    else if(vUsuario.radioCliente.isSelected())
                        Tipo = 3;
                    
                    if(modeloUsuario.editarUsuario(this.idBuscar, vUsuario.txtNombreUsuario.getText(), vUsuario.txtNacionalidadUsuario.getText(), vUsuario.txtCiudadUsuario.getText(), vUsuario.txtNacimientoUsuario.getText(), vUsuario.txtUserName.getText(), vUsuario.txtPassUsuario.getText(), Tipo))
                    {
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(1, "¡ACTUALIZACIÓN EXITOSA!");
                        mostrarAlerta.iniciarAlerta();
                        vUsuario.dispose();
                    } else{
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(3, "¡ALGO HA SALIDO MAL!");
                        mostrarAlerta.iniciarAlerta();
                    }
                }
                //===Acción para la ventana agregar===//
                else
                {
                    int Tipo = 0;
                    if(vUsuario.radioAdmin.isSelected())
                        Tipo = 1;
                    else if(vUsuario.radioTrabajador.isSelected())
                        Tipo = 2;
                    else if(vUsuario.radioCliente.isSelected())
                        Tipo = 3;
                    
                    if(modeloUsuario.usuarioAgregar(vUsuario.txtNombreUsuario.getText(), vUsuario.txtNacionalidadUsuario.getText(), vUsuario.txtCiudadUsuario.getText(), vUsuario.txtNacimientoUsuario.getText(), vUsuario.txtUserName.getText(), vUsuario.txtPassUsuario.getText(), Tipo))
                    {
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(1, "¡USUARIO REGISTRADO CON ÉXITO!");
                        mostrarAlerta.iniciarAlerta();
                        vUsuario.dispose();
                    } else{
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(3, "¡ALGO HA SALIDO MAL!");
                        mostrarAlerta.iniciarAlerta();
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
