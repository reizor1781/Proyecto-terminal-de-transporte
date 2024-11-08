/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.flota;

import java.awt.BorderLayout;
import modelo.*;



/**
 *
 * @author DARIO LOPEZ
 */
public class VistaAdminFlota extends javax.swing.JFrame {
    private Caseta caseta;
    private AdminFlota adminFlota;
    /**
     * Creates new form VistaAdminFlota
     */
    public VistaAdminFlota(Caseta caseta , AdminFlota adminFlota) {
        initComponents();
        this.adminFlota = adminFlota;
        this.caseta = caseta;
        adminFlotaName.setText(this.adminFlota.getNombre());
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        content = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelBienvenido = new javax.swing.JLabel();
        adminFlotaName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        vehiculos = new javax.swing.JMenu();
        menuGestionVehiculos = new javax.swing.JMenuItem();
        viajes = new javax.swing.JMenu();
        menuGestionVIajes = new javax.swing.JMenuItem();
        tiquetes = new javax.swing.JMenu();
        menuGestionTiquetes = new javax.swing.JMenuItem();
        devoluciones = new javax.swing.JMenu();
        menuGestionDevoluciones = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 153, 204)));
        content.setPreferredSize(new java.awt.Dimension(885, 671));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        labelBienvenido.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 48)); // NOI18N
        labelBienvenido.setForeground(new java.awt.Color(0, 0, 0));
        labelBienvenido.setText("BIENVENIDO");

        adminFlotaName.setFont(new java.awt.Font("DejaVu Serif", 1, 18)); // NOI18N
        adminFlotaName.setForeground(new java.awt.Color(0, 0, 0));
        adminFlotaName.setText("adminFlotaNombre");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("🌟 Panel de gestión de la Flota 🌟");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cada acción que realices aquí fortalece el funcionamiento eficiente y ordenado de la flota. Utiliza el");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("menú superior para gestionar los recursos disponibles:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Vehículos:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mantén actualizada la flota de vehículos. Registra nuevos vehículos, actualiza detalles importantes y");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("asegura que todos los recursos estén en óptimas condiciones para los viajes.");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Viajes:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Gestiona los viajes con precisión. Programa salidas, consulta detalles, ajusta horarios y asigna");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("vehiculos para mantener el servicio en marcha y bien organizado.");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("✨ Cada gestión que realices acerca a la flota a un nivel de servicio más seguro y confiable.");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("¡Gracias por tu compromiso y dedicación! ✨");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Tiquetes");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("experiencia fluida para cada pasajero que confía en el servicio.");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Supervisa y controla la emisión de tiquetes. Registra ventas, verifica disponibilidad y asegura una");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Devoluciones:");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("trato justo y ágil en cualquier devolución.");

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Administra las devoluciones de manera efectiva. Revisa casos, procesa solicitudes y garantiza un");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminFlotaName, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBienvenido)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(78, 78, 78)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminFlotaName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(0, 0, 0)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(0, 0, 0)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(11, 11, 11))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText(" ©TheCharles'sCousin'sCompany");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2024-10-30 183431 (1).png"))); // NOI18N
        jLabel15.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(206, 206, 206)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jLabel15)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        vehiculos.setText("Vehiculos");

        menuGestionVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Bus.jpg"))); // NOI18N
        menuGestionVehiculos.setText("Gestion");
        menuGestionVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionVehiculosActionPerformed(evt);
            }
        });
        vehiculos.add(menuGestionVehiculos);

        jMenuBar1.add(vehiculos);

        viajes.setText("Viajes");

        menuGestionVIajes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/viaje.jpg"))); // NOI18N
        menuGestionVIajes.setText("Gestion");
        menuGestionVIajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionVIajesActionPerformed(evt);
            }
        });
        viajes.add(menuGestionVIajes);

        jMenuBar1.add(viajes);

        tiquetes.setText("Tiquetes");

        menuGestionTiquetes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tiquetes.png"))); // NOI18N
        menuGestionTiquetes.setText("Gestion");
        menuGestionTiquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionTiquetesActionPerformed(evt);
            }
        });
        tiquetes.add(menuGestionTiquetes);

        jMenuBar1.add(tiquetes);

        devoluciones.setText("Devoluciones");

        menuGestionDevoluciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Devolucion.png"))); // NOI18N
        menuGestionDevoluciones.setText("Gestion");
        devoluciones.add(menuGestionDevoluciones);

        jMenuBar1.add(devoluciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGestionVIajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionVIajesActionPerformed
        VistaGestionViajes vt = new VistaGestionViajes(this.caseta);
        vt.setSize(885, 671);
        vt.setLocation(0,0);
        
        content.removeAll();
        content.add(vt, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_menuGestionVIajesActionPerformed

    private void menuGestionVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionVehiculosActionPerformed
        VistaGestionVehiculo vt = new VistaGestionVehiculo(this.caseta);
        vt.setSize(885, 671);
        vt.setLocation(0,0);
        
        content.removeAll();
        content.add(vt, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_menuGestionVehiculosActionPerformed

    private void menuGestionTiquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionTiquetesActionPerformed
        VistaGestionTiquete vt = new VistaGestionTiquete(this.caseta);
        vt.setSize(885, 671);
        vt.setLocation(0,0);
        
        content.removeAll();
        content.add(vt, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        
    }//GEN-LAST:event_menuGestionTiquetesActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminFlotaName;
    private javax.swing.JPanel content;
    private javax.swing.JMenu devoluciones;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JMenuItem menuGestionDevoluciones;
    private javax.swing.JMenuItem menuGestionTiquetes;
    private javax.swing.JMenuItem menuGestionVIajes;
    private javax.swing.JMenuItem menuGestionVehiculos;
    private javax.swing.JMenu tiquetes;
    private javax.swing.JMenu vehiculos;
    private javax.swing.JMenu viajes;
    // End of variables declaration//GEN-END:variables
}
