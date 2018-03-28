/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.vCorrecto;
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
    private vCorrecto correcto;
    
    public cAlertas(vCorrecto correcto) {
        this.correcto = correcto;
        this.correcto.btnAceptar.addActionListener(this);
        
        ImageIcon successful = new ImageIcon(getClass().getResource(("/img/correcto.png")));
        ImageIcon success = new ImageIcon(successful.getImage().getScaledInstance(correcto.jLabelSuccess.getWidth(), correcto.jLabelSuccess.getHeight(), Image.SCALE_DEFAULT));
        correcto.jLabelSuccess.setIcon(success);
    }
    
    public void iniciarAlerta() {
        correcto.pack();
        correcto.setLocationRelativeTo(null);
        correcto.setVisible(true);
        correcto.setLocationRelativeTo(null);
        correcto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                
        
        RSAnimation.setBajar(-230, 200, 2, 2, correcto);
        //correcto.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(correcto.btnAceptar == e.getSource()){
            try {
            //Nuestra ventana una vez que se abre se encuentra en la posición 200
            //por lo que ahora la posición inicial es 200 y la final la -230
            //los siguientes paramétros los dejamos en 2
            RSAnimation.setSubir(200, -230, 2, 2, correcto);
            //Ahora le daremos un tiempo para que la ventana se cierre
            //utilizamos un Thread, le damos 1 segundo
            Thread.sleep(1000);
            //y posteriormente cerramos la ventana
            correcto.dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(vCorrecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }
    
}
