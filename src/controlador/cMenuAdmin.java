package controlador;

import java.awt.Cursor;
import static java.awt.Frame.DEFAULT_CURSOR;
import static java.awt.Frame.HAND_CURSOR;
import vista.*;
import modelo.*;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class cMenuAdmin implements ActionListener, MouseListener{
    //=====Para la interfaz de menú de administrador=====//
    vMenuAdmin vMenuAdmin = new vMenuAdmin();
    Sesion sesion = new Sesion();

    public cMenuAdmin(vMenuAdmin vMenuAdmin) {
        this.vMenuAdmin = vMenuAdmin;
        
        this.vMenuAdmin.btnSalir.addActionListener(this);
        this.vMenuAdmin.btnMinimizar.addActionListener(this);
        
        this.vMenuAdmin.pnlAvion.addMouseListener(this);
        this.vMenuAdmin.pnlAyuda.addMouseListener(this);
        this.vMenuAdmin.pnlConfig.addMouseListener(this);
        this.vMenuAdmin.pnlSalir.addMouseListener(this);
        this.vMenuAdmin.pnlTripulacion.addMouseListener(this);
        this.vMenuAdmin.pnlUsuario.addMouseListener(this);
        this.vMenuAdmin.pnlVenta.addMouseListener(this);
        this.vMenuAdmin.pnlVuelo.addMouseListener(this);
    }
    
    public void iniciarVista(){
        ImageIcon iconLogo = new ImageIcon(getClass().getResource(("/icons/avion-3.png")));
        ImageIcon logo = new ImageIcon(iconLogo.getImage().getScaledInstance(vMenuAdmin.lblLogoIcon.getWidth(), vMenuAdmin.lblLogoIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblLogoIcon.setIcon(logo);
        
        ImageIcon iconAvion = new ImageIcon(getClass().getResource(("/icons/avion.png")));
        ImageIcon avion = new ImageIcon(iconAvion.getImage().getScaledInstance(vMenuAdmin.lblAvionIcon.getWidth(), vMenuAdmin.lblAvionIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblAvionIcon.setIcon(avion);
        
        ImageIcon iconUsuario = new ImageIcon(getClass().getResource(("/icons/usuarios.png")));
        ImageIcon usuario = new ImageIcon(iconUsuario.getImage().getScaledInstance(vMenuAdmin.lblUsuarioIcon.getWidth(), vMenuAdmin.lblUsuarioIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblUsuarioIcon.setIcon(usuario);
        
        ImageIcon iconVentas = new ImageIcon(getClass().getResource(("/icons/ventas.png")));
        ImageIcon ventas = new ImageIcon(iconVentas.getImage().getScaledInstance(vMenuAdmin.lblVentaIcon.getWidth(), vMenuAdmin.lblVentaIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblVentaIcon.setIcon(ventas);
        
        ImageIcon iconVuelos = new ImageIcon(getClass().getResource(("/icons/vuelos.png")));
        ImageIcon vuelos = new ImageIcon(iconVuelos.getImage().getScaledInstance(vMenuAdmin.lblVueloIcon.getWidth(), vMenuAdmin.lblVueloIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblVueloIcon.setIcon(vuelos);
        
        ImageIcon iconTripulacion = new ImageIcon(getClass().getResource(("/icons/tripulacion.png")));
        ImageIcon tripulacion = new ImageIcon(iconTripulacion.getImage().getScaledInstance(vMenuAdmin.lblTripulacionIcon.getWidth(), vMenuAdmin.lblTripulacionIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblTripulacionIcon.setIcon(tripulacion);
        
        ImageIcon iconConfig = new ImageIcon(getClass().getResource(("/icons/configuracion.png")));
        ImageIcon config = new ImageIcon(iconConfig.getImage().getScaledInstance(vMenuAdmin.lblConfigIcon.getWidth(), vMenuAdmin.lblConfigIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblConfigIcon.setIcon(config);
        
        ImageIcon iconCerrar = new ImageIcon(getClass().getResource(("/icons/cerrar-sesion.png")));
        ImageIcon cerrarSesion = new ImageIcon(iconCerrar.getImage().getScaledInstance(vMenuAdmin.lblSalirIcon.getWidth(), vMenuAdmin.lblSalirIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblSalirIcon.setIcon(cerrarSesion);
        
        ImageIcon iconAyuda = new ImageIcon(getClass().getResource(("/icons/help.png")));
        ImageIcon ayuda = new ImageIcon(iconAyuda.getImage().getScaledInstance(vMenuAdmin.lblAyudaIcon.getWidth(), vMenuAdmin.lblAyudaIcon.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.lblAyudaIcon.setIcon(ayuda);
        
        ImageIcon iconSalir = new ImageIcon(getClass().getResource(("/icons/exit-2.png")));
        ImageIcon salir = new ImageIcon(iconSalir.getImage().getScaledInstance(vMenuAdmin.btnSalir.getWidth(), vMenuAdmin.btnSalir.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.btnSalir.setIcon(salir);
        
        ImageIcon iconMinimizar = new ImageIcon(getClass().getResource(("/icons/minimizar-2.png")));
        ImageIcon minimizar = new ImageIcon(iconMinimizar.getImage().getScaledInstance(vMenuAdmin.btnMinimizar.getWidth(), vMenuAdmin.btnMinimizar.getHeight(), Image.SCALE_DEFAULT));
        vMenuAdmin.btnMinimizar.setIcon(minimizar);
        
        this.vMenuAdmin.setIconImage(new ImageIcon(getClass().getResource("/icons/avion-3.png")).getImage());
        this.vMenuAdmin.setTitle("Administrador");
        this.vMenuAdmin.setVisible(true);
        this.vMenuAdmin.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vMenuAdmin.btnSalir == e.getSource())
            System.exit(0);
        else if(this.vMenuAdmin.btnMinimizar == e.getSource())
            this.vMenuAdmin.setExtendedState(1);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.vMenuAdmin.pnlAvion == e.getSource())
        {
            vAdmin vAdmin = new vAdmin();
            mAdmin mAdmin = new mAdmin();
            cAdmin cAdmin = new cAdmin(vAdmin, mAdmin, sesion, 1);
            this.vMenuAdmin.dispose();
            cAdmin.iniciarVista();
        }
        
        else if(this.vMenuAdmin.pnlUsuario == e.getSource())
        {
            vAdmin vAdmin = new vAdmin();
            mAdmin mAdmin = new mAdmin();
            cAdmin cAdmin = new cAdmin(vAdmin, mAdmin, sesion, 2);
            this.vMenuAdmin.dispose();
            cAdmin.iniciarVista();
        }
        
        else if(this.vMenuAdmin.pnlVenta == e.getSource())
        {
            vAdmin vAdmin = new vAdmin();
            mAdmin mAdmin = new mAdmin();
            cAdmin cAdmin = new cAdmin(vAdmin, mAdmin, sesion, 3);
            this.vMenuAdmin.dispose();
            cAdmin.iniciarVista();
        }
        
        else if(this.vMenuAdmin.pnlVuelo == e.getSource())
        {
            vAdmin vAdmin = new vAdmin();
            mAdmin mAdmin = new mAdmin();
            cAdmin cAdmin = new cAdmin(vAdmin, mAdmin, sesion, 4);
            this.vMenuAdmin.dispose();
            cAdmin.iniciarVista();
        }
        
        else if(this.vMenuAdmin.pnlTripulacion == e.getSource())
        {
            vAdmin vAdmin = new vAdmin();
            mAdmin mAdmin = new mAdmin();
            cAdmin cAdmin = new cAdmin(vAdmin, mAdmin, sesion, 5);
            this.vMenuAdmin.dispose();
            cAdmin.iniciarVista();
        }
        
        else if(this.vMenuAdmin.pnlConfig == e.getSource())
        {
        }
        
        else if(this.vMenuAdmin.pnlSalir == e.getSource())
        {
        }
        
        else if(this.vMenuAdmin.pnlAyuda == e.getSource())
        {
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(this.vMenuAdmin.pnlAvion == e.getSource())
        {
            this.vMenuAdmin.pnlAvion.setBackground(new java.awt.Color(205,205,205));
        }
        
        else if(this.vMenuAdmin.pnlUsuario == e.getSource())
        {
            this.vMenuAdmin.pnlUsuario.setBackground(new java.awt.Color(205,205,205));
        }
        
        else if(this.vMenuAdmin.pnlVenta == e.getSource())
        {
            this.vMenuAdmin.pnlVenta.setBackground(new java.awt.Color(205,205,205));
        }
        
        else if(this.vMenuAdmin.pnlVuelo == e.getSource())
        {
            this.vMenuAdmin.pnlVuelo.setBackground(new java.awt.Color(205,205,205));
        }
        
        else if(this.vMenuAdmin.pnlTripulacion == e.getSource())
        {
            this.vMenuAdmin.pnlTripulacion.setBackground(new java.awt.Color(205,205,205));
        }
        
        else if(this.vMenuAdmin.pnlConfig == e.getSource())
        {
            this.vMenuAdmin.pnlConfig.setBackground(new java.awt.Color(205,205,205));
        }
        
        else if(this.vMenuAdmin.pnlSalir == e.getSource())
        {
            this.vMenuAdmin.pnlSalir.setBackground(new java.awt.Color(205,205,205));
        }
        
        else if(this.vMenuAdmin.pnlAyuda == e.getSource())
        {
            this.vMenuAdmin.pnlAyuda.setBackground(new java.awt.Color(205,205,205));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(this.vMenuAdmin.pnlAvion == e.getSource())
        {
            this.vMenuAdmin.pnlAvion.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlUsuario == e.getSource())
        {
            this.vMenuAdmin.pnlUsuario.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlVenta == e.getSource())
        {
            this.vMenuAdmin.pnlVenta.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlVuelo == e.getSource())
        {
            this.vMenuAdmin.pnlVuelo.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlTripulacion == e.getSource())
        {
            this.vMenuAdmin.pnlTripulacion.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlConfig == e.getSource())
        {
            this.vMenuAdmin.pnlConfig.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlSalir == e.getSource())
        {
            this.vMenuAdmin.pnlSalir.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlAyuda == e.getSource())
        {
            this.vMenuAdmin.pnlAyuda.setBackground(new java.awt.Color(223,223,223));
            this.vMenuAdmin.setCursor(new Cursor(HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(this.vMenuAdmin.pnlAvion == e.getSource())
        {
            this.vMenuAdmin.pnlAvion.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlUsuario == e.getSource())
        {
            this.vMenuAdmin.pnlUsuario.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlVenta == e.getSource())
        {
            this.vMenuAdmin.pnlVenta.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlVuelo == e.getSource())
        {
            this.vMenuAdmin.pnlVuelo.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlTripulacion == e.getSource())
        {
            this.vMenuAdmin.pnlTripulacion.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlConfig == e.getSource())
        {
            this.vMenuAdmin.pnlConfig.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlSalir == e.getSource())
        {
            this.vMenuAdmin.pnlSalir.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
        
        else if(this.vMenuAdmin.pnlAyuda == e.getSource())
        {
            this.vMenuAdmin.pnlAyuda.setBackground(new java.awt.Color(235,238,241));
            this.vMenuAdmin.setCursor(new Cursor(DEFAULT_CURSOR));
        }
    }
}
