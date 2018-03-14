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
public class vVuelos extends javax.swing.JFrame {

    /**
     * Creates new form vVuelos
     */
    public vVuelos() {
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon avion_logo = new ImageIcon(getClass().getResource(("/img/avion_logo.png")));
        ImageIcon usuario = new ImageIcon(getClass().getResource(("/img/usuario.png")));
        
        ImageIcon logotipo = new ImageIcon(avion_logo.getImage().getScaledInstance(jLabelLogo.getWidth(), jLabelLogo.getHeight(), Image.SCALE_DEFAULT));
        ImageIcon user = new ImageIcon(usuario.getImage().getScaledInstance(jLabelUsuarioImagen.getWidth(), jLabelUsuarioImagen.getHeight(), Image.SCALE_DEFAULT));
        
        jLabelLogo.setIcon(logotipo);
        jLabelUsuarioImagen.setIcon(user);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContainer = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jLabelUsuarioImagen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelNombreUser = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanelSuperior = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelNombreLogo = new javax.swing.JLabel();
        jLabelSeccion = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jPanelOpciones = new javax.swing.JPanel();
        jButtonAgregarVuelo = new javax.swing.JButton();
        jButtonEliminarVuelo = new javax.swing.JButton();
        jButtonModificarVuelo = new javax.swing.JButton();
        jLabelOpciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContainer.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(128, 0, 0));

        jLabelNombreUser.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabelNombreUser.setForeground(new java.awt.Color(153, 153, 153));
        jLabelNombreUser.setText("Nombre de usuario");

        jButton1.setBackground(new java.awt.Color(128, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Inicio");
        jButton1.setBorder(null);

        jButton2.setBackground(new java.awt.Color(128, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Aviones");
        jButton2.setBorder(null);

        jButton3.setBackground(new java.awt.Color(128, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Usuarios");
        jButton3.setBorder(null);

        jButton4.setBackground(new java.awt.Color(128, 0, 0));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Ventas");

        jButton5.setBackground(new java.awt.Color(255, 0, 0));
        jButton5.setForeground(new java.awt.Color(204, 204, 204));
        jButton5.setText("Vuelos");
        jButton5.setBorder(null);

        jButton6.setBackground(new java.awt.Color(128, 0, 0));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Cerrar sesión");
        jButton6.setBorder(null);

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabelUsuarioImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2))))
                .addContainerGap())
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelUsuarioImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelNombreUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelContainer.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 200, 595));

        jPanelSuperior.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(128, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabelNombreLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNombreLogo.setFont(new java.awt.Font("Montserrat", 2, 36)); // NOI18N
        jLabelNombreLogo.setText("VOYAGER AIRLINES");

        jLabelSeccion.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabelSeccion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeccion.setText("TEXTO");

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("X");
        jButtonSalir.setContentAreaFilled(false);
        jButtonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                        .addGap(0, 546, Short.MAX_VALUE)
                        .addComponent(jLabelSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                        .addComponent(jLabelNombreLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalir))))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGroup(jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombreLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSeccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelContainer.add(jPanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        jPanelOpciones.setBackground(new java.awt.Color(255, 255, 255));
        jPanelOpciones.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(153, 153, 153)));
        jPanelOpciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAgregarVuelo.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButtonAgregarVuelo.setText("Agregar");
        jPanelOpciones.add(jButtonAgregarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 40));

        jButtonEliminarVuelo.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButtonEliminarVuelo.setText("Modificar");
        jPanelOpciones.add(jButtonEliminarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 100, 40));

        jButtonModificarVuelo.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        jButtonModificarVuelo.setText("Eliminar");
        jPanelOpciones.add(jButtonModificarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 100, 40));

        jPanelContainer.add(jPanelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 680, 80));

        jLabelOpciones.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabelOpciones.setText("OPCIONES");
        jPanelContainer.add(jLabelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        getContentPane().add(jPanelContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 675));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(vVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vVuelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonAgregarVuelo;
    private javax.swing.JButton jButtonEliminarVuelo;
    private javax.swing.JButton jButtonModificarVuelo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombreLogo;
    private javax.swing.JLabel jLabelNombreUser;
    private javax.swing.JLabel jLabelOpciones;
    public javax.swing.JLabel jLabelSeccion;
    private javax.swing.JLabel jLabelUsuarioImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
