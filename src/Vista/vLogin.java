/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author David
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
        pnlSuperior = new javax.swing.JPanel();
        btnSalir = new componente.Boton();
        btnMinimizar = new componente.Boton();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnIniciar = new componente.Boton();
        lblMensajeLogin = new javax.swing.JLabel();
        btnRegistrar = new componente.Boton();
        btnMostrar = new componente.Boton();
        lblPassIcon = new javax.swing.JLabel();
        lblUsuarioIcon = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSuperior.setBackground(new java.awt.Color(0, 0, 0));
        pnlSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setColorHover(new java.awt.Color(45, 45, 45));
        btnSalir.setColorNormal(new java.awt.Color(31, 31, 31));
        btnSalir.setColorPressed(new java.awt.Color(15, 15, 15));
        pnlSuperior.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 2, 35, 30));

        btnMinimizar.setBackground(new java.awt.Color(31, 31, 31));
        btnMinimizar.setColorHover(new java.awt.Color(45, 45, 45));
        btnMinimizar.setColorNormal(new java.awt.Color(31, 31, 31));
        btnMinimizar.setColorPressed(new java.awt.Color(15, 15, 15));
        pnlSuperior.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 2, 35, 30));

        jPanel1.add(pnlSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 590, 40));

        txtUsuario.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setText("Usuario");
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 250, 40));

        txtPass.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setText("**********");
        txtPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 250, 40));

        btnIniciar.setBackground(new java.awt.Color(23, 43, 121));
        btnIniciar.setText("Iniciar sesión");
        btnIniciar.setColorHover(new java.awt.Color(53, 83, 217));
        btnIniciar.setColorNormal(new java.awt.Color(23, 43, 121));
        btnIniciar.setColorPressed(new java.awt.Color(16, 30, 84));
        btnIniciar.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jPanel1.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 145, 35));

        lblMensajeLogin.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        lblMensajeLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblMensajeLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 290, 30));

        btnRegistrar.setBackground(new java.awt.Color(204, 204, 204));
        btnRegistrar.setText("¡Registrarse!");
        btnRegistrar.setColorHover(new java.awt.Color(225, 225, 225));
        btnRegistrar.setColorNormal(new java.awt.Color(204, 204, 204));
        btnRegistrar.setColorPressed(new java.awt.Color(190, 190, 190));
        btnRegistrar.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 145, 35));

        btnMostrar.setBackground(new java.awt.Color(242, 251, 255));
        btnMostrar.setColorHover(new java.awt.Color(244, 252, 255));
        btnMostrar.setColorNormal(new java.awt.Color(242, 251, 255));
        btnMostrar.setColorPressed(new java.awt.Color(213, 242, 255));
        jPanel1.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 40, 40));

        lblPassIcon.setText("Pass");
        jPanel1.add(lblPassIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 40, 40));

        lblUsuarioIcon.setText("User");
        jPanel1.add(lblUsuarioIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 40, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Fondo.jpeg"))); // NOI18N
        lblFondo.setText("jLabel1");
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 45, 590, 600));

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public componente.Boton btnIniciar;
    public componente.Boton btnMinimizar;
    public componente.Boton btnMostrar;
    public componente.Boton btnRegistrar;
    public componente.Boton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFondo;
    public javax.swing.JLabel lblMensajeLogin;
    public javax.swing.JLabel lblPassIcon;
    public javax.swing.JLabel lblUsuarioIcon;
    private javax.swing.JPanel pnlSuperior;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
