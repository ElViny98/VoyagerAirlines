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
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class cVuelos implements ActionListener{
    private vAgregarVuelo agregarVuelo;
    private mVuelos modeloVuelos = new mVuelos();
    private vAlerta alerta = new vAlerta();
    
    public cVuelos(vAgregarVuelo agregarVuelo, int opcion){
        switch(opcion){
            //===Opciones de agregar===//
            case 1:
                this.agregarVuelo = agregarVuelo;

                this.agregarVuelo.btnAceptarVuelo.addActionListener(this);
                this.agregarVuelo.btnSalirAgregar.addActionListener(this);
                this.agregarVuelo.checkEscalas.addActionListener(this);
                
                ImageIcon ciuOrigen = new ImageIcon(getClass().getResource(("/icons/ciuOrigen.png")));
                ImageIcon origen = new ImageIcon(ciuOrigen.getImage().getScaledInstance(agregarVuelo.lblImgOrigen.getWidth(), agregarVuelo.lblImgOrigen.getHeight(), Image.SCALE_DEFAULT));
                agregarVuelo.lblImgOrigen.setIcon(origen);

                ImageIcon ciuDestino = new ImageIcon(getClass().getResource(("/icons/ciuDestino.png")));
                ImageIcon destino = new ImageIcon(ciuDestino.getImage().getScaledInstance(agregarVuelo.lblImgDestino.getWidth(), agregarVuelo.lblImgDestino.getHeight(), Image.SCALE_DEFAULT));
                agregarVuelo.lblImgDestino.setIcon(destino);

                ImageIcon salir = new ImageIcon(getClass().getResource(("/icons/reloj.png")));
                ImageIcon salida = new ImageIcon(salir.getImage().getScaledInstance(agregarVuelo.lblSalidaVuelo.getWidth(), agregarVuelo.lblSalidaVuelo.getHeight(), Image.SCALE_DEFAULT));
                agregarVuelo.lblSalidaVuelo.setIcon(salida);

                ImageIcon llegar = new ImageIcon(getClass().getResource(("/icons/reloj.png")));
                ImageIcon llegada = new ImageIcon(llegar.getImage().getScaledInstance(agregarVuelo.lblLlegadaVuelo.getWidth(), agregarVuelo.lblLlegadaVuelo.getHeight(), Image.SCALE_DEFAULT));
                agregarVuelo.lblLlegadaVuelo.setIcon(llegada);

                ImageIcon empleado = new ImageIcon(getClass().getResource(("/icons/empleados.png")));
                ImageIcon tripulacion = new ImageIcon(empleado.getImage().getScaledInstance(agregarVuelo.lblImgTripulacion.getWidth(), agregarVuelo.lblImgTripulacion.getHeight(), Image.SCALE_DEFAULT));
                agregarVuelo.lblImgTripulacion.setIcon(tripulacion);

                ImageIcon mapa = new ImageIcon(getClass().getResource(("/icons/map.png")));
                ImageIcon escala = new ImageIcon(mapa.getImage().getScaledInstance(agregarVuelo.lblImgEscala.getWidth(), agregarVuelo.lblImgEscala.getHeight(), Image.SCALE_DEFAULT));
                agregarVuelo.lblImgEscala.setIcon(escala);
                
                ImageIcon calendario = new ImageIcon(getClass().getResource(("/icons/calendar.png")));
                ImageIcon calendar = new ImageIcon(calendario.getImage().getScaledInstance(agregarVuelo.lblImgCalendarVuelo.getWidth(), agregarVuelo.lblImgCalendarVuelo.getHeight(), Image.SCALE_DEFAULT));
                agregarVuelo.lblImgCalendarVuelo.setIcon(calendar);
                
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
                
                break;
            case 2:
                break;
            case 3:
                break;
        }
        
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
    
    public void iniciarAgregar(){
        agregarVuelo.pack();
        agregarVuelo.setLocationRelativeTo(null);
        agregarVuelo.setVisible(true);
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
            //modeloVuelos.vueloAgregar(agregarVuelo.txtOrigenVuelo.getText(),agregarVuelo.txtDestinoVuelo.getText(), Integer.parseInt(agregarVuelo.txtEscalaVuelo.getText()), Integer.parseInt(agregarVuelo.txtTripulacionVuelo.getText()), agregarVuelo.txtFechaVuelo.getText(), agregarVuelo.txtSalidaVuelo.getText(), agregarVuelo.txtLlegadaVuelo.getText());
            //modeloVuelos.vueloAgregar("Prueba", "PruebaDos", 1, 2, "2018-03-30", "01:41:00", "10:41:00");
            
            
            
            if(agregarVuelo.txtOrigenVuelo.getText().equals("Ciudad de origen") || agregarVuelo.txtDestinoVuelo.getText().equals("Ciudad destino") || agregarVuelo.txtSalidaVuelo.getText().equals("Hora de salida") || agregarVuelo.txtLlegadaVuelo.getText().equals("Hora de llegada") || agregarVuelo.txtTripulacionVuelo.getText().equals("---No. de tripulación---")){
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
                
                if(modeloVuelos.vueloAgregar(agregarVuelo.txtOrigenVuelo.getText(),agregarVuelo.txtDestinoVuelo.getText(), Integer.parseInt(escala), Integer.parseInt(tripulacion), agregarVuelo.txtFechaVuelo.getText(), agregarVuelo.txtSalidaVuelo.getText(), agregarVuelo.txtLlegadaVuelo.getText()))
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
    
}
