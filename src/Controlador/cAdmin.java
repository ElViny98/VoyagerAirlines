/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.*;
import Vista.vAdmin;
import java.awt.Color;
import Vista.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.awt.Image;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class cAdmin implements ActionListener, MouseListener {
    //==========================Variables a utilizar==========================//
    private int idAvion;
    private int idVuelo = 0;
    private int idTrip = 0;
    private int idUser = 0;
    //========================Para el inicio de sesión========================//
    private Sesion s;
    //====================Para la pantalla de administrador===================//
    private mAdmin modeloAdmin;
    private final vAdmin vistaAdmin;
    //============================Para las alertas============================//
    private vAlerta alerta = new vAlerta();
    //==============Constructor para la ventana de administrador==============//
    public cAdmin(mAdmin modeloAdmin, vAdmin vistaAdmin, Sesion s) {
        this.modeloAdmin = modeloAdmin;
        this.vistaAdmin = vistaAdmin;
        this.s = s;
        //======Componentes generales de la pantalla de administrador=====//
        this.vistaAdmin.btnInicio.addActionListener(this);
        this.vistaAdmin.btnAviones.addActionListener(this);
        this.vistaAdmin.btnUsuarios.addActionListener(this);
        this.vistaAdmin.btnVentas.addActionListener(this);
        this.vistaAdmin.btnVuelos.addActionListener(this);
        this.vistaAdmin.btnTripulacion.addActionListener(this);
        this.vistaAdmin.btnSalirPrograma.addActionListener(this);
        this.vistaAdmin.btnMinimizar.addActionListener(this);
        this.vistaAdmin.btnCerrar.addActionListener(this);
        //=====Componentes de la sección de vuelos=====//
        this.vistaAdmin.btnAgregarVuelo.addActionListener(this);
        this.vistaAdmin.btnEditarVuelo.addActionListener(this);
        this.vistaAdmin.btnEliminarVuelo.addActionListener(this);
        this.vistaAdmin.btnRefresh.addActionListener(this);
        this.vistaAdmin.jTableVuelos.addMouseListener(this);
        //=====Componentes de la sección de aviones=====//
        this.vistaAdmin.tblAviones.addMouseListener(this);
        this.vistaAdmin.btnAvionDetalles.addActionListener(this);
        //=====Componentes de la sección de tripulación=====//
        this.vistaAdmin.tblTripulacion.addMouseListener(this);
        this.vistaAdmin.btnAgregarTripulacion.addActionListener(this);
        this.vistaAdmin.btnEditarTripulacion.addActionListener(this);
        this.vistaAdmin.btnEliminarTripulacion.addActionListener(this);
        this.vistaAdmin.btnRefresh1.addActionListener(this);
        //===================Sección Ventas====================//
        this.vistaAdmin.btnPVenta1.addActionListener(this);
        this.vistaAdmin.btnRefreshHV.addActionListener(this);
        //================Componentes de la sección de usuarios===============//
        this.vistaAdmin.btnAgregarUsuario.addActionListener(this);
        this.vistaAdmin.btnEditarUsuario.addActionListener(this);
        this.vistaAdmin.btnEliminarUsuario.addActionListener(this);
        this.vistaAdmin.btnRefresh2.addActionListener(this);
        this.vistaAdmin.tblUsuarios.addMouseListener(this);
    }
    //============Método para iniciar la pantalla de administrador============//
    public void iniciarVistaAdmin() {
        Font font = new Font("Montserrat", 0, 13);
        vistaAdmin.setTitle("Voyager Airlines - Panel de administración");
        vistaAdmin.pack();
        vistaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setVisible(true);
        vistaAdmin.setResizable(false);
        //=====================Enviar ícono a la pantalla=====================//
        vistaAdmin.setIconImage(new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage());
        //=====Enviar alto de las celdas en las tablas=====//
        this.vistaAdmin.tblAviones.setRowHeight(30);
        this.vistaAdmin.jTableVuelos.setRowHeight(30);
        this.vistaAdmin.tblTripulacion.setRowHeight(30);
        this.vistaAdmin.tblUsuarios.setRowHeight(30);
        this.vistaAdmin.jTableHV.setRowHeight(30);
//        this.vistaAdmin.tblTripulacion.isCellEditable(idTrip, idAvion);
        //=====Íconos=====//
        ImageIcon avion_logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon refrescar = new ImageIcon(getClass().getResource(("/icons/refresh.png")));
        ImageIcon find = new ImageIcon(getClass().getResource(("/icons/find.png")));
        ImageIcon airplane = new ImageIcon(getClass().getResource(("/icons/airplane.png")));
        ImageIcon employers = new ImageIcon(getClass().getResource(("/icons/empleados.png")));
        ImageIcon HVLT = new ImageIcon(getClass().getResource("/icons/HVentIcon.png"));
        ImageIcon HVRlogo = new ImageIcon(getClass().getResource("/icons/HVRIcon.png"));
        ImageIcon HVSlogo = new ImageIcon(getClass().getResource("/icons/HVSIcon.png"));
        ImageIcon users = new ImageIcon(getClass().getResource(("/icons/users.png")));
        //=====Íconos con tamaño específico=====//
        ImageIcon logotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelBigLogo.getWidth(), vistaAdmin.jLabelBigLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon SmallLogotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelSmallLogo.getWidth(), vistaAdmin.jLabelSmallLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon avionSeccion = new ImageIcon(airplane.getImage().getScaledInstance(vistaAdmin.jLabelImgSeccion.getWidth(), vistaAdmin.jLabelImgSeccion.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon buscar = new ImageIcon(find.getImage().getScaledInstance(vistaAdmin.jLabelImgBuscar.getWidth(), vistaAdmin.jLabelImgBuscar.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon refresh = new ImageIcon(refrescar.getImage().getScaledInstance(vistaAdmin.btnRefresh.getWidth(), vistaAdmin.btnRefresh.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon empleados = new ImageIcon(employers.getImage().getScaledInstance(vistaAdmin.jLabelImgSeccionTripulacion.getWidth(), vistaAdmin.jLabelImgSeccionTripulacion.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon HVLOGOTITLE = new ImageIcon(HVLT.getImage().getScaledInstance(vistaAdmin.JlHVIcon.getWidth(), vistaAdmin.JlHVIcon.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon HVRIcon = new ImageIcon(HVRlogo.getImage().getScaledInstance(vistaAdmin.btnRefreshHV.getWidth(), vistaAdmin.btnRefreshHV.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon HVSIcon = new ImageIcon(HVSlogo.getImage().getScaledInstance(vistaAdmin.jLBHVIcon.getWidth(), vistaAdmin.jLBHVIcon.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon usuarios = new ImageIcon(users.getImage().getScaledInstance(vistaAdmin.jLabelImgSeccionUsuarios.getWidth(), vistaAdmin.jLabelImgSeccionUsuarios.getHeight(), Image.SCALE_DEFAULT));
        //=====Enviar íconos a los componentes=====//
        vistaAdmin.jLabelBigLogo.setIcon(logotipo);
        vistaAdmin.jLabelSmallLogo.setIcon(SmallLogotipo);
        vistaAdmin.jLabelImgBuscar.setIcon(buscar);
        vistaAdmin.btnRefresh.setIcon(refresh);
        vistaAdmin.jLabelImgSeccion.setIcon(avionSeccion);
        vistaAdmin.jLabelImgSeccionTripulacion.setIcon(empleados);
        vistaAdmin.jLabelImgSeccionUsuarios.setIcon(usuarios);
        vistaAdmin.lblImgBuscar1.setIcon(buscar);
        vistaAdmin.lblImgBuscar2.setIcon(buscar);
        vistaAdmin.btnRefresh1.setIcon(refresh);
        vistaAdmin.btnRefresh2.setIcon(refresh);
        vistaAdmin.JlHVIcon.setIcon(HVLOGOTITLE);
        vistaAdmin.btnRefreshHV.setIcon(HVRIcon);
        vistaAdmin.jLBHVIcon.setIcon(HVSIcon);
        //=====Detalles de los componentes sección avión=====//
        vistaAdmin.tblAviones.setModel(modeloAdmin.tablaAviones());
        vistaAdmin.btnAvionDetalles.setEnabled(false);
        //============Detalles de los componentes de sección vuelo============//
        vistaAdmin.btnEditarVuelo.setEnabled(false);
        vistaAdmin.btnEliminarVuelo.setEnabled(false);
        vistaAdmin.txtBuscarVuelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarVueloKeyPressed(evt);
            }
         });
        //=========Detalles de los componentes de sección tripulación=========//
        vistaAdmin.btnEditarTripulacion.setEnabled(false);
        vistaAdmin.btnEliminarTripulacion.setEnabled(false);
        
        vistaAdmin.cmbTripulacion.addItem("Mostrar todo");
        vistaAdmin.cmbTripulacion.addItem("Mostrar pilotos");
        vistaAdmin.cmbTripulacion.addItem("Mostrar copilotos");
        vistaAdmin.cmbTripulacion.addItem("Mostrar azafatas(os)");
        
        vistaAdmin.txtBuscarTripulacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarTripulacionKeyPressed(evt);
            }
         });
        
        vistaAdmin.cmbTripulacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTripulacionItemStateChanged(evt);
            }
        });
        //===========Detalles de los componentes de sección usuarios==========//
        vistaAdmin.btnEliminarUsuario.setEnabled(false);
        vistaAdmin.btnEditarUsuario.setEnabled(false);
        
        vistaAdmin.cbxUsuario.addItem("Mostrar todo");
        vistaAdmin.cbxUsuario.addItem("Trabajadores");
        vistaAdmin.cbxUsuario.addItem("Clientes");
        
        vistaAdmin.txtBuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarUsuarioKeyPressed(evt);
            }
         });
        
        vistaAdmin.cbxUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxUsuariosItemStateChanged(evt);
            }
        });
        //=====Seleccionar el panel visible al ingresar=====//
        vistaAdmin.Inicio.setVisible(true);
        vistaAdmin.pnlAsientos.setVisible(false);
        vistaAdmin.Aviones.setVisible(false);
        vistaAdmin.Usuarios.setVisible(false);
        vistaAdmin.Ventas.setVisible(false);
        vistaAdmin.Vuelos.setVisible(false);
        vistaAdmin.Tripulacion.setVisible(false);
        //=====Enviar el nombre del usuario a la ventana de adminsitrador=====//
        vistaAdmin.lblNombre.setText(this.s.getNombre());
    }
    
    private void txtBuscarVueloKeyPressed(java.awt.event.KeyEvent evt) {                                          
        // TODO add your handling code here:
        //System.out.println("Se ha tecleado");
        String palabra = vistaAdmin.txtBuscarVuelo.getText();
        vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsultaBuscar(palabra));
    }
    
    private void txtBuscarTripulacionKeyPressed(java.awt.event.KeyEvent evt) {                                          
        // TODO add your handling code here:
        //System.out.println("Se ha tecleado");
        String palabra = vistaAdmin.txtBuscarTripulacion.getText();
        vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsultaBuscar(palabra));
        widthColumnTblTripulacion();
    }
    
    private void txtBuscarUsuarioKeyPressed(java.awt.event.KeyEvent evt) {
        String palabra = vistaAdmin.txtBuscarUsuario.getText();
        vistaAdmin.tblUsuarios.setModel(modeloAdmin.usuariosConsultaBuscar(palabra));
        widthColumnTblUsuarios();
    }
    
    private void cmbTripulacionItemStateChanged(java.awt.event.ItemEvent evt) {
        switch(vistaAdmin.cmbTripulacion.getSelectedIndex()){
            case 0:
                vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsulta());
                widthColumnTblTripulacion();
                break;
            case 1:
                vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsultaPrecisa("Piloto"));
                widthColumnTblTripulacion();
                break;
            case 2:
                vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsultaPrecisa("Copiloto"));
                widthColumnTblTripulacion();
                break;
            case 3:
                vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsultaPrecisa("Azafata(o)"));
                widthColumnTblTripulacion();
                break;
        }
        //vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsultaBuscar());
    }  
    private void cbxUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {
        switch(vistaAdmin.cbxUsuario.getSelectedIndex()){
            case 0:
                vistaAdmin.tblUsuarios.setModel(modeloAdmin.usuariosConsulta());
                widthColumnTblUsuarios();
                break;
            case 1:
                vistaAdmin.tblUsuarios.setModel(modeloAdmin.usuariosConsultaPrecisa(2));
                widthColumnTblUsuarios();
                break;
            case 2:
                vistaAdmin.tblUsuarios.setModel(modeloAdmin.usuariosConsultaPrecisa(3));
                widthColumnTblUsuarios();
                break;
        }
        //vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsultaBuscar());
    } 
    
    public void widthColumnTblTripulacion(){
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(0).setMinWidth(60);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(0).setMaxWidth(60);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(0).setPreferredWidth(60);

        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(1).setMinWidth(80);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(1).setMaxWidth(80);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(1).setPreferredWidth(80);

        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(3).setMinWidth(70);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(3).setMaxWidth(70);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(3).setPreferredWidth(70);

        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(4).setMinWidth(90);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(4).setMaxWidth(90);
        this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(4).setPreferredWidth(90);
    }
    
    public void widthColumnTblUsuarios(){
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(2).setMinWidth(80);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(2).setMaxWidth(80);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(80);
        
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(3).setMinWidth(90);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(3).setMaxWidth(90);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(3).setPreferredWidth(90);

        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(4).setMinWidth(90);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(4).setMaxWidth(90);
        this.vistaAdmin.tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(90);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //======Acciones realizadas dentro de la ventana de administrador=====//
        //===Panel de inicio===//
        if(vistaAdmin.btnInicio == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(true);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
        }
        //===Panel de aviones===//
        else if(vistaAdmin.btnAviones == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(true);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
        }
        //===Panel de usuarios===//
        else if(vistaAdmin.btnUsuarios == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(true);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
            
            vistaAdmin.tblUsuarios.setModel(modeloAdmin.usuariosConsulta());
            widthColumnTblUsuarios();
        }
        //===Panel de ventas===//
        else if(vistaAdmin.btnVentas == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(true);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
            
            vistaAdmin.jTableHV.setModel(modeloAdmin.VentasConsulta());
        }
        //=====================================================================================//
        else if(vistaAdmin.btnRefreshHV == e.getSource()){
            limpiarArreglos();
            vistaAdmin.jTableHV.setModel(modeloAdmin.VentasConsulta());
        }
        //===Panel de vuelos===//
        else if(vistaAdmin.btnVuelos == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(true);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
            
            vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsulta());
            vistaAdmin.btnEditarVuelo.setEnabled(false);
        }
        //===Panel de tripulación===//
        else if(vistaAdmin.btnTripulacion == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(true);
            
            vistaAdmin.cmbTripulacion.setSelectedIndex(0);
            vistaAdmin.txtBuscarTripulacion.setText("");
            vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsulta());
            widthColumnTblTripulacion();
        }
        //===Para cerrar el programa===//
        else if(vistaAdmin.btnSalirPrograma == e.getSource()){
            System.exit(0);
        }
        //===Para minimizar la pantalla===//
        else if(vistaAdmin.btnMinimizar == e.getSource()){
            vistaAdmin.setExtendedState(1);
        }
        //=============Acciones realizadas en el panel de usuario=============//
        else if(vistaAdmin.btnAgregarUsuario == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEditarUsuario.setEnabled(false);
            vistaAdmin.btnEliminarUsuario.setEnabled(false);
            vAgregarUsuario addUsuario = new vAgregarUsuario();
            cUser controladorUsuario = new cUser(addUsuario, 1, 0);
            controladorUsuario.iniciarAgregar();
            
        }
        else if(vistaAdmin.btnEditarUsuario == e.getSource()){
            limpiarArreglos();
            vAgregarUsuario editUsuario = new vAgregarUsuario();
            cUser controladorUsuario = new cUser(editUsuario, 2, this.idUser);
            controladorUsuario.iniciarAgregar();
        }
        else if(vistaAdmin.btnEliminarUsuario == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            if(this.idUser>9)
                mostrarAlerta.agregarContenido(6, "¿Seguro que desea eliminar el usuario número "+this.idUser+"?");
            else
                mostrarAlerta.agregarContenido(6, "¿Seguro que desea eliminar el usuario número 0"+this.idUser+"?");
            mostrarAlerta.setSeccionEliminar(3); //==Enviar tipo de eliminar==//
            mostrarAlerta.iniciarAlerta();
        }
        else if(vistaAdmin.btnRefresh2 == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEliminarUsuario.setEnabled(false);
            vistaAdmin.btnEditarUsuario.setEnabled(false);
            
            vistaAdmin.txtBuscarUsuario.setText("");
            vistaAdmin.cbxUsuario.setSelectedIndex(0);
            
            vistaAdmin.tblUsuarios.setModel(modeloAdmin.usuariosConsulta());
            widthColumnTblUsuarios();
        }
        //===========Acciones realizadas en el panel de tripulación===========//
        else if(vistaAdmin.btnAgregarTripulacion == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEditarTripulacion.setEnabled(false);
            vistaAdmin.btnEliminarTripulacion.setEnabled(false);
            vAgregarTripulacion addTripulacion = new vAgregarTripulacion();
            cTripulacion controladorTripulacion = new cTripulacion(addTripulacion, 1, 0);
            controladorTripulacion.iniciarAgregar();
        }
        else if(vistaAdmin.btnEditarTripulacion == e.getSource()){
            limpiarArreglos();
            vAgregarTripulacion editTripulacion = new vAgregarTripulacion();
            cTripulacion controladorTripulacion = new cTripulacion(editTripulacion, 2, this.idTrip);
            controladorTripulacion.iniciarAgregar();
        }
        else if(vistaAdmin.btnEliminarTripulacion == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            if(this.idTrip>9)
                mostrarAlerta.agregarContenido(5, "¿Seguro que desea eliminar el tripulante con el código "+this.idTrip+"?");
            else
                mostrarAlerta.agregarContenido(5, "¿Seguro que desea eliminar el tripulante con el código 0"+this.idTrip+"?");
            mostrarAlerta.setSeccionEliminar(2); //==Enviar tipo de eliminar==//
            mostrarAlerta.iniciarAlerta();
        }
        else if(vistaAdmin.btnRefresh1 == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEditarTripulacion.setEnabled(false);
            vistaAdmin.btnEliminarTripulacion.setEnabled(false);
            
            vistaAdmin.txtBuscarTripulacion.setText("");
            vistaAdmin.cmbTripulacion.setSelectedIndex(0);
            
            vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsulta());
            widthColumnTblTripulacion();
        }
        //==============Acciones realizadas en el panel de vuelos=============//
        else if(vistaAdmin.btnAgregarVuelo == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEditarVuelo.setEnabled(false);
            vistaAdmin.btnEliminarVuelo.setEnabled(false);
            vAgregarVuelo addVuelo = new vAgregarVuelo();
            cVuelos controladorVuelo = new cVuelos(addVuelo, 1, 0);
            controladorVuelo.iniciarAgregar();
        }
        else if(vistaAdmin.btnEditarVuelo == e.getSource()){
            limpiarArreglos();
            vAgregarVuelo editVuelo = new vAgregarVuelo();
            cVuelos controladorVuelo = new cVuelos(editVuelo, 2, this.idVuelo);
            controladorVuelo.iniciarAgregar();
        }
        else if(vistaAdmin.btnEliminarVuelo == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            if(this.idVuelo>9)
                mostrarAlerta.agregarContenido(4, "¿Seguro que desea eliminar el vuelo número "+this.idVuelo+"?");
            else
                mostrarAlerta.agregarContenido(4, "¿Seguro que desea eliminar el vuelo número 0"+this.idVuelo+"?");
            mostrarAlerta.setSeccionEliminar(1); //==Enviar tipo de eliminar==//
            mostrarAlerta.iniciarAlerta();
        }
        else if(vistaAdmin.btnRefresh == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEditarVuelo.setEnabled(false);
            vistaAdmin.btnEliminarVuelo.setEnabled(false);
            vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsulta());
        }
        //==============Acciones realizadas en el panel de avión==============//
        else if(vistaAdmin.btnAvionDetalles == e.getSource()){
            limpiarArreglos();
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.lblAsientos.setLayout(null);
            vistaAdmin.lblAsientos.setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
            Stack<String> ocupados = modeloAdmin.consultarAsientos(idAvion);
            //System.out.println(ocupados.pop());
            String[] oc = new String[ocupados.size()];
            int oc1 = 0;
            while(!ocupados.empty()) {
                oc[oc1] = ocupados.pop();
                oc1++;
            }
            
            JButton Asientos[] = new JButton[238];
            JLabel lblNombres[] = new JLabel[238];
            Font f = new Font("Montserrat", 0, 8);
            char fila = 65;
            int asiento = 1, x = 48, y = 350;
            int ac = 1;
            int ac2 = 0;
            int ac3 = 0;
            for(int i=1; i<238; i++) {
                String numAsiento = String.valueOf(fila) + String.valueOf(asiento); //Número de asiento
                if(i%7 != 0 || i == 0 || i<6) {
                    if(ac == 3) {
                        x+=30;
                        ac = 1;
                    }
                    lblNombres[i-1] = new JLabel(numAsiento);
                    Asientos[i-1] = new JButton();
                    Asientos[i-1].setBounds(x, y, 20, 20);
                    lblNombres[i-1].setBounds(x+5, y+20, 19, 19);
                    lblNombres[i-1].setFont(f);
                    for(int t=0; t<oc.length; t++) {
                        if(oc[t].equals(numAsiento)) {
                            Asientos[i-1].setBackground(new java.awt.Color(255, 0, 0));
                            Asientos[i-1].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ActionEvent) {
                                    getLblAsientoCliente().setText("Asiento: " + numAsiento);
                                    getLblNombreCliente().setText(getMAdmin().getNombreCliente(numAsiento, idAvion));
                                    System.out.println("Clic en " + numAsiento);
                                }
                            });
                        }
                    }
                    vistaAdmin.lblAsientos.add(Asientos[i-1]);
                    vistaAdmin.lblAsientos.add(lblNombres[i-1]);
                    
                    asiento++;
                    x+=25;
                    ac++;
                    
                }
                else {
                    ac2++;
                    if(ac2 == 2) {
                        asiento = 1;
                        fila++;
                        ac2=0;
                    }
                    x=48;
                    y+=40;
                    ac = 1;
                    if(String.valueOf(fila).equals("E") && ac3 == 0) {
                        y+=120;
                        ac3++;
                    }
                    if(String.valueOf(fila).equals("N") && ac3 == 1) {
                        y+=120;
                        ac3++;
                    }
                    
                    if(String.valueOf(fila).equals("R") && ac3 == 2) {
                        System.out.println("Vueltas "+ i);
                        break;
                    }
                }
            }
            vistaAdmin.pnlAsientos.setVisible(true);
        }
        
        if(e.getSource() == vistaAdmin.btnCerrar) {
            vLogin vL = new vLogin();
            mLogin mL = new mLogin();
            this.s.destruirSesion();
            this.vistaAdmin.dispose();
            cLogin cL = new cLogin(mL, vL);
            cL.iniciarVista();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //=============Acciones realizadas en el panel de aviones=============//
        if(e.getSource() == this.vistaAdmin.tblAviones) {
            int fila = vistaAdmin.tblAviones.rowAtPoint(e.getPoint());
            if(fila > -1) {
                //Muchos casteos :'v
                vistaAdmin.btnAvionDetalles.setEnabled(true);
                this.idAvion = Integer.parseInt(String.valueOf(vistaAdmin.tblAviones.getValueAt(fila, 0)));
                System.out.println("Clic en la tabla");
            }
        }
        if(this.vistaAdmin.jTableVuelos == e.getSource()){
            int fila = vistaAdmin.jTableVuelos.rowAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vistaAdmin.tblTripulacion.getColumnCount(); i++) {
                    if(vistaAdmin.tblTripulacion.getColumnName(i).equals("Código")){
                        this.idVuelo = Integer.parseInt(String.valueOf(vistaAdmin.jTableVuelos.getValueAt(fila, i)));
                        break;
                    }
                }
            }
            
            vistaAdmin.btnEditarVuelo.setEnabled(true);
            vistaAdmin.btnEliminarVuelo.setEnabled(true);
        }
        if(this.vistaAdmin.tblTripulacion == e.getSource()){
            int fila = vistaAdmin.tblTripulacion.rowAtPoint(e.getPoint());
            //fila = vistaAdmin.tblTripulacion.columnAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vistaAdmin.tblTripulacion.getColumnCount(); i++) {
                    if(vistaAdmin.tblTripulacion.getColumnName(i).equals("Código")){
                        this.idTrip = Integer.parseInt(String.valueOf(vistaAdmin.tblTripulacion.getValueAt(fila, i)));
                        break;
                    }
                }
            }
            vistaAdmin.btnEditarTripulacion.setEnabled(true);
            vistaAdmin.btnEliminarTripulacion.setEnabled(true);
        }
        if(this.vistaAdmin.tblUsuarios == e.getSource()){
            int fila = vistaAdmin.tblUsuarios.rowAtPoint(e.getPoint());
            //fila = vistaAdmin.tblTripulacion.columnAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vistaAdmin.tblUsuarios.getColumnCount(); i++) {
                    if(vistaAdmin.tblUsuarios.getColumnName(i).equals("Código")){
                        this.idUser = Integer.parseInt(String.valueOf(vistaAdmin.tblUsuarios.getValueAt(fila, i)));
                        break;
                    }
                }
            }
            vistaAdmin.btnEditarUsuario.setEnabled(true);
            vistaAdmin.btnEliminarUsuario.setEnabled(true);
        }
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
    //=================Método para limpiar los campos de texto================//
    private void limpiarArreglos() {
        vistaAdmin.lblAsientos.removeAll();
        vistaAdmin.lblAsientoCliente.setText("Asiento: ");
        vistaAdmin.lblNombreCliente.setText("");
    }
    
    private JLabel getLblAsientoCliente() {
        return this.vistaAdmin.lblAsientoCliente;
    }
    
    private JLabel getLblNombreCliente() {
        return this.vistaAdmin.lblNombreCliente;
    }
    
    private mAdmin getMAdmin() {
        return this.modeloAdmin;
    }
}
