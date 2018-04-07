package Controlador;

import Vista.vUsuario;
import Modelo.mUsuario;
import Modelo.Sesion;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import Modelo.mAdmin;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class cUsuario implements ActionListener, MouseListener, ItemListener{
    mUsuario mU;
    vUsuario vU;
    Sesion s;
    int id = 0, x;
    int idAvion = 0;
    int g = 0;
    mAdmin modeloAdmin = new mAdmin();
    private JButton Asientos[] = new JButton[238];
    private JLabel lblNombres[] = new JLabel[238];
    
    public cUsuario(mUsuario mU, vUsuario vU, Sesion s) {
        this.mU = mU;
        this.vU = vU;
        this.s = s;
        
        this.vU.btnPerfil.addActionListener(this);
        this.vU.btnInicio.addActionListener(this);
        this.vU.btnVuelos.addActionListener(this);
        this.vU.btnReservar.addActionListener(this);
        
        this.vU.tblVuelos.addMouseListener(this);
        this.vU.cmbRango.addItemListener(this);
        this.vU.cmbOrigenes.addItemListener(this);
    }
    
    public void iniciarVista() {
        this.vU.setLocationRelativeTo(null);
        this.vU.setResizable(false);
        this.vU.setVisible(true);
        this.vU.setTitle("Voyager Arilines");
        this.vU.setIconImage(new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage());
        hacerVisible(this.vU.Inicio);
        
        this.vU.btnReservar.setLayout(null);
        JLabel lblIcon = new JLabel("");
        ImageIcon l = new ImageIcon(getClass().getResource("/img/ic_reservar.png"));
        ImageIcon l2 = new ImageIcon(l.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        lblIcon.setIcon(l2);
        lblIcon.setBounds(180, -3, 64, 64);
        this.vU.btnReservar.add(lblIcon);
        
        this.vU.tblVuelos.setRowHeight(30);
        
        ImageIcon logo1 = new ImageIcon(getClass().getResource("/img/avion_logo.png"));
        ImageIcon logo2 = new ImageIcon(logo1.getImage().getScaledInstance(this.vU.lblLogo.getWidth(), this.vU.lblLogo.getHeight(), Image.SCALE_DEFAULT));
        
        this.vU.lblLogo.setIcon(logo2);
        
        this.vU.lblNombre.setText("Bienvenido(a) " + this.s.getNombre());
    }
    
    private void hacerVisible(JComponent comp) {
        for(int i=0; i<getComponentes().length; i++) {
            if(comp == getComponentes()[i])
                getComponentes()[i].setVisible(true);
            else
                getComponentes()[i].setVisible(false);
        }
    }
    
    private JComponent[] getComponentes() {
        JComponent[] comp = new JComponent[5];
        comp[0] = this.vU.Inicio;
        comp[1] = this.vU.Perfil;
        comp[2] = this.vU.Vuelos;
        comp[3] = this.vU.Compras;
        comp[4] = this.vU.pnlAsientos;
        return comp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vU.btnPerfil) {
            hacerVisible(this.vU.Perfil);
        }
        
        if(e.getSource() == this.vU.btnInicio) {
            hacerVisible(this.vU.Inicio);
        }
        
        if(e.getSource() ==this.vU.btnVuelos) {
            this.vU.tblVuelos.setModel(this.mU.getVuelos());
            //Esto es para esconder la columna de id
            this.vU.cmbOrigenes.setModel(this.mU.getOrigenes());
            this.vU.tblVuelos.getColumn("ID").setPreferredWidth(0);
            this.vU.tblVuelos.getColumn("ID").setMinWidth(0);
            this.vU.tblVuelos.getColumn("ID").setWidth(0);
            this.vU.tblVuelos.getColumn("ID").setMaxWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setPreferredWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setMinWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setMaxWidth(0);
            hacerVisible(this.vU.Vuelos);
        }
        
        if(e.getSource() == this.vU.btnReservar) {
            if(this.id == 0)
                this.vU.lblErrorVuelo.setText("Seleccione un vuelo de la lista para continuar");
            else {
                this.vU.Vuelos.setVisible(false);
                this.vU.pnlAsientos.setVisible(true);
                System.out.println(this.idAvion + ", " + this.id);
                Stack<String> ocupados = modeloAdmin.consultarAsientos(this.id);
                String[] oc = new String[ocupados.size()];
                int o = 0;
                while(!ocupados.empty()) {
                    oc[o] = ocupados.pop();
                    o++;
                }
                generarBotones(Integer.parseInt(String.valueOf(getSpnMenor().getValue())), Integer.parseInt(String.valueOf(getSpnAdulto().getValue())), oc);
                getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                this.vU.spnAdulto.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        int n = Integer.parseInt(String.valueOf(getSpnMenor().getValue()));
                        int a = Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        limpiarCampos();
                        getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                        generarBotones(n, a, oc);
                    }
                });
                
                this.vU.spnMenor.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        int n = Integer.parseInt(String.valueOf(getSpnMenor().getValue()));
                        int a = Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        limpiarCampos();
                        getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                        generarBotones(n, a, oc);
                    }
                });
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vU.tblVuelos) {
            int fila = this.vU.tblVuelos.rowAtPoint(e.getPoint());
            if(fila>-1) {
                this.id = Integer.parseInt(String.valueOf(this.vU.tblVuelos.getValueAt(fila, 4))); 
                this.idAvion = Integer.parseInt(String.valueOf(this.vU.tblVuelos.getValueAt(fila, 5))); 
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == this.vU.cmbOrigenes || e.getSource() == this.vU.cmbRango) {
            this.vU.tblVuelos.setModel(this.mU.setVuelosCiudad(String.valueOf(this.vU.cmbOrigenes.getSelectedItem()), 
                    String.valueOf(this.vU.cmbRango.getSelectedItem())));
            
            this.vU.tblVuelos.getColumn("ID").setPreferredWidth(0);
            this.vU.tblVuelos.getColumn("ID").setMinWidth(0);
            this.vU.tblVuelos.getColumn("ID").setWidth(0);
            this.vU.tblVuelos.getColumn("ID").setMaxWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setPreferredWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setMinWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setWidth(0);
            this.vU.tblVuelos.getColumn("idAvion").setMaxWidth(0);
        }
    }
    
    private void generarBotones(int n, int a, String[] oc) {
        this.x = n + a;
        g = 0;
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
                
                Asientos[i - 1].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                    
                });
                
                if(oc.length > 0) {
                    for(int w=0; w<oc.length; w++)  {
                        if(this.x!=0 && !oc[w].equals(numAsiento)) {
                            Asientos[i-1].setBackground(new java.awt.Color(0, 32, 209));
                            this.x--;
                        }
                    }
                }
                else {
                    if(this.x!=0) {
                        Asientos[i-1].setBackground(new java.awt.Color(0, 32, 209));
                        this.x--;
                    }
                }
                
                for(int t=0; t<oc.length; t++) {
                    if(oc[t].equals(numAsiento)) {
                        Asientos[i-1].setBackground(new java.awt.Color(255, 0, 0));
                    }
                    
                }
                this.vU.lblAsientos.add(Asientos[i-1]);
                this.vU.lblAsientos.add(lblNombres[i-1]);

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
    }
    
    private JSpinner getSpnAdulto() {
        return this.vU.spnAdulto;
    }
    
    private JSpinner getSpnMenor() {
        return this.vU.spnMenor;
    }
    
    private void limpiarCampos() {
        for(int i=0; i<Asientos.length; i++) {
            Asientos[i] = null;
            lblNombres[i] = null;
            this.vU.lblAsientos.removeAll();
        }
    }
    
    private JLabel getLblAsientos() {
        return this.vU.lblAsientos;
    }
}
