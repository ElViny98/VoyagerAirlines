/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.vPVentas;
import modelo.mVentas;
import modelo.Sesion;
import modelo.mAdmin;
import modelo.mLogin;
import vista.vLogin;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author Bryan
 */
public class cVentas implements ActionListener, MouseListener, ItemListener{
    mVentas mV;
    vPVentas vPV;
    Sesion ses;
    public int pp, pvpp;
    private int id = 0, x = 0, k = 1;
    private int tipo = 1;
    private ArrayList<String> AsientosS = new ArrayList<>();
    private ArrayList<String> AsientosO = new ArrayList<>();
    private mAdmin modeloAdmin = new mAdmin();
    private JButton Asientos[] = new JButton[238];
    private JLabel lblNombres[] = new JLabel[238];
    private int sTotal;
    private JFileChooser archivos = new JFileChooser();
    private double precioVuelo, precioTotal, totalRedondo;
    private String vOrigen, vDestino, vHora, dir;
    private String asientos = "Asientos: ";
    
    private String AAsientos = "Asientos: ";
    
    
    public cVentas(vPVentas Pventas, mVentas mV, String Nombre)
    {
        this.vPV = Pventas;
        this.mV = mV;
        
        this.vPV.jButtonPagar.addActionListener(this);
        //this.vPV.btnRegresarEfectivo.addActionListener(this);
        this.vPV.btnRegresarTarjeta.addActionListener(this);
        this.vPV.jcomboxTIdaRedondo.addActionListener(this);
        this.vPV.btnBuscarVuelos.addActionListener(this);
        this.vPV.btnAsientos.addActionListener(this);
        this.vPV.btnContinuar.addActionListener(this);
        this.vPV.btnRPago.addActionListener(this);
        this.vPV.btnExplorar.addActionListener(this);
        this.vPV.btnImprimirReporte.addActionListener(this);
        
        this.vPV.ComboBoxOrigen.addItemListener(this); 
        this.vPV.ComboBoxDestino.addItemListener(this);
        this.vPV.jcomboxTIdaRedondo.addItemListener(this);
        this.vPV.cmbSeleccion.addItemListener(this);
        
        this.vPV.jTableIDAIDA.addMouseListener(this);
        this.vPV.jTableRedondoIda.addMouseListener(this);
        this.vPV.jTableRedondoRegreso.addMouseListener(this);
        
        this.vPV.lblNombre.setText("Bienvenido(a) " +Nombre);
        vPV.btnCerrar.setVisible(false);
        this.pvpp=1;
    }
    
    public cVentas(mVentas mV, vPVentas vPV, Sesion ses) {
        this.mV = mV;
        this.vPV = vPV;
        this.ses = ses;
        
        this.vPV.btnCerrar.addActionListener(this);
        this.vPV.jButtonPagar.addActionListener(this);
        //this.vPV.btnRegresarEfectivo.addActionListener(this);
        this.vPV.btnRegresarTarjeta.addActionListener(this);
        this.vPV.jcomboxTIdaRedondo.addActionListener(this);
        this.vPV.btnBuscarVuelos.addActionListener(this);
        this.vPV.btnAsientos.addActionListener(this);
        this.vPV.btnContinuar.addActionListener(this);
        this.vPV.btnRPago.addActionListener(this);
        this.vPV.btnExplorar.addActionListener(this);
        this.vPV.btnImprimirReporte.addActionListener(this);
        
        this.vPV.ComboBoxOrigen.addItemListener(this); 
        this.vPV.ComboBoxDestino.addItemListener(this);
        this.vPV.jcomboxTIdaRedondo.addItemListener(this);
        this.vPV.cmbSeleccion.addItemListener(this);
        
        this.vPV.jTableIDAIDA.addMouseListener(this);
        this.vPV.jTableRedondoIda.addMouseListener(this);
        this.vPV.jTableRedondoRegreso.addMouseListener(this);
        
        this.vPV.lblNombre.setText(this.ses.getNombre());
        this.pvpp=2;
    }
    
    public void iniciarAgregar(){
        vPV.pack();
        vPV.setLocationRelativeTo(null);
        hacerVisible(this.vPV.Ventas);   
        vPV.setVisible(true);
        this.vPV.setTitle("Voyager Arilines");
        this.vPV.jTableIDAIDA.setRowHeight(25);
        this.vPV.jTableRedondoIda.setRowHeight(25);
        this.vPV.jTableRedondoRegreso.setRowHeight(25);
        
        vPV.ComboBoxOrigen.setModel(this.mV.getOrigenes());
        vPV.ComboBoxDestino.setModel(this.mV.getDestinos());
        vPV.jTableRedondoIda.setModel(this.mV.getVuelos());
        this.vPV.jTableRedondoIda.getColumn("ID").setPreferredWidth(0);
        this.vPV.jTableRedondoIda.getColumn("ID").setMinWidth(0);
        this.vPV.jTableRedondoIda.getColumn("ID").setWidth(0);
        this.vPV.jTableRedondoIda.getColumn("ID").setMaxWidth(0);
        vPV.jTableRedondoRegreso.setModel(this.mV.getVuelos());
        this.vPV.jTableRedondoRegreso.getColumn("ID").setPreferredWidth(0);
        this.vPV.jTableRedondoRegreso.getColumn("ID").setMinWidth(0);
        this.vPV.jTableRedondoRegreso.getColumn("ID").setWidth(0);
        this.vPV.jTableRedondoRegreso.getColumn("ID").setMaxWidth(0);
        this.vPV.jPanelIda.setVisible(false);
        this.vPV.jPanelRedondo.setVisible(true);

        Image icon = new ImageIcon(getClass().getResource("/img/avion_logo.png")).getImage();
        vPV.setIconImage(icon);
        ImageIcon AvionLogo = new ImageIcon(getClass().getResource("/img/avion_logo.png"));
        ImageIcon HVSIcon = new ImageIcon(AvionLogo.getImage().getScaledInstance(vPV.lblLogo.getWidth(), vPV.lblLogo.getHeight(), Image.SCALE_DEFAULT));
        vPV.lblLogo.setIcon(HVSIcon);
        ImageIcon SPointIcon = new ImageIcon(getClass().getResource("/icons/SellPointIcon.png"));
        ImageIcon SellPoint = new ImageIcon(SPointIcon.getImage().getScaledInstance(vPV.JlHVIcon.getWidth(), vPV.JlHVIcon.getHeight(), Image.SCALE_DEFAULT));
        vPV.JlHVIcon.setIcon(SellPoint);
        
        ImageIcon logo1 = new ImageIcon(getClass().getResource("/img/avion_logo.png"));
        
        ImageIcon faq = new ImageIcon(getClass().getResource("/icons/faq.png"));
        ImageIcon faq2 = new ImageIcon(faq.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        this.vPV.btnFaq.setIcon(faq2);
        this.vPV.pnlFaq.setVisible(false);
        
        this.vPV.jTextPAN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char k = ke.getKeyChar();
                if(!(Character.isDigit(k)) || getTxtTarjetaCompra().getText().length() > 15) {
                    ke.consume();
                }
            }
        });
        
        this.vPV.jTextFecha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char k = ke.getKeyChar();
                String c = getTxtVencimiento().getText();
                if(!(Character.isDigit(k)) || getTxtVencimiento().getText().length() == 5) {
                    ke.consume();
                }
                else {
                    if(getTxtVencimiento().getText().length() < 2) {
                        if((k<48 || k>'1') && getTxtVencimiento().getText().length() == 0)
                            ke.consume();
                        
                        if(getTxtVencimiento().getText().equals("0")) {
                            if((k<'1' || k>'9'))
                                ke.consume();
                        }
                        else
                            if((k<48 || k>'2'))
                                ke.consume();
                    }
                    if(getTxtVencimiento().getText().length() == 2) {
                        c = c + "/";
                        getTxtVencimiento().setText(c);
                    }
                }
            }
        });
        
        this.vPV.jTextCVC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char k = ke.getKeyChar();
                if(!(Character.isDigit(k)) || getTxtCcv().getText().length() == 3) {
                    ke.consume();
                }
            }
        });
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
        JComponent[] comp = new JComponent[2];
        comp[0] = this.vPV.pnlAsientos1;
        comp[1] = this.vPV.Ventas;
        
        return comp;
    }
    
    private void hacerVisiblePVPaneles(JComponent comp) {
        for(int i=0; i<getComponentesPVP().length; i++) {
            if(comp == getComponentesPVP()[i])
                getComponentesPVP()[i].setVisible(true);
            else
                getComponentesPVP()[i].setVisible(false);
        }
    }
    
    private JComponent[] getComponentesPVP() {
        JComponent[] comp = new JComponent[3];
        comp[0] = this.vPV.SeleccionTodo;
        comp[1] = this.vPV.PagoTarjeta;
        comp[2] = this.vPV.pnlEfectivo;
        
        return comp;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == vPV.jButtonPagar){
            if(vPV.jComboBoxSPago.getSelectedItem().toString().equals("Efectivo")){
                hacerVisiblePVPaneles(this.vPV.pnlEfectivo);
                this.vPV.lblAsientosPagar.setText(this.AAsientos);
                System.out.println("A: " + this.asientos);
                if(vPV.jcomboxTIdaRedondo.getSelectedItem().toString().equals("Redondo"))
                    this.vPV.lblVueloInfo.setText("Vuelo: " + vOrigen + ", con destino a " + vDestino + " y  de Regureso");
                else
                    this.vPV.lblVueloInfo.setText("Vuelo: " + vOrigen + ", con destino a " + vDestino);
                this.vPV.lblVueloHora.setText("Hora de salida: " + vHora);
                this.vPV.lblPrecioTotal.setText("Total a pagar: $" + formatearPrecio(this.totalRedondo)); 
            }
            else
                hacerVisiblePVPaneles(this.vPV.PagoTarjeta);
        }/*else if(ae.getSource() == vPV.btnRegresarEfectivo){
            hacerVisiblePVPaneles(this.vPV.SeleccionTodo);
        }*/else if(ae.getSource() == vPV.btnRegresarTarjeta){
            hacerVisiblePVPaneles(this.vPV.SeleccionTodo);   
        }else if(ae.getSource() == vPV.btnCerrar) {
            vLogin vL = new vLogin();
            mLogin mL = new mLogin();
            this.ses.destruirSesion();
            this.vPV.dispose();
            cLogin cL = new cLogin(vL);
            cL.iniciarVista();
        }else if(ae.getSource() == vPV.btnBuscarVuelos){  
            try
            {
                if(String.valueOf(this.vPV.jcomboxTIdaRedondo.getSelectedItem())=="Ida"){ 
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String sdI = dateFormat.format(vPV.jDateChooserSalid.getDate());
                    System.out.println("Fehca: " + sdI);
                    vPV.jTableIDAIDA.setModel(mV.getVuelosCompraR(sdI, String.valueOf(this.vPV.ComboBoxOrigen.getSelectedItem()), String.valueOf(this.vPV.ComboBoxDestino.getSelectedItem())));
                }else{
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String sdI = dateFormat.format(vPV.jDateChooserSalid.getDate());
                    System.out.println("Fehca: " + sdI);
                    SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
                    String sdR = Formato.format(vPV.jDateChooserRetorn.getDate());
                    System.out.println("Fehca: " + sdR);
                    vPV.jTableRedondoIda.setModel(mV.getVuelosCompraR(sdI, String.valueOf(this.vPV.ComboBoxOrigen.getSelectedItem()), String.valueOf(this.vPV.ComboBoxDestino.getSelectedItem())));
                    vPV.jTableRedondoRegreso.setModel(mV.getVuelosCompraRRegreso(sdR, String.valueOf(this.vPV.ComboBoxOrigen.getSelectedItem()), String.valueOf(this.vPV.ComboBoxDestino.getSelectedItem())));
                }
            }catch(Exception e){
                System.out.println("Fecha erronea");
            }   
        }else if(ae.getSource() == this.vPV.btnAsientos) {
            System.out.println("ID: " + this.id);
            AsientosS.clear();
            limpiarCampos();
            if(this.id == 0)
                this.vPV.lblErrorDeAsientos.setText("Seleccione un vuelo de la lista para continuar");
            else if(this.id != 0) {
                
                hacerVisiblePVPaneles(vPV.pnlAsientos1);
                hacerVisible(vPV.pnlAsientos1);
                double precioMenor = precioVuelo * 0.70;
                int n = Integer.parseInt(String.valueOf(getSpnMenor().getValue()));
                int a = Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                double precioAdulto = (precioVuelo * a) + (precioMenor * n);
                precioTotal = precioAdulto;
                totalRedondo = totalRedondo + precioTotal;
                this.vPV.lblPrecio.setText("$" + formatearPrecio(this.totalRedondo));
//                this.vU.Vuelos.setVisible(false);
//                this.vU.pnlAsientos.setVisible(true);
                precioTotal = precioVuelo;
                this.vPV.lblPrecio.setText("$" + formatearPrecio(this.totalRedondo));
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
                this.vPV.spnAdulto.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        double precioMenor = precioVuelo * 0.70;
                        int n = Integer.parseInt(String.valueOf(getSpnMenor().getValue()));
                        int a = Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        double precioAdulto = (precioVuelo * a) + (precioMenor * n);
                        precioTotal = precioAdulto;
                        totalRedondo = precioTotal;
                        limpiarCampos();
                        sTotal = Integer.parseInt(String.valueOf(getSpnMenor().getValue())) + 
                                 Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                        getLblPrecio().setText("$" + formatearPrecio(totalRedondo));
                        generarBotones(n, a, oc);
                    }
                });
                
                this.vPV.spnMenor.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        double precioMenor = precioVuelo * 0.70;
                        int n = Integer.parseInt(String.valueOf(getSpnMenor().getValue()));
                        int a = Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        precioMenor = (precioVuelo * a) + (precioMenor * n);
                        precioTotal = precioMenor;
                        totalRedondo = precioTotal;
                        limpiarCampos();
                        sTotal = Integer.parseInt(String.valueOf(getSpnMenor().getValue())) + 
                                 Integer.parseInt(String.valueOf(getSpnAdulto().getValue()));
                        getLblAsientos().setIcon(new ImageIcon(getClass().getResource("/img/Prueba.png")));
                       
                        getLblPrecio().setText("$" + formatearPrecio(totalRedondo));
                        generarBotones(n, a, oc);
                    }
                });
            }
        }else if(ae.getSource() == vPV.btnContinuar){
                String asientos = "Asientos: ";
                Color c1 = new Color(0, 32, 209);
                for(int i=1; i<238; i++) {
                    if(i%7 != 0 || i == 0 || i<6) {
                        if(Asientos[i-1].getBackground().getRGB() == c1.getRGB()) {
                            AsientosS.add(lblNombres[i - 1].getText());
                        }
                    }
                }
                System.out.println(AsientosS);
                int as = 0;
                while(as<AsientosS.size()) {
                    asientos = asientos + " " + AsientosS.get(as);
                    this.asientos = asientos;
                    //AAsientos = asientos;
                    AAsientos = AAsientos + " " + AsientosS.get(as);
                    System.out.println("a: " + AAsientos);
                    as++;
            }
            hacerVisible(vPV.Ventas);
            hacerVisiblePVPaneles(vPV.SeleccionTodo);
  
        }
        if(ae.getSource() == this.vPV.btnExplorar) {
            archivos.showSaveDialog(vPV);
            dir = archivos.getSelectedFile().getAbsolutePath();
            generarPdf(dir, 2);
            int iV = this.mV.realizarCompra(precioTotal, this.ses.getId(), 2);
            this.mV.reservarBoleto(id, this.ses.getId(), iV, AsientosS);
        }
        
        if(ae.getSource() == this.vPV.btnImprimirReporte) {
            dir = System.getProperty("user.home") + "\\AppData\\Local\\temp\\reportPrint";
            generarPdf(dir, 2);
            dir = dir + ".pdf";
            Desktop desktop = Desktop.getDesktop();
            File file = new File(dir);
            try {
                desktop.print(file);
            } catch (IOException ex) {
                Logger.getLogger(cUsuario.class.getName()).log(Level.SEVERE, null, ex);
                file.delete();
            }
            int iV = this.mV.realizarCompra(precioTotal, this.ses.getId(), 2);
            this.mV.reservarBoleto(id, this.ses.getId(), iV, AsientosS);
        }
        if(ae.getSource() == this.vPV.btnRPago) {
            //Validaciones
            String mensaje = "";
            int m, a;
            String numT = this.vPV.jTextPAN.getText();
            String fechaT = this.vPV.jTextFecha.getText();
            String ccv = this.vPV.jTextCVC.getText();
            String tipo = (String) this.vPV.jComboBoxSPago.getSelectedItem();
            
            char[] ver = fechaT.toCharArray();
            if(fechaT.length() > 2)
                m = Integer.parseInt(String.valueOf(ver[0] + ver[1]));
            else
                m = 0;
            if(fechaT.length() == 5)
                a = Integer.parseInt(String.valueOf(ver[3] + ver[4]));
            else
                a = 0;
            
            if(tipo.equals("Seleccionar...") || numT.length() < 16 || fechaT.length() < 5 || ccv.length() < 3) {
                if(tipo.equals("Seleccionar..."))
                    mensaje = mensaje + "Capture un tipo de tarjeta válido. ";
                if(numT.length()<16)
                    mensaje = mensaje + "Capture un número de tarjeta válido. ";
                if(fechaT.length()<5 || (m>12 || m == 0))
                    mensaje = mensaje + "Capture una fecha de vencimiento válida. ";
                if(ccv.length()<3)
                    mensaje = mensaje + "Capture un código de seguridad válido. ";
                
                this.vPV.lblTarjetaError.setText(mensaje);
            }
            else {
                int iV = this.mV.realizarCompra(precioTotal, this.ses.getId(), 1);
                System.out.println(iV);
                if(iV>0) {
                    this.mV.reservarBoleto(id, this.ses.getId(), iV, AsientosS);
                    archivos.setDialogTitle("Guardar reporte");
                    archivos.showSaveDialog(vPV);
                    generarPdf(archivos.getSelectedFile().getAbsolutePath(), 1);
                    hacerVisible(this.vPV.Ventas);
                }
            }
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
                this.vPV.lblAsientos.add(Asientos[i-1]);
                this.vPV.lblAsientos.add(lblNombres[i-1]);

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
            int q = 1;
            for(int i=1; i<238; i++) {
                if(i%7 != 0 || i == 0 || i<6) {
                    if(c!=0 && !asientos.contains(lblNombres[i-1].getText())) {
                        Asientos[i-1].setBackground(new java.awt.Color(0, 32, 209));
                        asientos.remove(lblNombres[i-1].getText());
                        c--;
                        q++;
                    }
                }
            }
        }
        else {
            while(this.x!=0) {
                Asientos[this.x - 1].setBackground(new Color(0, 32, 209));
                this.x--;
            }
        }
        System.out.println(System.currentTimeMillis() - inicio);
    }
    
    private void seleccionarAsientos(int posicion, int asientos) {
        ArrayList<String> compras = new ArrayList<>();
        Color c1 = new Color(0, 32, 209);
        Color c2 = new Color(214, 217, 223);
        Color c3 = new Color(255, 0, 0);
        if(this.tipo == 1) {
            ArrayList<JButton> botO = new ArrayList<>();
            int v = 0;
            int aux = 1;
            for(int i = 1; i<238; i++) {
                if(i%7 != 0 || i == 0 || i<6) {
                    if(Asientos[i - 1].getBackground().getRGB() == c3.getRGB()) {
                        botO.add(Asientos[i - 1]);
                    }
                }
            }
            int a = asientos;
            int a2 = 0;
            int a3 = 1;
            while(a2 < asientos) {
                if(botO.contains(Asientos[posicion - a3])) {
                    aux++;
                    a3++;
                }
                else {
                    if((posicion - aux + 1)%7!=0 || (posicion - aux + 1) == 0 || (posicion - aux + 1)<7) {
                        Asientos[posicion - aux].setBackground(c1);
                        a2++;
                        aux++;
                        a3++;
                    }
                    else
                        aux++;
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
        }
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
                    asiento.get(0).setBackground(c2);
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
    
    private JSpinner getSpnAdulto() {
        return this.vPV.spnAdulto;
    }
    
    private JSpinner getSpnMenor() {
        return this.vPV.spnMenor;
    }
    
    private JLabel getLblAsientos() {
        return this.vPV.lblAsientos;
    }
    
    private JLabel getLblPrecio() {
        return this.vPV.lblPrecio;
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
    
    private void limpiarCampos() {
        for(int i=0; i<Asientos.length; i++) {
            Asientos[i] = null;
            lblNombres[i] = null;
        }
        this.vPV.lblAsientos.removeAll();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == this.vPV.jTableIDAIDA) {
            int fila = this.vPV.jTableIDAIDA.rowAtPoint(me.getPoint());
            if(fila>-1) {
                this.id = Integer.parseInt(String.valueOf(this.vPV.jTableIDAIDA.getValueAt(fila, 0)));
                this.vOrigen = String.valueOf(this.vPV.jTableIDAIDA.getValueAt(fila, 1));
                this.vDestino = String.valueOf(this.vPV.jTableIDAIDA.getValueAt(fila, 2));
                this.vHora = String.valueOf(this.vPV.jTableIDAIDA.getValueAt(fila, 4));
                this.precioVuelo = Double.parseDouble(String.valueOf(this.vPV.jTableIDAIDA.getValueAt(fila, 5)));
            }
        }else if(me.getSource() == this.vPV.jTableRedondoIda){
            int fila = this.vPV.jTableRedondoIda.rowAtPoint(me.getPoint());
            if(fila>-1) {
                this.id = Integer.parseInt(String.valueOf(this.vPV.jTableRedondoIda.getValueAt(fila, 0)));
                this.vOrigen = String.valueOf(this.vPV.jTableRedondoIda.getValueAt(fila, 1));
                this.vDestino = String.valueOf(this.vPV.jTableRedondoIda.getValueAt(fila, 2));
                this.vHora = String.valueOf(this.vPV.jTableRedondoIda.getValueAt(fila, 4));
                this.precioVuelo = Double.parseDouble(String.valueOf(this.vPV.jTableRedondoIda.getValueAt(fila, 5)));
            }
        }else if(me.getSource() == this.vPV.jTableRedondoRegreso){
            int fila = this.vPV.jTableRedondoIda.rowAtPoint(me.getPoint());
            if(fila>-1) {
                this.id = Integer.parseInt(String.valueOf(this.vPV.jTableRedondoRegreso.getValueAt(fila, 0)));
                this.vOrigen = String.valueOf(this.vPV.jTableRedondoRegreso.getValueAt(fila, 1));
                this.vDestino = String.valueOf(this.vPV.jTableRedondoRegreso.getValueAt(fila, 2));
                this.vHora = String.valueOf(this.vPV.jTableRedondoRegreso.getValueAt(fila, 4));
                this.precioVuelo = Double.parseDouble(String.valueOf(this.vPV.jTableRedondoRegreso.getValueAt(fila, 5)));
            }
        }
    }
    
    private Document generarPdf(String path, int tipo) {
        Document doc = new Document();
        try {
            FontFactory.register("/fonts/Oxygen-Bold.ttf");
            com.itextpdf.text.Image logo = null;
            com.itextpdf.text.Font fuente = FontFactory.getFont("Oxygen-Bold", 22);
            FontFactory.register("/fonts/Oxygen-Regular.ttf");
            com.itextpdf.text.Font fuente2 = FontFactory.getFont("Oxygen-Regular", 13);
            logo = com.itextpdf.text.Image.getInstance("src/img/avion_logo2.png");
            PdfWriter p;
            p = PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
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
            if(vPV.jComboBoxSPago.getSelectedItem().toString().equals("Tarjeta"))
                doc.add(new Paragraph("Nombre: " + this.vPV.jTextNomT.getText(), fuente2));
            else
                doc.add(new Paragraph("Nombre: " + this.vPV.txtfNombreEfec.getText(), fuente2));
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            
            doc.add(new Paragraph("Datos de la compra.", fuente2));
            String infoBol;
            int menor = (int) this.vPV.spnMenor.getValue();
            int adulto = (int) this.vPV.spnAdulto.getValue();
            if(menor == 0) {
                infoBol = String.valueOf(adulto) + " Adulto(s)";
            }
            else {
                infoBol = String.valueOf(adulto) + " Adulto(s) y " + String.valueOf(menor) + " niño(s)";
            }
            doc.add(new Paragraph("Pasajeros: " + infoBol, fuente2));
            doc.add(Chunk.NEWLINE);
            if(vPV.jComboBoxSPago.getSelectedItem().toString().equals("Tarjeta"))
                doc.add(new Paragraph("Vuelo con origen en " + vOrigen + " y destino a " + vDestino + " y Regreso", fuente2));
            else
                doc.add(new Paragraph("Vuelo con origen en " + vOrigen + " y destino a " + vDestino + " y Regreso", fuente2));
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph(this.vPV.lblAsientosPagar.getText(), fuente2));
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Total: $" + formatearPrecio(precioTotal), fuente2));
            
            PdfContentByte pdfC = p.getDirectContent();
            Barcode128 bC = new Barcode128();
            bC.setCode("H1G534tg6dfsdvdsghyo1094710nf.213");
            com.itextpdf.text.Image code = bC.createImageWithBarcode(pdfC, BaseColor.BLACK, BaseColor.BLACK);
            code.setAbsolutePosition(150, 100);
            doc.add(code);
            
            doc.close();
        }catch(FileNotFoundException ex) {
            Logger.getLogger(cUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DocumentException | IOException ex) {
            Logger.getLogger(cUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doc;
    }
    
    private JTextField getTxtTarjetaCompra() {
        return this.vPV.jTextPAN;
    }
    
    private JTextField getTxtVencimiento() {
        return this.vPV.jTextFecha;
    }
    
    private JTextField getTxtCcv() {
       return this.vPV.jTextCVC;
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getSource()==vPV.jcomboxTIdaRedondo){
            if(vPV.jcomboxTIdaRedondo.getSelectedItem().toString().equals("Ida")){
                vPV.jDateChooserRetorn.setVisible(false);
                this.vPV.jPanelRedondo.setVisible(true);
                vPV.jLRetorn.setVisible(false);
                vPV.jTableIDAIDA.setModel(this.mV.getVuelos());
                this.vPV.jTableIDAIDA.getColumn("ID").setPreferredWidth(0);
                this.vPV.jTableIDAIDA.getColumn("ID").setMinWidth(0);
                this.vPV.jTableIDAIDA.getColumn("ID").setWidth(0);
                this.vPV.jTableIDAIDA.getColumn("ID").setMaxWidth(0);
                this.vPV.jPanelIda.setVisible(true);
                this.vPV.jPanelRedondo.setVisible(false);
            }else /*if(vPV.jcomboxTIdaRedondo.getSelectedItem().toString().equals("Redondo"))*/{
                vPV.jDateChooserRetorn.setVisible(true);
                vPV.jLRetorn.setVisible(true);
                vPV.jTableRedondoIda.setModel(this.mV.getVuelos());
                this.vPV.jTableRedondoIda.getColumn("ID").setPreferredWidth(0);
                this.vPV.jTableRedondoIda.getColumn("ID").setMinWidth(0);
                this.vPV.jTableRedondoIda.getColumn("ID").setWidth(0);
                this.vPV.jTableRedondoIda.getColumn("ID").setMaxWidth(0);
                vPV.jTableRedondoRegreso.setModel(this.mV.getVuelos());
                this.vPV.jTableRedondoRegreso.getColumn("ID").setPreferredWidth(0);
                this.vPV.jTableRedondoRegreso.getColumn("ID").setMinWidth(0);
                this.vPV.jTableRedondoRegreso.getColumn("ID").setWidth(0);
                this.vPV.jTableRedondoRegreso.getColumn("ID").setMaxWidth(0);
                this.vPV.jPanelIda.setVisible(false);
                this.vPV.jPanelRedondo.setVisible(true);
            }
        }
        if(ie.getSource() == this.vPV.cmbSeleccion) {
            if(String.valueOf(this.vPV.cmbSeleccion.getSelectedItem()).equals("Individual")) {
                this.tipo = 2;
            }
            else
                this.tipo = 1;
        }
    }
}
