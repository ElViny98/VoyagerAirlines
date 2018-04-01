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
public class cVuelos implements ActionListener, MouseListener{
    //===Variables a utilizar===//
    private String numBusqueda = "";
    //====================Para la ventana de agregar vuelo====================//
    private vAgregarVuelo agregarVuelo;
    private mVuelos modeloVuelos = new mVuelos();
    private vAlerta alerta = new vAlerta();
    //========================================================================//
    //==============Para la ventana de buscar avión / tripulación=============//
    private vBuscar_AgregarVuelo buscar = new vBuscar_AgregarVuelo();
    private mBuscar_AgregarVuelo modeloBuscar = new mBuscar_AgregarVuelo();
    //========================================================================//
    //=====Constructor para la ventana de Agregar, Editar o Eliminar vuelo====//
    public cVuelos(vAgregarVuelo agregarVuelo, int opcion){
        switch(opcion){
            //==========Ventana de agregar==========//
            case 1:
                this.agregarVuelo = agregarVuelo;
                
                this.agregarVuelo.btnAceptarVuelo.addActionListener(this);
                this.agregarVuelo.btnSalirAgregar.addActionListener(this);
                this.agregarVuelo.checkEscalas.addActionListener(this);
                this.agregarVuelo.btnBuscarAvionVuelo.addActionListener(this);
                this.agregarVuelo.btnBuscarTripulacionVuelo.addActionListener(this);
                this.agregarVuelo.txtAvionVuelo.disable();
                //==========Íconos//==========//
                ImageIcon ciuOrigen = new ImageIcon(getClass().getResource(("/icons/ciuOrigen.png")));
                ImageIcon ciuDestino = new ImageIcon(getClass().getResource(("/icons/ciuDestino.png")));
                ImageIcon clock = new ImageIcon(getClass().getResource(("/icons/reloj.png")));
                ImageIcon empleado = new ImageIcon(getClass().getResource(("/icons/empleados.png")));
                ImageIcon mapa = new ImageIcon(getClass().getResource(("/icons/map.png")));
                ImageIcon calendario = new ImageIcon(getClass().getResource(("/icons/calendar.png")));
                ImageIcon hashtag = new ImageIcon(getClass().getResource(("/icons/hashtag.png")));
                //==========Imágenes de tamaño específico==========//
                ImageIcon origen = new ImageIcon(ciuOrigen.getImage().getScaledInstance(agregarVuelo.lblImgOrigen.getWidth(), agregarVuelo.lblImgOrigen.getHeight(), Image.SCALE_DEFAULT));
                ImageIcon destino = new ImageIcon(ciuDestino.getImage().getScaledInstance(agregarVuelo.lblImgDestino.getWidth(), agregarVuelo.lblImgDestino.getHeight(), Image.SCALE_DEFAULT));
                ImageIcon salida = new ImageIcon(clock.getImage().getScaledInstance(agregarVuelo.lblSalidaVuelo.getWidth(), agregarVuelo.lblSalidaVuelo.getHeight(), Image.SCALE_DEFAULT));
                ImageIcon llegada = new ImageIcon(clock.getImage().getScaledInstance(agregarVuelo.lblLlegadaVuelo.getWidth(), agregarVuelo.lblLlegadaVuelo.getHeight(), Image.SCALE_DEFAULT));
                ImageIcon tripulacion = new ImageIcon(empleado.getImage().getScaledInstance(agregarVuelo.lblImgTripulacion.getWidth(), agregarVuelo.lblImgTripulacion.getHeight(), Image.SCALE_DEFAULT));
                ImageIcon escala = new ImageIcon(mapa.getImage().getScaledInstance(agregarVuelo.lblImgEscala.getWidth(), agregarVuelo.lblImgEscala.getHeight(), Image.SCALE_DEFAULT));
                ImageIcon calendar = new ImageIcon(calendario.getImage().getScaledInstance(agregarVuelo.lblImgCalendarVuelo.getWidth(), agregarVuelo.lblImgCalendarVuelo.getHeight(), Image.SCALE_DEFAULT));
                ImageIcon number = new ImageIcon(hashtag.getImage().getScaledInstance(agregarVuelo.lblAvionVuelo.getWidth(), agregarVuelo.lblAvionVuelo.getHeight(), Image.SCALE_DEFAULT));
                
                agregarVuelo.lblImgOrigen.setIcon(origen);

                agregarVuelo.lblImgDestino.setIcon(destino);

                agregarVuelo.lblSalidaVuelo.setIcon(salida);

                agregarVuelo.lblLlegadaVuelo.setIcon(llegada);

                agregarVuelo.lblImgTripulacion.setIcon(tripulacion);

                agregarVuelo.lblImgEscala.setIcon(escala);
                
                agregarVuelo.lblImgCalendarVuelo.setIcon(calendar);
                
                agregarVuelo.lblAvionVuelo.setIcon(number);
                
                agregarVuelo.txtEscalaVuelo.disable();
                
                //===Para agregar placeholder a cada uno de los campos de texto===//
                agregarVuelo.txtOrigenVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        txtOrigenVueloFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        txtOrigenVueloFocusLost(evt);
                    }
                });
                
                agregarVuelo.txtDestinoVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        txtDestinoVueloFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        txtDestinoVueloFocusLost(evt);
                    }
                });
                
                agregarVuelo.txtSalidaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        txtSalidaVueloFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        txtSalidaVueloFocusLost(evt);
                    }
                });
                
                agregarVuelo.txtLlegadaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        txtLlegadaVueloFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        txtLlegadaVueloFocusLost(evt);
                    }
                });
                
                agregarVuelo.txtEscalaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        txtEscalaVueloFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        txtEscalaVueloFocusLost(evt);
                    }
                });
                
                agregarVuelo.txtFechaVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        txtFechaVueloFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        txtFechaVueloFocusLost(evt);
                    }
                });
                
                agregarVuelo.txtAvionVuelo.addFocusListener(new java.awt.event.FocusAdapter() {
                    public void focusGained(java.awt.event.FocusEvent evt) {
                        txtAvionVueloFocusGained(evt);
                    }
                    public void focusLost(java.awt.event.FocusEvent evt) {
                        txtAvionVueloFocusLost(evt);
                    }
                });
                
                break;
            //===Opción editar===//
            case 2:
                break;
            case 3:
                break;
        }
        
    }
    //====Método para crear la ventana de buscar tripulación o buscar avión===//
    public void buscarDatos(vBuscar_AgregarVuelo buscar){
        this.buscar = buscar;
        
        this.buscar.btnAceptarBuscar.addActionListener(this);
        this.buscar.btnCerrarBuscarVuelo.addActionListener(this);
        this.buscar.tblNumBuscar.addMouseListener(this);
        /*===Para dejar "invisible" una columna específica===
        this.buscar.tblDatosBuscar.getColumnModel().getColumn(0).setMinWidth(0);
        this.buscar.tblDatosBuscar.getColumnModel().getColumn(0).setMaxWidth(0);
        this.buscar.tblDatosBuscar.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.buscar.tblDatosBuscar.getColumnModel().getColumn(0).setResizable(false);*/
    }
    //===Validar la opción de si se quieren o no escalas===//
    public void validarCheck(){
        
        if(agregarVuelo.checkEscalas.isSelected()){
            agregarVuelo.txtEscalaVuelo.setEnabled(true);
        }
        else if(!agregarVuelo.checkEscalas.isSelected()){
            agregarVuelo.txtEscalaVuelo.setText("---Escala---");
            agregarVuelo.txtEscalaVuelo.setEnabled(false);
        }
    }
    //===Métodos para colocar placeholder===//
    private void txtOrigenVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtOrigenVuelo.getText().equals("Ciudad de origen")){
            agregarVuelo.txtOrigenVuelo.setText("");
        }
    }                                          
    private void txtOrigenVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtOrigenVuelo.getText().equals("")){
            agregarVuelo.txtOrigenVuelo.setText("Ciudad de origen");
        }
    }
    //======================================//
    //===Métodos para colocar placeholder===//
    private void txtDestinoVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtDestinoVuelo.getText().equals("Ciudad destino")){
            agregarVuelo.txtDestinoVuelo.setText("");
        }
    }                                          
    private void txtDestinoVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtDestinoVuelo.getText().equals("")){
            agregarVuelo.txtDestinoVuelo.setText("Ciudad destino");
        }
    }
    //======================================//
    //===Métodos para colocar placeholder===//
    private void txtSalidaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtSalidaVuelo.getText().equals("Hora de salida")){
            agregarVuelo.txtSalidaVuelo.setText("");
        }
    }                                          
    private void txtSalidaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtSalidaVuelo.getText().equals("")){
            agregarVuelo.txtSalidaVuelo.setText("Hora de salida");
        }
    }
    //======================================//
    //===Métodos para colocar placeholder===//
    private void txtLlegadaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtLlegadaVuelo.getText().equals("Hora de llegada")){
            agregarVuelo.txtLlegadaVuelo.setText("");
        }
    }                                          
    private void txtLlegadaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtLlegadaVuelo.getText().equals("")){
            agregarVuelo.txtLlegadaVuelo.setText("Hora de llegada");
        }
    }
    //======================================//
    //===Métodos para colocar placeholder===//
    private void txtEscalaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtEscalaVuelo.getText().equals("---Escala---")){
            agregarVuelo.txtEscalaVuelo.setText("");
        }
    }                                          
    private void txtEscalaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtEscalaVuelo.getText().equals("")){
            agregarVuelo.txtEscalaVuelo.setText("---Escala---");
        }
    }
    //======================================//
    //===Métodos para colocar placeholder===//
    private void txtFechaVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtFechaVuelo.getText().equals("Fecha de vuelo")){
            agregarVuelo.txtFechaVuelo.setText("");
        }
    }                                          
    private void txtFechaVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtFechaVuelo.getText().equals("")){
            agregarVuelo.txtFechaVuelo.setText("Fecha de vuelo");
        }
    }
    //======================================//
    //===Métodos para colocar placeholder===//
    private void txtAvionVueloFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(agregarVuelo.txtAvionVuelo.getText().equals("---No. de avión---")){
            agregarVuelo.txtAvionVuelo.setText("");
        }
    }                                          
    private void txtAvionVueloFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(agregarVuelo.txtAvionVuelo.getText().equals("")){
            agregarVuelo.txtAvionVuelo.setText("---No. de avión---");
        }
    }
    //======================================//
    
    public void iniciarAgregar(){
        agregarVuelo.pack();
        agregarVuelo.setLocationRelativeTo(null);
        agregarVuelo.setVisible(true);
    }
    public void iniciarBuscar(){
        buscar.pack();
        buscar.setLocationRelativeTo(null);
        buscar.setVisible(true);
        //===Enviar los datos a la tabla de números de avión disponible===//
        buscar.tblNumBuscar.setModel(modeloBuscar.avionConsulta());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(agregarVuelo.btnSalirAgregar == e.getSource()){
            agregarVuelo.dispose();
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
                String escala = "", tripulacion = "";
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
                
                if(modeloVuelos.vueloAgregar(agregarVuelo.txtOrigenVuelo.getText(),agregarVuelo.txtDestinoVuelo.getText(), agregarVuelo.txtEscalaVuelo.getText(), Integer.parseInt(tripulacion), agregarVuelo.txtFechaVuelo.getText(), agregarVuelo.txtSalidaVuelo.getText(), agregarVuelo.txtLlegadaVuelo.getText()))
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
        else if(agregarVuelo.btnBuscarAvionVuelo == e.getSource())
        {
            vBuscar_AgregarVuelo vistaBuscar = new vBuscar_AgregarVuelo();
            this.buscarDatos(vistaBuscar);
            this.iniciarBuscar();
        }
        //===Para la sección de agregar===//
        if(buscar.btnAceptarBuscar == e.getSource()){
            agregarVuelo.txtAvionVuelo.setText(this.numBusqueda);
            buscar.dispose();
        }
        else if(buscar.btnCerrarBuscarVuelo == e.getSource()){
            buscar.dispose();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(buscar.tblNumBuscar == e.getSource()){
            int fila = buscar.tblNumBuscar.rowAtPoint(e.getPoint());
            int numeroAvion;
            String numAvion;
            if (fila > -1){
                numAvion = String.valueOf(buscar.tblNumBuscar.getValueAt(fila, 0));
                numeroAvion = Integer.parseInt(numAvion);
                buscar.tblDatosBuscar.setModel(modeloBuscar.datosAvionConsulta(numeroAvion));
                this.numBusqueda = numAvion;
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
