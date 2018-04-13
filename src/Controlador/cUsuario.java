package Controlador;

import Vista.vUsuario;
import Vista.vAlertaPerfil;
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
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class cUsuario implements ActionListener, MouseListener, ItemListener{
    mUsuario mU;
    vUsuario vU;
    Sesion s;
    int id = 0, x;
    int idAvion = 0;
    int tipo = 1;
    ArrayList<String> AsientosS = new ArrayList<>();
    ArrayList<String> AsientosO = new ArrayList<>();
    mAdmin modeloAdmin = new mAdmin();
    private JButton Asientos[] = new JButton[238];
    private JLabel lblNombres[] = new JLabel[238];
    private int sTotal;
    private JFileChooser archivos = new JFileChooser();
    private double precioVuelo, precioTotal;
    private String vOrigen, vDestino, vHora;
    
    public cUsuario(mUsuario mU, vUsuario vU, Sesion s) {
        this.mU = mU;
        this.vU = vU;
        this.s = s;
        
        this.vU.btnPerfil.addActionListener(this);
        this.vU.btnInicio.addActionListener(this);
        this.vU.btnVuelos.addActionListener(this);
        this.vU.btnReservar.addActionListener(this);
        this.vU.btnContinuar.addActionListener(this);
        this.vU.btnCambiarCiudad.addActionListener(this);
        this.vU.btnCambiarContra.addActionListener(this);
        this.vU.btnCambiarCorreo.addActionListener(this);
        this.vU.btnBorrarPerfil.addActionListener(this);
        this.vU.btnMetodo.addActionListener(this);
        this.vU.btnVolverAsientos.addActionListener(this);
        this.vU.btnExplorar.addActionListener(this);
        
        this.vU.btnFaq.addMouseListener(this);
        this.vU.tblVuelos.addMouseListener(this);
        this.vU.cmbRango.addItemListener(this);
        this.vU.cmbOrigenes.addItemListener(this);
        this.vU.cmbSeleccion.addItemListener(this);
    }
    
    public void iniciarVista() {
        this.vU.setLocationRelativeTo(null);
        this.vU.setResizable(false);
        this.vU.setVisible(true);
        this.vU.setTitle("Voyager Arilines");
        this.vU.setIconImage(new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage());
        this.vU.pnlComprar.setVisible(false);
        this.vU.pnlFaq.setVisible(false);
        this.vU.pnlEfectivo.setVisible(false);
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
        
        ImageIcon faq = new ImageIcon(getClass().getResource("/icons/faq.png"));
        ImageIcon faq2 = new ImageIcon(faq.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        this.vU.btnFaq.setIcon(faq2);
        this.vU.lblLogo.setIcon(logo2);
        
        this.vU.lblNombre.setText("Bienvenido(a) " + this.s.getNombre());
        this.vU.pnlFaq.setVisible(false);
    }
    
    /**
     * Para hacer visible uno o más componentes a lavez
     * @param comp Uno o mas JComponent's 
     */
    private void hacerVisible(JComponent... comp) {
        int j = 0;
        JComponent[] c = getComponentes();
        for(int i=0; i<c.length; i++) {
            if(comp[j] == c[i] && comp.length == 1) {
                c[i].setVisible(true);
            }
            else if(comp[j] == c[i] && comp.length > 1) {
                c[i].setVisible(true);
                j++;
            }
            else
                c[i].setVisible(false);
        }
    }
    
    private JComponent[] getComponentes() {
        JComponent[] comp = new JComponent[7];
        comp[0] = this.vU.Inicio;
        comp[1] = this.vU.Perfil;
        comp[2] = this.vU.Vuelos;
        comp[3] = this.vU.Compras;
        comp[4] = this.vU.pnlAsientos;
        comp[5] = this.vU.pnlComprar;
        comp[6] = this.vU.pnlEfectivo;
        return comp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vU.btnPerfil) {
            limpiarCampos();
            hacerVisible(this.vU.Perfil);
        }
        
        if(e.getSource() == this.vU.btnInicio) {
            limpiarCampos();
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
                precioTotal = precioVuelo;
                this.vU.lblPrecio.setText("$" + formatearPrecio(precioVuelo));
                Stack<String> ocupados = modeloAdmin.consultarAsientos(this.id);
                String[] oc = new String[ocupados.size()];
                int o = 0;
                while(!ocupados.empty()) {
                    AsientosO.add(ocupados.pop());
                    oc[o] = AsientosO.get(o);
                    o++;
                }
                generarBotones(Integer.parseInt(String.valueOf(getSpnMenor().getValue())), Integer.parseInt(String.valueOf(getSpnAdulto().getValue())), oc);
                getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                this.vU.spnAdulto.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        double precioMenor = precioVuelo * 0.70;
                        int n = Integer.parseInt(String.valueOf(getSpnMenor().getValue()));
                        int a = Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        double precioAdulto = (precioVuelo * a) + (precioMenor * n);
                        precioTotal = precioAdulto;
                        limpiarCampos();
                        sTotal = Integer.parseInt(String.valueOf(getSpnMenor().getValue())) + 
                                 Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                        getLblPrecio().setText("$" + formatearPrecio(precioTotal));
                        generarBotones(n, a, oc);
                    }
                });
                
                this.vU.spnMenor.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        double precioMenor = precioVuelo * 0.70;
                        int n = Integer.parseInt(String.valueOf(getSpnMenor().getValue()));
                        int a = Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        precioMenor = (precioVuelo * a) + (precioMenor * n);
                        precioTotal = precioMenor;
                        limpiarCampos();
                        sTotal = Integer.parseInt(String.valueOf(getSpnMenor().getValue())) + 
                                 Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                       
                        getLblPrecio().setText("$" + formatearPrecio(precioTotal));
                        generarBotones(n, a, oc);
                    }
                });
            }
        }
        
        if(e.getSource() == this.vU.btnContinuar) {
            String asientos = "Asientos: ";
            if(this.tipo == 1) {
                Color c1 = new Color(0, 32, 209);
                for(int i=1; i<238; i++) {
                    if(i%7 != 0 || i == 0 || i<6) {
                        if(Asientos[i-1].getBackground().getRGB() == c1.getRGB()) {
                            AsientosS.add(lblNombres[i - 1].getText());
                        }
                    }
                }
                System.out.println(AsientosS);
            }
            int as = 0;
            while(as<AsientosS.size()) {
                asientos = asientos + " " + AsientosS.get(as);
                as++;
            }
            this.vU.lblAsientosPagar.setText(asientos);
            this.vU.lblVueloInfo.setText("Vuelo: " + vOrigen + ", con destino a " + vDestino);
            this.vU.lblVueloHora.setText("Hora de salida: " + vHora);
            this.vU.lblPrecioTotal.setText("Total a pagar: $" + formatearPrecio(precioTotal));
            hacerVisible(this.vU.pnlComprar, this.vU.pnlEfectivo);
        }
        
        if(e.getSource() == this.vU.btnExplorar) {
            generarPdf();
        }
        
        if(e.getSource() == this.vU.btnPerfil) {
            hacerVisible(this.vU.Perfil);
            ArrayList<String> datos = this.mU.getDatosPerfil(this.s.getId());
            String num = null;
            if(datos.size() == 5) {
                char[] tarjeta = datos.get(4).toCharArray();
                for(int i=0; i<tarjeta.length - 4; i++) {
                    if(i<14) {
                        tarjeta[i] = '*';
                    }
                }
                this.vU.btnMetodo.setText("Borrar método de pago");
                num = String.valueOf(tarjeta);
            }
            this.vU.lblPerfilNombre.setText(this.s.getNombre());
            this.vU.txtNacionalidad.setText(datos.get(0));
            this.vU.txtCiudad.setText(datos.get(1));
            this.vU.txtPerfilCorreo.setText(this.s.getUsuario());
            this.vU.txtPassPerfil.setText(datos.get(2));
            this.vU.txtFechaPerfil.setText(datos.get(3));   
            this.vU.txtTarjeta.setText(num);
        }
        
        if(e.getSource() == this.vU.btnCambiarCiudad) {
            if(!this.vU.txtCiudad.isEnabled()) {
                this.vU.txtCiudad.setEnabled(true);
            }
            else {
                this.mU.cambiarDatos(this.vU.txtCiudad.getText(), 1, this.s.getId());
                this.vU.txtCiudad.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.vU.btnCambiarCorreo) {
            if(!this.vU.txtPerfilCorreo.isEnabled()) {
                this.vU.txtPerfilCorreo.setEnabled(true);
            }
            else {
                this.mU.cambiarDatos(this.vU.txtPerfilCorreo.getText(), 2, this.s.getId());
                this.vU.txtPerfilCorreo.setEnabled(false);
            }
        }
        if(e.getSource() == this.vU.btnCambiarContra) {
            if(!this.vU.txtPassPerfil.isEnabled()) {
                this.vU.txtPassPerfil.setEnabled(true);
            }
            else {
                this.mU.cambiarDatos(this.vU.txtPassPerfil.getText(), 3, this.s.getId());
                this.vU.txtPassPerfil.setEnabled(false);
            }
        }
        
        if(e.getSource() == this.vU.btnBorrarPerfil) {
            vAlertaPerfil vA = new vAlertaPerfil();
            cAlertasPerfil cA = new cAlertasPerfil(vA);
            cA.iniciarVista();
        }
        
        if(e.getSource() == this.vU.btnVolverAsientos) {
            this.vU.pnlComprar.setVisible(false);
            this.vU.pnlAsientos.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vU.tblVuelos) {
            int fila = this.vU.tblVuelos.rowAtPoint(e.getPoint());
            if(fila>-1) {
                this.vOrigen = String.valueOf(this.vU.tblVuelos.getValueAt(fila, 0));
                this.vDestino = String.valueOf(this.vU.tblVuelos.getValueAt(fila, 1));
                this.vHora = String.valueOf(this.vU.tblVuelos.getValueAt(fila, 3));
                this.id = Integer.parseInt(String.valueOf(this.vU.tblVuelos.getValueAt(fila, 4))); 
                this.idAvion = Integer.parseInt(String.valueOf(this.vU.tblVuelos.getValueAt(fila, 5))); 
                this.precioVuelo = Double.parseDouble(String.valueOf(this.vU.tblVuelos.getValueAt(fila, 6)));
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
        if(e.getSource() == this.vU.btnFaq) {
            this.vU.pnlFaq.setVisible(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this.vU.btnFaq) {
            this.vU.pnlFaq.setVisible(false);
        }
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
        if(e.getSource() == this.vU.cmbSeleccion) {
            if(String.valueOf(this.vU.cmbSeleccion.getSelectedItem()).equals("Individual")) {
                this.tipo = 2;
            }
            else
                this.tipo = 1;
        }
    }
    
    private void generarBotones(int n, int a, String[] oc) {
        long inicio = System.currentTimeMillis();
        this.x = n + a;
        final int k = this.x; 
        Font f = new Font("Montserrat", 0, 8);
        char fila = 65;
        Color color = new Color(255, 0, 0);
        int asiento = 1, x = 48, y = 350;
        int ac = 1;
        int ac2 = 0;
        int ac3 = 0;
        for(int i=1; i<238; i++) {
            final int o = i;
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
                        Asientos[i-1].setBackground(color);
                    }    
                }
                //No se agrega ActionListener a asientos ocupados
                if(color.getRGB() != Asientos[i-1].getBackground().getRGB()) {
                    Asientos[i-1].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            seleccionarAsientos(o, k);
                        }
                    });
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
                    break;
                }
            }
        }
        int c = n + a;
        ArrayList<String> asientos = new ArrayList<>();
        asientos.addAll(Arrays.asList(oc));
        if(oc.length > 0) {
            int q = 0;
            for(int i=1; i<238; i++) {
                if(i%7 != 0 || i == 0 || i<6) {
                    if(c!=0 && !asientos.contains(lblNombres[i-1].getText())) {
                        Asientos[i-1].setBackground(new java.awt.Color(0, 32, 209));
                        asientos.remove(lblNombres[i-q].getText());
                        c--;
                        q++;
                    }
                }
            }
        }
        else {
            while(this.x!=0) {
                Asientos[x].setBackground(new Color(0, 32, 209));
                x--;
            }
        }
        System.out.println(System.currentTimeMillis() - inicio);
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
        }
        this.vU.lblAsientos.removeAll();
    }
    
    private JLabel getLblAsientos() {
        return this.vU.lblAsientos;
    }
    
    private void seleccionarAsientos(int posicion, int asientos) {
        ArrayList<String> compras = new ArrayList<>();
        Color c1 = new Color(0, 32, 209);
        Color c2 = new Color(214, 217, 223);
        if(this.tipo == 1) {
            int v = 0;
            for(int t = asientos; t>v; t--) {
                try {
                    if(t%7 != 0 || t == 0 || t<6) {
                        if(Asientos[posicion - t].getBackground().getRGB() != c1.getRGB()) {
                            Asientos[posicion - t].setBackground(c1);
                            compras.add(lblNombres[posicion - t].getText());
                        }
                    }
                }catch(NullPointerException e) {
                    v--;
                    Asientos[(posicion - t) - 1].setBackground(c1);
                    compras.add(lblNombres[(posicion - t) - 1].getText());
                    t--;
                }
            }        
            System.out.println(compras);
            for(int i = 1; i<posicion - 1; i++) {
                if(i%7 != 0 || i == 0 || i<6) {
                    if(Asientos[i - 1].getBackground().getRGB() == c1.getRGB() && asientos!=0) {
                        Asientos[i - 1].setBackground(c2);
                        asientos--;
                    }
                }
            }
            AsientosS = compras;
        }
        //Este es el más fácil :v
        else {
            ArrayList<JButton> asiento = new ArrayList<>();
            if(sTotal != 0) {
                for(int i=1; i<238; i++) {
                    if(i%7 != 0 || i == 0 || i<6) {
                        if(Asientos[i - 1].getBackground().getRGB() == c1.getRGB()) {
                            asiento.add(Asientos[i - 1]);
                        }
                    }
                }
                if(!asiento.contains(Asientos[posicion - 1])) {
                    Asientos[posicion - 1].setBackground(c1);
                    compras.add(lblNombres[posicion - 1].getText());
                    sTotal--;
                }
            }
            else {
                for(int i=1; i<238; i++) {
                    if(i%7 != 0 || i == 0 || i<6) {
                        if(Asientos[i - 1].getBackground().getRGB() == c1.getRGB()) {
                            asiento.add(Asientos[i - 1]);
                            System.out.println(asiento);
                        }
                    }
                    asiento.get(asientos - 1).setBackground(c2);
                    if(!asiento.contains(Asientos[posicion - 1])) {
                        Asientos[posicion - 1].setBackground(c1);
                        asiento.add(Asientos[posicion - 1]);
                        asiento.remove(0);
                    }
                }
                Asientos[posicion - 1].setBackground(c1);
            }
        }
    }
    
    private JLabel getLblPrecio() {
        return this.vU.lblPrecio;
    }
    
    private String formatearPrecio(double precioTotal) {
        String precio = String.format("%.2f", precioTotal);
        char pre[] = precio.toCharArray();
        String pre2 = "";
        if(precioTotal>1000 && precioTotal<10000) {
            for(int i=0; i<pre.length; i++) {
                if(i == 1) {
                    pre2 = pre2 + ",";
                    pre2 = pre2 + String.valueOf(pre[i]);
                }
                else {
                    pre2 = pre2 + String.valueOf(pre[i]);
                }
            }
        }
        if(precioTotal>10000 && precioTotal<100000) {
            for(int i=0; i<pre.length; i++) {
                if(i == 2) {
                    pre2 = pre2 + ",";
                    pre2 = pre2 + String.valueOf(pre[i]);
                }
                else {
                    pre2 = pre2 + String.valueOf(pre[i]);
                }
            }
        }
        if(precioTotal>100000 && precioTotal<1000000) {
            for(int i=0; i<pre.length; i++) {
                if(i == 3) {
                    pre2 = pre2 + ",";
                    pre2 = pre2 + String.valueOf(pre[i]);
                }
                else {
                    pre2 = pre2 + String.valueOf(pre[i]);
                }
            }
        }
        return pre2;
    }
    
    private void generarPdf() {
        Document doc = new Document();
        try {
            FontFactory.register("/fonts/Oxygen-Bold.ttf");
            com.itextpdf.text.Image logo = null;
            com.itextpdf.text.Font fuente = FontFactory.getFont("Oxygen-Bold", 22);
            FontFactory.register("/fonts/Oxygen-Regular.ttf");
            com.itextpdf.text.Font fuente2 = FontFactory.getFont("Oxygen-Regular", 12);
            logo = com.itextpdf.text.Image.getInstance("src/img/avion_logo2.png");
            archivos.showSaveDialog(vU);
            String path = archivos.getSelectedFile().getAbsolutePath();
            PdfWriter p = PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
            doc.open();
            PdfPCell pCell = new PdfPCell();
            PdfPCell pCell2 = new PdfPCell();
            
            PdfPTable pTable = new PdfPTable(2);
            pTable.setWidthPercentage(100);
            pTable.setWidths(new int[]{1, 3});
            
            logo.scaleAbsolute(80, 80);
            
            pCell.addElement(logo);
            pCell.setBorder(Rectangle.NO_BORDER);
            pTable.addCell(pCell);
            
            Paragraph marca = new Paragraph("Voyager Airlines", fuente);
            marca.setAlignment(Element.ALIGN_CENTER);
            
            pCell2.addElement(marca);
            pCell2.setVerticalAlignment(Element.ALIGN_CENTER);
            pCell2.setBorder(Rectangle.NO_BORDER);
            
            pTable.addCell(pCell2);
            
            doc.add(pTable);
            
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Datos del cliente.", fuente2));
            doc.add(new Paragraph("Nombre: " + this.s.getNombre(), fuente2));
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            
            doc.add(new Paragraph("Datos de la compra.", fuente2));
            String infoBol;
            int menor = (int) this.vU.spnMenor.getValue();
            int adulto = (int) this.vU.spnAdulto.getValue();
            if(menor == 0) {
                infoBol = String.valueOf(adulto) + " Adulto(s)";
            }
            else {
                infoBol = String.valueOf(adulto) + " Adulto(s) y " + String.valueOf(menor) + " niño(s)";
            }
            doc.add(new Paragraph("Pasajeros: " + infoBol, fuente2));
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Vuelo con origen en " + vOrigen + " y destino a " + vDestino, fuente2));
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph(this.vU.lblAsientosPagar.getText(), fuente2));
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Total: $" + formatearPrecio(precioTotal), fuente2));
            
            PdfContentByte pdfC = p.getDirectContent();
            Barcode128 bC = new Barcode128();
            bC.setCode("H1G534tg6dfsdvdsghyo1094710nf.213");
            com.itextpdf.text.Image code = bC.createImageWithBarcode(pdfC, BaseColor.BLACK, BaseColor.BLACK);
            code.setAbsolutePosition(170, 550);
            doc.add(code);
            
            doc.close();
        }catch(FileNotFoundException ex) {
            Logger.getLogger(cUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DocumentException | IOException ex) {
            Logger.getLogger(cUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
