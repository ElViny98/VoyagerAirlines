/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Sesion;
import Modelo.mAdmin;
import Vista.vAdmin;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class cAdmin implements ActionListener, MouseListener {
    private mAdmin modeloAdmin;
    private vAdmin vistaAdmin;
    private Sesion s;
    
    public cAdmin(mAdmin modeloAdmin, vAdmin vistaAdmin) 
    {
        this.modeloAdmin = modeloAdmin;
        this.vistaAdmin = vistaAdmin;
    }
    
    public cAdmin(mAdmin modeloAdmin, vAdmin vistaAdmin, Sesion s) {
        this.modeloAdmin = modeloAdmin;
        this.vistaAdmin = vistaAdmin;
        this.s = s;
        
        this.vistaAdmin.btnInicio.addActionListener(this);
        this.vistaAdmin.btnAviones.addActionListener(this);
        this.vistaAdmin.btnUsuarios.addActionListener(this);
        this.vistaAdmin.btnVentas.addActionListener(this);
        this.vistaAdmin.btnVuelos.addActionListener(this);
        this.vistaAdmin.btnCerrar.addActionListener(this);
        //this.vistaAdmin.jButtonRefresh.addActionListener(this);
        //this.vistaAdmin.tablaVuelos.addMouseListener(this);
        //this.vistaAdmin.tblAviones.addMouseListener(this);
    }
    
    public void iniciarVistaAdmin() {
        //Font font = new Font("Montserrat", 0, 13);
        vistaAdmin.setTitle("Panel de administración");
        vistaAdmin.pack();
        vistaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setVisible(true);

        
        ImageIcon avion_logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon logotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelBigLogo.getWidth(), vistaAdmin.jLabelBigLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon SmallLogotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelSmallLogo.getWidth(), vistaAdmin.jLabelSmallLogo.getHeight(), Image.SCALE_DEFAULT));
        
        vistaAdmin.jLabelBigLogo.setIcon(logotipo);
        vistaAdmin.jLabelSmallLogo.setIcon(SmallLogotipo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //=====================================================================================//
        if(vistaAdmin.btnInicio == e.getSource()){
            int posicionInicio = vistaAdmin.Inicio.getX();
            int posicionAviones = vistaAdmin.Aviones.getX();
            int posicionUsuarios = vistaAdmin.Usuarios.getX();
            int posicionVenta = vistaAdmin.Ventas.getX();
            int posicionVuelo = vistaAdmin.Vuelos.getX();

            //Mover a la derecha, no visible
            if(posicionAviones < 300)
                vistaAdmin.Aviones.setBounds(1010, 10, 735, 570);
            else if(posicionUsuarios < 300)
                vistaAdmin.Usuarios.setBounds(1010, 10, 735, 570);
            else if(posicionVenta < 300)
                vistaAdmin.Ventas.setBounds(1010, 10, 735, 570);
            else if(posicionVuelo < 300)
                vistaAdmin.Vuelos.setBounds(1010, 10, 735, 570);

            if(posicionInicio > 200)
                vistaAdmin.Inicio.setBounds(245, 10, 735, 570); //Mover a la izquierda, visible
        }
        //=====================================================================================//
        else if(vistaAdmin.btnAviones == e.getSource()){
            int posicionInicio = vistaAdmin.Inicio.getX();
            int posicionAviones = vistaAdmin.Aviones.getX();
            int posicionUsuarios = vistaAdmin.Usuarios.getX();
            int posicionVenta = vistaAdmin.Ventas.getX();
            int posicionVuelo = vistaAdmin.Vuelos.getX();

            //Mover a la derecha, no visible
            if(posicionInicio < 300)
                vistaAdmin.Inicio.setBounds(1010, 10, 735, 570);
            else if(posicionUsuarios < 300)
                vistaAdmin.Usuarios.setBounds(1010, 10, 735, 570);
            else if(posicionVenta < 300)
                vistaAdmin.Ventas.setBounds(1010, 10, 735, 570);
            else if(posicionVuelo < 300)
                vistaAdmin.Vuelos.setBounds(1010, 10, 735, 570);

            if(posicionAviones > 200)
                vistaAdmin.Aviones.setBounds(245, 10, 735, 570); //Mover a la izquierda, visible
        }
        //=====================================================================================//
        else if(vistaAdmin.btnUsuarios == e.getSource()){
            int posicionInicio = vistaAdmin.Inicio.getX();
            int posicionAviones = vistaAdmin.Aviones.getX();
            int posicionUsuarios = vistaAdmin.Usuarios.getX();
            int posicionVenta = vistaAdmin.Ventas.getX();
            int posicionVuelo = vistaAdmin.Vuelos.getX();

            //Mover a la derecha, no visible
            if(posicionInicio < 300)
                vistaAdmin.Inicio.setBounds(1010, 10, 735, 570);
            else if(posicionAviones < 300)
                vistaAdmin.Aviones.setBounds(1010, 10, 735, 570);
            else if(posicionVenta < 300)
                vistaAdmin.Ventas.setBounds(1010, 10, 735, 570);
            else if(posicionVuelo < 300)
                vistaAdmin.Vuelos.setBounds(1010, 10, 735, 570);

            if(posicionUsuarios > 200)
                vistaAdmin.Usuarios.setBounds(245, 10, 735, 570); //Mover a la izquierda, visible
        }
        //=====================================================================================//
        else if(vistaAdmin.btnVentas == e.getSource()){
            int posicionInicio = vistaAdmin.Inicio.getX();
            int posicionAviones = vistaAdmin.Aviones.getX();
            int posicionUsuarios = vistaAdmin.Usuarios.getX();
            int posicionVenta = vistaAdmin.Ventas.getX();
            int posicionVuelo = vistaAdmin.Vuelos.getX();

            //Mover a la derecha, no visible
            if(posicionInicio < 300)
                vistaAdmin.Inicio.setBounds(1010, 10, 735, 570);
            else if(posicionAviones < 300)
                vistaAdmin.Aviones.setBounds(1010, 10, 735, 570);
            else if(posicionUsuarios < 300)
                vistaAdmin.Usuarios.setBounds(1010, 10, 735, 570);
            else if(posicionVuelo < 300)
                vistaAdmin.Vuelos.setBounds(1010, 10, 735, 570);

            if(posicionVenta > 200)
                vistaAdmin.Ventas.setBounds(245, 10, 735, 570); //Mover a la izquierda, visible
        }
        //=====================================================================================//
        else if(vistaAdmin.btnVuelos == e.getSource()){
            int posicionInicio = vistaAdmin.Inicio.getX();
            int posicionAviones = vistaAdmin.Aviones.getX();
            int posicionUsuarios = vistaAdmin.Usuarios.getX();
            int posicionVenta = vistaAdmin.Ventas.getX();
            int posicionVuelo = vistaAdmin.Vuelos.getX();

            //Mover a la derecha, no visible
            if(posicionInicio < 300)
                vistaAdmin.Inicio.setBounds(1010, 10, 735, 570);
            else if(posicionAviones < 300)
                vistaAdmin.Aviones.setBounds(1010, 10, 735, 570);
            else if(posicionUsuarios < 300)
                vistaAdmin.Usuarios.setBounds(1010, 10, 735, 570);
            else if(posicionVenta < 300)
                vistaAdmin.Ventas.setBounds(1010, 10, 735, 570);

            if(posicionVuelo > 200)
                vistaAdmin.Vuelos.setBounds(245, 10, 735, 570); //Mover a la izquierda, visible
        }
        //=====================================================================================//
        else if(vistaAdmin.btnSalir == e.getSource()){
            System.exit(0);
        }
        //=====================================================================================//
        else if(vistaAdmin.btnMinimizar == e.getSource()){
            vistaAdmin.setExtendedState(1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*if(e.getSource() == vistaAdmin.tablaVuelos) {
            int fila = vistaAdmin.tablaVuelos.rowAtPoint(e.getPoint());
        }
        
        if(e.getSource() == vistaAdmin.tblAviones) {
            int fila = vistaAdmin.tblAviones.rowAtPoint(e.getPoint());
        }*/
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
