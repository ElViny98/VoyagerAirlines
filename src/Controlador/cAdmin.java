package controlador;

import vista.*;
import modelo.*;

import rojerusan.RSAnimation;
import java.awt.Cursor;
import java.awt.Desktop;
import static java.awt.Frame.DEFAULT_CURSOR;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rojerusan.RSButtonMaterial;

public class cAdmin implements ActionListener, MouseListener{
    //=====Para la interfaz de administrador=====//
    vAdmin vAdmin = new vAdmin();
    mAdmin mAdmin = new mAdmin();
    Sesion sesion;
    //=====Variable para activar el panel correspondiente=====//
    private int valorPanel;
    //=====Variable para mostrar o esconder el menú=====//
    boolean mostrar, mostrarPanelExtraVuelos;
    //=====Variables para disponibilidad de botones=====//
    boolean disponibleEditar, disponibleEliminar, disponibleDetalles, disponibleTips;
    //=====Variables para seleccionar si se agrega o edita=====//
    boolean agregarAvion;
    boolean agregarUsuarios;
    boolean agregarVuelos;
    boolean buscandoVuelosTripulacion;
    boolean agregarTripulacion;
    //=====Variables para almacenar condiciones de búsqueda=====//
    private String[] condicionAvion = new String[3]; //0: ID, 1: Nombre, 2: cbx - estatus
    private String[] condicionUsuarios = new String[3]; //0: Nombre, 1: Nacionalidad, 2: cbx - tipo
    private String[] condicionVentas = new String[3]; //0: ID, 1: Nombre, 2: cbx - Pago
    private String[] condicionVuelos = new String[2]; //0: ID, 1: Nombre
    private String[] condicionTripulacion = new String[3]; //0: ID, 1: Nombre, 2: cbx - Puesto
    //=====Variables que almacenan los ID=====//
    private int idAvion;
    private int idUsuario;
    private int idVentas;
    private int idVuelos, idVuelosEleccion, tipoEditarVuelos;
    private int idTripulacion;
    //=====Variables para almacenar consultas específicas=====//
    private String[] datosAvion = new String[4];
    private String[] datosUsuario = new String[4];
    private String[] bestVentas = new String[6];
    private String[] datosVenta = new String[4];
    private String[] datosVuelos = new String[10];
    private String[] datosTripulacion = new String[5];
    private String texto;
    
    public cAdmin(vAdmin vAdmin, mAdmin mAdmin, Sesion sesion, int valor) {
        this.valorPanel=valor;
        
        this.vAdmin = vAdmin;
        this.mAdmin = mAdmin;
        this.sesion = sesion;
        this.mostrar=true;
        this.mostrarPanelExtraVuelos=false;
        
        this.agregarAvion=false;
        this.agregarUsuarios=false;
        this.agregarVuelos=false;
        this.buscandoVuelosTripulacion=false;
        this.agregarTripulacion=false;
        
        this.idAvion=0;
        this.idUsuario=0;
        this.idVentas=0;
        this.idVuelos=0;
        this.idTripulacion=0;
        
        this.condicionAvion[0] = "";
        this.condicionAvion[1] = "";
        this.condicionAvion[2] = "";
        
        this.condicionUsuarios[0] = "";
        this.condicionUsuarios[1] = "";
        this.condicionUsuarios[2] = "";
                
        this.condicionVentas[0] = "";
        this.condicionVentas[1] = "";
        this.condicionVentas[2] = "";
        
        this.condicionVuelos[0] = "";
        this.condicionVuelos[1] = "";
        
        this.condicionTripulacion[0] = "";
        this.condicionTripulacion[1] = "";
        this.condicionTripulacion[2] = "";
        //=====Para disponibilidad de los botones=====//
        this.disponibleEditar=false;
        this.disponibleEliminar=false;
        this.disponibleDetalles=false;
        this.disponibleTips=false;
        //=====Botones=====//
        this.vAdmin.btnSalir.addActionListener(this);
        this.vAdmin.btnMinimizar.addActionListener(this);
        this.vAdmin.btnVerTripulacionAgregarEditarVuelos.addActionListener(this);
        this.vAdmin.btnVerAvionAgregarEditarVuelos.addActionListener(this);
        //=====Íconos de menú=====//
        this.vAdmin.lblMenuIcon.addMouseListener(this);
        this.vAdmin.lblAvionesIcon.addMouseListener(this);
        this.vAdmin.lblConfigIcon.addMouseListener(this);
        this.vAdmin.lblHomeIcon.addMouseListener(this);
        this.vAdmin.lblTripulacionIcon.addMouseListener(this);
        this.vAdmin.lblUsuariosIcon.addMouseListener(this);
        this.vAdmin.lblVentasIcon.addMouseListener(this);
        this.vAdmin.lblVuelosIcon.addMouseListener(this);
        //=====Opciones de menú=====//
        this.vAdmin.lblAvionesTexto.addMouseListener(this);
        this.vAdmin.lblConfigTexto.addMouseListener(this);
        this.vAdmin.lblHomeTexto.addMouseListener(this);
        this.vAdmin.lblTripulacionTexto.addMouseListener(this);
        this.vAdmin.lblUsuariosTexto.addMouseListener(this);
        this.vAdmin.lblVentasTexto.addMouseListener(this);
        this.vAdmin.lblVuelosTexto.addMouseListener(this);
        //=====Opciones de la opción de avión=====//
        this.vAdmin.btnDetallesAvion.addMouseListener(this);
        this.vAdmin.btnEditarAvion.addMouseListener(this);
        this.vAdmin.btnEliminarAvion.addMouseListener(this);
        this.vAdmin.btnAgregarAvion.addMouseListener(this);
        this.vAdmin.lblAgregarAvionIcon.addMouseListener(this);
        this.vAdmin.lblEditarAvionIcon.addMouseListener(this);
        this.vAdmin.lblEliminarAvionIcon.addMouseListener(this);
        this.vAdmin.lblDetallesAvionIcon.addMouseListener(this);
        this.vAdmin.btnTipsAvion.addMouseListener(this);
        this.vAdmin.lblActualizarAvionIcon.addMouseListener(this);
        this.vAdmin.lblCancelarAvionIcon.addMouseListener(this);
        this.vAdmin.lblConfirmarAgregarEditarAvion.addMouseListener(this);
        this.vAdmin.lblCancelarAgregarEditarAvion.addMouseListener(this);
        this.vAdmin.lblRegresarAgregarEditarAvion.addMouseListener(this);
        this.vAdmin.tblAvion.addMouseListener(this);
        
        //=====Opciones de la opción de usuarios=====//
        this.vAdmin.btnDetallesUsuarios.addMouseListener(this);
        this.vAdmin.btnEditarUsuarios.addMouseListener(this);
        this.vAdmin.btnEliminarUsuarios.addMouseListener(this);
        this.vAdmin.btnAgregarUsuarios.addMouseListener(this);
        this.vAdmin.btnTipsUsuarios.addMouseListener(this);
        this.vAdmin.lblActualizarUsuariosIcon.addMouseListener(this);
        this.vAdmin.lblCancelarUsuariosIcon.addMouseListener(this);
        this.vAdmin.lblConfirmarAgregarEditarUsuarios.addMouseListener(this);
        this.vAdmin.lblCancelarAgregarEditarUsuarios.addMouseListener(this);
        this.vAdmin.lblRegresarAgregarEditarUsuarios.addMouseListener(this);
        this.vAdmin.tblUsuarios.addMouseListener(this);
        //=====Opciones de la opción de ventas=====//
        this.vAdmin.btnDetallesVentas.addMouseListener(this);
        this.vAdmin.btnVentaVentas.addMouseListener(this);
        this.vAdmin.btnTipsVentas.addMouseListener(this);
        this.vAdmin.lblActualizarVentasIcon.addMouseListener(this);
        this.vAdmin.lblCancelarVentasIcon.addMouseListener(this);
        this.vAdmin.tblVentas.addMouseListener(this);
        //=====Opciones de la opción de vuelos=====//
        this.vAdmin.btnDetallesVuelos.addMouseListener(this);
        this.vAdmin.btnEditarVuelos.addMouseListener(this);
        this.vAdmin.btnEliminarVuelos.addMouseListener(this);
        this.vAdmin.btnAgregarVuelos.addMouseListener(this);
        this.vAdmin.btnTipsVuelos.addMouseListener(this);
        this.vAdmin.lblActualizarUsuariosIcon.addMouseListener(this);
        this.vAdmin.lblCancelarVuelosIcon.addMouseListener(this);
        this.vAdmin.lblConfirmarAgregarEditarVuelos.addMouseListener(this);
        this.vAdmin.lblCancelarAgregarEditarVuelos.addMouseListener(this);
        this.vAdmin.lblRegresarAgregarEditarVuelos.addMouseListener(this);
        this.vAdmin.tblVuelos.addMouseListener(this);
        this.vAdmin.tblVuelosSeleccionAgregarEditar.addMouseListener(this);
        this.vAdmin.cbEscalaVuelos.addActionListener(this);
        //=====Opciones de la opción de tripulación=====//
        this.vAdmin.btnDetallesTripulacion.addMouseListener(this);
        this.vAdmin.btnEditarTripulacion.addMouseListener(this);
        this.vAdmin.btnEliminarTripulacion.addMouseListener(this);
        this.vAdmin.btnAgregarTripulacion.addMouseListener(this);
        this.vAdmin.btnTipsTripulacion.addMouseListener(this);
        this.vAdmin.lblActualizarTripulacionIcon.addMouseListener(this);
        this.vAdmin.lblCancelarTripulacionIcon.addMouseListener(this);
        this.vAdmin.lblConfirmarAgregarEditarTripulacion.addMouseListener(this);
        this.vAdmin.lblCancelarAgregarEditarTripulacion.addMouseListener(this);
        this.vAdmin.lblRegresarAgregarEditarTripulacion.addMouseListener(this);
        this.vAdmin.tblTripulacion.addMouseListener(this);
        this.vAdmin.tblVuelosSeleccionAgregarEditar.addMouseListener(this);
        this.vAdmin.cbEscalaVuelos.addActionListener(this);
    }
    
    public void iniciarVista(){
        activarPanelSecundario(1);
        activarPanelPrincipal(this.valorPanel);
        
        this.vAdmin.pnlVuelosTripulacionAvion.setVisible(false);
        
        ImageIcon iconLogo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon logo = new ImageIcon(iconLogo.getImage().getScaledInstance(vAdmin.lblLogoIcon.getWidth(), vAdmin.lblLogoIcon.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.lblLogoIcon.setIcon(logo);
        
        ImageIcon iconMenu = new ImageIcon(getClass().getResource(("/icons/menu-blanco.png")));
        ImageIcon menu = new ImageIcon(iconMenu.getImage().getScaledInstance(vAdmin.lblMenuIcon.getWidth(), vAdmin.lblMenuIcon.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.lblMenuIcon.setIcon(menu);
        
        ImageIcon iconHome = new ImageIcon(getClass().getResource(("/icons/home-blanco.png")));
        ImageIcon home = new ImageIcon(iconHome.getImage().getScaledInstance(vAdmin.lblHomeIcon.getWidth()-10, vAdmin.lblHomeIcon.getHeight()-10, Image.SCALE_DEFAULT));
        vAdmin.lblHomeIcon.setIcon(home);
        
        ImageIcon iconAvion = new ImageIcon(getClass().getResource(("/icons/avion-blanco.png")));
        ImageIcon avion = new ImageIcon(iconAvion.getImage().getScaledInstance(vAdmin.lblAvionesIcon.getWidth()-10, vAdmin.lblAvionesIcon.getHeight()-10, Image.SCALE_DEFAULT));
        vAdmin.lblAvionesIcon.setIcon(avion);
        
        ImageIcon iconUsuario = new ImageIcon(getClass().getResource(("/icons/usuarios-blanco.png")));
        ImageIcon usuario = new ImageIcon(iconUsuario.getImage().getScaledInstance(vAdmin.lblUsuariosIcon.getWidth()-10, vAdmin.lblUsuariosIcon.getHeight()-10, Image.SCALE_DEFAULT));
        vAdmin.lblUsuariosIcon.setIcon(usuario);
        
        ImageIcon iconVenta = new ImageIcon(getClass().getResource(("/icons/ventas-blanco.png")));
        ImageIcon venta = new ImageIcon(iconVenta.getImage().getScaledInstance(vAdmin.lblVentasIcon.getWidth()-10, vAdmin.lblVentasIcon.getHeight()-10, Image.SCALE_DEFAULT));
        vAdmin.lblVentasIcon.setIcon(venta);
        
        ImageIcon iconVuelo = new ImageIcon(getClass().getResource(("/icons/vuelos-blanco.png")));
        ImageIcon vuelo = new ImageIcon(iconVuelo.getImage().getScaledInstance(vAdmin.lblVuelosIcon.getWidth()-10, vAdmin.lblVuelosIcon.getHeight()-10, Image.SCALE_DEFAULT));
        vAdmin.lblVuelosIcon.setIcon(vuelo);
        
        ImageIcon iconTripulacion = new ImageIcon(getClass().getResource(("/icons/tripulacion-blanco.png")));
        ImageIcon tripulacion = new ImageIcon(iconTripulacion.getImage().getScaledInstance(vAdmin.lblTripulacionIcon.getWidth()-10, vAdmin.lblTripulacionIcon.getHeight()-10, Image.SCALE_DEFAULT));
        vAdmin.lblTripulacionIcon.setIcon(tripulacion);
        
        ImageIcon iconConfig = new ImageIcon(getClass().getResource(("/icons/configuracion-blanco.png")));
        ImageIcon config = new ImageIcon(iconConfig.getImage().getScaledInstance(vAdmin.lblConfigIcon.getWidth()-10, vAdmin.lblConfigIcon.getHeight()-10, Image.SCALE_DEFAULT));
        vAdmin.lblConfigIcon.setIcon(config);
        
        ImageIcon iconPuntoTerminal = new ImageIcon(getClass().getResource(("/icons/punto-venta.png")));
        ImageIcon puntoTerminal = new ImageIcon(iconPuntoTerminal.getImage().getScaledInstance(vAdmin.lblVentaVentasIcon.getWidth()-40, vAdmin.lblVentaVentasIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblVentaVentasIcon.setIcon(puntoTerminal);
        
        ImageIcon iconAgregar = new ImageIcon(getClass().getResource(("/icons/agregar.png")));
        ImageIcon agregar = new ImageIcon(iconAgregar.getImage().getScaledInstance(vAdmin.lblAgregarAvionIcon.getWidth()-40, vAdmin.lblAgregarAvionIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblAgregarAvionIcon.setIcon(agregar);
        vAdmin.lblAgregarUsuariosIcon.setIcon(agregar);
        vAdmin.lblAgregarVuelosIcon.setIcon(agregar);
        vAdmin.lblAgregarTripulacionIcon.setIcon(agregar);
        
        ImageIcon iconEditar = new ImageIcon(getClass().getResource(("/icons/editar.png")));
        ImageIcon editar = new ImageIcon(iconEditar.getImage().getScaledInstance(vAdmin.lblEditarAvionIcon.getWidth()-40, vAdmin.lblEditarAvionIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblEditarAvionIcon.setIcon(editar);
        vAdmin.lblEditarUsuariosIcon.setIcon(editar);
        vAdmin.lblEditarAvionIcon.setIcon(editar);
        vAdmin.lblEditarVuelosIcon.setIcon(editar);
        vAdmin.lblEditarTripulacionIcon.setIcon(editar);
        
        ImageIcon iconEliminar = new ImageIcon(getClass().getResource(("/icons/eliminar.png")));
        ImageIcon eliminar = new ImageIcon(iconEliminar.getImage().getScaledInstance(vAdmin.lblEliminarAvionIcon.getWidth()-40, vAdmin.lblEliminarAvionIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblEliminarAvionIcon.setIcon(eliminar);
        vAdmin.lblEliminarUsuariosIcon.setIcon(eliminar);
        vAdmin.lblEliminarAvionIcon.setIcon(eliminar);
        vAdmin.lblEliminarVuelosIcon.setIcon(eliminar);
        vAdmin.lblEliminarTripulacionIcon.setIcon(eliminar);
        
        ImageIcon iconDetalles = new ImageIcon(getClass().getResource(("/icons/detalles.png")));
        ImageIcon detalles = new ImageIcon(iconDetalles.getImage().getScaledInstance(vAdmin.lblDetallesAvionIcon.getWidth()-40, vAdmin.lblDetallesAvionIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblDetallesAvionIcon.setIcon(detalles);
        vAdmin.lblDetallesUsuariosIcon.setIcon(detalles);
        vAdmin.lblDetallesVentasIcon.setIcon(detalles);
        vAdmin.lblDetallesAvionIcon.setIcon(detalles);
        vAdmin.lblDetallesVuelosIcon.setIcon(detalles);
        vAdmin.lblDetallesTripulacionIcon.setIcon(detalles);
        
        ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/no-information.png")));
        ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsAvion.getWidth()-40, vAdmin.btnTipsAvion.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.btnTipsAvion.setIcon(information);
        vAdmin.btnTipsUsuarios.setIcon(information);
        vAdmin.btnTipsVentas.setIcon(information);
        vAdmin.btnTipsAvion.setIcon(information);
        vAdmin.btnTipsVuelos.setIcon(information);
        vAdmin.btnTipsTripulacion.setIcon(information);
        
        ImageIcon iconActualizar = new ImageIcon(getClass().getResource(("/icons/actualizar.png")));
        ImageIcon actualizar = new ImageIcon(iconActualizar.getImage().getScaledInstance(vAdmin.lblActualizarAvionIcon.getWidth(), vAdmin.lblActualizarAvionIcon.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.lblActualizarAvionIcon.setIcon(actualizar);
        vAdmin.lblActualizarUsuariosIcon.setIcon(actualizar);
        vAdmin.lblActualizarVentasIcon.setIcon(actualizar);
        vAdmin.lblActualizarVuelosIcon.setIcon(actualizar);
        vAdmin.lblActualizarTripulacionIcon.setIcon(actualizar);
        
        ImageIcon iconCancelar = new ImageIcon(getClass().getResource(("/icons/cancelar.png")));
        ImageIcon cancelar = new ImageIcon(iconCancelar.getImage().getScaledInstance(vAdmin.lblCancelarAvionIcon.getWidth(), vAdmin.lblCancelarAvionIcon.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.lblCancelarAvionIcon.setIcon(cancelar);
        vAdmin.lblCancelarAgregarEditarAvion.setIcon(cancelar);
        vAdmin.lblCancelarAgregarEditarUsuarios.setIcon(cancelar);
        vAdmin.lblCancelarUsuariosIcon.setIcon(cancelar);
        vAdmin.lblCancelarVentasIcon.setIcon(cancelar);
        vAdmin.lblCancelarVuelosIcon.setIcon(cancelar);
        vAdmin.lblCancelarAgregarEditarVuelos.setIcon(cancelar);
        vAdmin.lblCancelarAgregarEditarTripulacion.setIcon(cancelar);
        vAdmin.lblCancelarTripulacionIcon.setIcon(cancelar);
        
        ImageIcon iconConfirmar = new ImageIcon(getClass().getResource(("/icons/confirmar.png")));
        ImageIcon confirmar = new ImageIcon(iconConfirmar.getImage().getScaledInstance(vAdmin.lblConfirmarAgregarEditarAvion.getWidth(), vAdmin.lblConfirmarAgregarEditarAvion.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.lblConfirmarAgregarEditarAvion.setIcon(confirmar);
        vAdmin.lblConfirmarAgregarEditarUsuarios.setIcon(confirmar);
        vAdmin.lblConfirmarAgregarEditarVuelos.setIcon(confirmar);
        vAdmin.lblConfirmarAgregarEditarTripulacion.setIcon(confirmar);
        
        ImageIcon iconCerrar = new ImageIcon(getClass().getResource(("/icons/exit.png")));
        ImageIcon cerrar = new ImageIcon(iconCerrar.getImage().getScaledInstance(vAdmin.lblRegresarAgregarEditarAvion.getWidth(), vAdmin.lblRegresarAgregarEditarAvion.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.lblRegresarAgregarEditarAvion.setIcon(cerrar);
        vAdmin.lblRegresarAgregarEditarUsuarios.setIcon(cerrar);
        vAdmin.lblRegresarAgregarEditarVuelos.setIcon(cerrar);
        vAdmin.lblRegresarAgregarEditarTripulacion.setIcon(cerrar);
                
        ImageIcon iconTip = new ImageIcon(getClass().getResource(("/icons/tips.png")));
        ImageIcon tip = new ImageIcon(iconTip.getImage().getScaledInstance(vAdmin.lblTip1Icon5.getWidth(), vAdmin.lblTip1Icon5.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.lblTip1Icon5.setIcon(tip);
        vAdmin.lblTip2Icon5.setIcon(tip);
        vAdmin.lblTip3Icon5.setIcon(tip);
        vAdmin.lblTip4Icon5.setIcon(tip);
        
        ImageIcon iconPrimero = new ImageIcon(getClass().getResource(("/icons/primero.png")));
        ImageIcon primero = new ImageIcon(iconPrimero.getImage().getScaledInstance(vAdmin.lblVentaVentasIcon.getWidth()-40, vAdmin.lblVentaVentasIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblPrimerLugarIcon.setIcon(primero);
        
        ImageIcon iconSegundo = new ImageIcon(getClass().getResource(("/icons/segundo.png")));
        ImageIcon segundo = new ImageIcon(iconSegundo.getImage().getScaledInstance(vAdmin.lblVentaVentasIcon.getWidth()-40, vAdmin.lblVentaVentasIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblSegundoLugarIcon.setIcon(segundo);
        
        ImageIcon iconTercero = new ImageIcon(getClass().getResource(("/icons/tercero.png")));
        ImageIcon tercero = new ImageIcon(iconTercero.getImage().getScaledInstance(vAdmin.lblVentaVentasIcon.getWidth()-40, vAdmin.lblVentaVentasIcon.getHeight()-40, Image.SCALE_DEFAULT));
        vAdmin.lblTercerLugarIcon.setIcon(tercero);
        
        ImageIcon iconExit = new ImageIcon(getClass().getResource(("/icons/exit-2.png")));
        ImageIcon exit = new ImageIcon(iconExit.getImage().getScaledInstance(vAdmin.btnSalir.getWidth(), vAdmin.btnSalir.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.btnSalir.setIcon(exit);
        
        ImageIcon iconMinimizar = new ImageIcon(getClass().getResource(("/icons/minimizar-2.png")));
        ImageIcon minimizar = new ImageIcon(iconMinimizar.getImage().getScaledInstance(vAdmin.btnMinimizar.getWidth(), vAdmin.btnMinimizar.getHeight(), Image.SCALE_DEFAULT));
        vAdmin.btnMinimizar.setIcon(minimizar);
        
        
        //====================Componentes de avión====================//
        vAdmin.cbxEstadoAvion.addItem("--Mostrar todo--");
        vAdmin.cbxEstadoAvion.addItem("Número 1");
        vAdmin.cbxEstadoAvion.addItem("Número 2");
        actualizarTablaAvion();
        
        /*String texto = "<html><body>Para poder eliminar o editar un registro, primero debe seleccionar un registro en la tabla de aviones</body></html>";
        this.vAdmin.lblTip1.setText(texto);
        texto = "<html><body>Para realizar una búsqueda específica, debe usar alguno de los campos mostrados a la derecha de la tabla de aviones."
                + "Puede utilizar varios campos de búsqueda.</body></html>";
        this.vAdmin.lblTip2.setText(texto);
        texto = "<html><body>Para volver a mostrar la tabla de registros. <br>"
                + "Si se encuentra en TIPS, debe volver a dar clic en el botón de info. en la parte superior. <br>"
                + "Si se enuentra en editar registro, sólo debe dar clic en regresar, o botón de confirmar.</body></html>";
        this.vAdmin.lblTip3.setText(texto);*/
        vAdmin.txtBuscarIDAvion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarIDAvionKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarIDAvionKeyReleased(evt);
            }
        });
        
        vAdmin.txtBuscarNombreAvion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreAvionKeyReleased(evt);
            }
        });
        
        vAdmin.cbxEstadoAvion.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEstadoAvionItemStateChanged(evt);
            }
        });
        //====================Componentes de usuario====================//
        vAdmin.cbxTipoUsuarios.addItem("--Mostrar todo--");
        vAdmin.cbxTipoUsuarios.addItem("Administradores");
        vAdmin.cbxTipoUsuarios.addItem("Trabajadores");
        vAdmin.cbxTipoUsuarios.addItem("Clientes");
        actualizarTablaUsuarios();
        vAdmin.txtBuscarNombreUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreUsuariosKeyReleased(evt);
            }
        });
        
        vAdmin.txtBuscarNacionalidadUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNacionalidadUsuariosKeyReleased(evt);
            }
        });
        
        vAdmin.cbxTipoUsuarios.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoUsuariosItemStateChanged(evt);
            }
        });
        //====================Componentes de ventas====================//
        this.bestVentas = mAdmin.bestVentas();
        vAdmin.lblPrimerLugarTexto.setText(this.bestVentas[0]);
        vAdmin.lblSegundoLugarTexto.setText(this.bestVentas[2]);
        vAdmin.lblTercerLugarTexto.setText(this.bestVentas[4]);
        
        vAdmin.cbxPagoVentas.addItem("--Mostrar todo--");
        vAdmin.cbxPagoVentas.addItem("Pago efectivo");
        vAdmin.cbxPagoVentas.addItem("Pago tarjeta");
        actualizarTablaVentas();
        vAdmin.txtBuscarIDVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarIDVentasKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarIDVentasKeyReleased(evt);
            }
        });
        
        vAdmin.txtBuscarNombreVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreVentasKeyReleased(evt);
            }
        });
        
        vAdmin.cbxPagoVentas.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPagoVentasItemStateChanged(evt);
            }
        });
        //====================Componentes de vuelos====================//
        actualizarTablaVuelos();
        vAdmin.txtBuscarIDVuelos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarIDVuelosKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarIDVuelosKeyReleased(evt);
            }
        });
        
        vAdmin.txtBuscarNombreVuelos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreVuelosKeyReleased(evt);
            }
        });
        //====================Componentes de tripulación====================//
        vAdmin.cbxTripulacionPuesto.addItem("Piloto/a");
        vAdmin.cbxTripulacionPuesto.addItem("Copiloto/a");
        vAdmin.cbxTripulacionPuesto.addItem("Azafato/a");
        actualizarTablaTripulacion();
        vAdmin.txtBuscarIDTripulacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarIDTripulacionKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarIDTripulacionKeyReleased(evt);
            }
        });
        
        vAdmin.txtBuscarNombreTripulacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarNombreTripulacionKeyReleased(evt);
            }
        });
        
        vAdmin.cbxPuestoTripulacion.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPuestoTripulacionItemStateChanged(evt);
            }
        });
        
        
        
        this.vAdmin.setIconImage(new ImageIcon(getClass().getResource("/icons/avion-3.png")).getImage());
        this.vAdmin.setTitle("Administrador");
        this.vAdmin.setVisible(true);
        this.vAdmin.setLocationRelativeTo(null);
    }
    
    private void restaurarValores()
    {
        this.mostrarPanelExtraVuelos=false;
        
        this.disponibleEditar=false;
        this.disponibleEliminar=false;
        this.disponibleDetalles=false;
        this.disponibleTips=false;
    }
    
    public void activarPanelPrincipal(int valor)
    {
        switch(valor)
        {
            case 1://==Activar el panel de avión==//
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlUsuarios);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVentas);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVuelos);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlTripulacion);
                RSAnimation.setMoverIzquierda(1000, 60, 0, 1, this.vAdmin.pnlAviones);
                this.vAdmin.pnlAvionBoton.setBackground(new java.awt.Color(0, 139, 185));
                this.vAdmin.pnlUsuarioBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVentaBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVueloBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlTripulacionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.lblSeccion.setText("Avión");
                
                this.vAdmin.pnlUsuarios.setVisible(false);
                this.vAdmin.pnlVentas.setVisible(false);
                this.vAdmin.pnlVuelos.setVisible(false);
                this.vAdmin.pnlTripulacion.setVisible(false);
                this.vAdmin.pnlAviones.setVisible(true);
                
                this.texto = "<html><body>Para poder eliminar o editar un registro, primero debe seleccionar un registro en la tabla de aviones</body></html>";
                this.vAdmin.lblTip1111.setText(texto);
                texto = "<html><body>Para realizar una búsqueda específica, debe usar alguno de los campos mostrados a la derecha de la tabla de aviones."
                        + "Puede utilizar varios campos de búsqueda.</body></html>";
                this.vAdmin.lblTip22.setText(texto);
                texto = "<html><body>Para volver a mostrar la tabla de registros. <br>"
                        + "Si se encuentra en TIPS, debe volver a dar clic en el botón de info. en la parte superior. <br>"
                        + "Si se enuentra en editar registro, sólo debe dar clic en regresar, o botón de confirmar.</body></html>";
                this.vAdmin.lblTip23.setText(texto);
                this.texto = "<html><body>Clic en reporte para poder generar un reporte PDF</body></html>";
                this.vAdmin.lblTip24.setText(texto);
                break;
            case 2://==Activar el panel de usuario==//
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlAviones);
                
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVentas);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVuelos);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlTripulacion);
                RSAnimation.setMoverIzquierda(1000, 60, 0, 1, this.vAdmin.pnlUsuarios);
                this.vAdmin.pnlUsuarioBoton.setBackground(new java.awt.Color(0, 139, 185));
                this.vAdmin.pnlAvionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVentaBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVueloBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlTripulacionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.lblSeccion.setText("Usuarios");
                
                this.vAdmin.pnlUsuarios.setVisible(true);
                this.vAdmin.pnlVentas.setVisible(false);
                this.vAdmin.pnlVuelos.setVisible(false);
                this.vAdmin.pnlTripulacion.setVisible(false);
                this.vAdmin.pnlAviones.setVisible(false);
                this.texto = "<html><body>Para poder eliminar o editar un registro, primero debe seleccionar un registro en la tabla de usuarios</body></html>";
                this.vAdmin.lblTip1111.setText(texto);
                texto = "<html><body>Para realizar una búsqueda específica, debe usar alguno de los campos mostrados a la derecha de la tabla de usuarios."
                        + "Puede utilizar varios campos de búsqueda.</body></html>";
                this.vAdmin.lblTip22.setText(texto);
                texto = "<html><body>Para volver a mostrar la tabla de registros. <br>"
                        + "Si se encuentra en TIPS, debe volver a dar clic en el botón de info. en la parte superior. <br>"
                        + "Si se enuentra en editar registro, sólo debe dar clic en regresar, o botón de confirmar.</body></html>";
                this.vAdmin.lblTip23.setText(texto);
                this.texto = "<html><body>Clic en reporte para poder generar un reporte PDF</body></html>";
                this.vAdmin.lblTip24.setText(texto);
                break;
            case 3://==Activar el panel de ventas==//
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlAviones);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlUsuarios);
                
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVuelos);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlTripulacion);
                RSAnimation.setMoverIzquierda(1000, 60, 0, 1, this.vAdmin.pnlVentas);
                this.vAdmin.pnlVentaBoton.setBackground(new java.awt.Color(0, 139, 185));
                this.vAdmin.pnlAvionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlUsuarioBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVueloBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlTripulacionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.lblSeccion.setText("Ventas");
                
                this.vAdmin.pnlUsuarios.setVisible(false);
                this.vAdmin.pnlVentas.setVisible(true);
                this.vAdmin.pnlVuelos.setVisible(false);
                this.vAdmin.pnlTripulacion.setVisible(false);
                this.vAdmin.pnlAviones.setVisible(false);
                this.texto = "<html><body>Para poder eliminar o editar un registro, primero debe seleccionar un registro en la tabla de ventas</body></html>";
                this.vAdmin.lblTip1111.setText(texto);
                texto = "<html><body>Para realizar una búsqueda específica, debe usar alguno de los campos mostrados a la derecha de la tabla de ventas."
                        + "Puede utilizar varios campos de búsqueda.</body></html>";
                this.vAdmin.lblTip22.setText(texto);
                texto = "<html><body>Para volver a mostrar la tabla de registros. <br>"
                        + "Si se encuentra en TIPS, debe volver a dar clic en el botón de info. en la parte superior. <br>"
                        + "Si se enuentra en editar registro, sólo debe dar clic en regresar, o botón de confirmar.</body></html>";
                this.vAdmin.lblTip23.setText(texto);
                this.texto = "<html><body>Clic en reporte para poder generar un reporte PDF</body></html>";
                this.vAdmin.lblTip24.setText(texto);
                break;
            case 4://==Activar el panel de vuelos==//
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlAviones);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlUsuarios);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVentas);
                
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlTripulacion);
                RSAnimation.setMoverIzquierda(1000, 60, 0, 1, this.vAdmin.pnlVuelos);
                this.vAdmin.pnlVueloBoton.setBackground(new java.awt.Color(0, 139, 185));
                this.vAdmin.pnlAvionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlUsuarioBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVentaBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlTripulacionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.lblSeccion.setText("Vuelos");
                
                this.vAdmin.pnlUsuarios.setVisible(false);
                this.vAdmin.pnlVentas.setVisible(false);
                this.vAdmin.pnlVuelos.setVisible(true);
                this.vAdmin.pnlTripulacion.setVisible(false);
                this.vAdmin.pnlAviones.setVisible(false);
                this.texto = "<html><body>Para poder eliminar o editar un registro, primero debe seleccionar un registro en la tabla de vuelos</body></html>";
                this.vAdmin.lblTip1111.setText(texto);
                texto = "<html><body>Para realizar una búsqueda específica, debe usar alguno de los campos mostrados a la derecha de la tabla de vuelos."
                        + "Puede utilizar varios campos de búsqueda.</body></html>";
                this.vAdmin.lblTip22.setText(texto);
                texto = "<html><body>Para volver a mostrar la tabla de registros. <br>"
                        + "Si se encuentra en TIPS, debe volver a dar clic en el botón de info. en la parte superior. <br>"
                        + "Si se enuentra en editar registro, sólo debe dar clic en regresar, o botón de confirmar.</body></html>";
                this.vAdmin.lblTip23.setText(texto);
                this.texto = "<html><body>Clic en reporte para poder generar un reporte PDF</body></html>";
                this.vAdmin.lblTip24.setText(texto);
                break;
            case 5://==Activar el panel de tripulación==//
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlAviones);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlUsuarios);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVentas);
                RSAnimation.setMoverDerecha(60, 1000, 0, 1, this.vAdmin.pnlVuelos);
                RSAnimation.setMoverIzquierda(1000, 60, 0, 1, this.vAdmin.pnlTripulacion);
                this.vAdmin.pnlTripulacionBoton.setBackground(new java.awt.Color(0, 139, 185));
                this.vAdmin.pnlAvionBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlUsuarioBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVentaBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.pnlVueloBoton.setBackground(new java.awt.Color(0, 124, 166));
                this.vAdmin.lblSeccion.setText("Tripulación");
                
                this.vAdmin.pnlUsuarios.setVisible(false);
                this.vAdmin.pnlVentas.setVisible(false);
                this.vAdmin.pnlVuelos.setVisible(false);
                this.vAdmin.pnlTripulacion.setVisible(true);
                this.vAdmin.pnlAviones.setVisible(false);
                this.texto = "<html><body>Para poder eliminar o editar un registro, primero debe seleccionar un registro en la tabla de tripulación</body></html>";
                this.vAdmin.lblTip1111.setText(texto);
                texto = "<html><body>Para realizar una búsqueda específica, debe usar alguno de los campos mostrados a la derecha de la tabla de tripulación."
                        + "Puede utilizar varios campos de búsqueda.</body></html>";
                this.vAdmin.lblTip22.setText(texto);
                texto = "<html><body>Para volver a mostrar la tabla de registros. <br>"
                        + "Si se encuentra en TIPS, debe volver a dar clic en el botón de info. en la parte superior. <br>"
                        + "Si se enuentra en editar registro, sólo debe dar clic en regresar, o botón de confirmar.</body></html>";
                this.vAdmin.lblTip23.setText(texto);
                this.texto = "<html><body>Clic en reporte para poder generar un reporte PDF</body></html>";
                this.vAdmin.lblTip24.setText(texto);
                break;
        }
        restaurarValores();
    }
    
    private void activarPanelSecundario(int valor)
    {
        //===Componentes del panel de aviones===//
        switch(this.valorPanel)
        {
            case 1:
                if(valor == 1)
                {
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlAvionesTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarAvion);
                    
                    this.vAdmin.pnlAvionesTabla.setVisible(true);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarAvion.setVisible(false);
                }
                else if(valor == 2)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAvionesTabla);
                    RSAnimation.setSubir(600, 280, 0, 10, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarAvion);
                    
                    this.vAdmin.pnlAvionesTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(true);
                    this.vAdmin.pnlAgregarEditarAvion.setVisible(false);
                }
                else if(valor == 3)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAvionesTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlAgregarEditarAvion);
                    
                    this.vAdmin.pnlAvionesTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarAvion.setVisible(true);
                }
                break;
            case 2:
                if(valor == 1)
                {
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlUsuariosTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarUsuarios);
                    
                    this.vAdmin.pnlUsuariosTabla.setVisible(true);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarUsuarios.setVisible(false);
                }
                else if(valor == 2)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlUsuariosTabla);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarUsuarios);
                    
                    this.vAdmin.pnlUsuariosTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(true);
                    this.vAdmin.pnlAgregarEditarUsuarios.setVisible(false);
                }
                else if(valor == 3)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlUsuariosTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlAgregarEditarUsuarios);
                    
                    this.vAdmin.pnlUsuariosTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarUsuarios.setVisible(true);
                }
                break;
            case 3:
                if(valor == 1)
                {
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlVentasTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    
                    this.vAdmin.pnlVentasTabla.setVisible(true);
                    this.vAdmin.pnlTips.setVisible(false);
                }
                else if(valor == 2)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlVentasTabla);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlTips);
                    
                    this.vAdmin.pnlVentasTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(true);
                }
                break;
            case 4:
                if(valor == 1)
                {
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlVuelosTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarVuelos);
                    
                    this.vAdmin.pnlVuelosTabla.setVisible(true);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarVuelos.setVisible(false);
                }
                else if(valor == 2)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlVuelosTabla);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarVuelos);
                    
                    this.vAdmin.pnlVuelosTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(true);
                    this.vAdmin.pnlAgregarEditarVuelos.setVisible(false);
                }
                else if(valor == 3)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlVuelosTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlAgregarEditarVuelos);
                    
                    this.vAdmin.pnlVuelosTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarVuelos.setVisible(true);
                }
                break;
            case 5:
                if(valor == 1)
                {
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlTripulacionTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarTripulacion);
                    
                    this.vAdmin.pnlTripulacionTabla.setVisible(true);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarTripulacion.setVisible(false);
                }
                else if(valor == 2)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTripulacionTabla);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlAgregarEditarTripulacion);
                    
                    this.vAdmin.pnlTripulacionTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(true);
                    this.vAdmin.pnlAgregarEditarTripulacion.setVisible(false);
                }
                else if(valor == 3)
                {
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTripulacionTabla);
                    RSAnimation.setBajar(280, 600, 0, 1, this.vAdmin.pnlTips);
                    RSAnimation.setSubir(600, 280, 0, 1, this.vAdmin.pnlAgregarEditarTripulacion);
                    
                    this.vAdmin.pnlTripulacionTabla.setVisible(false);
                    this.vAdmin.pnlTips.setVisible(false);
                    this.vAdmin.pnlAgregarEditarTripulacion.setVisible(true);
                }
                break;
        }
    }
    
    private void actualizarTablaAvion()
    {
        vAdmin.tblAvion.setModel(mAdmin.avionConsulta(this.condicionAvion));
        widthColumnTablaAvionAgregar();
        vAdmin.tblAvion.getTableHeader().setReorderingAllowed(false);
    }
    
    private void actualizarTablaUsuarios()
    {
        vAdmin.tblUsuarios.setModel(mAdmin.usuariosConsulta(this.condicionUsuarios));
        widthColumnTablaUsuariosAgregar();
    }
    
    private void actualizarTablaVentas()
    {
        vAdmin.tblVentas.setModel(mAdmin.VentasConsulta(this.condicionVentas));
        widthColumnTablaVentas();
    }
    private void actualizarTablaVuelos()
    {
        vAdmin.tblVuelos.setModel(mAdmin.vuelosConsulta(this.condicionVuelos));
        widthColumnTablaVuelos();
    }
    private void actualizarTablaTripulacion()
    {
        vAdmin.tblTripulacion.setModel(mAdmin.tripulacionConsulta(this.condicionTripulacion));
        widthColumnTablaTripulacion();
    }
    
    private void limpiarCampos()
    {
        //=====Campos del panel de avión=====//
        vAdmin.txtBuscarIDAvion.setText("");
        vAdmin.txtBuscarNombreAvion.setText("");
        vAdmin.cbxEstadoAvion.setSelectedIndex(0);
        
        vAdmin.txtAvionNumero.setText("");
        vAdmin.txtAvionCapacidad.setText("");
        vAdmin.txtAvionNombre.setText("");
        vAdmin.txtAvionEstatus.setText("");
        //=====Campos del panel de usuarios=====//
        vAdmin.txtBuscarNombreUsuarios.setText("");
        vAdmin.txtBuscarNacionalidadUsuarios.setText("");
        vAdmin.cbxTipoUsuarios.setSelectedIndex(0);
        
        vAdmin.txtUsuariosCiudad.setText("");
        vAdmin.txtUsuariosContra.setText("");
        vAdmin.txtUsuariosEdad.setText("");
        vAdmin.txtUsuariosNacimiento.setText("");
        vAdmin.txtUsuariosNacionalidad.setText("");
        vAdmin.txtUsuariosNombre.setText("");
        vAdmin.txtUsuariosNumero.setText("");
        vAdmin.txtUsuariosUsuario.setText("");
        //=====Campos del panel de ventas=====//
        vAdmin.txtBuscarIDVentas.setText("");
        vAdmin.txtBuscarNombreVentas.setText("");
        vAdmin.cbxPagoVentas.setSelectedIndex(0);
        //=====Campos del panel de vuelos=====//
        vAdmin.txtBuscarIDVuelos.setText("");
        vAdmin.txtBuscarNombreVuelos.setText("");
        
        vAdmin.txtVuelosNumero.setText("");
        vAdmin.txtVuelosOrigen.setText("");
        vAdmin.txtVuelosDestino.setText("");
        vAdmin.txtVuelosHoraSalida.setText("");
        vAdmin.txtVuelosHoraLlegada.setText("");
        vAdmin.txtVuelosTripulacion.setText("");
        vAdmin.txtVuelosAvion.setText("");
        vAdmin.txtVuelosEscala.setText("");
        vAdmin.txtVuelosFechaSalida.setText("");
        vAdmin.txtVuelosPrecio.setText("");
        vAdmin.cbEscalaVuelos.setSelected(false);
        this.vAdmin.separadorVuelosEscala.setForeground(new java.awt.Color(65,113,154));
        //=====Campos del panel de tripulación=====//
        vAdmin.txtBuscarIDTripulacion.setText("");
        vAdmin.txtBuscarNombreTripulacion.setText("");
        //vAdmin.cbxPuestoTripulacion.setSelectedIndex(0);
        
        vAdmin.txtTripulacionNumero.setText("");
        vAdmin.txtTripulacionNombre.setText("");
        vAdmin.txtTripulacionTripulacion.setText("");
        vAdmin.cbxTripulacionPuesto.setSelectedIndex(0);
    }
    
    public void validarCheck(){
        if(vAdmin.cbEscalaVuelos.isSelected()){
            vAdmin.txtVuelosEscala.setEnabled(true);
            this.vAdmin.separadorVuelosEscala.setForeground(new java.awt.Color(65,113,154));
        }
        else if(!vAdmin.cbEscalaVuelos.isSelected()){
            vAdmin.txtVuelosEscala.setText("");
            this.vAdmin.separadorVuelosEscala.setForeground(new java.awt.Color(255,135,2));
            vAdmin.txtVuelosEscala.setEnabled(false);
        }
    }
    
    public void widthColumnTablaAvionAgregar(){
        this.vAdmin.tblAvion.getColumnModel().getColumn(0).setMinWidth(80);
        this.vAdmin.tblAvion.getColumnModel().getColumn(0).setMaxWidth(80);
        this.vAdmin.tblAvion.getColumnModel().getColumn(0).setPreferredWidth(80);
        
        this.vAdmin.tblAvion.getColumnModel().getColumn(2).setMinWidth(100);
        this.vAdmin.tblAvion.getColumnModel().getColumn(2).setMaxWidth(100);
        this.vAdmin.tblAvion.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        this.vAdmin.tblAvion.getColumnModel().getColumn(3).setMinWidth(80);
        this.vAdmin.tblAvion.getColumnModel().getColumn(3).setMaxWidth(80);
        this.vAdmin.tblAvion.getColumnModel().getColumn(3).setPreferredWidth(80);
    }
    
    public void widthColumnTablaUsuariosAgregar(){
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(0).setMinWidth(70);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(70);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(70);
        
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(2).setMinWidth(100);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(2).setMaxWidth(100);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(3).setMinWidth(120);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(3).setMaxWidth(120);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(3).setPreferredWidth(120);
        
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(4).setMinWidth(80);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(4).setMaxWidth(80);
        this.vAdmin.tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(80);
    }
    
    public void widthColumnTablaVentas(){
        this.vAdmin.tblVentas.getColumnModel().getColumn(0).setMinWidth(70);
        this.vAdmin.tblVentas.getColumnModel().getColumn(0).setMaxWidth(70);
        this.vAdmin.tblVentas.getColumnModel().getColumn(0).setPreferredWidth(70);
        
        this.vAdmin.tblVentas.getColumnModel().getColumn(2).setMinWidth(90);
        this.vAdmin.tblVentas.getColumnModel().getColumn(2).setMaxWidth(90);
        this.vAdmin.tblVentas.getColumnModel().getColumn(2).setPreferredWidth(90);
        
        this.vAdmin.tblVentas.getColumnModel().getColumn(3).setMinWidth(80);
        this.vAdmin.tblVentas.getColumnModel().getColumn(3).setMaxWidth(80);
        this.vAdmin.tblVentas.getColumnModel().getColumn(3).setPreferredWidth(80);
        
        this.vAdmin.tblVentas.getColumnModel().getColumn(4).setMinWidth(100);
        this.vAdmin.tblVentas.getColumnModel().getColumn(4).setMaxWidth(100);
        this.vAdmin.tblVentas.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    
    public void widthColumnTablaVuelos(){
        this.vAdmin.tblVuelos.getColumnModel().getColumn(0).setMinWidth(80);
        this.vAdmin.tblVuelos.getColumnModel().getColumn(0).setMaxWidth(80);
        this.vAdmin.tblVuelos.getColumnModel().getColumn(0).setPreferredWidth(80);
        
        this.vAdmin.tblVuelos.getColumnModel().getColumn(2).setMinWidth(90);
        this.vAdmin.tblVuelos.getColumnModel().getColumn(2).setMaxWidth(90);
        this.vAdmin.tblVuelos.getColumnModel().getColumn(2).setPreferredWidth(90);
        
        this.vAdmin.tblVuelos.getColumnModel().getColumn(3).setMinWidth(125);
        this.vAdmin.tblVuelos.getColumnModel().getColumn(3).setMaxWidth(125);
        this.vAdmin.tblVuelos.getColumnModel().getColumn(3).setPreferredWidth(125);
    }
    
    public void widthColumnTablaTripulacion(){
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(0).setMinWidth(80);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(0).setMaxWidth(80);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(0).setPreferredWidth(80);
        
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(2).setMinWidth(80);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(2).setMaxWidth(80);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(2).setPreferredWidth(80);
        
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(3).setMinWidth(90);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(3).setMaxWidth(90);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(3).setPreferredWidth(90);
        
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(4).setMinWidth(130);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(4).setMaxWidth(130);
        this.vAdmin.tblTripulacion.getColumnModel().getColumn(4).setPreferredWidth(130);
    }
    //========================================================================//
    //=====Cuando se teclea=====//
    private void txtBuscarIDAvionKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionAvion[0] = vAdmin.txtBuscarIDAvion.getText();
        vAdmin.tblAvion.setModel(mAdmin.avionConsulta(this.condicionAvion));
        actualizarTablaAvion();
    } 
    //=====Para validar solo la entrada de números=====//
    private void txtBuscarIDAvionKeyTyped(java.awt.event.KeyEvent evt) {                                        
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)) || vchar == KeyEvent.VK_BACK_SPACE || vchar == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }
    //=====Cuando se teclea=====//
    private void txtBuscarNombreAvionKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionAvion[1] = vAdmin.txtBuscarNombreAvion.getText();
        vAdmin.tblAvion.setModel(mAdmin.avionConsulta(this.condicionAvion));
        actualizarTablaAvion();
    } 
    //=====Cuando se cambia en el combo box=====//
    private void cbxEstadoAvionItemStateChanged(java.awt.event.ItemEvent evt) {
        if(vAdmin.cbxEstadoAvion.getSelectedIndex() > 0){
            this.condicionAvion[2] = String.valueOf(vAdmin.cbxEstadoAvion.getSelectedIndex());
            vAdmin.tblAvion.setModel(mAdmin.avionConsulta(this.condicionAvion));
        }
        else
        {
            this.condicionAvion[2] = "";
            vAdmin.tblAvion.setModel(mAdmin.avionConsulta(this.condicionAvion));
        }
        actualizarTablaAvion();
    }
    //========================================================================//
    //=====Cuando se teclea=====//
    private void txtBuscarNombreUsuariosKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionUsuarios[0] = vAdmin.txtBuscarNombreUsuarios.getText();
        vAdmin.tblUsuarios.setModel(mAdmin.usuariosConsulta(this.condicionUsuarios));
        actualizarTablaUsuarios();
    }
    //=====Cuando se teclea=====//
    private void txtBuscarNacionalidadUsuariosKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionUsuarios[1] = vAdmin.txtBuscarNacionalidadUsuarios.getText();
        vAdmin.tblUsuarios.setModel(mAdmin.usuariosConsulta(this.condicionUsuarios));
        actualizarTablaUsuarios();
    } 
    //=====Cuando se cambia en el combo box=====//
    private void cbxTipoUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {
        if(vAdmin.cbxTipoUsuarios.getSelectedIndex() > 0){
            this.condicionUsuarios[2] = String.valueOf(vAdmin.cbxTipoUsuarios.getSelectedIndex());
            vAdmin.tblUsuarios.setModel(mAdmin.usuariosConsulta(this.condicionUsuarios));
        }
        else
        {
            this.condicionUsuarios[2] = "";
            vAdmin.tblUsuarios.setModel(mAdmin.usuariosConsulta(this.condicionUsuarios));
        }
        actualizarTablaUsuarios();
    }
    //========================================================================//
    //=====Cuando se teclea=====//
    private void txtBuscarIDVentasKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionVentas[0] = vAdmin.txtBuscarIDVentas.getText();
        vAdmin.tblVentas.setModel(mAdmin.VentasConsulta(this.condicionVentas));
        actualizarTablaVentas();
    } 
    //=====Para validar solo la entrada de números=====//
    private void txtBuscarIDVentasKeyTyped(java.awt.event.KeyEvent evt) {                                        
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)) || vchar == KeyEvent.VK_BACK_SPACE || vchar == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }
    //=====Cuando se teclea=====//
    private void txtBuscarNombreVentasKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionVentas[1] = vAdmin.txtBuscarNombreVentas.getText();
        vAdmin.tblVentas.setModel(mAdmin.VentasConsulta(this.condicionVentas));
        actualizarTablaVentas();
    } 
    //=====Cuando se cambia en el combo box=====//
    private void cbxPagoVentasItemStateChanged(java.awt.event.ItemEvent evt) {
        if(vAdmin.cbxPagoVentas.getSelectedIndex() > 0){
            if(vAdmin.cbxPagoVentas.getSelectedIndex() == 1)
                this.condicionVentas[2] = "Efectivo";
            else
                this.condicionVentas[2] = "Tarjeta";
                
            vAdmin.tblVentas.setModel(mAdmin.VentasConsulta(this.condicionVentas));
        }
        else
        {
            this.condicionVentas[2] = "";
            vAdmin.tblVentas.setModel(mAdmin.VentasConsulta(this.condicionVentas));
        }
        actualizarTablaVentas();
    }
    //========================================================================//
    //=====Cuando se teclea=====//
    private void txtBuscarIDVuelosKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionVuelos[0] = vAdmin.txtBuscarIDVuelos.getText();
        vAdmin.tblVuelos.setModel(mAdmin.vuelosConsulta(this.condicionVuelos));
        actualizarTablaVuelos();
    } 
    //=====Para validar solo la entrada de números=====//
    private void txtBuscarIDVuelosKeyTyped(java.awt.event.KeyEvent evt) {                                        
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)) || vchar == KeyEvent.VK_BACK_SPACE || vchar == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }
    //=====Cuando se teclea=====//
    private void txtBuscarNombreVuelosKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionVuelos[1] = vAdmin.txtBuscarNombreVuelos.getText();
        vAdmin.tblVuelos.setModel(mAdmin.vuelosConsulta(this.condicionVuelos));
        actualizarTablaVuelos();
    }
    //========================================================================//
    //=====Cuando se teclea=====//
    private void txtBuscarIDTripulacionKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionTripulacion[0] = vAdmin.txtBuscarIDTripulacion.getText();
        vAdmin.tblTripulacion.setModel(mAdmin.avionConsulta(this.condicionTripulacion));
        actualizarTablaTripulacion();
    } 
    //=====Para validar solo la entrada de números=====//
    private void txtBuscarIDTripulacionKeyTyped(java.awt.event.KeyEvent evt) {                                        
        char vchar = evt.getKeyChar();
        if(!(Character.isDigit(vchar)) || vchar == KeyEvent.VK_BACK_SPACE || vchar == KeyEvent.VK_DELETE){
            evt.consume();
        }
    }
    //=====Cuando se teclea=====//
    private void txtBuscarNombreTripulacionKeyReleased(java.awt.event.KeyEvent evt) {
        this.condicionTripulacion[1] = vAdmin.txtBuscarNombreTripulacion.getText();
        vAdmin.tblTripulacion.setModel(mAdmin.avionConsulta(this.condicionTripulacion));
        actualizarTablaTripulacion();
    } 
    //=====Cuando se cambia en el combo box=====//
    private void cbxPuestoTripulacionItemStateChanged(java.awt.event.ItemEvent evt) {
        switch(vAdmin.cbxPuestoTripulacion.getSelectedIndex())
        {
            case 0:
                this.condicionTripulacion[2] = "";
                break;
            case 1:
                this.condicionTripulacion[2] = "Piloto";
                break;
            case 2:
                this.condicionTripulacion[2] = "Copiloto";
                break;
            case 3:
                this.condicionTripulacion[2] = "Azafata";
                break;
        }
        actualizarTablaTripulacion();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vAdmin.btnSalir == e.getSource())
            System.exit(0);
        else if(this.vAdmin.btnMinimizar == e.getSource())
            this.vAdmin.setExtendedState(1);
        else if(this.vAdmin.btnVerTripulacionAgregarEditarVuelos == e.getSource())
        {
            this.buscandoVuelosTripulacion=true;
            this.vAdmin.pnlVuelosTripulacionAvion.setVisible(true);
            vAdmin.tblVuelosSeleccionAgregarEditar.setModel(mAdmin.avionConsulta());
            if(this.mostrarPanelExtraVuelos == false)
            {
                this.vAdmin.pnlVuelosTripulacionAvion.setVisible(true);
                this.vAdmin.lblCancelarAgregarEditarVuelos.setVisible(false);
                this.vAdmin.lblConfirmarAgregarEditarVuelos.setVisible(false);
                this.vAdmin.lblRegresarAgregarEditarVuelos.setVisible(false);
                this.vAdmin.btnVerTripulacionAgregarEditarVuelos.setTypeButton(RSButtonMaterial.TYPEBUTTON.SECONDARY);
                this.vAdmin.btnVerTripulacionAgregarEditarVuelos.setText("Ocultar");
                this.vAdmin.pnlVuelosTripulacionAvion.setVisible(true);
                activarPanelSecundario(3);
                this.mostrarPanelExtraVuelos = true;
            }
            else
            {
                this.vAdmin.pnlVuelosTripulacionAvion.setVisible(false);
                this.vAdmin.lblCancelarAgregarEditarVuelos.setVisible(true);
                this.vAdmin.lblConfirmarAgregarEditarVuelos.setVisible(true);
                this.vAdmin.lblRegresarAgregarEditarVuelos.setVisible(true);
                this.vAdmin.btnVerTripulacionAgregarEditarVuelos.setTypeButton(RSButtonMaterial.TYPEBUTTON.PRIMARY);
                this.vAdmin.btnVerTripulacionAgregarEditarVuelos.setText("Ver");
                this.vAdmin.pnlVuelosTripulacionAvion.setVisible(false);
                activarPanelSecundario(3);
                this.mostrarPanelExtraVuelos = false;
            }
        }
        else if(this.vAdmin.btnVerAvionAgregarEditarVuelos == e.getSource())
        {
            this.buscandoVuelosTripulacion=false;
            vAdmin.tblVuelosSeleccionAgregarEditar.setModel(mAdmin.tripulacionConsulta());
            if(this.mostrarPanelExtraVuelos == false)
            {
                this.vAdmin.pnlVuelosTripulacionAvion.setVisible(true);
                this.vAdmin.lblCancelarAgregarEditarVuelos.setVisible(false);
                this.vAdmin.lblConfirmarAgregarEditarVuelos.setVisible(false);
                this.vAdmin.lblRegresarAgregarEditarVuelos.setVisible(false);
                this.vAdmin.btnVerAvionAgregarEditarVuelos.setTypeButton(RSButtonMaterial.TYPEBUTTON.SECONDARY);
                this.vAdmin.btnVerAvionAgregarEditarVuelos.setText("Ocultar");
                this.vAdmin.pnlVuelosTripulacionAvion.setVisible(true);
                activarPanelSecundario(3);
                this.mostrarPanelExtraVuelos = true;
            }
            else
            {
                this.vAdmin.pnlVuelosTripulacionAvion.setVisible(false);
                this.vAdmin.lblCancelarAgregarEditarVuelos.setVisible(true);
                this.vAdmin.lblConfirmarAgregarEditarVuelos.setVisible(true);
                this.vAdmin.lblRegresarAgregarEditarVuelos.setVisible(true);
                this.vAdmin.btnVerAvionAgregarEditarVuelos.setTypeButton(RSButtonMaterial.TYPEBUTTON.PRIMARY);
                this.vAdmin.btnVerAvionAgregarEditarVuelos.setText("Ver");
                activarPanelSecundario(3);
                this.mostrarPanelExtraVuelos = false;
            }
        }
        else if(this.vAdmin.cbEscalaVuelos == e.getSource())
            validarCheck();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //=====Opciones de menú=====//
        if(this.vAdmin.lblMenuIcon == e.getSource())
        {
            if(this.mostrar == true)
            {
                RSAnimation.setMoverDerecha(-235, 0, 5, 1, this.vAdmin.pnlMenu);
                this.mostrar = false;
            }
            else
            {
                RSAnimation.setMoverIzquierda(0, -235, 5, 1, this.vAdmin.pnlMenu);
                this.mostrar = true;
            }
        }
        else if(this.vAdmin.lblHomeIcon == e.getSource() || this.vAdmin.lblHomeTexto == e.getSource())
        {
            vMenuAdmin vMenuAdmin = new vMenuAdmin();
            cMenuAdmin cMenuAdmin = new cMenuAdmin(vMenuAdmin);
            this.vAdmin.dispose();
            cMenuAdmin.iniciarVista();
        }
        else if(this.vAdmin.lblAvionesIcon == e.getSource() || this.vAdmin.lblAvionesTexto == e.getSource())
        {
            this.valorPanel=1;
            activarPanelPrincipal(1);
        }
        else if(this.vAdmin.lblUsuariosIcon == e.getSource() || this.vAdmin.lblUsuariosTexto == e.getSource())
        {
            this.valorPanel=2;
            activarPanelPrincipal(2);
        }
        else if(this.vAdmin.lblVentasIcon == e.getSource() || this.vAdmin.lblVentasTexto == e.getSource())
        {
            this.valorPanel=3;
            activarPanelPrincipal(3);
        }
        else if(this.vAdmin.lblVuelosIcon == e.getSource() || this.vAdmin.lblVuelosTexto == e.getSource())
        {
            this.valorPanel=4;
            activarPanelPrincipal(4);
        }
        else if(this.vAdmin.lblTripulacionIcon == e.getSource() || this.vAdmin.lblTripulacionTexto == e.getSource())
        {
            this.valorPanel=5;
            activarPanelPrincipal(5);
        }
        else if(this.vAdmin.lblConfigIcon == e.getSource() || this.vAdmin.lblConfigTexto == e.getSource())
        {
            try {
                File path = new File ("src//reportes//Manual.pdf");
                Desktop.getDesktop().open(path);
            }catch (IOException ex) {
                 ex.printStackTrace();
            }
        }
        //=====Opciones del panel de avión=====//
        else if(this.vAdmin.tblAvion == e.getSource())
        {
            int fila = vAdmin.tblAvion.rowAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vAdmin.tblAvion.getColumnCount(); i++) {
                    if(vAdmin.tblAvion.getColumnName(i).equals("Número")){
                        this.idAvion = Integer.parseInt(String.valueOf(vAdmin.tblAvion.getValueAt(fila, i)));
                        this.vAdmin.lblEliminarAvionIcon.setEnabled(true);
                        this.vAdmin.btnEliminarAvion.setEnabled(true);
                        this.vAdmin.lblEditarAvionIcon.setEnabled(true);
                        this.vAdmin.btnEditarAvion.setEnabled(true);
                        break;
                    }
                }
            }
        }
        else if(this.vAdmin.btnDetallesAvion == e.getSource())
        {
            if(this.vAdmin.cbxEstadoAvion.getSelectedIndex()==0)
                this.mAdmin.reporteAvion(0, 3, this.vAdmin.txtBuscarNombreAvion.getText());
            else if(this.vAdmin.cbxEstadoAvion.getSelectedIndex()==1)
                this.mAdmin.reporteAvion(0, 2, this.vAdmin.txtBuscarNombreAvion.getText());
            else if(this.vAdmin.cbxEstadoAvion.getSelectedIndex()==2)
                this.mAdmin.reporteAvion(1, 3, this.vAdmin.txtBuscarNombreAvion.getText());
        }
        else if(this.vAdmin.btnTipsAvion == e.getSource())
        {
            if(this.disponibleTips == true)
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/no-information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsAvion.getWidth()-40, vAdmin.btnTipsAvion.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsAvion.setIcon(null);
                vAdmin.btnTipsAvion.setIcon(information);
                this.disponibleTips=!this.disponibleTips;
                activarPanelSecundario(1);
            }
            else
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsAvion.getWidth()-40, vAdmin.btnTipsAvion.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsAvion.setIcon(null);
                vAdmin.btnTipsAvion.setIcon(information);
                this.disponibleTips=!this.disponibleTips;
                activarPanelSecundario(2);
            }
        }
        else if(this.vAdmin.lblAgregarAvionIcon == e.getSource() || this.vAdmin.btnAgregarAvion == e.getSource())
        {
            this.vAdmin.lblTituloAgregarEditarAvion.setText("AGREGAR AVIÓN");
            activarPanelSecundario(3);
            this.agregarAvion=true;
        }
        else if(this.vAdmin.lblEditarAvionIcon == e.getSource() || this.vAdmin.btnEditarAvion == e.getSource())
        {
            if(this.vAdmin.lblEditarAvionIcon.isEnabled() == true || this.vAdmin.btnEditarAvion.isEnabled() == true)
            {
                this.agregarAvion=false;
                this.vAdmin.lblTituloAgregarEditarAvion.setText("EDITAR AVIÓN");
                
                this.datosAvion=mAdmin.avionConsultaEspecifica(this.idAvion);
                this.vAdmin.txtAvionNumero.setText(this.datosAvion[0]);
                this.vAdmin.txtAvionNombre.setText(this.datosAvion[1]);
                this.vAdmin.txtAvionCapacidad.setText(this.datosAvion[2]);
                this.vAdmin.txtAvionEstatus.setText(this.datosAvion[3]);
                activarPanelSecundario(3);
            }
        }
        else if(this.vAdmin.lblEliminarAvionIcon == e.getSource() || this.vAdmin.btnEliminarAvion == e.getSource())
        {
            if(this.vAdmin.lblEliminarAvionIcon.isEnabled() == true || this.vAdmin.btnEliminarAvion.isEnabled() == true)
            {
                if(mAdmin.eliminarAvion(this.idAvion) == true)
                {
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    vAdmin.tblAvion.setModel(mAdmin.avionConsulta(this.condicionAvion));
                    activarPanelSecundario(1);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
                    activarPanelSecundario(1);
            }
        }
        else if(this.vAdmin.lblRegresarAgregarEditarAvion == e.getSource())
        {
            activarPanelSecundario(1);
            limpiarCampos();
        }
        else if(this.vAdmin.lblActualizarAvionIcon == e.getSource())
        {
            actualizarTablaAvion();
            limpiarCampos();
        }
        else if(this.vAdmin.lblCancelarAgregarEditarAvion == e.getSource())
            limpiarCampos();
        else if(this.vAdmin.lblConfirmarAgregarEditarAvion == e.getSource())
        {
            if(this.agregarAvion == true)
            {
                if(mAdmin.avionAgregar(
                        this.vAdmin.txtAvionNombre.getText(), 
                        Integer.parseInt(this.vAdmin.txtAvionCapacidad.getText()), 
                        Integer.parseInt(this.vAdmin.txtAvionEstatus.getText())
                ) == true)
                {
                    JOptionPane.showMessageDialog(null, "Agregado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha agregado con éxito");
            }
            else
            {
                if(mAdmin.editarAvion(
                        this.idAvion,
                        this.vAdmin.txtAvionNombre.getText(), 
                        Integer.parseInt(this.vAdmin.txtAvionCapacidad.getText()), 
                        Integer.parseInt(this.vAdmin.txtAvionEstatus.getText())
                ) == true)
                {
                    JOptionPane.showMessageDialog(null, "Editado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha editado con éxito");
            }
            actualizarTablaAvion();
        }
        //====================Opciones del panel de usuarios====================//
        else if(this.vAdmin.tblUsuarios == e.getSource())
        {
            int fila = vAdmin.tblUsuarios.rowAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vAdmin.tblUsuarios.getColumnCount(); i++) {
                    if(vAdmin.tblUsuarios.getColumnName(i).equals("Código")){
                        this.idUsuario = Integer.parseInt(String.valueOf(vAdmin.tblUsuarios.getValueAt(fila, i)));
                        this.vAdmin.lblEliminarUsuariosIcon.setEnabled(true);
                        this.vAdmin.btnEliminarUsuarios.setEnabled(true);
                        this.vAdmin.lblEditarUsuariosIcon.setEnabled(true);
                        this.vAdmin.btnEditarUsuarios.setEnabled(true);
                        break;
                    }
                }
            }
        }
        else if(this.vAdmin.btnTipsUsuarios == e.getSource())
        {
            if(this.disponibleTips == true)
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/no-information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsUsuarios.getWidth()-40, vAdmin.btnTipsUsuarios.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsUsuarios.setIcon(null);
                vAdmin.btnTipsUsuarios.setIcon(information);
                activarPanelSecundario(1);
                this.disponibleTips=!this.disponibleTips;
            }
            else
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsUsuarios.getWidth()-40, vAdmin.btnTipsUsuarios.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsUsuarios.setIcon(null);
                vAdmin.btnTipsUsuarios.setIcon(information);
                activarPanelSecundario(2);
                this.disponibleTips=!this.disponibleTips;
            }
        }
        else if(this.vAdmin.lblAgregarUsuariosIcon == e.getSource() || this.vAdmin.btnAgregarUsuarios == e.getSource())
        {
            this.vAdmin.lblTituloAgregarEditarUsuarios.setText("AGREGAR USUARIO");
            activarPanelSecundario(3);
            this.agregarUsuarios=true;
        }
        else if(this.vAdmin.lblEditarUsuariosIcon == e.getSource() || this.vAdmin.btnEditarUsuarios == e.getSource())
        {
            if(this.vAdmin.lblEditarUsuariosIcon.isEnabled() == true || this.vAdmin.btnEditarUsuarios.isEnabled() == true)
            {
                this.agregarUsuarios=false;
                this.vAdmin.lblTituloAgregarEditarUsuarios.setText("EDITAR USUARIO");
                this.datosUsuario=mAdmin.consultaUsuarioEspecifico(this.idUsuario);
                
                this.vAdmin.txtUsuariosNumero.setText(this.datosUsuario[0]);
                this.vAdmin.txtUsuariosNombre.setText(this.datosUsuario[1]);
                this.vAdmin.txtUsuariosNacionalidad.setText(this.datosUsuario[2]);
                this.vAdmin.txtUsuariosCiudad.setText(this.datosUsuario[3]);
                this.vAdmin.txtUsuariosNacimiento.setText(this.datosUsuario[4]);
                this.vAdmin.txtUsuariosEdad.setText(this.datosUsuario[5]);
                this.vAdmin.txtUsuariosUsuario.setText(this.datosUsuario[6]);
                this.vAdmin.txtUsuariosContra.setText(this.datosUsuario[7]);
                if(this.datosUsuario[8].equals("1"))
                    this.vAdmin.jBtnAdminUsuarios.setSelected(true);
                else if(this.datosUsuario[8].equals("3"))
                    this.vAdmin.jBtnAdminUsuarios.setSelected(true);
                else if(this.datosUsuario[8].equals("2"))
                    this.vAdmin.jBtnAdminUsuarios.setSelected(true);
                
                activarPanelSecundario(3);
            }
        }
        else if(this.vAdmin.lblEliminarUsuariosIcon == e.getSource() || this.vAdmin.btnEliminarUsuarios == e.getSource())
        {
            if(this.vAdmin.lblEliminarUsuariosIcon.isEnabled() == true || this.vAdmin.btnEliminarUsuarios.isEnabled() == true)
            {
                if(mAdmin.eliminarAvion(this.idAvion) == true)/////////////////
                {
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    vAdmin.tblAvion.setModel(mAdmin.avionConsulta(this.condicionAvion));
                    activarPanelSecundario(1);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
                    activarPanelSecundario(1);
            }
        }
        else if(this.vAdmin.lblRegresarAgregarEditarUsuarios == e.getSource())
        {
            activarPanelSecundario(1);
            limpiarCampos();
        }
        else if(this.vAdmin.lblActualizarUsuariosIcon == e.getSource())
        {
            actualizarTablaUsuarios();
            limpiarCampos();
        }
        else if(this.vAdmin.lblCancelarAgregarEditarUsuarios == e.getSource())
            limpiarCampos();
        else if(this.vAdmin.lblConfirmarAgregarEditarUsuarios == e.getSource())
        {
            if(this.agregarUsuarios == true)
            {
                int Tipo=0;
                if(this.vAdmin.jBtnAdminUsuarios.isSelected())
                    Tipo=1;
                else if(this.vAdmin.jBtnTrabajadorUsuarios.isSelected())
                    Tipo=2;
                else if(this.vAdmin.jBtnClienteUsuarios.isSelected())
                    Tipo=3;
                if(mAdmin.usuarioAgregar(
                        this.vAdmin.txtUsuariosNombre.getText(), 
                        this.vAdmin.txtUsuariosNacionalidad.getText(), 
                        this.vAdmin.txtUsuariosCiudad.getText(), 
                        this.vAdmin.txtUsuariosNacimiento.getText(), 
                        this.vAdmin.txtUsuariosUsuario.getText(), 
                        this.vAdmin.txtUsuariosContra.getText(), 
                        Tipo) == true)
                {
                    JOptionPane.showMessageDialog(null, "Agregado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha agregado con éxito");
            }
            else
            {
                int Tipo=0;
                if(this.vAdmin.jBtnAdminUsuarios.isSelected())
                    Tipo=1;
                else if(this.vAdmin.jBtnTrabajadorUsuarios.isSelected())
                    Tipo=2;
                else if(this.vAdmin.jBtnClienteUsuarios.isSelected())
                    Tipo=3;
                if(mAdmin.editarUsuario(
                        this.idUsuario, 
                        this.vAdmin.txtUsuariosNombre.getText(), 
                        this.vAdmin.txtUsuariosNacionalidad.getText(), 
                        this.vAdmin.txtUsuariosCiudad.getText(), 
                        this.vAdmin.txtUsuariosNacimiento.getText(), 
                        this.vAdmin.txtUsuariosUsuario.getText(), 
                        this.vAdmin.txtUsuariosContra.getText(), 
                        Tipo) == true)
                {
                    JOptionPane.showMessageDialog(null, "Editado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha editado con éxito");
            }
            actualizarTablaUsuarios();
        }
        //====================Opciones del panel de ventas====================//
        else if(this.vAdmin.tblVentas == e.getSource())
        {
            int fila = vAdmin.tblVentas.rowAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vAdmin.tblVentas.getColumnCount(); i++) {
                    if(vAdmin.tblVentas.getColumnName(i).equals("Código")){
                        this.idVentas = Integer.parseInt(String.valueOf(vAdmin.tblVentas.getValueAt(fila, i)));
                        break;
                    }
                }
            }
        }
        else if(this.vAdmin.btnDetallesVentas == e.getSource())
        {
            this.mAdmin.reporteVentas(this.vAdmin.txtBuscarNombreVentas.getText(), this.vAdmin.cbxPagoVentas.getSelectedIndex());
        }
        else if(this.vAdmin.btnTipsVentas == e.getSource())
        {
            if(this.disponibleTips == true)
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/no-information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsVentas.getWidth()-40, vAdmin.btnTipsVentas.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsVentas.setIcon(null);
                vAdmin.btnTipsVentas.setIcon(information);
                activarPanelSecundario(1);
                this.disponibleTips=!this.disponibleTips;
            }
            else
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsVentas.getWidth()-40, vAdmin.btnTipsVentas.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsVentas.setIcon(null);
                vAdmin.btnTipsVentas.setIcon(information);
                activarPanelSecundario(2);
                this.disponibleTips=!this.disponibleTips;
            }
        }
        else if(this.vAdmin.lblActualizarVentasIcon == e.getSource())
        {
            actualizarTablaVentas();
            limpiarCampos();
        }
        else if(this.vAdmin.lblCancelarVentasIcon == e.getSource())
            limpiarCampos();
        //====================Opciones del panel de vuelos====================//
        else if(this.vAdmin.tblVuelos == e.getSource())
        {
            int fila = vAdmin.tblVuelos.rowAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vAdmin.tblVuelos.getColumnCount(); i++) {
                    if(vAdmin.tblVuelos.getColumnName(i).equals("Número")){
                        this.idVuelos = Integer.parseInt(String.valueOf(vAdmin.tblVuelos.getValueAt(fila, i)));
                        this.vAdmin.lblEliminarVuelosIcon.setEnabled(true);
                        this.vAdmin.btnEliminarVuelos.setEnabled(true);
                        this.vAdmin.lblEditarVuelosIcon.setEnabled(true);
                        this.vAdmin.btnEditarVuelos.setEnabled(true);
                        break;
                    }
                }
            }
        }
        else if(this.vAdmin.btnDetallesVuelos == e.getSource())
        {
            this.mAdmin.reporteVuelos(this.vAdmin.txtBuscarNombreVuelos.getText());
        }
        else if(this.vAdmin.tblVuelosSeleccionAgregarEditar == e.getSource())
        {
            int fila = vAdmin.tblVuelosSeleccionAgregarEditar.rowAtPoint(e.getPoint());
            if(this.buscandoVuelosTripulacion == true)
            {
                if(fila > -1) {
                    for (int i = 0; i < vAdmin.tblVuelosSeleccionAgregarEditar.getColumnCount(); i++) {
                        if(vAdmin.tblVuelosSeleccionAgregarEditar.getColumnName(i).equals("Avión")){
                            this.idVuelosEleccion = Integer.parseInt(String.valueOf(vAdmin.tblVuelosSeleccionAgregarEditar.getValueAt(fila, i)));
                            vAdmin.tblVuelosOpcionAgregarEditar.setModel(mAdmin.datosAvionConsulta(this.idVuelosEleccion));
                            vAdmin.txtVuelosAvion.setText(String.valueOf(this.idVuelosEleccion));
                            break;
                        }
                    }
                }
            }
            else
            {
                if(fila > -1) {
                    for (int i = 0; i < vAdmin.tblVuelosSeleccionAgregarEditar.getColumnCount(); i++) {
                        if(vAdmin.tblVuelosSeleccionAgregarEditar.getColumnName(i).equals("Tripulación")){
                            this.idVuelosEleccion = Integer.parseInt(String.valueOf(vAdmin.tblVuelosSeleccionAgregarEditar.getValueAt(fila, i)));
                            vAdmin.tblVuelosOpcionAgregarEditar.setModel(mAdmin.datosTripulacionConsulta(this.idVuelosEleccion));
                            vAdmin.txtVuelosTripulacion.setText(String.valueOf(this.idVuelosEleccion));
                            break;
                        }
                    }
                }
            }
        }
        
        else if(this.vAdmin.btnTipsVuelos == e.getSource())
        {
            if(this.disponibleTips == true)
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/no-information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsVuelos.getWidth()-40, vAdmin.btnTipsVuelos.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsVuelos.setIcon(null);
                vAdmin.btnTipsVuelos.setIcon(information);
                activarPanelSecundario(1);
                this.disponibleTips=!this.disponibleTips;
            }
            else
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsVuelos.getWidth()-40, vAdmin.btnTipsVuelos.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsVuelos.setIcon(null);
                vAdmin.btnTipsVuelos.setIcon(information);
                activarPanelSecundario(2);
                this.disponibleTips=!this.disponibleTips;
            }
        }
        else if(this.vAdmin.lblAgregarVuelosIcon == e.getSource() || this.vAdmin.btnAgregarVuelos == e.getSource())
        {
            this.vAdmin.lblTituloAgregarEditarVuelos.setText("AGREGAR VUELO");
            activarPanelSecundario(3);
            this.agregarVuelos=true;
        }
        else if(this.vAdmin.lblEditarVuelosIcon == e.getSource() || this.vAdmin.btnEditarVuelos == e.getSource())
        {
            if(this.vAdmin.lblEditarVuelosIcon.isEnabled() == true || this.vAdmin.btnEditarVuelos.isEnabled() == true)
            {
                this.agregarVuelos=false;
                this.vAdmin.lblTituloAgregarEditarVuelos.setText("EDITAR VUELO");
                this.datosVuelos=mAdmin.consultaVueloEspecifico(this.idVuelos);
                
                this.vAdmin.txtVuelosNumero.setText(this.datosVuelos[0]);
                this.vAdmin.txtVuelosOrigen.setText(this.datosVuelos[1]);
                this.vAdmin.txtVuelosDestino.setText(this.datosVuelos[2]);
                this.vAdmin.txtVuelosTripulacion.setText(this.datosVuelos[4]);
                this.vAdmin.txtVuelosFechaSalida.setText(this.datosVuelos[5]);
                this.vAdmin.txtVuelosHoraSalida.setText(this.datosVuelos[6]);
                this.vAdmin.txtVuelosHoraLlegada.setText(this.datosVuelos[7]);
                if(! this.datosVuelos[8].equals(""))
                {
                    this.vAdmin.cbEscalaVuelos.setSelected(true);
                    this.tipoEditarVuelos=1;
                }
                else
                {
                    this.vAdmin.cbEscalaVuelos.setSelected(false);
                    this.tipoEditarVuelos=0;
                }
                this.vAdmin.txtVuelosEscala.setText(this.datosVuelos[8]);
                this.vAdmin.txtVuelosPrecio.setText(this.datosVuelos[9]);
                activarPanelSecundario(3);
            }
        }
        else if(this.vAdmin.lblEliminarVuelosIcon == e.getSource() || this.vAdmin.btnEliminarVuelos == e.getSource())
        {
            if(this.vAdmin.lblEliminarVuelosIcon.isEnabled() == true || this.vAdmin.btnEliminarVuelos.isEnabled() == true)
            {
                this.datosVuelos=mAdmin.consultaVueloEspecifico(this.idVuelos);
                if(! this.datosVuelos[8].equals(""))
                    this.tipoEditarVuelos=1;
                else
                    this.tipoEditarVuelos=0;
                if(mAdmin.vueloEliminar(
                        this.tipoEditarVuelos, 
                        this.idVuelos, 
                        Integer.parseInt(this.datosVuelos[3]))== true)
                {
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    actualizarTablaVuelos();
                    activarPanelSecundario(1);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
                    activarPanelSecundario(1);
            }
        }
        else if(this.vAdmin.lblRegresarAgregarEditarVuelos == e.getSource())
        {
            activarPanelSecundario(1);
            limpiarCampos();
        }
        else if(this.vAdmin.lblActualizarUsuariosIcon == e.getSource())
        {
            actualizarTablaUsuarios();
            limpiarCampos();
        }
        else if(this.vAdmin.lblCancelarAgregarEditarVuelos == e.getSource())
            limpiarCampos();
        else if(this.vAdmin.lblConfirmarAgregarEditarVuelos == e.getSource())
        {
            if(this.agregarVuelos == true)
            {
                if(mAdmin.vueloAgregar(
                        this.vAdmin.txtVuelosOrigen.getText(), 
                        this.vAdmin.txtVuelosDestino.getText(), 
                        this.vAdmin.txtVuelosEscala.getText(), 
                        Integer.parseInt(this.vAdmin.txtVuelosTripulacion.getText()), 
                        this.vAdmin.txtVuelosFechaSalida.getText(), 
                        this.vAdmin.txtVuelosHoraSalida.getText(), 
                        this.vAdmin.txtVuelosHoraLlegada.getText(), 
                        Double.parseDouble(this.vAdmin.txtVuelosPrecio.getText())) == true )
                {
                    JOptionPane.showMessageDialog(null, "Agregado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha agregado con éxito");
            }
            else
            {
                String escala = "", tripulacion = "";
                if(vAdmin.txtVuelosEscala.getText().equals("")){
                    escala = "0";
                } else{
                    escala = vAdmin.txtVuelosEscala.getText();
                }
                if(vAdmin.txtVuelosTripulacion.getText().equals("")){
                    tripulacion = "0";
                } else{
                    tripulacion = vAdmin.txtVuelosTripulacion.getText();
                }
                
                if(mAdmin.vueloEditar(
                        this.tipoEditarVuelos,
                        this.idVuelos,
                        Integer.parseInt(this.datosVuelos[3]),
                        this.vAdmin.txtVuelosOrigen.getText(), 
                        this.vAdmin.txtVuelosDestino.getText(), 
                        escala, 
                        Integer.parseInt(tripulacion), 
                        this.vAdmin.txtVuelosFechaSalida.getText(), 
                        this.vAdmin.txtVuelosHoraSalida.getText(), 
                        this.vAdmin.txtVuelosHoraLlegada.getText()) == true )
                {
                    JOptionPane.showMessageDialog(null, "Editado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha editado con éxito");
            }
            actualizarTablaVuelos();
        }
        //====================Opciones del panel de tripulación====================//
        else if(this.vAdmin.tblTripulacion == e.getSource())
        {
            int fila = vAdmin.tblTripulacion.rowAtPoint(e.getPoint());
            if(fila > -1) {
                for (int i = 0; i < vAdmin.tblTripulacion.getColumnCount(); i++) {
                    if(vAdmin.tblTripulacion.getColumnName(i).equals("Código")){
                        this.idTripulacion = Integer.parseInt(String.valueOf(vAdmin.tblTripulacion.getValueAt(fila, i)));
                        this.vAdmin.lblEliminarTripulacionIcon.setEnabled(true);
                        this.vAdmin.btnEliminarTripulacion.setEnabled(true);
                        this.vAdmin.lblEditarTripulacionIcon.setEnabled(true);
                        this.vAdmin.btnEditarTripulacion.setEnabled(true);
                        break;
                    }
                }
            }
        }
        
        else if(this.vAdmin.btnTipsTripulacion == e.getSource())
        {
            if(this.disponibleTips == true)
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/no-information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsTripulacion.getWidth()-40, vAdmin.btnTipsTripulacion.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsTripulacion.setIcon(null);
                vAdmin.btnTipsTripulacion.setIcon(information);
                activarPanelSecundario(1);
                this.disponibleTips=!this.disponibleTips;
            }
            else
            {
                ImageIcon iconInformation = new ImageIcon(getClass().getResource(("/icons/information.png")));
                ImageIcon information = new ImageIcon(iconInformation.getImage().getScaledInstance(vAdmin.btnTipsTripulacion.getWidth()-40, vAdmin.btnTipsTripulacion.getHeight()-40, Image.SCALE_DEFAULT));
                vAdmin.btnTipsTripulacion.setIcon(null);
                vAdmin.btnTipsTripulacion.setIcon(information);
                activarPanelSecundario(2);
                this.disponibleTips=!this.disponibleTips;
            }
        }
        else if(this.vAdmin.lblAgregarTripulacionIcon == e.getSource() || this.vAdmin.btnAgregarTripulacion == e.getSource())
        {
            this.vAdmin.lblTituloAgregarEditarTripulacion.setText("AGREGAR TRIPULANTE");
            activarPanelSecundario(3);
            this.agregarTripulacion=true;
        }
        else if(this.vAdmin.lblEditarTripulacionIcon == e.getSource() || this.vAdmin.btnEditarTripulacion == e.getSource())
        {
            if(this.vAdmin.lblEditarTripulacionIcon.isEnabled() == true || this.vAdmin.btnEditarTripulacion.isEnabled() == true)
            {
                this.agregarTripulacion=false;
                this.vAdmin.lblTituloAgregarEditarTripulacion.setText("EDITAR TRIPULANTE");
                this.datosTripulacion=mAdmin.consultaTripulacionEspecifico(this.idTripulacion);
                
                this.vAdmin.txtTripulacionNumero.setText(this.datosTripulacion[0]);
                this.vAdmin.txtTripulacionNombre.setText(this.datosTripulacion[1]);
                
                if(this.datosTripulacion[2].equals("Piloto"))
                    vAdmin.cbxTripulacionPuesto.setSelectedIndex(0);
                else if(this.datosTripulacion[2].equals("Copiloto"))
                    vAdmin.cbxTripulacionPuesto.setSelectedIndex(1);
                else if(this.datosTripulacion[2].equals("Azafata"))
                    vAdmin.cbxTripulacionPuesto.setSelectedIndex(2);
                
                this.vAdmin.txtTripulacionTripulacion.setText(this.datosTripulacion[4]);
                activarPanelSecundario(3);
            }
        }
        else if(this.vAdmin.lblEliminarTripulacionIcon == e.getSource() || this.vAdmin.btnEliminarTripulacion == e.getSource())
        {
            if(this.vAdmin.lblEliminarTripulacionIcon.isEnabled() == true || this.vAdmin.btnEliminarTripulacion.isEnabled() == true)
            {
                if(mAdmin.tripulacionEliminar(this.idTripulacion)== true)
                {
                    JOptionPane.showMessageDialog(null, "Eliminado con éxito");
                    actualizarTablaTripulacion();
                    activarPanelSecundario(1);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar");
                    activarPanelSecundario(1);
            }
        }
        else if(this.vAdmin.lblRegresarAgregarEditarTripulacion == e.getSource())
        {
            activarPanelSecundario(1);
            limpiarCampos();
        }
        else if(this.vAdmin.lblActualizarTripulacionIcon == e.getSource())
        {
            actualizarTablaTripulacion();
            limpiarCampos();
        }
        else if(this.vAdmin.lblCancelarAgregarEditarTripulacion == e.getSource())
            limpiarCampos();
        else if(this.vAdmin.lblConfirmarAgregarEditarTripulacion == e.getSource())
        {
            if(this.agregarTripulacion == true)
            {
                if(mAdmin.tripulacionAgregar(
                        vAdmin.txtTripulacionNombre.getText(), 
                        String.valueOf(vAdmin.cbxTripulacionPuesto.getSelectedItem()), 
                        Integer.parseInt(vAdmin.txtTripulacionTripulacion.getText())) == true)
                {
                    JOptionPane.showMessageDialog(null, "Agregado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha agregado con éxito");
            }
            else
            {
                if(mAdmin.editarTripulacion(
                        this.idTripulacion, 
                        vAdmin.txtTripulacionNombre.getText(),  
                        String.valueOf(vAdmin.cbxTripulacionPuesto.getSelectedItem()),
                        Integer.parseInt(vAdmin.txtTripulacionTripulacion.getText())) == true)
                {
                    JOptionPane.showMessageDialog(null, "Editado con éxito");
                    limpiarCampos();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha editado con éxito");
            }
            actualizarTablaTripulacion();
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
        if(
                this.vAdmin.lblMenuIcon == e.getSource() ||
                this.vAdmin.lblAvionesIcon == e.getSource() ||
                this.vAdmin.lblConfigIcon == e.getSource() ||
                this.vAdmin.lblHomeIcon == e.getSource() ||
                this.vAdmin.lblTripulacionIcon == e.getSource() ||
                this.vAdmin.lblUsuariosIcon == e.getSource() ||
                this.vAdmin.lblVentasIcon == e.getSource() ||
                this.vAdmin.lblVuelosIcon == e.getSource() ||
                this.vAdmin.lblAvionesTexto == e.getSource() ||
                this.vAdmin.lblConfigTexto == e.getSource() ||
                this.vAdmin.lblHomeTexto == e.getSource() ||
                this.vAdmin.lblTripulacionTexto == e.getSource() ||
                this.vAdmin.lblUsuariosTexto == e.getSource() ||
                this.vAdmin.lblVentasTexto == e.getSource() ||
                this.vAdmin.lblVuelosTexto == e.getSource() ||
                this.vAdmin.lblActualizarAvionIcon == e.getSource() ||
                this.vAdmin.lblCancelarAvionIcon == e.getSource() ||
                this.vAdmin.btnTipsAvion == e.getSource() ||
                this.vAdmin.lblConfirmarAgregarEditarAvion == e.getSource() ||
                this.vAdmin.lblCancelarAgregarEditarAvion == e.getSource() ||
                this.vAdmin.lblAgregarAvionIcon == e.getSource() ||
                this.vAdmin.lblEditarAvionIcon == e.getSource() ||
                this.vAdmin.lblDetallesAvionIcon == e.getSource() ||
                this.vAdmin.lblEliminarAvionIcon == e.getSource() ||
                this.vAdmin.btnAgregarAvion == e.getSource() ||
                this.vAdmin.btnDetallesAvion == e.getSource() ||
                this.vAdmin.btnEditarAvion == e.getSource() ||
                this.vAdmin.btnEliminarAvion == e.getSource() ||
                this.vAdmin.lblRegresarAgregarEditarAvion == e.getSource()
                )
        {
            this.vAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(
                this.vAdmin.lblMenuIcon == e.getSource() ||
                this.vAdmin.lblAvionesIcon == e.getSource() ||
                this.vAdmin.lblConfigIcon == e.getSource() ||
                this.vAdmin.lblHomeIcon == e.getSource() ||
                this.vAdmin.lblTripulacionIcon == e.getSource() ||
                this.vAdmin.lblUsuariosIcon == e.getSource() ||
                this.vAdmin.lblVentasIcon == e.getSource() ||
                this.vAdmin.lblVuelosIcon == e.getSource() ||
                this.vAdmin.lblAvionesTexto == e.getSource() ||
                this.vAdmin.lblConfigTexto == e.getSource() ||
                this.vAdmin.lblHomeTexto == e.getSource() ||
                this.vAdmin.lblTripulacionTexto == e.getSource() ||
                this.vAdmin.lblUsuariosTexto == e.getSource() ||
                this.vAdmin.lblVentasTexto == e.getSource() ||
                this.vAdmin.lblVuelosTexto == e.getSource() ||
                this.vAdmin.lblActualizarAvionIcon == e.getSource() ||
                this.vAdmin.lblCancelarAvionIcon == e.getSource() ||
                this.vAdmin.btnTipsAvion == e.getSource() ||
                this.vAdmin.lblConfirmarAgregarEditarAvion == e.getSource() ||
                this.vAdmin.lblCancelarAgregarEditarAvion == e.getSource() ||
                this.vAdmin.lblAgregarAvionIcon == e.getSource() ||
                this.vAdmin.lblEditarAvionIcon == e.getSource() ||
                this.vAdmin.lblDetallesAvionIcon == e.getSource() ||
                this.vAdmin.lblEliminarAvionIcon == e.getSource() ||
                this.vAdmin.btnAgregarAvion == e.getSource() ||
                this.vAdmin.btnDetallesAvion == e.getSource() ||
                this.vAdmin.btnEditarAvion == e.getSource() ||
                this.vAdmin.btnEliminarAvion == e.getSource() ||
                this.vAdmin.lblRegresarAgregarEditarAvion == e.getSource()
                )
        {
            this.vAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
    }
    
}
