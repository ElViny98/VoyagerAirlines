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
public class vUsuario extends javax.swing.JFrame {

    /**
     * Creates new form vUsuario
     */
    public vUsuario() {
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
        jPanelContenedor = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnVuelos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        Inicio = new javax.swing.JPanel();
        jLabelBigLogo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        Perfil = new javax.swing.JPanel();
        Compras = new javax.swing.JPanel();
        pnlAsientos = new javax.swing.JPanel();
        pnlImg = new javax.swing.JScrollPane();
        lblAsientos = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spnMenor = new javax.swing.JSpinner();
        spnAdulto = new javax.swing.JSpinner();
        Vuelos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelImgSeccion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVuelos = new javax.swing.JTable();
        cmbRango = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbOrigenes = new javax.swing.JComboBox<>();
        btnReservar = new javax.swing.JButton();
        lblErrorVuelo = new javax.swing.JLabel();
        btnSalirPrograma = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(213, 216, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 216, 223), 5));
        jPanel1.setMinimumSize(new java.awt.Dimension(240, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanelMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 45, 215, -1));

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TODOS LOS DERECHOS RESERVADOS");
        jPanelMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 505, 215, 20));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VOYAGER AIRLINES");
        jPanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 525, 215, 20));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Versión 1.0");
        jPanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 545, 215, 20));

        btnInicio.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnInicio.setText("Inicio");
        jPanelMenu.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 215, 40));

        btnPerfil.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnPerfil.setText("Perfil");
        jPanelMenu.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 125, 215, 40));

        btnCompras.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnCompras.setText("Compras");
        jPanelMenu.add(btnCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 185, 215, 40));

        btnVuelos.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnVuelos.setText("Vuelos");
        jPanelMenu.add(btnVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 245, 215, 40));

        btnCerrar.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        btnCerrar.setText("Cerrar sesión");
        jPanelMenu.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 455, 215, 40));

        lblFecha.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("29 de Marzo de 2018");
        jPanelMenu.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        jPanelContenedor.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 225, 570));

        Inicio.setBackground(new java.awt.Color(255, 255, 255));
        Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBigLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Inicio.add(jLabelBigLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 495, 330));

        lblNombre.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre apellido, cargo");
        Inicio.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 730, 40));

        jPanelContenedor.add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        Perfil.setBackground(new java.awt.Color(0, 51, 255));
        Perfil.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        Perfil.setForeground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout PerfilLayout = new javax.swing.GroupLayout(Perfil);
        Perfil.setLayout(PerfilLayout);
        PerfilLayout.setHorizontalGroup(
            PerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        PerfilLayout.setVerticalGroup(
            PerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPanelContenedor.add(Perfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        Compras.setBackground(new java.awt.Color(255, 51, 51));
        Compras.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        Compras.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout ComprasLayout = new javax.swing.GroupLayout(Compras);
        Compras.setLayout(ComprasLayout);
        ComprasLayout.setHorizontalGroup(
            ComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        ComprasLayout.setVerticalGroup(
            ComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPanelContenedor.add(Compras, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        pnlAsientos.setBackground(new java.awt.Color(255, 255, 255));
        pnlAsientos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlImg.setViewportView(lblAsientos);

        pnlAsientos.add(pnlImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 322, 570));

        lblNombreCliente.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        pnlAsientos.add(lblNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel9.setText("Niños:");
        pnlAsientos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 204, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel4.setText("Adultos:");
        pnlAsientos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 253, -1, -1));

        spnMenor.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        spnMenor.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        pnlAsientos.add(spnMenor, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        spnAdulto.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        spnAdulto.setModel(new javax.swing.SpinnerNumberModel(1, 0, 99, 1));
        pnlAsientos.add(spnAdulto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, -1));

        jPanelContenedor.add(pnlAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        Vuelos.setBackground(new java.awt.Color(255, 255, 255));
        Vuelos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Vuelos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(213, 216, 223));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImgSeccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabelImgSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 28)); // NOI18N
        jLabel6.setText("PRÓXIMOS VUELOS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 430, 60));

        Vuelos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 731, 80));

        tblVuelos.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        tblVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Origen", "Destino", "Salida", "Llegada"
            }
        ));
        tblVuelos.setToolTipText("");
        tblVuelos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblVuelos);

        Vuelos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 700, 290));

        cmbRango.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cmbRango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Una semana", "Dos semanas", "Un mes" }));
        Vuelos.add(cmbRango, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 395, 150, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel7.setText("Mostrar vuelos salientes en:");
        Vuelos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        jLabel8.setText("Mostrar vuelos con destino a:");
        Vuelos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        cmbOrigenes.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cmbOrigenes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Vuelos.add(cmbOrigenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 445, 150, -1));

        btnReservar.setBackground(new java.awt.Color(0, 32, 209));
        btnReservar.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        btnReservar.setForeground(new java.awt.Color(255, 255, 255));
        btnReservar.setText("   ¡Reservar este vuelo!");
        btnReservar.setBorder(null);
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Vuelos.add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 250, 60));

        lblErrorVuelo.setBackground(new java.awt.Color(255, 255, 255));
        lblErrorVuelo.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        lblErrorVuelo.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorVuelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Vuelos.add(lblErrorVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 700, -1));

        jPanelContenedor.add(Vuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        jPanel1.add(jPanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 105, 990, 590));

        btnSalirPrograma.setBackground(new java.awt.Color(255, 255, 255));
        btnSalirPrograma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSalirPrograma.setText("X");
        jPanel1.add(btnSalirPrograma, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 50, 50));

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnMinimizar.setText("-");
        jPanel1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 50, 50));

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 85, 85));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("VOYAGER AIRLINES");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 30, 450, 45));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Compras;
    public javax.swing.JPanel Inicio;
    public javax.swing.JPanel Perfil;
    public javax.swing.JPanel Vuelos;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnCompras;
    public javax.swing.JButton btnInicio;
    public javax.swing.JButton btnMinimizar;
    public javax.swing.JButton btnPerfil;
    public javax.swing.JButton btnReservar;
    public javax.swing.JButton btnSalirPrograma;
    public javax.swing.JButton btnVuelos;
    public javax.swing.JComboBox<String> cmbOrigenes;
    public javax.swing.JComboBox<String> cmbRango;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelBigLogo;
    public javax.swing.JLabel jLabelImgSeccion;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JLabel lblAsientos;
    public javax.swing.JLabel lblErrorVuelo;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblLogo;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblNombreCliente;
    public javax.swing.JPanel pnlAsientos;
    public javax.swing.JScrollPane pnlImg;
    public javax.swing.JSpinner spnAdulto;
    public javax.swing.JSpinner spnMenor;
    public javax.swing.JTable tblVuelos;
    // End of variables declaration//GEN-END:variables
}
