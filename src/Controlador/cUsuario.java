package Controlador;

import Vista.vUsuario;
import Modelo.mUsuario;
import Modelo.Sesion;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class cUsuario implements ActionListener, MouseListener, ItemListener{
    mUsuario mU;
    vUsuario vU;
    Sesion s;
    
    public cUsuario(mUsuario mU, vUsuario vU, Sesion s) {
        this.mU = mU;
        this.vU = vU;
        this.s = s;
        
        this.vU.btnPerfil.addActionListener(this);
        this.vU.btnInicio.addActionListener(this);
        this.vU.btnVuelos.addActionListener(this);
        
        this.vU.tblVuelos.addMouseListener(this);
        this.vU.cmbRango.addItemListener(this);
        this.vU.cmbOrigenes.addItemListener(this);
    }
    
    public void iniciarVista() {
        this.vU.setLocationRelativeTo(null);
        this.vU.setResizable(false);
        this.vU.setVisible(true);
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
            hacerVisible(this.vU.Vuelos);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vU.tblVuelos) {
            int fila = this.vU.tblVuelos.rowAtPoint(e.getPoint());
            if(fila>-1) {
                System.out.println(String.valueOf(this.vU.tblVuelos.getValueAt(fila, 4))); 
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
        }
    }
}
