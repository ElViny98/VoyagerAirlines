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
import Modelo.mLogin;
import Vista.vLogin;
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
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class cUsuario implements ActionListener, MouseListener, ItemListener{
    mUsuario mU;
    vUsuario vU;
    Sesion s;
    private int id = 0, x = 0, k = 1;
    private int tipo = 1;
    private ArrayList<String> AsientosS = new ArrayList<>();
    private ArrayList<String> AsientosO = new ArrayList<>();
    private ArrayList<String> DatosUsuario = new ArrayList<>();
    private mAdmin modeloAdmin = new mAdmin();
    private JButton Asientos[] = new JButton[238];
    private JLabel lblNombres[] = new JLabel[238];
    private int sTotal;
    private JFileChooser archivos = new JFileChooser();
    private double precioVuelo, precioTotal;
    private String vOrigen, vDestino, vHora, dir;
    
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
        this.vU.btnVolverAsientos.addActionListener(this);
        this.vU.btnExplorar.addActionListener(this);
        this.vU.btnImprimirReporte.addActionListener(this);
        this.vU.rbtnEfectivo.addActionListener(this);
        this.vU.rbtnTarjeta.addActionListener(this);
        this.vU.txtTarjetaCompra.addActionListener(this);
        this.vU.btnCerrar.addActionListener(this);
        this.vU.btnPagar.addActionListener(this);
        this.vU.btnCompras.addActionListener(this);
        this.vU.btnNoUsar.addActionListener(this);
        
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
        this.vU.pnlFaq.setVisible(false);
        this.vU.btnNoUsar.setVisible(false);
        hacerVisible(this.vU.Inicio);
        
        this.vU.btnReservar.setLayout(null);
        this.vU.btnContinuar.setLayout(null);
        JLabel lblIcon = new JLabel("");
        JLabel lblIcon2 = new JLabel("");
        ImageIcon l = new ImageIcon(getClass().getResource("/img/ic_reservar.png"));
        ImageIcon l2 = new ImageIcon(l.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
        lblIcon.setIcon(l2);
        lblIcon2.setIcon(l2);
        lblIcon.setBounds(180, -3, 64, 64);
        this.vU.btnReservar.add(lblIcon);
        lblIcon2.setBounds(100, -8, 64, 64);
        this.vU.btnContinuar.add(lblIcon2);
        
        this.vU.tblVuelos.setRowHeight(30);
        this.vU.tblCompras.setRowHeight(30);
        
        ImageIcon logo1 = new ImageIcon(getClass().getResource("/img/avion_logo.png"));
        ImageIcon logo2 = new ImageIcon(logo1.getImage().getScaledInstance(this.vU.lblLogo.getWidth(), this.vU.lblLogo.getHeight(), Image.SCALE_DEFAULT));
        
        ImageIcon faq = new ImageIcon(getClass().getResource("/icons/faq.png"));
        ImageIcon faq2 = new ImageIcon(faq.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        this.vU.btnFaq.setIcon(faq2);
        this.vU.lblLogo.setIcon(logo2);
        
        this.vU.lblNombre.setText("Bienvenido(a) " + this.s.getNombre());
        this.vU.pnlFaq.setVisible(false);
        
        this.vU.txtTarjetaCompra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char k = ke.getKeyChar();
                if(!(Character.isDigit(k)) || getTxtTarjetaCompra().getText().length() > 15) {
                    ke.consume();
                }
            }
        });
        
        this.vU.txtVencimiento.addKeyListener(new KeyAdapter() {
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
        
        this.vU.txtCcv.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                char k = ke.getKeyChar();
                if(!(Character.isDigit(k)) || getTxtCcv().getText().length() == 3) {
                    ke.consume();
                }
            }
        });
    }
    
    /**
     * Para hacer visible uno o más componentes a la vez
     * @param comp Uno o mas JComponent's 
     */
    private void hacerVisible(JComponent... comp) {
        int j = 0;
        JComponent[] c = getComponentes();
        for(int i=0; i<c.length; i++) {
            if(comp[j] == c[i] && j<comp.length) {
                c[i].setVisible(true);
                if(comp.length > 1 && j<comp.length - 1)
                    j++;
                    
            }
            else
                c[i].setVisible(false);
        }
    }
    
    private JComponent[] getComponentes() {
        JComponent[] comp = new JComponent[8];
        comp[0] = this.vU.Inicio;
        comp[1] = this.vU.Perfil;
        comp[2] = this.vU.Vuelos;
        comp[3] = this.vU.Compras;
        comp[4] = this.vU.pnlAsientos;
        comp[5] = this.vU.pnlComprar;
        comp[6] = this.vU.pnlEfectivo;
        comp[7] = this.vU.pnlTarjeta;
        return comp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vU.btnPerfil) {
            limpiarCampos();
            AsientosS.clear();
            hacerVisible(this.vU.Perfil);
        }
        
        if(e.getSource() == this.vU.btnInicio) {
            limpiarCampos();
            AsientosS.clear();
            hacerVisible(this.vU.Inicio);
        }
        
        if(e.getSource() ==this.vU.btnVuelos) {
            limpiarCampos();
            AsientosS.clear();
            this.vU.tblVuelos.setModel(this.mU.getVuelos());
            this.vU.cmbOrigenes.setSelectedIndex(0);
            this.vU.cmbRango.setSelectedIndex(0);
            this.vU.lblErrorVuelo.setText("");
            //Esto es para esconder la columna de id
            this.vU.cmbOrigenes.setModel(this.mU.getOrigenes());
            this.vU.tblVuelos.getColumn("ID").setPreferredWidth(0);
            this.vU.tblVuelos.getColumn("ID").setMinWidth(0);
            this.vU.tblVuelos.getColumn("ID").setWidth(0);
            this.vU.tblVuelos.getColumn("ID").setMaxWidth(0);
            hacerVisible(this.vU.Vuelos);
        }
        
        if(e.getSource() == this.vU.btnReservar) {
            AsientosS.clear();
            limpiarCampos();
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
                as++;
            }
            this.vU.lblAsientosPagar.setText(asientos);
            this.vU.lblVueloInfo.setText("Vuelo: " + vOrigen + ", con destino a " + vDestino);
            this.vU.lblVueloHora.setText("Hora de salida: " + vHora);
            this.vU.lblPrecioTotal.setText("Total a pagar: $" + formatearPrecio(precioTotal));
            hacerVisible(this.vU.pnlComprar, this.vU.pnlEfectivo);
        }
        
        if(e.getSource() == this.vU.rbtnEfectivo) {
            hacerVisible(this.vU.pnlComprar, this.vU.pnlEfectivo);
        }
        
        if(e.getSource() == this.vU.rbtnTarjeta) {
            ArrayList<String> datos = this.mU.checarTarjeta(this.s.getId());
            if(!datos.isEmpty()) {
                this.vU.txtNombreTit.setText(datos.get(1));
                String tarjeta = datos.get(2);
                String ccv = datos.get(4);
                char[] t = tarjeta.toCharArray();
                char[] c = ccv.toCharArray();
                for(int i=0; i<t.length; i++) {
                    if(i<12) {
                        t[i] = '*';
                    }
                }
                for(int i=0; i<c.length; i++) {
                    c[i] = '*';
                }
                this.vU.txtTarjetaCompra.setText(String.valueOf(t));
                this.vU.txtCcv.setText(String.valueOf(c));
                this.vU.txtVencimiento.setText(datos.get(3));
                this.vU.txtCcv.setEnabled(false);
                this.vU.txtTarjetaCompra.setEnabled(false);
                this.vU.txtVencimiento.setEnabled(false);
                this.vU.btnNoUsar.setVisible(true);
                this.vU.cmbTipoTarjeta.setSelectedItem(datos.get(0));
                this.vU.chkGuardar.setSelected(true);
                DatosUsuario = datos;
            }
            hacerVisible(this.vU.pnlComprar, this.vU.pnlTarjeta);
        }
        
        if(e.getSource() == this.vU.btnExplorar) {
            archivos.showSaveDialog(vU);
            dir = archivos.getSelectedFile().getAbsolutePath();
            generarPdf(dir, 2);
            int iV = this.mU.realizarCompra(precioTotal, this.s.getId(), 2);
            this.mU.reservarBoleto(id, this.s.getId(), iV, AsientosS);
        }
        
        if(e.getSource() == this.vU.btnImprimirReporte) {
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
            int iV = this.mU.realizarCompra(precioTotal, this.s.getId(), 2);
            this.mU.reservarBoleto(id, this.s.getId(), iV, AsientosS);
        }
        
        if(e.getSource() == this.vU.btnPagar) {
            //Validaciones
            String mensaje = "";
            int m, a;
            String numT = this.vU.txtTarjetaCompra.getText();
            String fechaT = this.vU.txtVencimiento.getText();
            String ccv = this.vU.txtCcv.getText();
            String tipo = (String) this.vU.cmbTipoTarjeta.getSelectedItem();
            
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
                
                this.vU.lblTarjetaError.setText(mensaje);
            }
            else {
                if(this.vU.chkGuardar.isSelected() && !this.vU.btnNoUsar.isVisible()) {
                    this.mU.guardarTarjeta(this.s.getId(), 1, (String) this.vU.cmbTipoTarjeta.getSelectedItem(),
                            this.vU.txtNombreTit.getText(), this.vU.txtTarjetaCompra.getText(),
                            this.vU.txtVencimiento.getText(), this.vU.txtCcv.getText());
                }
                else if(this.vU.chkGuardar.isSelected() && this.vU.btnNoUsar.isVisible()) {
                    this.mU.guardarTarjeta(this.s.getId(), 2, (String) this.vU.cmbTipoTarjeta.getSelectedItem(),
                            this.vU.txtNombreTit.getText(), this.vU.txtTarjetaCompra.getText(),
                            this.vU.txtVencimiento.getText(), this.vU.txtCcv.getText());
                }
                else if(this.vU.chkGuardar.isSelected() && !this.vU.txtTarjetaCompra.isEnabled()) {
                    
                }
                int iV = this.mU.realizarCompra(precioTotal, this.s.getId(), 1);
                System.out.println(iV);
                if(iV>0) {
                    this.mU.reservarBoleto(id, this.s.getId(), iV, AsientosS);
                    archivos.setDialogTitle("Guardar reporte");
                    archivos.showSaveDialog(vU);
                    generarPdf(archivos.getSelectedFile().getAbsolutePath(), 1);
                    hacerVisible(this.vU.Inicio);
                }
            }
        }
        
        if(e.getSource() == this.vU.btnNoUsar) {
            this.vU.txtTarjetaCompra.setEnabled(true);
            this.vU.txtTarjetaCompra.setText("");
            this.vU.txtVencimiento.setEnabled(true);
            this.vU.txtVencimiento.setText("");
            this.vU.txtCcv.setEnabled(true);
            this.vU.txtCcv.setText("");
        }
        
        if(e.getSource() == this.vU.btnPerfil) {
            hacerVisible(this.vU.Perfil);
            ArrayList<String> datos = this.mU.getDatosPerfil(this.s.getId());
            String num = null;
            if(datos.size() == 5) {
                char[] tarjeta = datos.get(4).toCharArray();
                for(int i=0; i<tarjeta.length - 4; i++) {
                    if(i<12) {
                        tarjeta[i] = '*';
                    }
                }
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
            cAlertasPerfil cA = new cAlertasPerfil(vA, this.mU, this.vU);
            cA.iniciarVista();
        }
        
        if(e.getSource() == this.vU.btnVolverAsientos) {
            AsientosS.clear();
            hacerVisible(this.vU.pnlAsientos);
        }
        
        if(e.getSource() == this.vU.btnCompras) {
            AsientosS.clear();
            this.vU.tblCompras.setModel(this.mU.getComprasUsuario(this.s.getId()));
            hacerVisible(this.vU.Compras);
        }
        
        if(e.getSource() == this.vU.btnCerrar) {
            this.s.destruirSesion();
            vLogin vL = new vLogin();
            mLogin mL = new mLogin();
            cLogin cL = new cLogin(mL, vL);
            this.vU.dispose();
            cL.iniciarVista();
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
                this.precioVuelo = Double.parseDouble(String.valueOf(this.vU.tblVuelos.getValueAt(fila, 5)));
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
    
    private Document generarPdf(String path, int tipo) {
        Document doc = new Document();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.now();
        
        
        String fecha = fmt.format(date);
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
            Paragraph da = new Paragraph(fecha);
            da.setAlignment(Element.ALIGN_RIGHT);
            doc.add(da);
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
            
            
            if(tipo == 2) {
                doc.add(Chunk.NEWLINE);
                doc.add(Chunk.NEWLINE);
                doc.add(new Paragraph("Presentar este reporte en el aeropuerto para realizar su pago."));
                doc.add(new Paragraph("Este reporte es válido las siguientes 72 horas desde el momento en que se obtuvo."));
            }
            
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
        return this.vU.txtTarjetaCompra;
    }
    
    private JTextField getTxtVencimiento() {
        return this.vU.txtVencimiento;
    }
    
    private JTextField getTxtCcv() {
       return this.vU.txtCcv;
    }
}
