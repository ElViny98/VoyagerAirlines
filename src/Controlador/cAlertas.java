/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.*;
import Modelo.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import rojerusan.RSAnimation;

import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class cAlertas implements ActionListener{
    private vAlerta alerta;
    private int tipoAlerta, numVuelo, tipoEliminar, seccionEliminar, numTrip, numUser;
    private String[] datosVuelo;
    private mVuelos modeloVuelo = new mVuelos();
    private mTripulacion modeloTripulacion = new mTripulacion();
    private mUser modeloUsuario = new mUser();
    /*===Para la sección eliminar:
        1 = Vuelos
        2 = Tripulacion
        3 = Usuario (Cliente)
    */
    public int getSeccionEliminar() {
        return seccionEliminar;
    }

    public void setSeccionEliminar(int seccionEliminar) {
        this.seccionEliminar = seccionEliminar;
    }
    
    public cAlertas(vAlerta alerta) {
        this.alerta = alerta;
        this.alerta.btnAceptarAlert.addActionListener(this);
        this.alerta.btnNoConfirmar.addActionListener(this);
        this.alerta.btnSiConfirmar.addActionListener(this);
    }
    
    
    public void agregarContenido(int tipoAlerta, String texto){
        //===Se utilizan para alerta de confirmación===//
        ImageIcon quest = new ImageIcon(getClass().getResource(("/img/quest.jpg")));
        ImageIcon confirmar = new ImageIcon(quest.getImage().getScaledInstance(alerta.lblImgConfirmar.getWidth(), alerta.lblImgConfirmar.getHeight(), Image.SCALE_DEFAULT));
        String cadena1 = "", cadena2 = "", numero = "";
        switch(tipoAlerta){
            case 1://Alerta correcto
                ImageIcon successful = new ImageIcon(getClass().getResource(("/img/correct.png")));
                ImageIcon success = new ImageIcon(successful.getImage().getScaledInstance(alerta.lblImgAlerta.getWidth(), alerta.lblImgAlerta.getHeight(), Image.SCALE_DEFAULT));
                alerta.lblImgAlerta.setIcon(success);
                alerta.lblAccionAlert.setText(texto);
                alerta.panelAlerta.setVisible(true);
                alerta.panelConfirmar.setVisible(false);
                break;
            case 2://Alerta advertencia
                ImageIcon warning = new ImageIcon(getClass().getResource(("/img/warning.png")));
                ImageIcon advertencia = new ImageIcon(warning.getImage().getScaledInstance(alerta.lblImgAlerta.getWidth(), alerta.lblImgAlerta.getHeight(), Image.SCALE_DEFAULT));
                alerta.lblImgAlerta.setIcon(advertencia);
                alerta.lblAccionAlert.setText(texto);
                alerta.panelAlerta.setVisible(true);
                alerta.panelConfirmar.setVisible(false);
                break;
            case 3://Alerta error
                ImageIcon error = new ImageIcon(getClass().getResource(("/img/error.png")));
                ImageIcon errorA = new ImageIcon(error.getImage().getScaledInstance(alerta.lblImgAlerta.getWidth(), alerta.lblImgAlerta.getHeight(), Image.SCALE_DEFAULT));
                alerta.lblImgAlerta.setIcon(errorA);
                alerta.lblAccionAlert.setText(texto);
                alerta.panelAlerta.setVisible(true);
                alerta.panelConfirmar.setVisible(false);
                break;
            case 4://Alerta confirmar eliminar vuelo
                this.tipoAlerta = tipoAlerta;
                
                cadena1 = texto.substring(0, 35);
                cadena2 = texto.substring(35, 46);
                numero = texto.substring(43, 45);
                this.numVuelo = Integer.parseInt(numero);
                
                alerta.lblAccionConfirmar.setText(cadena1);
                alerta.lblAccionConfirmar2.setText(cadena2);
                
                alerta.lblImgConfirmar.setIcon(confirmar);
                alerta.panelAlerta.setVisible(false);
                alerta.panelConfirmar.setVisible(true);
                
                this.datosVuelo = modeloVuelo.consultaVueloEspecifico(this.numVuelo);//la 3 es de escala
                if(datosVuelo[3].equals("0"))
                    this.tipoEliminar = 0;
                else
                    this.tipoEliminar = 1;
            case 5:
                this.tipoAlerta = tipoAlerta;
                
                cadena1 = texto.substring(0,29);
                cadena2 = texto.substring(29, texto.length());
                numero = texto.substring(texto.length() - 3, texto.length() - 1);
                this.numTrip = Integer.parseInt(numero);
                
                alerta.lblAccionConfirmar.setText(cadena1);
                alerta.lblAccionConfirmar2.setText(cadena2);
                
                alerta.lblImgConfirmar.setIcon(confirmar);
                alerta.panelAlerta.setVisible(false);
                alerta.panelConfirmar.setVisible(true);
            case 6:
                this.tipoAlerta = tipoAlerta;
                cadena1 = texto.substring(0,29);
                cadena2 = texto.substring(29, texto.length());
                numero = texto.substring(texto.length() - 3, texto.length() - 1);
                this.numUser = Integer.parseInt(numero);
                
                alerta.lblAccionConfirmar.setText(cadena1);
                alerta.lblAccionConfirmar2.setText(cadena2);
                
                alerta.lblImgConfirmar.setIcon(confirmar);
                alerta.panelAlerta.setVisible(false);
                alerta.panelConfirmar.setVisible(true);
            default://Alerta rara que no debe pasar nunca
                break;
        }
    }
    
    public void iniciarAlerta() {
        alerta.pack();
        alerta.setLocationRelativeTo(null);
        alerta.setVisible(true);
        alerta.setLocationRelativeTo(null);

        RSAnimation.setBajar(-230, 200, 2, 2, alerta);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(alerta.btnSiConfirmar == e.getSource()){
            if(this.getSeccionEliminar() == 1){
                modeloVuelo.vueloEliminar(this.tipoEliminar, numVuelo, Integer.parseInt(this.datosVuelo[3]));
                try {
                    RSAnimation.setSubir(200, -330, 2, 2, alerta);
                    Thread.sleep(500);
                    alerta.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(vAlerta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(this.getSeccionEliminar() == 2){
                modeloTripulacion.tripulacionEliminar(this.numTrip);
                try {
                    RSAnimation.setSubir(200, -330, 2, 2, alerta);
                    Thread.sleep(500);
                    alerta.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(vAlerta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(this.getSeccionEliminar() == 3){
                modeloUsuario.eliminarUsuario(this.numUser);
                try {
                    RSAnimation.setSubir(200, -330, 2, 2, alerta);
                    Thread.sleep(500);
                    alerta.dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(vAlerta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        if(alerta.btnAceptarAlert == e.getSource() || alerta.btnNoConfirmar == e.getSource()){
            try {
                RSAnimation.setSubir(200, -330, 2, 2, alerta);
                Thread.sleep(500);
                alerta.dispose();
            } catch (InterruptedException ex) {
                Logger.getLogger(vAlerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
}
