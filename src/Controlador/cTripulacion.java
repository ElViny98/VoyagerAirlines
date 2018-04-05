/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.*;
import Modelo.*;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class cTripulacion implements ActionListener, MouseListener {
    //==========================Variables a utilizar==========================//
    private int idBuscar;
    private int tipoEditar = 0;
    private String[] datos;
    //======================Para la ventana de tripulacion====================//
    private vAgregarTripulacion tripulacion;
    private mTripulacion modeloTripulacion = new mTripulacion();
    //============================Para las alertas============================//
    private vAlerta alerta = new vAlerta();
    //=======Constructor para la ventana de Agregar o Editar tripulacion======//
    public cTripulacion(vAgregarTripulacion tripulacion, int opcion, int idBuscar){
        //==========Íconos//==========//
        ImageIcon user = new ImageIcon(getClass().getResource(("/img/user.png")));
        ImageIcon personal = new ImageIcon(getClass().getResource(("/icons/empleados.png")));
        ImageIcon hashtag = new ImageIcon(getClass().getResource(("/icons/hashtag.png")));
        //==========Imágenes de tamaño específico==========//
        ImageIcon usuario = new ImageIcon(user.getImage().getScaledInstance(tripulacion.lblImgNombre.getWidth(), tripulacion.lblImgNombre.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon puesto = new ImageIcon(personal.getImage().getScaledInstance(tripulacion.lblPuestoTripulacion.getWidth(), tripulacion.lblPuestoTripulacion.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon numero = new ImageIcon(hashtag.getImage().getScaledInstance(tripulacion.lblNumTripulacion.getWidth(), tripulacion.lblNumTripulacion.getHeight(), Image.SCALE_DEFAULT));
        //==========Enviar imagen a componente==========//
        tripulacion.lblImgNombre.setIcon(usuario);
        tripulacion.lblPuestoTripulacion.setIcon(puesto);
        tripulacion.lblNumTripulacion.setIcon(numero);
        switch(opcion){
            //==========Ventana de agregar==========//
            case 1:
                this.tripulacion = tripulacion;
                
                this.tripulacion.btnAceptarTripulacion.addActionListener(this);
                this.tripulacion.btnSalirAgregar.addActionListener(this);
                this.tripulacion.btnLimpiarCamposTripulacion.addActionListener(this);
                this.tripulacion.cbxPuesto.addItem("---Puesto---");
                this.tripulacion.cbxPuesto.addItem("Piloto");
                this.tripulacion.cbxPuesto.addItem("Copiloto");
                this.tripulacion.cbxPuesto.addItem("Azafata(o)");
                break;
            //===Ventana de editar===//
            case 2:
                this.tripulacion = tripulacion;
                this.idBuscar = idBuscar;
                
                this.tripulacion.btnAceptarTripulacion.addActionListener(this);
                this.tripulacion.btnSalirAgregar.addActionListener(this);
                this.tripulacion.btnLimpiarCamposTripulacion.addActionListener(this);
                this.tripulacion.cbxPuesto.addItem("---Puesto---");
                this.tripulacion.cbxPuesto.addItem("Piloto");
                this.tripulacion.cbxPuesto.addItem("Copiloto");
                this.tripulacion.cbxPuesto.addItem("Azafata(o)");
                
                this.tripulacion.lblTituloTripulacion.setText("Editar tripulante");
                this.datos = modeloTripulacion.consultaTripulacionEspecifico(this.idBuscar);
                
                this.tripulacion.txtNombreTripulacion.setText(datos[1]);
                this.tripulacion.txtTripulacion.setText(datos[4]);
                switch(datos[2]){
                    case "Piloto":
                        this.tripulacion.cbxPuesto.set
                        break;
                }
                
                break;
            case 3:
                break;
        }
        //=====Método para agregar placeholder al campo de origen=====//
        tripulacion.txtNombreTripulacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        //=====Método para agregar placeholder al campo de Destino====//
        tripulacion.txtTripulacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTripulacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTripulacionFocusLost(evt);
            }
        });
        
    }
    
    //==========Método para iniciar la ventana para agregar un vuelo==========//
    public void iniciarAgregar(){
        tripulacion.pack();
        tripulacion.setLocationRelativeTo(null);
        tripulacion.setVisible(true);
    }
    
    public void limpiarCamposTripulacion(){
        System.out.println("Entrar");
        tripulacion.txtNombreTripulacion.setText("Apellido, Nombre");
        tripulacion.txtTripulacion.setText("No. tripulación");
        tripulacion.cbxPuesto.setSelectedIndex(0);
    }
    
    //===========Métodos para colocar placeholder al campo de origen==========//
    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(tripulacion.txtNombreTripulacion.getText().equals("Apellido, Nombre")){
            tripulacion.txtNombreTripulacion.setText("");
        }
    }                                          
    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(tripulacion.txtNombreTripulacion.getText().equals("")){
            tripulacion.txtNombreTripulacion.setText("Apellido, Nombre");
        }
    }
    //==========Métodos para colocar placeholder al campo de destino==========//
    private void txtTripulacionFocusGained(java.awt.event.FocusEvent evt) {                                           
        if(tripulacion.txtTripulacion.getText().equals("No. tripulación")){
            tripulacion.txtTripulacion.setText("");
        }
    }                                          
    private void txtTripulacionFocusLost(java.awt.event.FocusEvent evt) {                                         
        if(tripulacion.txtTripulacion.getText().equals("")){
            tripulacion.txtTripulacion.setText("No. tripulación");
        }
    }
    //===Método para conocer si un dato es numérico o no===//
    public boolean isNumeric(String cadena) {
        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tripulacion.btnAceptarTripulacion == e.getSource()){
            //===Verificar que los datos no estén vacíos o sin completar===//
            if(tripulacion.txtNombreTripulacion.getText().equals("Apellido, Nombre") || tripulacion.cbxPuesto.getSelectedIndex() == 0)
            {
                cAlertas mostrarAlerta = new cAlertas(alerta);
                mostrarAlerta.agregarContenido(2, "¡COMPLETAR TODOS LOS CAMPOS!");
                mostrarAlerta.iniciarAlerta();
            }
            else
            {   
                //===Si el dato no es numérico===//
                if(!isNumeric(tripulacion.txtTripulacion.getText())){
                    cAlertas mostrarAlerta = new cAlertas(alerta);
                    mostrarAlerta.agregarContenido(3, "¡ALGO HA SALIDO MAL!");
                    mostrarAlerta.iniciarAlerta();
                } 
                //===El dato sí es numérico===//
                else{
                    int numTripulacion;
                    if(tripulacion.txtTripulacion.getText().equals("No. tripulación") || tripulacion.txtTripulacion.equals(""))
                        numTripulacion = 0;
                    else
                        numTripulacion = Integer.parseInt(tripulacion.txtTripulacion.getText());

                    if(modeloTripulacion.tripulacionAgregar(tripulacion.txtNombreTripulacion.getText(), tripulacion.cbxPuesto.getSelectedItem().toString(), numTripulacion))
                    {
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(1, "¡TRABAJADOR AGREGADO CON ÉXITO!");
                        mostrarAlerta.iniciarAlerta();
                        tripulacion.dispose();
                    } else{
                        cAlertas mostrarAlerta = new cAlertas(alerta);
                        mostrarAlerta.agregarContenido(3, "¡ALGO HA SALIDO MAL!");
                        mostrarAlerta.iniciarAlerta();
                    }
                }
            }
        }
        else if(tripulacion.btnLimpiarCamposTripulacion == e.getSource()){
            limpiarCamposTripulacion();
        }
        if(tripulacion.btnSalirAgregar == e.getSource()){
            tripulacion.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
