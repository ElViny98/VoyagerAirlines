/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.*;
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
    
    public cAlertas(vAlerta alerta) {
        this.alerta = alerta;
        this.alerta.btnAceptarAlert.addActionListener(this);
        
        
    }
    
    public void agregarContenido(int tipoAlerta){
        switch(tipoAlerta){
            case 1://Alerta correcto
                ImageIcon successful = new ImageIcon(getClass().getResource(("/img/correct.png")));
                ImageIcon success = new ImageIcon(successful.getImage().getScaledInstance(alerta.lblImgAlerta.getWidth(), alerta.lblImgAlerta.getHeight(), Image.SCALE_DEFAULT));
                alerta.lblImgAlerta.setIcon(success);
                alerta.lblAccionAlert.setText("¡VUELO AGREGADO CON ÉXITO!");
                break;
            case 2://Alerta advertencia
                ImageIcon warning = new ImageIcon(getClass().getResource(("/img/warning.png")));
                ImageIcon advertencia = new ImageIcon(warning.getImage().getScaledInstance(alerta.lblImgAlerta.getWidth(), alerta.lblImgAlerta.getHeight(), Image.SCALE_DEFAULT));
                alerta.lblImgAlerta.setIcon(advertencia);
                alerta.lblAccionAlert.setText("¡ESTA ES UNA ALERTA DE ADVERTENCIA!");
                break;
            case 3://Alerta error
                ImageIcon error = new ImageIcon(getClass().getResource(("/img/error.png")));
                ImageIcon errorA = new ImageIcon(error.getImage().getScaledInstance(alerta.lblImgAlerta.getWidth(), alerta.lblImgAlerta.getHeight(), Image.SCALE_DEFAULT));
                alerta.lblImgAlerta.setIcon(errorA);
                alerta.lblAccionAlert.setText("¡ALGO HA SALIDO MAL!");
                break;
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
        if(alerta.btnAceptarAlert == e.getSource()){
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
