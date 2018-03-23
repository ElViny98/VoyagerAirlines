/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
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
    
    public cAdmin(mAdmin modeloAdmin, vAdmin vistaAdmin) {
        this.modeloAdmin = modeloAdmin;
        this.vistaAdmin = vistaAdmin;
        
        this.vistaAdmin.jButtonAgregarVuelo.addActionListener(this);
        this.vistaAdmin.jButtonEliminarVuelo.addActionListener(this);
        this.vistaAdmin.jButtonModificarVuelo.addActionListener(this);
        this.vistaAdmin.jButtonRefresh.addActionListener(this);
        this.vistaAdmin.tablaVuelos.addMouseListener(this);
        this.vistaAdmin.tblAviones.addMouseListener(this);
    }
    
    public void iniciarVistaAdmin() {
        Font font = new Font("Montserrat", 0, 13);
        vistaAdmin.setTitle("Panel de administración");
        vistaAdmin.pack();
        vistaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaAdmin.setLocationRelativeTo(null);
        
        
        ImageIcon avion_logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon usuario = new ImageIcon(getClass().getResource(("/img/usuario.png")));
        
        ImageIcon logotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelLogo.getWidth(), vistaAdmin.jLabelLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon user = new ImageIcon(usuario.getImage().getScaledInstance(vistaAdmin.jLabelUsuarioImagen.getWidth(), vistaAdmin.jLabelUsuarioImagen.getHeight(), Image.SCALE_DEFAULT));
        
        vistaAdmin.jLabelLogo.setIcon(logotipo);
        vistaAdmin.jLabelUsuarioImagen.setIcon(user);
        
        Animacion.Animacion.mover_izquierda(1010, 190, 1, 2, vistaAdmin.jPanelInicio);
        int posicionInicio = vistaAdmin.jPanelInicio.getX();
        System.out.println("Inicio: "+posicionInicio);
        vistaAdmin.jLabelSeccion.setText("Inicio");
        
        //Íconos a botones//
        ImageIcon agregar = new ImageIcon(getClass().getResource(("/icons/add.png")));
        ImageIcon editar = new ImageIcon(getClass().getResource(("/icons/edit.png")));
        ImageIcon refrescar = new ImageIcon(getClass().getResource(("/icons/refresh.png")));
        ImageIcon eliminar = new ImageIcon(getClass().getResource(("/icons/delete.png")));
        System.out.println("Ancho: " + vistaAdmin.jButtonAgregarVuelo.getWidth()/4 + "\nAlto: " + vistaAdmin.jButtonAgregarVuelo.getHeight()/4);
        
        ImageIcon add = new ImageIcon(agregar.getImage().getScaledInstance(vistaAdmin.jButtonAgregarVuelo.getWidth()/4, vistaAdmin.jButtonAgregarVuelo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon edit = new ImageIcon(editar.getImage().getScaledInstance(vistaAdmin.jButtonModificarVuelo.getWidth()/4, vistaAdmin.jButtonModificarVuelo.getHeight() - 8, Image.SCALE_DEFAULT));
        ImageIcon refresh = new ImageIcon(refrescar.getImage().getScaledInstance(vistaAdmin.jButtonRefresh.getWidth(), vistaAdmin.jButtonRefresh.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon delete = new ImageIcon(eliminar.getImage().getScaledInstance(vistaAdmin.jButtonEliminarVuelo.getWidth()/4, (vistaAdmin.jButtonEliminarVuelo.getHeight()/2), Image.SCALE_DEFAULT));
        
        vistaAdmin.jButtonAgregarVuelo.setIcon(add);
        vistaAdmin.jButtonModificarVuelo.setIcon(edit);
        vistaAdmin.jButtonEliminarVuelo.setIcon(delete);
        vistaAdmin.jButtonRefresh.setIcon(refresh);
        
        
        vistaAdmin.tablaVuelos.setModel(modeloAdmin.vuelosConsulta());
        vistaAdmin.tblAviones.setModel(modeloAdmin.tablaAviones());
        vistaAdmin.tablaVuelos.setFont(font);
        vistaAdmin.tblAviones.setFont(font);
        vistaAdmin.setVisible(true);
        vistaAdmin.setResizable(false);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vistaAdmin.tablaVuelos) {
            int fila = vistaAdmin.tablaVuelos.rowAtPoint(e.getPoint());
        }
        
        if(e.getSource() == vistaAdmin.tblAviones) {
            int fila = vistaAdmin.tblAviones.rowAtPoint(e.getPoint());
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
