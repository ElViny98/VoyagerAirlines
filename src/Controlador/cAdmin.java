/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Sesion;
import Modelo.mAdmin;
import Vista.vAdmin;
import Vista.vCorrecto;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class cAdmin implements ActionListener, MouseListener {
    private mAdmin modeloAdmin;
    private vCorrecto correcto = new vCorrecto();//Alerta correcto
    private vAdmin vistaAdmin;
    private Sesion s;
    private int idAvion;
    
    //Con inicio de sesión
    public cAdmin(mAdmin modeloAdmin, vAdmin vistaAdmin, Sesion s) {
        this.modeloAdmin = modeloAdmin;
        this.vistaAdmin = vistaAdmin;
        this.s = s;
        
        this.vistaAdmin.btnInicio.addActionListener(this);
        this.vistaAdmin.btnAviones.addActionListener(this);
        this.vistaAdmin.btnUsuarios.addActionListener(this);
        this.vistaAdmin.btnVentas.addActionListener(this);
        this.vistaAdmin.btnVuelos.addActionListener(this);
        this.vistaAdmin.btnSalirPrograma.addActionListener(this);
        this.vistaAdmin.btnMinimizar.addActionListener(this);
        
        this.vistaAdmin.btnAgregarVuelo.addActionListener(this);
        
        this.vistaAdmin.setVisible(true);
        this.vistaAdmin.setLocationRelativeTo(null);
    }
    //Sin inicio de sesión
    public cAdmin(mAdmin modeloAdmin, vAdmin vistaAdmin) {
        this.modeloAdmin = modeloAdmin;
        this.vistaAdmin = vistaAdmin;
        
        this.vistaAdmin.btnInicio.addActionListener(this);
        this.vistaAdmin.btnAviones.addActionListener(this);
        this.vistaAdmin.btnUsuarios.addActionListener(this);
        this.vistaAdmin.btnVentas.addActionListener(this);
        this.vistaAdmin.btnVuelos.addActionListener(this);
        this.vistaAdmin.btnSalirPrograma.addActionListener(this);
        this.vistaAdmin.btnMinimizar.addActionListener(this);
        this.vistaAdmin.btnAvionDetalles.addActionListener(this);
        this.vistaAdmin.tblAviones.addMouseListener(this);
        
        this.vistaAdmin.btnAgregarVuelo.addActionListener(this);
        this.vistaAdmin.setVisible(true);
        this.vistaAdmin.setLocationRelativeTo(null);
    }
    
    public void iniciarVistaAdmin() {
        Font font = new Font("Montserrat", 0, 13);
        vistaAdmin.setTitle("Panel de administración");
        //vistaAdmin.pack();
        vistaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //vistaAdmin.setLocationRelativeTo(null);
        //vistaAdmin.setVisible(true);

        ImageIcon avion_logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon refrescar = new ImageIcon(getClass().getResource(("/icons/refresh.png")));
        ImageIcon find = new ImageIcon(getClass().getResource(("/icons/find.png")));
        ImageIcon airplane = new ImageIcon(getClass().getResource(("/icons/airplane.png")));
        
        ImageIcon logotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelBigLogo.getWidth(), vistaAdmin.jLabelBigLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon SmallLogotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelSmallLogo.getWidth(), vistaAdmin.jLabelSmallLogo.getHeight(), Image.SCALE_DEFAULT));
        
        ImageIcon avionSeccion = new ImageIcon(airplane.getImage().getScaledInstance(vistaAdmin.jLabelImgSeccion.getWidth(), vistaAdmin.jLabelImgSeccion.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon buscar = new ImageIcon(find.getImage().getScaledInstance(vistaAdmin.jLabelImgBuscar.getWidth(), vistaAdmin.jLabelImgBuscar.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon refresh = new ImageIcon(refrescar.getImage().getScaledInstance(vistaAdmin.btnRefresh.getWidth(), vistaAdmin.btnRefresh.getHeight(), Image.SCALE_DEFAULT));
        
        vistaAdmin.tblAviones.setModel(modeloAdmin.tablaAviones());
        vistaAdmin.jLabelBigLogo.setIcon(logotipo);
        vistaAdmin.jLabelSmallLogo.setIcon(SmallLogotipo);
        vistaAdmin.jLabelImgBuscar.setIcon(buscar);
        vistaAdmin.btnRefresh.setIcon(refresh);
        vistaAdmin.jLabelImgSeccion.setIcon(avionSeccion);
        
        //========================================//
        //============Para las alertas============//
        //========================================//
        
        
        
        
        vistaAdmin.pnlAsientos.setVisible(false);
        vistaAdmin.Aviones.setVisible(false);
        vistaAdmin.Usuarios.setVisible(false);
        vistaAdmin.Ventas.setVisible(false);
        vistaAdmin.Vuelos.setVisible(false);
        vistaAdmin.Inicio.setVisible(true);
        
        vistaAdmin.btnAvionDetalles.setEnabled(false);
        
        vistaAdmin.setResizable(false);
        vistaAdmin.setIconImage(new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage());
        vistaAdmin.tblAviones.setModel(modeloAdmin.tablaAviones());
        vistaAdmin.jLabelBigLogo.setIcon(logotipo);
        vistaAdmin.jLabelSmallLogo.setIcon(SmallLogotipo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //=====================================================================================//
        if(vistaAdmin.btnInicio == e.getSource()){
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(true);
            vistaAdmin.pnlAsientos.setVisible(false);
        }
        //=====================================================================================//
        else if(vistaAdmin.btnAviones == e.getSource()){
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(true);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
        }
        //=====================================================================================//
        else if(vistaAdmin.btnUsuarios == e.getSource()){
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(true);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
        }
        //=====================================================================================//
        else if(vistaAdmin.btnVentas == e.getSource()){
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(true);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
        }
        //=====================================================================================//
        else if(vistaAdmin.btnVuelos == e.getSource()){
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(true);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            
            vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsulta());
        }
        if(vistaAdmin.btnAgregarVuelo == e.getSource()){
            System.out.println("Presionando");
            cAlertas alerta = new cAlertas(correcto);
            alerta.iniciarAlerta();
            
        }
        //=====================================================================================//
        if(vistaAdmin.btnSalirPrograma == e.getSource()){
            System.exit(0);
            
        }
        //=====================================================================================//
        else if(vistaAdmin.btnAvionDetalles == e.getSource()){
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.lblAsientos.setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
            vistaAdmin.pnlAsientos.setVisible(true);
            vistaAdmin.pnlImg.add(new JButton("Aceptar"), -1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vistaAdmin.tblAviones) {
            int fila = vistaAdmin.tblAviones.rowAtPoint(e.getPoint());
            if(fila > -1) {
                //Muchos casteos :'v
                vistaAdmin.btnAvionDetalles.setEnabled(true);
                this.idAvion = Integer.parseInt(String.valueOf(vistaAdmin.tblAviones.getValueAt(fila, 0)));
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
