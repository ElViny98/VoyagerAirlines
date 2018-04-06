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
    private int idBuscar;
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
        ImageIcon employer = new ImageIcon(getClass().getResource(("/icons/trabajador.png")));
        //==========Imágenes de tamaño específico==========//
        ImageIcon usuario = new ImageIcon(user.getImage().getScaledInstance(vUsuario.lblImgNombre.getWidth(), vUsuario.lblImgNombre.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon bandera = new ImageIcon(flag.getImage().getScaledInstance(vUsuario.lblImgNacionalidad.getWidth(), vUsuario.lblImgNacionalidad.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon ciudad = new ImageIcon(city.getImage().getScaledInstance(vUsuario.lblImgCiudad.getWidth(), vUsuario.lblImgCiudad.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon nacimiento = new ImageIcon(birthday.getImage().getScaledInstance(vUsuario.lblImgNacimiento.getWidth(), vUsuario.lblImgNacimiento.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon contra = new ImageIcon(password.getImage().getScaledInstance(vUsuario.lblImgPass.getWidth(), vUsuario.lblImgPass.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon trabajador = new ImageIcon(employer.getImage().getScaledInstance(vUsuario.lblImgTipo.getWidth(), vUsuario.lblImgTipo.getHeight(), Image.SCALE_DEFAULT));
        //==========Enviar imagen a componente==========//
        vUsuario.lblImgNombre.setIcon(usuario);
        vUsuario.lblImgNacionalidad.setIcon(bandera);
        vUsuario.lblImgCiudad.setIcon(ciudad);
        vUsuario.lblImgNacimiento.setIcon(nacimiento);
        vUsuario.lblImgUsuario.setIcon(usuario);
        vUsuario.lblImgTipo.setIcon(trabajador);
        vUsuario.lblImgPass.setIcon(contra);
        
        switch(opcion){
            //==========Ventana de agregar==========//
            case 1:
                this.vUsuario = vUsuario;
                
                this.vUsuario.btnAceptarUsuario.addActionListener(this);
                this.vUsuario.btnSalirAgregar.addActionListener(this);
                this.vUsuario.btnLimpiarCamposUsuario.addActionListener(this);
                this.vUsuario.cbxTipoUsuario.addItem("---Tipo---");
                this.vUsuario.cbxTipoUsuario.addItem("Administrador");
                this.vUsuario.cbxTipoUsuario.addItem("Trabajador");
                
                break;
            //===Ventana de editar===//
            case 2:/*
                this.vUsuario = vUsuario;
                this.idBuscar = idBuscar;
                
                this.vUsuario.btnAceptarTripulacion.addActionListener(this);
                this.vUsuario.btnSalirAgregar.addActionListener(this);
                this.vUsuario.btnLimpiarCamposTripulacion.addActionListener(this);
                this.vUsuario.cbxPuesto.addItem("---Puesto---");
                this.vUsuario.cbxPuesto.addItem("Piloto");
                this.vUsuario.cbxPuesto.addItem("Copiloto");
                this.vUsuario.cbxPuesto.addItem("Azafata(o)");
                
                this.vUsuario.lblTituloTripulacion.setText("Editar tripulante");
                this.datos = modeloTripulacion.consultaTripulacionEspecifico(this.idBuscar);
                
                this.vUsuario.txtNombreTripulacion.setText(datos[1]);
                this.vUsuario.txtTripulacion.setText(datos[4]);
                switch(datos[2]){
                    case "Piloto":
                        this.vUsuario.cbxPuesto.setSelectedIndex(1);
                        break;
                    case "Copiloto":
                        this.vUsuario.cbxPuesto.setSelectedIndex(2);
                        break;
                    case "Azafata(o)":
                        this.vUsuario.cbxPuesto.setSelectedIndex(3);
                        break;
                    default:
                        this.vUsuario.cbxPuesto.setSelectedIndex(3);
                        break;
                }*/
                
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
        vUsuario.cbxTipoUsuario.setSelectedIndex(0);
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
        else if(vUsuario.btnAceptarUsuario == e.getSource()){
            //===Revisar que se hayan completado los campos obligatorios===//
            if(vUsuario.txtNombreUsuario.getText().equals("Apellido, Nombre") || vUsuario.txtNacionalidadUsuario.getText().equals("Nacionalidad") || vUsuario.txtCiudadUsuario.getText().equals("Ciudad") || vUsuario.txtNacimientoUsuario.getText().equals("Nacimiento") || vUsuario.txtUserName.getText().equals("Usuario") || vUsuario.txtPassUsuario.getText().equals("Contraseña") || vUsuario.cbxTipoUsuario.getSelectedIndex() == 0){
                cAlertas mostrarAlerta = new cAlertas(alerta);
                mostrarAlerta.agregarContenido(2, "¡RELLENAR LOS CAMPOS!");
                mostrarAlerta.iniciarAlerta();
            }
            else{
                //===Acción para la ventana editar===//
                if(this.idBuscar>=1)
                {/*
                    if(modeloVuelos.vueloEditar(this.tipoEditar, this.idBuscar, Integer.parseInt(this.datos[3]), agregarVuelo.txtOrigenVuelo.getText(),agregarVuelo.txtDestinoVuelo.getText(), escala, Integer.parseInt(tripulacion), agregarVuelo.txtFechaVuelo.getText(), agregarVuelo.txtSalidaVuelo.getText(), agregarVuelo.txtLlegadaVuelo.getText()))
                    {
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(1, "¡ACTUALIZACIÓN EXITOSA!");
                        mostrarAlerta.iniciarAlerta();
                        agregarVuelo.dispose();
                    } else{
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(3, "¡ALGO HA SALIDO MAL!");
                        mostrarAlerta.iniciarAlerta();
                    }*/
                }
                //===Acción para la ventana agregar===//
                else
                {
                    int Tipo = 0;
                    if(vUsuario.cbxTipoUsuario.getSelectedIndex() == 1)
                        Tipo = 2;
                    else if(vUsuario.cbxTipoUsuario.getSelectedIndex() == 2)
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
