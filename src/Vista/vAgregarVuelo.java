/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author David
 */
public class vAgregarVuelo extends javax.swing.JFrame {

    /**
     * Creates new form vAgregar
     */
    public vAgregarVuelo() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnSalirAgregar = new javax.swing.JButton();
        lblTituloVuelo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImgOrigen = new javax.swing.JLabel();
        lblImgDestino = new javax.swing.JLabel();
        txtOrigenVuelo = new javax.swing.JTextField();
        txtDestinoVuelo = new javax.swing.JTextField();
        lblSalidaVuelo = new javax.swing.JLabel();
        lblImgTripulacion = new javax.swing.JLabel();
        lblLlegadaVuelo = new javax.swing.JLabel();
        lblImgEscala = new javax.swing.JLabel();
        txtSalidaVuelo = new javax.swing.JTextField();
        txtLlegadaVuelo = new javax.swing.JTextField();
        txtTripulacionVuelo = new javax.swing.JTextField();
        txtEscalaVuelo = new javax.swing.JTextField();
        checkEscalas = new javax.swing.JCheckBox();
        btnAceptarVuelo = new javax.swing.JButton();
        lblImgCalendarVuelo = new javax.swing.JLabel();
        txtFechaVuelo = new javax.swing.JTextField();
        btnBuscarTripulacionVuelo = new javax.swing.JButton();
        txtAvionVuelo = new javax.swing.JTextField();
        lblAvionVuelo = new javax.swing.JLabel();
        btnBuscarAvionVuelo = new javax.swing.JButton();
        btnLimpiarCamposVuelo = new javax.swing.JButton();
        lblImgPrecioVuelo = new javax.swing.JLabel();
        txtPrecioVuelo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(213, 216, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(498, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 128));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalirAgregar.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        btnSalirAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirAgregar.setText("X");
        btnSalirAgregar.setContentAreaFilled(false);
        btnSalirAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnSalirAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 10, 50, 50));

        lblTituloVuelo.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        lblTituloVuelo.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloVuelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloVuelo.setText("Agregar vuelo");
        jPanel3.add(lblTituloVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 496, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 496, 70));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(lblImgOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 50, 50));
        jPanel4.add(lblImgDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 50));

        txtOrigenVuelo.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        txtOrigenVuelo.setText("Ciudad de origen");
        txtOrigenVuelo.setToolTipText("Ciudad de origen");
        jPanel4.add(txtOrigenVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 20, 150, 30));

        txtDestinoVuelo.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        txtDestinoVuelo.setText("Ciudad destino");
        txtDestinoVuelo.setToolTipText("Ciudad destino");
        txtDestinoVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoVueloActionPerformed(evt);
            }
        });
        jPanel4.add(txtDestinoVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 20, 150, 30));
        jPanel4.add(lblSalidaVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 40, 40));
        jPanel4.add(lblImgTripulacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 155, 40, 40));
        jPanel4.add(lblLlegadaVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 88, 40, 40));
        jPanel4.add(lblImgEscala, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 155, 40, 40));

        txtSalidaVuelo.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        txtSalidaVuelo.setText("Hora de salida");
        txtSalidaVuelo.setToolTipText("Hora de salida");
        jPanel4.add(txtSalidaVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 90, 150, 30));

        txtLlegadaVuelo.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        txtLlegadaVuelo.setText("Hora de llegada");
        txtLlegadaVuelo.setToolTipText("Hora de llegada");
        jPanel4.add(txtLlegadaVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 90, 150, 30));

        txtTripulacionVuelo.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        txtTripulacionVuelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTripulacionVuelo.setText("---No. de tripulación---");
        jPanel4.add(txtTripulacionVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 160, 150, 30));

        txtEscalaVuelo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtEscalaVuelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEscalaVuelo.setText("---Escala---");
        jPanel4.add(txtEscalaVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 160, 150, 30));

        checkEscalas.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        checkEscalas.setText("Escalas");
        jPanel4.add(checkEscalas, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 200, -1, -1));

        btnAceptarVuelo.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        btnAceptarVuelo.setText("Aceptar");
        jPanel4.add(btnAceptarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 350, 75, 30));
        jPanel4.add(lblImgCalendarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 40, 40));

        txtFechaVuelo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtFechaVuelo.setText("Fecha de vuelo");
        jPanel4.add(txtFechaVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 235, 150, 30));

        btnBuscarTripulacionVuelo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnBuscarTripulacionVuelo.setText("Buscar tripulación");
        jPanel4.add(btnBuscarTripulacionVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 195, 150, 30));

        txtAvionVuelo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txtAvionVuelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAvionVuelo.setText("---No. de avión---");
        jPanel4.add(txtAvionVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 235, 150, 30));
        jPanel4.add(lblAvionVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 40, 40));

        btnBuscarAvionVuelo.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnBuscarAvionVuelo.setText("Buscar avión");
        jPanel4.add(btnBuscarAvionVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 270, 150, 30));

        btnLimpiarCamposVuelo.setFont(new java.awt.Font("Montserrat", 0, 11)); // NOI18N
        btnLimpiarCamposVuelo.setText("Limpiar campos");
        jPanel4.add(btnLimpiarCamposVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 130, 30));
        jPanel4.add(lblImgPrecioVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 40, 40));

        txtPrecioVuelo.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        txtPrecioVuelo.setText("Precio");
        txtPrecioVuelo.setToolTipText("Precio de vuelo");
        jPanel4.add(txtPrecioVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 285, 150, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 85, 470, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 72, 496, 213));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDestinoVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoVueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoVueloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vAgregarVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vAgregarVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vAgregarVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vAgregarVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vAgregarVuelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptarVuelo;
    public javax.swing.JButton btnBuscarAvionVuelo;
    public javax.swing.JButton btnBuscarTripulacionVuelo;
    public javax.swing.JButton btnLimpiarCamposVuelo;
    public javax.swing.JButton btnSalirAgregar;
    public javax.swing.JCheckBox checkEscalas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel lblAvionVuelo;
    public javax.swing.JLabel lblImgCalendarVuelo;
    public javax.swing.JLabel lblImgDestino;
    public javax.swing.JLabel lblImgEscala;
    public javax.swing.JLabel lblImgOrigen;
    public javax.swing.JLabel lblImgPrecioVuelo;
    public javax.swing.JLabel lblImgTripulacion;
    public javax.swing.JLabel lblLlegadaVuelo;
    public javax.swing.JLabel lblSalidaVuelo;
    public javax.swing.JLabel lblTituloVuelo;
    public javax.swing.JTextField txtAvionVuelo;
    public javax.swing.JTextField txtDestinoVuelo;
    public javax.swing.JTextField txtEscalaVuelo;
    public javax.swing.JTextField txtFechaVuelo;
    public javax.swing.JTextField txtLlegadaVuelo;
    public javax.swing.JTextField txtOrigenVuelo;
    public javax.swing.JTextField txtPrecioVuelo;
    public javax.swing.JTextField txtSalidaVuelo;
    public javax.swing.JTextField txtTripulacionVuelo;
    // End of variables declaration//GEN-END:variables
}
