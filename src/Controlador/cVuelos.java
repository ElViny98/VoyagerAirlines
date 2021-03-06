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
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class cVuelos implements ActionListener, MouseListener{
    //==========================Variables a utilizar==========================//
    private String numBusqueda = "";
    private int idBuscar = 0;
    private int tipoEditar = 0;
    private String[] datos;
    //============================Para las alertas============================//
    private vAlerta alerta = new vAlerta();
    //========================Para la ventana de vuelos=======================//
    private vAgregarVuelo agregarVuelo;
    private mVuelos modeloVuelos = new mVuelos();
    //==============Para la ventana de buscar avión / tripulación=============//
    private vBuscar_AgregarVuelo buscar = new vBuscar_AgregarVuelo();
    private mBuscar_AgregarVuelo modeloBuscar = new mBuscar_AgregarVuelo();
    //========================================================================//
    //==========Constructor para la ventana de Agregar o Editar vuelo=========//
    public cVuelos(vAgregarVuelo vuelo, int opcion, int idBuscar){
        //==========Íconos//==========//
        ImageIcon ciuOrigen = new ImageIcon(getClass().getResource(("/icons/ciuOrigen.png")));
        ImageIcon ciuDestino = new ImageIcon(getClass().getResource(("/icons/ciuDestino.png")));
        ImageIcon clock = new ImageIcon(getClass().getResource(("/icons/reloj.png")));
        ImageIcon empleado = new ImageIcon(getClass().getResource(("/icons/empleados.png")));
        ImageIcon mapa = new ImageIcon(getClass().getResource(("/icons/map.png")));
        ImageIcon calendario = new ImageIcon(getClass().getResource(("/icons/calendar.png")));
        ImageIcon hashtag = new ImageIcon(getClass().getResource(("/icons/hashtag.png")));
        ImageIcon price = new ImageIcon(getClass().getResource(("/icons/price.png")));
        //==========Imágenes de tamaño específico==========//
        ImageIcon origen = new ImageIcon(ciuOrigen.getImage().getScaledInstance(vuelo.lblImgOrigen.getWidth(), vuelo.lblImgOrigen.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon destino = new ImageIcon(ciuDestino.getImage().getScaledInstance(vuelo.lblImgDestino.getWidth(), vuelo.lblImgDestino.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon salida = new ImageIcon(clock.getImage().getScaledInstance(vuelo.lblSalidaVuelo.getWidth(), vuelo.lblSalidaVuelo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon llegada = new ImageIcon(clock.getImage().getScaledInstance(vuelo.lblLlegadaVuelo.getWidth(), vuelo.lblLlegadaVuelo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon tripulacion = new ImageIcon(empleado.getImage().getScaledInstance(vuelo.lblImgTripulacion.getWidth(), vuelo.lblImgTripulacion.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon escala = new ImageIcon(mapa.getImage().getScaledInstance(vuelo.lblImgEscala.getWidth(), vuelo.lblImgEscala.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon calendar = new ImageIcon(calendario.getImage().getScaledInstance(vuelo.lblImgCalendarVuelo.getWidth(), vuelo.lblImgCalendarVuelo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon number = new ImageIcon(hashtag.getImage().getScaledInstance(vuelo.lblAvionVuelo.getWidth(), vuelo.lblAvionVuelo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon precio = new ImageIcon(price.getImage().getScaledInstance(vuelo.lblImgPrecioVuelo.getWidth(), vuelo.lblImgPrecioVuelo.getHeight(), Image.SCALE_DEFAULT));
        //==========Enviar imagen a componente==========//
        vuelo.lblImgOrigen.setIcon(origen);
        vuelo.lblImgDestino.setIcon(destino);
        vuelo.lblSalidaVuelo.setIcon(salida);
        vuelo.lblLlegadaVuelo.setIcon(llegada);
        vuelo.lblImgTripulacion.setIcon(tripulacion);
        vuelo.lblImgEscala.setIcon(escala);
        vuelo.lblImgCalendarVuelo.setIcon(calendar);
        vuelo.lblAvionVuelo.setIcon(number);
        vuelo.lblImgPrecioVuelo.setIcon(precio);
        vuelo.txtEscalaVuelo.disable();
        //======Campos de texto editados=====//
        vuelo.txtOrigenVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        vuelo.txtDestinoVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        vuelo.txtEscalaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        vuelo.txtFechaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        vuelo.txtLlegadaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        vuelo.txtPrecioVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        vuelo.txtSalidaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        switch(opcion){
            //==========Ventana de agregar==========//
            case 1:
                this.agregarVuelo = vuelo;
                
                this.agregarVuelo.btnAceptarVuelo.addActionListener(this);
                this.agregarVuelo.btnSalirAgregar.addActionListener(this);
                this.agregarVuelo.checkEscalas.addActionListener(this);
                this.agregarVuelo.btnBuscarAvionVuelo.addActionListener(this);
                this.agregarVuelo.btnBuscarTripulacionVuelo.addActionListener(this);
                this.agregarVuelo.btnLimpiarCamposVuelo.addActionListener(this);
                this.agregarVuelo.txtAvionVuelo.disable();
                this.agregarVuelo.txtTripulacionVuelo.disable();
                break;
            //===Ventana de editar===//
            case 2:
                this.agregarVuelo = vuelo;
                this.idBuscar = idBuscar;
                
                this.agregarVuelo.btnAceptarVuelo.addActionListener(this);
                this.agregarVuelo.btnSalirAgregar.addActionListener(this);
                this.agregarVuelo.checkEscalas.addActionListener(this);
                this.agregarVuelo.btnBuscarAvionVuelo.addActionListener(this);
                this.agregarVuelo.btnBuscarTripulacionVuelo.addActionListener(this);
                this.agregarVuelo.btnLimpiarCamposVuelo.addActionListener(this);
                this.agregarVuelo.txtAvionVuelo.disable();
                this.agregarVuelo.txtTripulacionVuelo.disable();
                
                this.agregarVuelo.lblTituloVuelo.setText("Editar vuelo");
                this.datos = modeloVuelos.consultaVueloEspecifico(this.idBuscar);
                
                this.agregarVuelo.txtOrigenVuelo.setText(datos[1]);
                this.agregarVuelo.txtDestinoVuelo.setText(datos[2]);
                
                if(datos[3].equals("0")){
                    this.agregarVuelo.txtEscalaVuelo.setText("---Escala---");
                    this.tipoEditar = 0;
                }
                else{
                    this.agregarVuelo.txtEscalaVuelo.setText(datos[8]);
                    this.tipoEditar = 1;
                }
                if(datos[4].equals("0"))
                    this.agregarVuelo.txtTripulacionVuelo.setText("---No. de tripulación---");
                else
                    this.agregarVuelo.txtTripulacionVuelo.setText(datos[4]);
                this.agregarVuelo.txtFechaVuelo.setText(datos[5]);
                this.agregarVuelo.txtSalidaVuelo.setText(datos[6]);
                this.agregarVuelo.txtLlegadaVuelo.setText(datos[7]);
                this.agregarVuelo.txtPrecioVuelo.setText(datos[9]);
                
                break;
            case 3:
                break;
        }
        //=====Método para agregar placeholder al campo de origen=====//
        vuelo.txtOrigenVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOrigenVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOrigenVueloFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de Destino====//
        vuelo.txtDestinoVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDestinoVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDestinoVueloFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de salida=====//
        vuelo.txtSalidaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSalidaVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSalidaVueloFocusLost(evt);
            }
        });
        //====Método para agregar placeholder al campo de llegada=====//
        vuelo.txtLlegadaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLlegadaVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLlegadaVueloFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de escala=====//
        vuelo.txtEscalaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEscalaVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEscalaVueloFocusLost(evt);
            }
        });
        //======Método para agregar placeholder al campo de fecha=====//
        vuelo.txtFechaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaVueloFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de escala=====//
        vuelo.txtTripulacionVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTripulacionVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTripulacionVueloFocusLost(evt);
            }
        });
        //======Método para agregar placeholder al campo de precio=====//
        vuelo.txtPrecioVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioVueloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioVueloFocusLost(evt);
            }
        });
    }
    //====Método para crear la ventana de buscar tripulación o buscar avión===//
    public void buscarDatos(vBuscar_AgregarVuelo buscar){
        this.buscar = buscar;
        
        this.buscar.btnAceptarBuscarAvion.addActionListener(this);
        this.buscar.btnAceptarBuscarTrip.addActionListener(this);
        this.buscar.btnCerrarBuscarVuelo.addActionListener(this);
        this.buscar.tblNumBuscarAvion.addMouseListener(this);
        this.buscar.tblNumBuscarTripulacion.addMouseListener(this);
        this.buscar.tblNumBuscarAvion.setRowHeight(30);
        this.buscar.tblNumBuscarTripulacion.setRowHeight(30);
        this.buscar.tblDatosBuscar.setRowHeight(30);
    }
    //==========Método para iniciar la ventana para agregar un vuelo==========//
    public void iniciarAgregar(){
        agregarVuelo.pack();
        agregarVuelo.setLocationRelativeTo(null);
        agregarVuelo.setVisible(true);
    }
    //================Método para iniciar la ventana de buscar================//
    public void iniciarBuscar(int tipo){
        buscar.pack();
        buscar.setLocationRelativeTo(null);
        buscar.setVisible(true);
        Font f = new Font("Montserrat", 0, 12);
        switch(tipo){
            //==========Para la ventana de buscar avión==========//
            case 1:
                buscar.tablaTripulacion.setVisible(false);
                buscar.btnAceptarBuscarTrip.setVisible(false);
                buscar.tablaAvion.setVisible(true);
                
                buscar.tblDatosBuscar.setFont(f);
                buscar.tblDatosBuscar.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Nombre de avión");
                buscar.tblDatosBuscar.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Capacidad");
                //=Enviar los datos a la tabla de números de avión disponibl==//
                buscar.tblNumBuscarAvion.setModel(modeloBuscar.avionConsulta());
                buscar.lblTituloBuscar.setText("BUSCAR AVIÓN");
                break;
            //==========Para la ventana de buscar tripulación==========//
            case 2:
                buscar.tblDatosBuscar.setFont(f);
                buscar.tablaTripulacion.setVisible(true);
                buscar.tablaAvion.setVisible(false);
                buscar.btnAceptarBuscarAvion.setVisible(false);
                
                buscar.tblDatosBuscar.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Puesto");
                buscar.tblDatosBuscar.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Nombre");
                //=Enviar los datos a la tabla de números de avión disponibl==//
                buscar.tblNumBuscarTripulacion.setModel(modeloBuscar.tripulacionConsulta());
                buscar.lblTituloBuscar.setText("BUSCAR TRIPULACIÓN");
                break;
        }
    }
    //=============Validar la opción de si se quieren o no escalas============//
    public void validarCheck(){
        
        if(agregarVuelo.checkEscalas.isSelected()){
            agregarVuelo.txtEscalaVuelo.setEnabled(true);
        }
        else if(!agregarVuelo.checkEscalas.isSelected()){
            agregarVuelo.txtEscalaVuelo.setText("---Escala---");
            agregarVuelo.txtEscalaVuelo.setEnabled(false);
        }
    }
    public void limpiarCamposVuelo(){
        agregarVuelo.txtOrigenVuelo.setText("Ciudad de origen");
        agregarVuelo.txtDestinoVuelo.setText("Ciudad destino");
        agregarVuelo.txtSalidaVuelo.setText("Hora de salida");
        agregarVuelo.txtLlegadaVuelo.setText("Hora de llegada");
        agregarVuelo.txtEscalaVuelo.setText("---Escala---");
        agregarVuelo.txtTripulacionVuelo.setText("---No. de tripulación---");
        agregarVuelo.txtAvionVuelo.setText("---No. de avión---");
        agregarVuelo.txtFechaVuelo.setText("Fecha de vuelo");
    }
    //===========Métodos para colocar placeholder al campo de origen==========//
    private void txtOrigenVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtOrigenVuelo.getText().equals("Ciudad de origen")){
            agregarVuelo.txtOrigenVuelo.setText("");
            agregarVuelo.txtOrigenVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtOrigenVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtOrigenVuelo.getText().equals("")){
            agregarVuelo.txtOrigenVuelo.setText("Ciudad de origen");
            agregarVuelo.txtOrigenVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //==========Métodos para colocar placeholder al campo de destino==========//
    private void txtDestinoVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtDestinoVuelo.getText().equals("Ciudad destino")){
            agregarVuelo.txtDestinoVuelo.setText("");
            agregarVuelo.txtDestinoVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtDestinoVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtDestinoVuelo.getText().equals("")){
            agregarVuelo.txtDestinoVuelo.setText("Ciudad destino");
            agregarVuelo.txtDestinoVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //===========Métodos para colocar placeholder al campo de vuelo===========//
    private void txtSalidaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtSalidaVuelo.getText().equals("Hora de salida")){
            agregarVuelo.txtSalidaVuelo.setText("");
            agregarVuelo.txtSalidaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtSalidaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtSalidaVuelo.getText().equals("")){
            agregarVuelo.txtSalidaVuelo.setText("Hora de salida");
            agregarVuelo.txtSalidaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //==========Métodos para colocar placeholder al campo de llegada==========//
    private void txtLlegadaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtLlegadaVuelo.getText().equals("Hora de llegada")){
            agregarVuelo.txtLlegadaVuelo.setText("");
            agregarVuelo.txtLlegadaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtLlegadaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtLlegadaVuelo.getText().equals("")){
            agregarVuelo.txtLlegadaVuelo.setText("Hora de llegada");
            agregarVuelo.txtLlegadaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //===========Métodos para colocar placeholder al campo de escala==========//
    private void txtEscalaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtEscalaVuelo.getText().equals("---Escala---")){
            agregarVuelo.txtEscalaVuelo.setText("");
            agregarVuelo.txtEscalaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtEscalaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtEscalaVuelo.getText().equals("")){
            agregarVuelo.txtEscalaVuelo.setText("---Escala---");
            agregarVuelo.txtEscalaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //===========Métodos para colocar placeholder al campo de fecha===========//
    private void txtFechaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtFechaVuelo.getText().equals("Fecha de vuelo")){
            agregarVuelo.txtFechaVuelo.setText("");
            agregarVuelo.txtFechaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtFechaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtFechaVuelo.getText().equals("")){
            agregarVuelo.txtFechaVuelo.setText("Fecha de vuelo");
            agregarVuelo.txtFechaVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //========Métodos para colocar placeholder al campo de tripulación========//
    private void txtTripulacionVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtTripulacionVuelo.getText().equals("---No. de tripulación---")){
            agregarVuelo.txtTripulacionVuelo.setText("");
            agregarVuelo.txtTripulacionVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtTripulacionVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtTripulacionVuelo.getText().equals("")){
            agregarVuelo.txtTripulacionVuelo.setText("---No. de tripulación---");
            agregarVuelo.txtTripulacionVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //===========Métodos para colocar placeholder al campo de avión===========//
    private void txtAvionVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtAvionVuelo.getText().equals("---No. de avión---")){
            agregarVuelo.txtAvionVuelo.setText("");
            agregarVuelo.txtAvionVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtAvionVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtAvionVuelo.getText().equals("")){
            agregarVuelo.txtAvionVuelo.setText("---No. de avión---");
            agregarVuelo.txtAvionVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }
    //==========Métodos para colocar placeholder al campo de precio===========//
    private void txtPrecioVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtPrecioVuelo.getText().equals("Precio")){
            agregarVuelo.txtPrecioVuelo.setText("");
            agregarVuelo.txtPrecioVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));
        }
    }                                          
    private void txtPrecioVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtPrecioVuelo.getText().equals("")){
            agregarVuelo.txtPrecioVuelo.setText("Precio");
            agregarVuelo.txtPrecioVuelo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //==========Acciones para la ventana de agregar vuelo==========//
        if(agregarVuelo.btnSalirAgregar == e.getSource()){
            agregarVuelo.dispose();
        }
        else if(agregarVuelo.btnLimpiarCamposVuelo == e.getSource()){
            limpiarCamposVuelo();
        }
        else if(agregarVuelo.checkEscalas == e.getSource()){
            validarCheck();
        }
        else if(agregarVuelo.btnAceptarVuelo == e.getSource()){
            //===Revisar que se hayan completado los campos obligatorios===//
            if(agregarVuelo.txtOrigenVuelo.getText().equals("Ciudad de origen") || agregarVuelo.txtDestinoVuelo.getText().equals("Ciudad destino") || agregarVuelo.txtSalidaVuelo.getText().equals("Hora de salida") || agregarVuelo.txtLlegadaVuelo.getText().equals("Hora de llegada") || agregarVuelo.txtTripulacionVuelo.getText().equals("---No. de tripulación---") || agregarVuelo.txtFechaVuelo.getText().equals("Fecha de vuelo")){
                cAlertas mostrarAlerta = new cAlertas(alerta);
                mostrarAlerta.agregarContenido(2, "¡RELLENAR LOS CAMPOS!");
                mostrarAlerta.iniciarAlerta();
            }
            else{
                String escala = "", tripulacion = "", avion = "";
                if(agregarVuelo.txtEscalaVuelo.getText().equals("---Escala---")){
                    escala = "0";
                } else{
                    escala = agregarVuelo.txtEscalaVuelo.getText();
                }
                if(agregarVuelo.txtTripulacionVuelo.getText().equals("---No. de tripulación---")){
                    tripulacion = "0";
                } else{
                    tripulacion = agregarVuelo.txtTripulacionVuelo.getText();
                }
                if(agregarVuelo.txtAvionVuelo.getText().equals("---No. de avión---")){
                    avion = "0";
                } else{
                    avion = agregarVuelo.txtAvionVuelo.getText();
                }
                //===Acción para la ventana editar===//
                if(this.idBuscar>=1)
                {
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
                    }
                }
                //===Acción para la ventana agregar===//
                else
                {
                    if(modeloVuelos.vueloAgregar(agregarVuelo.txtOrigenVuelo.getText(),agregarVuelo.txtDestinoVuelo.getText(), escala, Integer.parseInt(tripulacion), agregarVuelo.txtFechaVuelo.getText(), agregarVuelo.txtSalidaVuelo.getText(), agregarVuelo.txtLlegadaVuelo.getText(), Double.parseDouble(agregarVuelo.txtPrecioVuelo.getText())))
                    {
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(1, "¡VUELO REGISTRADO CON ÉXITO!");
                        mostrarAlerta.iniciarAlerta();
                        agregarVuelo.dispose();
                    } else{
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(3, "¡ALGO HA SALIDO MAL!");
                        mostrarAlerta.iniciarAlerta();
                    }
                }
            }
        }
        else if(agregarVuelo.btnBuscarAvionVuelo == e.getSource())
        {
            vBuscar_AgregarVuelo vistaBuscar = new vBuscar_AgregarVuelo();
            this.buscarDatos(vistaBuscar);
            this.iniciarBuscar(1);
        }
        else if(agregarVuelo.btnBuscarTripulacionVuelo == e.getSource()){
            vBuscar_AgregarVuelo buscando = new vBuscar_AgregarVuelo();
            this.buscarDatos(buscando);
            this.iniciarBuscar(2);
        }
        //==========Acciones para la sección de buscar==========//
        if(buscar.btnAceptarBuscarAvion == e.getSource()){
            agregarVuelo.txtAvionVuelo.setText(this.numBusqueda);
            this.numBusqueda = "";
            buscar.dispose();
        }
        else if(buscar.btnAceptarBuscarTrip == e.getSource()){
            agregarVuelo.txtTripulacionVuelo.setText(this.numBusqueda);
            this.numBusqueda = "";
            buscar.dispose();
        }
        else if(buscar.btnCerrarBuscarVuelo == e.getSource()){
            buscar.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //==========Acciones del mouse de la ventana buscar==========//
        if(buscar.tblNumBuscarAvion == e.getSource()){
            int fila = buscar.tblNumBuscarAvion.rowAtPoint(e.getPoint());
            int numeroAvion;
            String numAvion;
            if (fila > -1){
                numAvion = String.valueOf(buscar.tblNumBuscarAvion.getValueAt(fila, 0));
                numeroAvion = Integer.parseInt(numAvion);
                buscar.tblDatosBuscar.setModel(modeloBuscar.datosAvionConsulta(numeroAvion));
                this.numBusqueda = numAvion;
            }
        }
        else if(buscar.tblNumBuscarTripulacion == e.getSource()){
            int fila = buscar.tblNumBuscarTripulacion.rowAtPoint(e.getPoint());
            int numeroTripulacion;
            String numTripulacion;
            if (fila > -1){
                numTripulacion = String.valueOf(buscar.tblNumBuscarTripulacion.getValueAt(fila, 0));
                numeroTripulacion = Integer.parseInt(numTripulacion);
                buscar.tblDatosBuscar.setModel(modeloBuscar.datosTripulacionConsulta(numeroTripulacion));
                this.numBusqueda = numTripulacion;
            }
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
    
}
