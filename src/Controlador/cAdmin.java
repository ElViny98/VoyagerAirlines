/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Sesion;
import Modelo.mAdmin;
import Modelo.mLogin;
import Vista.vAdmin;
import java.awt.Color;
import Vista.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.awt.Image;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class cAdmin implements ActionListener, MouseListener {
    private mAdmin modeloAdmin;
    private final vAdmin vistaAdmin;
    private Sesion s;
    private int idAvion;
    
    //========================================//
    //============Para las alertas============//
    private vAlerta alerta = new vAlerta();
    //========================================//
    
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
        this.vistaAdmin.btnCerrar.addActionListener(this);
        
        //====================================================//
        //===================Sección vuelos===================//
        this.vistaAdmin.btnAgregarVuelo.addActionListener(this);
        this.vistaAdmin.btnEditarVuelo.addActionListener(this);
        this.vistaAdmin.btnEliminarVuelo.addActionListener(this);
        this.vistaAdmin.btnRefresh.addActionListener(this);
        //=====================================================//
        //===================Sección aviones===================//
        this.vistaAdmin.tblAviones.addMouseListener(this);
        this.vistaAdmin.btnAvionDetalles.addActionListener(this);
        //=====================================================//
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
        
        //====================================================//
        //===================Sección vuelos===================//
        this.vistaAdmin.btnAgregarVuelo.addActionListener(this);
        this.vistaAdmin.btnEditarVuelo.addActionListener(this);
        this.vistaAdmin.btnEliminarVuelo.addActionListener(this);
        this.vistaAdmin.btnRefresh.addActionListener(this);
        //=====================================================//
        //===================Sección aviones===================//
        this.vistaAdmin.tblAviones.addMouseListener(this);
        this.vistaAdmin.btnAvionDetalles.addActionListener(this);
        //=====================================================//
    }
    
    public void iniciarVistaAdmin() {
        Font font = new Font("Montserrat", 0, 13);
        vistaAdmin.setTitle("Panel de administración");
        //vistaAdmin.pack();
        vistaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setVisible(true);

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
        
        vistaAdmin.pnlAsientos.setVisible(false);
        vistaAdmin.Aviones.setVisible(false);
        vistaAdmin.Usuarios.setVisible(false);
        vistaAdmin.Ventas.setVisible(false);
        vistaAdmin.Vuelos.setVisible(false);
        vistaAdmin.Inicio.setVisible(true);
        vistaAdmin.lblNombre.setText(this.s.getNombre());
        
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
            limpiarArreglos();
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
            limpiarArreglos();
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
            limpiarArreglos();
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
            limpiarArreglos();
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
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(true);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            
            vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsulta());
        }
        //=====================================================================================//
        else if(vistaAdmin.btnAgregarVuelo == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            mostrarAlerta.agregarContenido(1);
            mostrarAlerta.iniciarAlerta();
            
        }
        //=====================================================================================//
        else if(vistaAdmin.btnEditarVuelo == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            mostrarAlerta.agregarContenido(2);
            mostrarAlerta.iniciarAlerta();
            
        }
        //=====================================================================================//
        else if(vistaAdmin.btnEliminarVuelo == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            mostrarAlerta.agregarContenido(3);
            mostrarAlerta.iniciarAlerta();
            
        }
        //=====================================================================================//
        else if(vistaAdmin.btnRefresh == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            mostrarAlerta.agregarContenido(1);
            mostrarAlerta.iniciarAlerta();
            
        }
        //=====================================================================================//
        if(vistaAdmin.btnSalirPrograma == e.getSource()){
            System.exit(0);
            
        }
        //=====================================================================================//
        else if(vistaAdmin.btnAvionDetalles == e.getSource()){
            limpiarArreglos();
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.lblAsientos.setLayout(null);
            vistaAdmin.lblAsientos.setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
            Stack<String> ocupados = modeloAdmin.consultarAsientos(idAvion);
            //System.out.println(ocupados.pop());
            String[] oc = new String[ocupados.size()];
            int oc1 = 0;
            while(!ocupados.empty()) {
                oc[oc1] = ocupados.pop();
                oc1++;
            }
            
            JButton Asientos[] = new JButton[238];
            JLabel lblNombres[] = new JLabel[238];
            Font f = new Font("Montserrat", 0, 8);
            char fila = 65;
            int asiento = 1, x = 48, y = 350;
            int ac = 1;
            int ac2 = 0;
            int ac3 = 0;
            for(int i=1; i<238; i++) {
                String numAsiento = String.valueOf(fila) + String.valueOf(asiento); //Número de asiento
                if(i%7 != 0 || i == 0 || i<6) {
                    if(ac == 3) {
                        x+=30;
                        ac = 1;
                    }
                    lblNombres[i-1] = new JLabel(numAsiento);
                    Asientos[i-1] = new JButton();
                    Asientos[i-1].setBounds(x, y, 20, 20);
                    lblNombres[i-1].setBounds(x+5, y+20, 19, 19);
                    Asientos[i-1].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ActionEvent) {
                            getLblAsientoCliente().setText("Asiento: " + numAsiento);
                            getLblNombreCliente().setText(getMAdmin().getNombreCliente(numAsiento, idAvion));
                            System.out.println("Clic en " + numAsiento);
                        }
                    });
                    lblNombres[i-1].setFont(f);
                    for(int t=0; t<oc.length; t++) {
                        if(oc[t].equals(numAsiento)) {
                            Asientos[i-1].setBackground(new java.awt.Color(255, 0, 0));
                        }
                    }
                    vistaAdmin.lblAsientos.add(Asientos[i-1]);
                    vistaAdmin.lblAsientos.add(lblNombres[i-1]);
                    
                    asiento++;
                    x+=25;
                    ac++;
                    
                }
                else {
                    ac2++;
                    if(ac2 == 2) {
                        asiento = 1;
                        fila++;
                        ac2=0;
                    }
                    x=48;
                    y+=40;
                    ac = 1;
                    if(String.valueOf(fila).equals("E") && ac3 == 0) {
                        y+=120;
                        ac3++;
                    }
                    if(String.valueOf(fila).equals("N") && ac3 == 1) {
                        y+=120;
                        ac3++;
                    }
                    
                    if(String.valueOf(fila).equals("R") && ac3 == 2) {
                        System.out.println("Vueltas "+ i);
                        break;
                    }
                }
            }
            vistaAdmin.pnlAsientos.setVisible(true);
        }
        
        if(e.getSource() == vistaAdmin.btnCerrar) {
            vLogin vL = new vLogin();
            mLogin mL = new mLogin();
            this.s.destruirSesion();
            this.vistaAdmin.dispose();
            cLogin cL = new cLogin(mL, vL);
            cL.iniciarVista();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vistaAdmin.tblAviones) {
            int fila = vistaAdmin.tblAviones.rowAtPoint(e.getPoint());
            if(fila > -1) {
                //Muchos casteos :'v
                vistaAdmin.btnAvionDetalles.setEnabled(true);
                this.idAvion = Integer.parseInt(String.valueOf(vistaAdmin.tblAviones.getValueAt(fila, 0)));
                System.out.println("Clic en la tabla");
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
    
   
    private void limpiarArreglos() {
        vistaAdmin.lblAsientos.removeAll();
        vistaAdmin.lblAsientoCliente.setText("Asiento: ");
        vistaAdmin.lblNombreCliente.setText("");
    }
    
    private JLabel getLblAsientoCliente() {
        return this.vistaAdmin.lblAsientoCliente;
    }
    
    private JLabel getLblNombreCliente() {
        return this.vistaAdmin.lblNombreCliente;
    }
    
    private mAdmin getMAdmin() {
        return this.modeloAdmin;
    }
}
