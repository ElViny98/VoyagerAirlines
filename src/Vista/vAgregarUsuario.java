/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author David
 */
public class vAgregarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form vAgregarUsuario
     */
    public vAgregarUsuario() {
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
        lblTituloUsuario = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblImgNombre = new javax.swing.JLabel();
        lblImgNacionalidad = new javax.swing.JLabel();
        lblImgCiudad = new javax.swing.JLabel();
        lblImgNacimiento = new javax.swing.JLabel();
        lblImgUsuario = new javax.swing.JLabel();
        lblImgPass = new javax.swing.JLabel();
        lblImgTipo = new javax.swing.JLabel();
        txtNacimientoUsuario = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtNacionalidadUsuario = new javax.swing.JTextField();
        txtCiudadUsuario = new javax.swing.JTextField();
        btnAceptarUsuario = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        btnLimpiarCamposUsuario = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxTipoUsuario = new javax.swing.JComboBox<>();
        txtPassUsuario = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(213, 216, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(498, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 100, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalirAgregar.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        btnSalirAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirAgregar.setText("X");
        btnSalirAgregar.setContentAreaFilled(false);
        btnSalirAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(btnSalirAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 10, 50, 50));

        lblTituloUsuario.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        lblTituloUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloUsuario.setText("Agregar usuario");
        jPanel3.add(lblTituloUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 496, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 496, 70));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(lblImgNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 50));
        jPanel4.add(lblImgNacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 50, 50));
        jPanel4.add(lblImgCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 50, 50));
        jPanel4.add(lblImgNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 50, 50));
        jPanel4.add(lblImgUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 50, 50));
        jPanel4.add(lblImgPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 50, 50));
        jPanel4.add(lblImgTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 50, 50));

        txtNacimientoUsuario.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtNacimientoUsuario.setText("Nacimiento");
        txtNacimientoUsuario.setToolTipText("DD/MM/AAAA");
        jPanel4.add(txtNacimientoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 180, 150, 30));

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtNombreUsuario.setText("Apellido, Nombre");
        txtNombreUsuario.setToolTipText("Nombre completo");
        jPanel4.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 60, 380, 30));

        txtNacionalidadUsuario.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtNacionalidadUsuario.setText("Nacionalidad");
        txtNacionalidadUsuario.setToolTipText("Nacionalidad");
        jPanel4.add(txtNacionalidadUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 120, 150, 30));

        txtCiudadUsuario.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtCiudadUsuario.setText("Ciudad");
        txtCiudadUsuario.setToolTipText("Ciudad");
        jPanel4.add(txtCiudadUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 120, 150, 30));

        btnAceptarUsuario.setText("Aceptar");
        jPanel4.add(btnAceptarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 75, 30));

        txtUserName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUserName.setText("Usuario");
        txtUserName.setToolTipText("Nombre de usuario");
        jPanel4.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 270, 150, 30));

        btnLimpiarCamposUsuario.setText("Limpiar campos");
        jPanel4.add(btnLimpiarCamposUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 130, 30));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 225, 450, 5));

        jLabel1.setFont(new java.awt.Font("Sitka Small", 2, 18)); // NOI18N
        jLabel1.setText("Datos personales");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 20, 420, 30));

        jLabel6.setFont(new java.awt.Font("Sitka Small", 2, 18)); // NOI18N
        jLabel6.setText("Datos de usuario");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 230, 420, -1));

        jPanel4.add(cbxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 310, 150, 30));

        txtPassUsuario.setText("Contraseña");
        txtPassUsuario.setToolTipText("Contraseña");
        jPanel4.add(txtPassUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 250, 150, 30));

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
            java.util.logging.Logger.getLogger(vAgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vAgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vAgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vAgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vAgregarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAceptarUsuario;
    public javax.swing.JButton btnLimpiarCamposUsuario;
    public javax.swing.JButton btnSalirAgregar;
    public javax.swing.JComboBox<String> cbxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblImgCiudad;
    public javax.swing.JLabel lblImgNacimiento;
    public javax.swing.JLabel lblImgNacionalidad;
    public javax.swing.JLabel lblImgNombre;
    public javax.swing.JLabel lblImgPass;
    public javax.swing.JLabel lblImgTipo;
    public javax.swing.JLabel lblImgUsuario;
    public javax.swing.JLabel lblTituloUsuario;
    public javax.swing.JTextField txtCiudadUsuario;
    public javax.swing.JTextField txtNacimientoUsuario;
    public javax.swing.JTextField txtNacionalidadUsuario;
    public javax.swing.JTextField txtNombreUsuario;
    public javax.swing.JPasswordField txtPassUsuario;
    public javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
