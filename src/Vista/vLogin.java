/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Vinicio
 */
public class vLogin extends javax.swing.JFrame {

    /**
     * Creates new form vLogin
     */
    public vLogin() {
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
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlContainer = new javax.swing.JPanel();
        pnlInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnRegistro = new javax.swing.JButton();
        btnOlvido = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblMsj = new javax.swing.JLabel();
        pnlRecuperar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();
        btnCambiar = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblRecuperar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        pnlContra = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblMsjContra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 40)); // NOI18N
        jLabel3.setText("Voyager Airlines");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnlContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel1.setText("Usuario: ");

        txtUsuario.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel2.setText("Contraseña:");

        btnEntrar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnEntrar.setText("Ingresar");
        btnEntrar.setToolTipText("Inicia sesión");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });

        btnRegistro.setBackground(new java.awt.Color(0, 0, 0, 0));
        btnRegistro.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnRegistro.setForeground(new java.awt.Color(0, 51, 255));
        btnRegistro.setText("¿Aún no tienes cuenta? ¡Regístrate! ");
        btnRegistro.setToolTipText("");
        btnRegistro.setBorder(null);
        btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });

        btnOlvido.setBackground(new java.awt.Color(0, 0, 0, 0));
        btnOlvido.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnOlvido.setForeground(new java.awt.Color(0, 51, 255));
        btnOlvido.setText("¿Olvidaste tu contraseña?");
        btnOlvido.setBorder(null);
        btnOlvido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtPass.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        lblMsj.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblMsj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlInicioLayout = new javax.swing.GroupLayout(pnlInicio);
        pnlInicio.setLayout(pnlInicioLayout);
        pnlInicioLayout.setHorizontalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInicioLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnEntrar))
                    .addGroup(pnlInicioLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInicioLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(btnOlvido))
                    .addGroup(pnlInicioLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btnRegistro)))
                .addContainerGap(161, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMsj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInicioLayout.setVerticalGroup(
            pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(pnlInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addComponent(btnOlvido)
                .addGap(18, 18, 18)
                .addComponent(btnRegistro)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar)
                .addGap(49, 49, 49)
                .addComponent(lblMsj)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pnlContainer.add(pnlInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 580, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel5.setText("Nueva contraseña: ");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel6.setText("Confirmar contraseña: ");

        btnCambiar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnCambiar.setText("Aceptar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblRecuperar.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lblRecuperar.setForeground(new java.awt.Color(255, 0, 0));
        lblRecuperar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout pnlRecuperarLayout = new javax.swing.GroupLayout(pnlRecuperar);
        pnlRecuperar.setLayout(pnlRecuperarLayout);
        pnlRecuperarLayout.setHorizontalGroup(
            pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecuperarLayout.createSequentialGroup()
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlRecuperarLayout.createSequentialGroup()
                        .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRecuperarLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRecuperarLayout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCancelar)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 175, Short.MAX_VALUE))
                    .addGroup(pnlRecuperarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRecuperar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRecuperarLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCambiar)
                                .addGap(162, 162, 162)))))
                .addContainerGap())
        );
        pnlRecuperarLayout.setVerticalGroup(
            pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRecuperarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblUsuario)
                .addGap(36, 36, 36)
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(50, 50, 50)
                .addGroup(pnlRecuperarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(lblRecuperar)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pnlContainer.add(pnlRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 320));

        btnVolver.setBackground(new java.awt.Color(255,255,255,0));
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setText("Correo electrónico");

        txtBuscar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnBuscar.setText("Buscar");

        lblMsjContra.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblMsjContra.setForeground(new java.awt.Color(255, 0, 0));
        lblMsjContra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMsjContra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlContraLayout = new javax.swing.GroupLayout(pnlContra);
        pnlContra.setLayout(pnlContraLayout);
        pnlContraLayout.setHorizontalGroup(
            pnlContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContraLayout.createSequentialGroup()
                .addGap(0, 142, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
            .addGroup(pnlContraLayout.createSequentialGroup()
                .addGroup(pnlContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContraLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(btnBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMsjContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContraLayout.setVerticalGroup(
            pnlContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(pnlContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(btnBuscar)
                .addGap(54, 54, 54)
                .addComponent(lblMsjContra)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pnlContainer.add(pnlContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 320));

        getContentPane().add(pnlContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 600, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroActionPerformed

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnCambiar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEntrar;
    public javax.swing.JButton btnOlvido;
    public javax.swing.JButton btnRegistro;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblMsj;
    public javax.swing.JLabel lblMsjContra;
    public javax.swing.JLabel lblRecuperar;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JPanel pnlContainer;
    public javax.swing.JPanel pnlContra;
    public javax.swing.JPanel pnlInicio;
    public javax.swing.JPanel pnlRecuperar;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JPasswordField txtPass1;
    public javax.swing.JPasswordField txtPass2;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
