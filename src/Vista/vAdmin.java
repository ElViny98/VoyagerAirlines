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
public class vAdmin extends javax.swing.JFrame {
    /**
     * Creates new form asd
     */
    public vAdmin() {
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
        lblNombre = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnAviones = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnVuelos = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        Inicio = new javax.swing.JPanel();
        jLabelBigLogo = new javax.swing.JLabel();
        Aviones = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAviones = new javax.swing.JTable();
        Usuarios = new javax.swing.JPanel();
        Ventas = new javax.swing.JPanel();
        pnlAsientos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblAsientos = new javax.swing.JLabel();
        Vuelos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelImgSeccion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabelImgBuscar = new javax.swing.JLabel();
        txtBuscarVuelo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnMinimizar = new javax.swing.JButton();
        jLabelSmallLogo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jPanel1.setBackground(new java.awt.Color(213, 216, 223));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 216, 223), 5));
        jPanel1.setMinimumSize(new java.awt.Dimension(240, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContenedor.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre apellido, cargo");
        jPanelMenu.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 215, 40));

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

        btnInicio.setText("Inicio");
        jPanelMenu.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 65, 215, 40));

        btnAviones.setText("Aviones");
        jPanelMenu.add(btnAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 125, 215, 40));

        btnUsuarios.setText("Usuarios");
        jPanelMenu.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 185, 215, 40));

        btnVentas.setText("Ventas");
        jPanelMenu.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 245, 215, 40));

        btnVuelos.setText("Vuelos");
        jPanelMenu.add(btnVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 305, 215, 40));

        btnCerrar.setText("Cerrar sesión");
        jPanelMenu.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 455, 215, 40));

        jPanelContenedor.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 225, 570));

        Inicio.setBackground(new java.awt.Color(255, 255, 255));
        Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBigLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Inicio.add(jLabelBigLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 495, 330));

        jPanelContenedor.add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        Aviones.setBackground(Inicio.getBackground());
        Aviones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        Aviones.setForeground(new java.awt.Color(255, 255, 255));
        Aviones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAviones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAviones.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblAviones);

        Aviones.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 710, 420));

        jPanelContenedor.add(Aviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        Usuarios.setBackground(new java.awt.Color(0, 51, 255));
        Usuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        Usuarios.setForeground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout UsuariosLayout = new javax.swing.GroupLayout(Usuarios);
        Usuarios.setLayout(UsuariosLayout);
        UsuariosLayout.setHorizontalGroup(
            UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        UsuariosLayout.setVerticalGroup(
            UsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPanelContenedor.add(Usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        Ventas.setBackground(new java.awt.Color(255, 51, 51));
        Ventas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        Ventas.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout VentasLayout = new javax.swing.GroupLayout(Ventas);
        Ventas.setLayout(VentasLayout);
        VentasLayout.setHorizontalGroup(
            VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        VentasLayout.setVerticalGroup(
            VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPanelContenedor.add(Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        pnlAsientos.setBackground(Inicio.getBackground());

        jScrollPane1.setViewportView(lblAsientos);

        javax.swing.GroupLayout pnlAsientosLayout = new javax.swing.GroupLayout(pnlAsientos);
        pnlAsientos.setLayout(pnlAsientosLayout);
        pnlAsientosLayout.setHorizontalGroup(
            pnlAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlAsientosLayout.setVerticalGroup(
            pnlAsientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelContenedor.add(pnlAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        Vuelos.setBackground(new java.awt.Color(255, 255, 255));
        Vuelos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Vuelos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(213, 216, 223));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelImgSeccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabelImgSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 60));

        jLabel6.setFont(new java.awt.Font("Sitka Small", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(63, 136, 143));
        jLabel6.setText("VUELOS");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 60));

        Vuelos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 731, 80));

        jPanel3.setBackground(new java.awt.Color(213, 216, 223));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Agregar");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        jButton2.setText("Editar");
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        jButton3.setText("Eliminar");
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 30));

        jLabelImgBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabelImgBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 415, 40, 40));

        txtBuscarVuelo.setFont(new java.awt.Font("Sitka Heading", 0, 12)); // NOI18N
        txtBuscarVuelo.setText("Para buscar");
        jPanel3.add(txtBuscarVuelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 418, 100, 34));

        Vuelos.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 90, 150, 460));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Origen", "Destino", "Salida", "Llegada"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        Vuelos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 540, 420));

        btnRefresh.setContentAreaFilled(false);
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Vuelos.add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 30, 30));

        jPanelContenedor.add(Vuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 10, 735, 570));

        jPanel1.add(jPanelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 105, 990, 590));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSalir.setText("X");
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 50, 50));

        btnMinimizar.setBackground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnMinimizar.setText("-");
        jPanel1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 50, 50));

        jLabelSmallLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelSmallLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 85, 85));

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
    public javax.swing.JPanel Aviones;
    public javax.swing.JPanel Inicio;
    public javax.swing.JPanel Usuarios;
    public javax.swing.JPanel Ventas;
    public javax.swing.JPanel Vuelos;
    public javax.swing.JButton btnAviones;
    public javax.swing.JButton btnCerrar;
    public javax.swing.JButton btnInicio;
    public javax.swing.JButton btnMinimizar;
    public javax.swing.JButton btnRefresh;
    public javax.swing.JButton btnSalir;
    public javax.swing.JButton btnUsuarios;
    public javax.swing.JButton btnVentas;
    public javax.swing.JButton btnVuelos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabelBigLogo;
    public javax.swing.JLabel jLabelImgBuscar;
    public javax.swing.JLabel jLabelImgSeccion;
    public javax.swing.JLabel jLabelSmallLogo;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanelContenedor;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel lblAsientos;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JPanel pnlAsientos;
    public javax.swing.JTable tblAviones;
    public javax.swing.JTextField txtBuscarVuelo;
    // End of variables declaration//GEN-END:variables
}
