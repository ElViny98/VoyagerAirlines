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
    //==========================Variables a utilizar==========================//
    private int idAvion;
    private int idVuelo = 0;
    //========================Para el inicio de sesión========================//
    private Sesion s;
    //====================Para la pantalla de administrador===================//
    private mAdmin modeloAdmin;
    private final vAdmin vistaAdmin;
    //============================Para las alertas============================//
    private vAlerta alerta = new vAlerta();
    //==============Constructor para la ventana de administrador==============//
    public cAdmin(mAdmin modeloAdmin, vAdmin vistaAdmin, Sesion s) {
        this.modeloAdmin = modeloAdmin;
        this.vistaAdmin = vistaAdmin;
        this.s = s;
        //======Componentes generales de la pantalla de administrador=====//
        this.vistaAdmin.btnInicio.addActionListener(this);
        this.vistaAdmin.btnAviones.addActionListener(this);
        this.vistaAdmin.btnUsuarios.addActionListener(this);
        this.vistaAdmin.btnVentas.addActionListener(this);
        this.vistaAdmin.btnVuelos.addActionListener(this);
        this.vistaAdmin.btnTripulacion.addActionListener(this);
        this.vistaAdmin.btnSalirPrograma.addActionListener(this);
        this.vistaAdmin.btnMinimizar.addActionListener(this);
        this.vistaAdmin.btnCerrar.addActionListener(this);
        //=====Componentes de la sección de vuelos=====//
        this.vistaAdmin.btnAgregarVuelo.addActionListener(this);
        this.vistaAdmin.btnEditarVuelo.addActionListener(this);
        this.vistaAdmin.btnEliminarVuelo.addActionListener(this);
        this.vistaAdmin.btnRefresh.addActionListener(this);
        this.vistaAdmin.jTableVuelos.addMouseListener(this);
        //=====Componentes de la sección de aviones=====//
        this.vistaAdmin.tblAviones.addMouseListener(this);
        this.vistaAdmin.btnAvionDetalles.addActionListener(this);
        //=====Componentes de la sección de tripulación=====//
        this.vistaAdmin.tblTripulacion.addMouseListener(this);
    }
    //============Método para iniciar la pantalla de administrador============//
    public void iniciarVistaAdmin() {
        Font font = new Font("Montserrat", 0, 13);
        vistaAdmin.setTitle("Voyager Airlines - Panel de administración");
        vistaAdmin.pack();
        vistaAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistaAdmin.setLocationRelativeTo(null);
        vistaAdmin.setVisible(true);
        vistaAdmin.setResizable(false);
        //=====================Enviar ícono a la pantalla=====================//
        vistaAdmin.setIconImage(new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage());
        //=====Enviar alto de las celdas en las tablas=====//
        this.vistaAdmin.tblAviones.setRowHeight(30);
        this.vistaAdmin.jTableVuelos.setRowHeight(30);
        this.vistaAdmin.tblTripulacion.setRowHeight(30);
        
        //=====Íconos=====//
        ImageIcon avion_logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon refrescar = new ImageIcon(getClass().getResource(("/icons/refresh.png")));
        ImageIcon find = new ImageIcon(getClass().getResource(("/icons/find.png")));
        ImageIcon airplane = new ImageIcon(getClass().getResource(("/icons/airplane.png")));
        //=====Íconos con tamaño específico=====//
        ImageIcon logotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelBigLogo.getWidth(), vistaAdmin.jLabelBigLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon SmallLogotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(vistaAdmin.jLabelSmallLogo.getWidth(), vistaAdmin.jLabelSmallLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon avionSeccion = new ImageIcon(airplane.getImage().getScaledInstance(vistaAdmin.jLabelImgSeccion.getWidth(), vistaAdmin.jLabelImgSeccion.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon buscar = new ImageIcon(find.getImage().getScaledInstance(vistaAdmin.jLabelImgBuscar.getWidth(), vistaAdmin.jLabelImgBuscar.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon refresh = new ImageIcon(refrescar.getImage().getScaledInstance(vistaAdmin.btnRefresh.getWidth(), vistaAdmin.btnRefresh.getHeight(), Image.SCALE_DEFAULT));
        //=====Enviar íconos a los componentes=====//
        vistaAdmin.jLabelBigLogo.setIcon(logotipo);
        vistaAdmin.jLabelSmallLogo.setIcon(SmallLogotipo);
        vistaAdmin.jLabelImgBuscar.setIcon(buscar);
        vistaAdmin.btnRefresh.setIcon(refresh);
        vistaAdmin.jLabelImgSeccion.setIcon(avionSeccion);
        //=====Detalles de los componentes sección avión=====//
        vistaAdmin.tblAviones.setModel(modeloAdmin.tablaAviones());
        vistaAdmin.btnAvionDetalles.setEnabled(false);
        //============Detalles de los componentes de sección vuelo============//
        vistaAdmin.btnEditarVuelo.setEnabled(false);
        vistaAdmin.btnEliminarVuelo.setEnabled(false);
        vistaAdmin.txtBuscarVuelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarVueloKeyPressed(evt);
            }
         });
        //vistaAdmin.tblAviones.setModel(modeloAdmin.tablaAviones()); Repetido
        //=====Seleccionar el panel visible al ingresar=====//
        vistaAdmin.Inicio.setVisible(true);
        vistaAdmin.pnlAsientos.setVisible(false);
        vistaAdmin.Aviones.setVisible(false);
        vistaAdmin.Usuarios.setVisible(false);
        vistaAdmin.Ventas.setVisible(false);
        vistaAdmin.Vuelos.setVisible(false);
        vistaAdmin.Tripulacion.setVisible(false);
        //=====Enviar el nombre del usuario a la ventana de adminsitrador=====//
        vistaAdmin.lblNombre.setText(this.s.getNombre());
    }
    
    private void txtBuscarVueloKeyPressed(java.awt.event.KeyEvent evt) {                                          
        // TODO add your handling code here:
        //System.out.println("Se ha tecleado");
        String palabra = vistaAdmin.txtBuscarVuelo.getText();
        vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsultaBuscar(palabra));
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //======Acciones realizadas dentro de la ventana de administrador=====//
        //===Panel de inicio===//
        if(vistaAdmin.btnInicio == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(true);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
        }
        //===Panel de aviones===//
        else if(vistaAdmin.btnAviones == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(true);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
        }
        //===Panel de usuarios===//
        else if(vistaAdmin.btnUsuarios == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(true);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
        }
        //===Panel de ventas===//
        else if(vistaAdmin.btnVentas == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(true);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
        }
        //===Panel de vuelos===//
        else if(vistaAdmin.btnVuelos == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(true);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(false);
            
            vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsulta());
            vistaAdmin.btnEditarVuelo.setEnabled(false);
        }
        //===Panel de tripulación===//
        else if(vistaAdmin.btnTripulacion == e.getSource()){
            limpiarArreglos();
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Aviones.setVisible(false);
            vistaAdmin.Usuarios.setVisible(false);
            vistaAdmin.Ventas.setVisible(false);
            vistaAdmin.Vuelos.setVisible(false);
            vistaAdmin.Inicio.setVisible(false);
            vistaAdmin.pnlAsientos.setVisible(false);
            vistaAdmin.Tripulacion.setVisible(true);
            
            vistaAdmin.tblTripulacion.setModel(modeloAdmin.tripulacionConsulta());
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(0).setMinWidth(70);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(0).setMaxWidth(70);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(0).setPreferredWidth(70);
            
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(1).setMinWidth(140);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(1).setMaxWidth(140);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(1).setPreferredWidth(140);
            
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(3).setMinWidth(70);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(3).setMaxWidth(70);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(3).setPreferredWidth(70);
            
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(4).setMinWidth(70);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(4).setMaxWidth(70);
            this.vistaAdmin.tblTripulacion.getColumnModel().getColumn(4).setPreferredWidth(70);
        }
        //===Para cerrar el programa===//
        else if(vistaAdmin.btnSalirPrograma == e.getSource()){
            System.exit(0);
        }
        //===Para minimizar la pantalla===//
        else if(vistaAdmin.btnMinimizar == e.getSource()){
            vistaAdmin.setExtendedState(1);
        }
        //==============Acciones realizadas en el panel de vuelos=============//
        else if(vistaAdmin.btnAgregarVuelo == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEditarVuelo.setEnabled(false);
            vistaAdmin.btnEliminarVuelo.setEnabled(false);
            vAgregarVuelo addVuelo = new vAgregarVuelo();
            cVuelos controladorVuelo = new cVuelos(addVuelo, 1, 0);
            controladorVuelo.iniciarAgregar();
        }
        else if(vistaAdmin.btnEditarVuelo == e.getSource()){
            limpiarArreglos();
            vAgregarVuelo editVuelo = new vAgregarVuelo();
            cVuelos controladorVuelo = new cVuelos(editVuelo, 2, this.idVuelo);
            controladorVuelo.iniciarAgregar();
        }
        else if(vistaAdmin.btnEliminarVuelo == e.getSource()){
            limpiarArreglos();
            cAlertas mostrarAlerta = new cAlertas(alerta);
            if(this.idVuelo>9)
                mostrarAlerta.agregarContenido(4, "¿Seguro que desea eliminar el vuelo número "+this.idVuelo+"?");
            else
                mostrarAlerta.agregarContenido(4, "¿Seguro que desea eliminar el vuelo número 0"+this.idVuelo+"?");
            
            mostrarAlerta.iniciarAlerta();
        }
        else if(vistaAdmin.btnRefresh == e.getSource()){
            limpiarArreglos();
            vistaAdmin.btnEditarVuelo.setEnabled(false);
            vistaAdmin.btnEliminarVuelo.setEnabled(false);
            vistaAdmin.jTableVuelos.setModel(modeloAdmin.vuelosConsulta());
        }
        //==============Acciones realizadas en el panel de avión==============//
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
                    lblNombres[i-1].setFont(f);
                    for(int t=0; t<oc.length; t++) {
                        if(oc[t].equals(numAsiento)) {
                            Asientos[i-1].setBackground(new java.awt.Color(255, 0, 0));
                            Asientos[i-1].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ActionEvent) {
                                    getLblAsientoCliente().setText("Asiento: " + numAsiento);
                                    getLblNombreCliente().setText(getMAdmin().getNombreCliente(numAsiento, idAvion));
                                    System.out.println("Clic en " + numAsiento);
                                }
                            });
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
        //=============Acciones realizadas en el panel de aviones=============//
        if(e.getSource() == this.vistaAdmin.tblAviones) {
            int fila = vistaAdmin.tblAviones.rowAtPoint(e.getPoint());
            if(fila > -1) {
                //Muchos casteos :'v
                vistaAdmin.btnAvionDetalles.setEnabled(true);
                this.idAvion = Integer.parseInt(String.valueOf(vistaAdmin.tblAviones.getValueAt(fila, 0)));
                System.out.println("Clic en la tabla");
            }
        }
        if(this.vistaAdmin.jTableVuelos == e.getSource()){
            int fila = vistaAdmin.jTableVuelos.rowAtPoint(e.getPoint());
            if(fila > -1) {
                this.idVuelo = Integer.parseInt(String.valueOf(vistaAdmin.jTableVuelos.getValueAt(fila, 0)));
            }
            vistaAdmin.btnEditarVuelo.setEnabled(true);
            vistaAdmin.btnEliminarVuelo.setEnabled(true);
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
    //=================Método para limpiar los campos de texto================//
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
