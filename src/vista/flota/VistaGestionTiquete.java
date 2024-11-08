/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.flota;

import controlador.flota.ControladorVistaTiquete;
import modelo.*;
import excepciones.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CARLOS
 */
public class VistaGestionTiquete extends javax.swing.JPanel {
    private ControladorVistaTiquete controlador;
    private Caseta caseta;
    /**
     * Creates new form VistaGestionTiquete
     */
    public VistaGestionTiquete(Caseta caseta) {
        initComponents();
        controlador = new ControladorVistaTiquete();
        this.caseta = caseta;
        llenarTablaViajes();
        llenarTablaTiquetes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnVenderTiqueteConReserva = new javax.swing.JButton();
        ViajeSinReserva = new javax.swing.JPanel();
        txtCedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        btnVenderTiqueteSinReserva = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        boxPago = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViajes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTiquetes = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(0, 153, 204)));
        setPreferredSize(new java.awt.Dimension(885, 671));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(870, 660));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Reservas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha de compra", "Valor total", "Cantidad tiquetes", "Cliente (cedula)", "Viaje (id)", "Estado"
            }
        ));
        jScrollPane3.setViewportView(tblReservas);

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Seleccione de la tabla el tiquete");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("al cual desea vender");

        btnVenderTiqueteConReserva.setBackground(new java.awt.Color(204, 153, 255));
        btnVenderTiqueteConReserva.setForeground(new java.awt.Color(255, 255, 255));
        btnVenderTiqueteConReserva.setText("Vender Tiquete");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(btnVenderTiqueteConReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVenderTiqueteConReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ViajeSinReserva.setBackground(new java.awt.Color(255, 255, 255));
        ViajeSinReserva.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Tiquete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        txtCedula.setBackground(new java.awt.Color(204, 204, 204));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cedula del cliente");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cantidad de tiquetes");

        txtCant.setBackground(new java.awt.Color(204, 204, 204));
        txtCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantActionPerformed(evt);
            }
        });

        btnVenderTiqueteSinReserva.setBackground(new java.awt.Color(0, 153, 204));
        btnVenderTiqueteSinReserva.setForeground(new java.awt.Color(255, 255, 255));
        btnVenderTiqueteSinReserva.setText("Vender Tiquete");
        btnVenderTiqueteSinReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderTiqueteSinReservaActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Metodo de Pago");

        boxPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Puntos", "Dinero" }));

        tblViajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Origen", "Destino", "Fecha salida", "Fecha llegada", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblViajes);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Seleciona el viaje el cual va a vender los tiquetes:");

        javax.swing.GroupLayout ViajeSinReservaLayout = new javax.swing.GroupLayout(ViajeSinReserva);
        ViajeSinReserva.setLayout(ViajeSinReservaLayout);
        ViajeSinReservaLayout.setHorizontalGroup(
            ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViajeSinReservaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViajeSinReservaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ViajeSinReservaLayout.createSequentialGroup()
                        .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVenderTiqueteSinReserva)
                            .addGroup(ViajeSinReservaLayout.createSequentialGroup()
                                .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCant)
                                    .addComponent(boxPago, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ViajeSinReservaLayout.setVerticalGroup(
            ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViajeSinReservaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViajeSinReservaLayout.createSequentialGroup()
                        .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ViajeSinReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVenderTiqueteSinReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        tblTiquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Fecha de venta", "Metodo de Pago", "Viaje"
            }
        ));
        jScrollPane2.setViewportView(tblTiquetes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViajeSinReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ViajeSinReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(645, 645, 645))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantActionPerformed

    private void btnVenderTiqueteSinReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderTiqueteSinReservaActionPerformed
        if (!validarCampos()) {
            try {
                int cedula = Integer.parseInt(txtCedula.getText());
                int cantPuestos = Integer.parseInt(txtCant.getText());
                String pago = boxPago.getSelectedItem().toString();
                Cliente cliente = controlador.buscarCliente(cedula);
                Viaje viaje = viajeTabla();
                modelo.Tiquete.cargarContadorId();
                Tiquete tiquete = new Tiquete(LocalDate.now(),cliente,viaje,pago);
                modelo.Tiquete.guardarContadorId();
                controlador.generarTiquete(cantPuestos,this.caseta,viaje,tiquete);
                JOptionPane.showMessageDialog(null, "Se vendio el tiquete con éxito");
                vaciarCampos();
                llenarTablaViajes();
                llenarTablaTiquetes();

            } catch (NoSeleccionoNadaException | UsuarioNoEncontradoONoRegistradoException | NoPuntosException | NoExisteElViajeException | NoAsientosException | ElViajeYaNoEstaDisponibleException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en el formato de los datos ingresados.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar los campos correspondientes");
        }
    }//GEN-LAST:event_btnVenderTiqueteSinReservaActionPerformed
    public void vaciarCampos() {
        txtCedula.setText(null);
        txtCant.setText(null);
        boxPago.setSelectedIndex(0);
    }

    public boolean validarCampos() {
        return txtCedula.getText().isEmpty()
                || txtCant.getText().isEmpty()
                || "Seleccionar".equals(boxPago.getSelectedItem().toString());

    }

    private void llenarTablaViajes() {
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        model.setColumnIdentifiers(new Object[]{"id", "Origen", "Destino", "Fecha Salida", "Fecha llegada", "Valor"});
        ArrayList<Viaje> aux = controlador.getListaViajesDeLaCaseta(this.caseta);
        for (int i = 0; i < aux.size(); i++) {
            Viaje viaje = aux.get(i);
            model.addRow(new Object[]{
                    viaje.getIdViaje(),
                    viaje.getOrigen(),
                    viaje.getDestino(),
                    viaje.getFechaSalida(),
                    viaje.getFechallegada(),
                    viaje.getValor()
            });

        }
        tblViajes.setModel(model);
    }
    private void llenarTablaTiquetes() {
        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        model.setColumnIdentifiers(new Object[]{"id", "fecha venta", "Metodo de pago","Cliente","Destino","Fecha Salida","Fecha llegada","Valor"});
        ArrayList<Viaje> aux = controlador.getListaViajesDeLaCaseta(this.caseta);
        for (int i = 0; i < aux.size(); i++) {
            for (Tiquete tiquete : aux.get(i).getTiquetes()){
                Viaje viaje = aux.get(i);
                model.addRow(new Object[]{
                        tiquete.getIdTiquete(),
                        tiquete.getFechaDeCreacion(),
                        tiquete.getMetodoPago(),
                        tiquete.getCliente(),
                        viaje.getDestino(),
                        viaje.getFechaSalida(),
                        viaje.getFechallegada(),
                        viaje.getValor()
                });
            }


        }
        tblTiquetes.setModel(model);
    }
    public Viaje viajeTabla() throws NoSeleccionoNadaException {
        int filaSeleccionada = tblViajes.getSelectedRow();
        if (filaSeleccionada == -1) {
            throw new NoSeleccionoNadaException();
        }

        Object id = tblViajes.getValueAt(filaSeleccionada, 0);

        if (!(id instanceof Integer)) {
            throw new IllegalArgumentException("El ID de viaje seleccionado no es un número válido.");
        }

        System.out.println("ID seleccionado de la tabla: " + id);

        Viaje viaje = controlador.buscarViajeTabla(this.caseta, (Integer) id);
        if (viaje == null) {
            System.out.println("El viaje con ID " + id + " no está en la empresa.");
        }

        return viaje;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ViajeSinReserva;
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> boxPago;
    private javax.swing.JButton btnVenderTiqueteConReserva;
    private javax.swing.JButton btnVenderTiqueteSinReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTable tblTiquetes;
    private javax.swing.JTable tblViajes;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
