/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package proyecto_gm.RecibosHonorarios;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import proyecto_gm.Exportar;

/**
 *
 * @author EduardoPC
 */
public class frmRecibosHonorarios extends javax.swing.JInternalFrame {

    boolean esNuevo = false;

    public frmRecibosHonorarios() {
        initComponents();
        JTableHeader header = tblHonorarios.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(JLabel.CENTER);
                setBackground(Color.DARK_GRAY);
                setForeground(Color.WHITE);
                setFont(getFont().deriveFont(Font.BOLD, 13));
                return this;
            }
        });

        DefaultTableModel modelo = (DefaultTableModel) tblHonorarios.getModel();

        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        DatosRecibosHonorarios.Habilitar(escritorio, false);

        DatosRecibosHonorarios.Mostrar(modelo);
        tblHonorarios.setCellSelectionEnabled(false);
        tblHonorarios.setRowSelectionAllowed(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtApe = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDirec = new javax.swing.JTextField();
        txtIR = new javax.swing.JTextField();
        txtConcepto = new javax.swing.JTextField();
        cboPago = new javax.swing.JComboBox<>();
        cboDistrito = new javax.swing.JComboBox<>();
        txtImpNeto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtImpTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHonorarios = new javax.swing.JTable();
        txtFecEmi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNroRecibo = new javax.swing.JTextField();
        btnExportar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("RECIBOS POR HONORARIOS");
        setToolTipText(null);

        escritorio.setBackground(new java.awt.Color(255, 248, 239));
        escritorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        escritorio.setFocusCycleRoot(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        btnNuevo.setName("nuevo"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        btnEditar.setName("editar"); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/eliminar.png"))); // NOI18N
        btnEliminar.setName("eliminar"); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardar.png"))); // NOI18N
        btnGuardar.setName("guardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regresar.png"))); // NOI18N
        btnCancelar.setName("cancelar"); // NOI18N
        btnCancelar.setNextFocusableComponent(txtNroRecibo);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nro. Recibo:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("RUC:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Distrito:");

        jLabel7.setText("Apellidos:");

        txtRuc.setNextFocusableComponent(txtNom);
        txtRuc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRucFocusLost(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });

        txtApe.setNextFocusableComponent(cboDistrito);
        txtApe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApeFocusLost(evt);
            }
        });

        txtNom.setNextFocusableComponent(txtApe);
        txtNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomFocusLost(evt);
            }
        });

        jLabel8.setText("Concepto:");

        jLabel9.setText("Forma de pago:");

        jLabel10.setText("Importe Neto:");

        jLabel11.setText("Retención IR:");

        txtDirec.setNextFocusableComponent(cboPago);
        txtDirec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDirecFocusLost(evt);
            }
        });

        txtIR.setNextFocusableComponent(txtConcepto);
        txtIR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIRFocusLost(evt);
            }
        });
        txtIR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIRKeyTyped(evt);
            }
        });

        txtConcepto.setNextFocusableComponent(txtFecEmi);

        cboPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Seleccionar>>",  "Transferencia", "Al contado" }));
        cboPago.setNextFocusableComponent(txtImpNeto);
        cboPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPagoActionPerformed(evt);
            }
        });

        cboDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "<<Seleccionar>>",
            "Ancón",
            "Ate",
            "Barranco",
            "Breña",
            "Carabayllo",
            "Chaclacayo",
            "Chorrillos",
            "Cieneguilla",
            "Comas",
            "El Agustino",
            "Independencia",
            "Jesús María",
            "La Molina",
            "La Victoria",
            "Lima",
            "Lince",
            "Los Olivos",
            "Lurigancho",
            "Lurin",
            "Magdalena del Mar",
            "Miraflores",
            "Pachacamac",
            "Pucusana",
            "Pueblo Libre",
            "Puente Piedra",
            "Punta Hermosa",
            "Punta Negra",
            "Rímac",
            "San Bartolo",
            "San Borja",
            "San Isidro",
            "San Juan de Lurigancho",
            "San Juan de Miraflores",
            "San Luis",
            "San Martín de Porres",
            "San Miguel",
            "Santa Anita",
            "Santa María del Mar",
            "Santa Rosa",
            "Santiago de Surco",
            "Surquillo",
            "Villa El Salvador",
            "Villa María del Triunfo"
        }));
        cboDistrito.setNextFocusableComponent(txtDirec);

        txtImpNeto.setNextFocusableComponent(txtIR);
        txtImpNeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtImpNetoFocusLost(evt);
            }
        });
        txtImpNeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImpNetoKeyTyped(evt);
            }
        });

        jLabel12.setText("Importe Total:");

        txtImpTotal.setEditable(false);

        tblHonorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NRO. RECIBO", "RUC", "NOMBRES", "APELLIDOS", "DISTRITO", "DIRECCIÓN", "F. PAGO", "CONCEPTO", "IMP. NETO", "RETENCIÓN IR", "IMP. TOTAL", "FEC. EMISIÓN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHonorarios.setFocusable(false);
        tblHonorarios.setRowHeight(25);
        tblHonorarios.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tblHonorarios.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblHonorarios.setShowGrid(true);
        tblHonorarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblHonorarios);
        if (tblHonorarios.getColumnModel().getColumnCount() > 0) {
            tblHonorarios.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        txtFecEmi.setNextFocusableComponent(btnGuardar);
        txtFecEmi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFecEmiKeyTyped(evt);
            }
        });

        jLabel13.setText("Fec. Emisión:");

        txtNroRecibo.setActionCommand("<Not Set>");
        txtNroRecibo.setFocusCycleRoot(true);
        txtNroRecibo.setNextFocusableComponent(txtRuc);
        txtNroRecibo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNroReciboKeyTyped(evt);
            }
        });

        btnExportar.setText("Exportar a Excel");
        btnExportar.setName("exportar"); // NOI18N
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboPago, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12))
                            .addComponent(jLabel13))
                        .addGap(37, 37, 37)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecEmi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIR, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImpTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(209, 209, 209))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtImpNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExportar)
                        .addGap(45, 45, 45))))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(19, 19, 19))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cboDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtNroRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(cboPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtImpTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtFecEmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtImpNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnExportar)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OcultarColumna(JTable tabla, int indiceColumna) {
        TableColumn col = tabla.getColumnModel().getColumn(indiceColumna);
        TableColumnModel tcm = tabla.getColumnModel();
        tcm.removeColumn(col);
    }

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        DatosRecibosHonorarios.Habilitar(escritorio, true);
        String codigo = DatosRecibosHonorarios.GenerarCodigo();

        if (codigo != null) {
            txtId.setText(codigo);
            txtId.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al generar el código.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txtId.requestFocus();
        txtNroRecibo.setText("NUM-");
        txtNroRecibo.requestFocus();

        esNuevo = true;
        tblHonorarios.setRowSelectionAllowed(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Agrupar las cajas de texto
        JTextField[] camposTexto = {txtId, txtNroRecibo, txtRuc, txtNom, txtApe,
            txtDirec, txtConcepto, txtImpNeto, txtIR, txtImpTotal, txtFecEmi};
        JComboBox[] combos = {cboDistrito, cboPago};

        DatosRecibosHonorarios.Editar(escritorio, tblHonorarios, camposTexto, combos);
        esNuevo = false; // Indicamos que no sera un nuevo registro
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DatosRecibosHonorarios.Eliminar(tblHonorarios);
        DatosRecibosHonorarios.Habilitar(escritorio, false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String distrito = null;
        String pago = null;

        if (cboDistrito.getSelectedItem() == null || cboPago.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona un valor en los combo boxes.");
            return; // Se detiene el proceso si algún combo box no tiene selección
        } else {
            distrito = cboDistrito.getSelectedItem().toString();
            pago = cboPago.getSelectedItem().toString();
        }

        if (txtImpNeto.getText().isEmpty() || txtIR.getText().isEmpty() || txtImpTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa los campos de importe.");
            return; // Se detiene el proceso si algún campo de importe está vacío
        }

        if (txtId == null || txtNroRecibo == null || txtRuc == null || txtNom == null || txtApe == null || txtDirec == null || txtImpNeto == null || txtConcepto == null || txtFecEmi == null) {
            JOptionPane.showMessageDialog(null, "Alguno de los campos no está inicializado.");
            return; // Se detiene el proceso si algún campo no está inicializado
        }

        if (txtId.getText().isEmpty() || txtRuc.getText().isEmpty() || txtNom.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completar bien los campos");
            return; // Se detiene el proceso si los campos requeridos están vacíos
        }

        if (!txtId.getText().matches("^[A-Z]{3}[0-9]{4}$")) {
            JOptionPane.showMessageDialog(null, "El formato del Id es incorrecto. Debe ser 'CAR0002'.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtId.requestFocus();
            return; // Se detiene el proceso si el formato del Id no es correcto
        }

        ReciboHonorario rec = new ReciboHonorario(
                txtId.getText(),
                txtNroRecibo.getText(),
                txtRuc.getText(),
                txtNom.getText(),
                txtApe.getText(),
                distrito, // Asignación del distrito seleccionado
                txtDirec.getText(),
                pago, // Asignación del pago seleccionado
                txtConcepto.getText(),
                txtFecEmi.getText(),
                Float.parseFloat(txtImpNeto.getText()),
                Float.parseFloat(txtIR.getText()),
                Float.parseFloat(txtImpTotal.getText())
        );

        JTextField[] campos = {txtNroRecibo, txtRuc, txtNom, txtApe, txtDirec, txtImpNeto, txtConcepto, txtFecEmi};
        JComboBox[] combos = {cboDistrito, cboPago};

        if (!DatosRecibosHonorarios.Validar(campos, combos)) {
            return; // Se corta la ejecución del botón si la validación no es exitosa
        }

        if (esNuevo) {
            if (txtId.getText().isEmpty() || txtRuc.getText().isEmpty() || txtNom.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completar bien los campos");
                return; // Se detiene el proceso si los campos están vacíos
            } else {
                // Se realiza la inserción del nuevo recibo
                if (DatosRecibosHonorarios.Insertar(rec, tblHonorarios)) {
                    DatosRecibosHonorarios.Limpiar(escritorio);
                    DatosRecibosHonorarios.Habilitar(escritorio, false);
                    tblHonorarios.clearSelection();
                    tblHonorarios.setRowSelectionAllowed(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Actualiza el recibo existente
            if (txtId.getText().isEmpty() || txtRuc.getText().isEmpty() || txtNom.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Completar bien los campos");
                return; // Se detiene el proceso si los campos están vacíos
            } else {
                rec.setCodigoRecibo(txtId.getText());
                DatosRecibosHonorarios.Actualizar(rec, tblHonorarios);
                DatosRecibosHonorarios.Limpiar(escritorio);
                DatosRecibosHonorarios.Habilitar(escritorio, false);
                tblHonorarios.clearSelection();
                tblHonorarios.setRowSelectionAllowed(true);
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        DatosRecibosHonorarios.Limpiar(escritorio);
        DatosRecibosHonorarios.Habilitar(escritorio, false);
        tblHonorarios.clearSelection();
        tblHonorarios.setRowSelectionAllowed(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtImpNetoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImpNetoFocusLost
        String impBruto = txtImpNeto.getText();
        if (impBruto.isEmpty()) {
            impBruto = "0.00";
            txtImpNeto.setText(impBruto); // Agrega esta línea para establecer el valor en la caja de texto
        }
        float rentaBruta = Float.parseFloat(impBruto);
        float ir = Math.round(rentaBruta * 0.08f * 100.0f) / 100.0f;
        txtIR.setText(String.valueOf(ir));
        txtIR.selectAll(); // Agrega esta línea para seleccionar el contenido de txtIR
    }//GEN-LAST:event_txtImpNetoFocusLost

    private void txtFecEmiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecEmiKeyTyped
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_BACK_SPACE) {
            // permitir eliminar el carácter anterior incluso si es una diagonal
            String fecha = txtFecEmi.getText();
            if (!fecha.isEmpty()) {
                // eliminar el último carácter de la cadena
                fecha = fecha.substring(0, fecha.length() - 1);
                txtFecEmi.setText(fecha);
            }
        } else if (!Character.isDigit(c)) {
            evt.consume(); // Si no es un número, se ignora el evento de tecla
        }

        String fecha = txtFecEmi.getText();
        int length = fecha.length();
        if (length == 2 || length == 5) { // Si se ha ingresado un día o un mes completo, se agrega el guión correspondiente
            fecha += "/";
            txtFecEmi.setText(fecha);
        }

        if (length >= 10) {
            evt.consume(); // Si ya se ha ingresado la fecha completa, se ignora el evento de tecla
        }
    }//GEN-LAST:event_txtFecEmiKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        char c = evt.getKeyChar();
        if (!((c >= '0') && (c <= '9') || (c == evt.VK_BACK_SPACE) || (c == evt.VK_DELETE))) {
            evt.consume();// Si no es un número, se ignora el evento de tecla
        }
        if (txtRuc.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomFocusLost
        String text = txtNom.getText().trim();
        txtNom.setText(text);
    }//GEN-LAST:event_txtNomFocusLost

    private void txtApeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApeFocusLost
        String text = txtApe.getText().trim();
        txtApe.setText(text);
    }//GEN-LAST:event_txtApeFocusLost

    private void txtDirecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDirecFocusLost
        String text = txtDirec.getText().trim();
        txtDirec.setText(text);
    }//GEN-LAST:event_txtDirecFocusLost

    private void txtImpNetoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImpNetoKeyTyped
        char c = evt.getKeyChar();
        String text = txtImpNeto.getText();

        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume(); // Si no es un número o un punto, se ignora el evento de tecla
        } else if (c == '.' && text.contains(".")) {
            evt.consume(); // Si el carácter ingresado es un punto y ya hay un punto en el campo de texto, se ignora el evento de tecla
        } else if (text.contains(".") && text.length() - text.indexOf(".") > 2) {
            evt.consume(); // Si ya hay dos decimales en el campo de texto, se ignora el evento de tecla
        } else if (text.equals("0") && c != '.') {
            evt.consume(); // Si el primer carácter es 0 y el siguiente carácter no es un punto, se ignora el evento de tecla
        }
    }//GEN-LAST:event_txtImpNetoKeyTyped

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try {
            Exportar obj = new Exportar();
            obj.exportarExcel(tblHonorarios);
        } catch (IOException ex) {
            Logger.getLogger(frmRecibosHonorarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void txtIRFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIRFocusLost
        String impIR = txtIR.getText();
        if (impIR.isEmpty()) {
            impIR = "0.00";
            txtIR.setText(impIR); // Agrega esta línea para establecer el valor en la caja de texto
        }
        float rentaBruta = Float.parseFloat(txtImpNeto.getText());
        float impRenta = Float.parseFloat(impIR);
        float rentaNeta = Math.round((rentaBruta - impRenta) * 100.0) / 100.0f;
        txtImpTotal.setText(String.valueOf(rentaNeta));
    }//GEN-LAST:event_txtIRFocusLost

    private void txtIRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIRKeyTyped
        char c = evt.getKeyChar();
        String text = txtImpNeto.getText();

        if (!(Character.isDigit(c) || c == '.')) {
            evt.consume(); // Si no es un número o un punto, se ignora el evento de tecla
        } else if (c == '.' && text.contains(".")) {
            evt.consume(); // Si el carácter ingresado es un punto y ya hay un punto en el campo de texto, se ignora el evento de tecla
        } else if (text.contains(".") && text.length() - text.indexOf(".") > 2) {
            evt.consume(); // Si ya hay dos decimales en el campo de texto, se ignora el evento de tecla
        } else if (text.equals("0") && c != '.') {
            evt.consume(); // Si el primer carácter es 0 y el siguiente carácter no es un punto, se ignora el evento de tecla
        }
    }//GEN-LAST:event_txtIRKeyTyped

    private void txtNroReciboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNroReciboKeyTyped
        char c = evt.getKeyChar();
        // Validar que sea un número o un carácter de control
        if (!Character.isDigit(c) && !Character.isISOControl(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNroReciboKeyTyped

    private void txtRucFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRucFocusLost
        String text = txtRuc.getText().trim();
        txtRuc.setText(text);
    }//GEN-LAST:event_txtRucFocusLost

    private void cboPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCancelar;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnExportar;
    public static javax.swing.JButton btnGuardar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboDistrito;
    private javax.swing.JComboBox<String> cboPago;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHonorarios;
    private javax.swing.JTextField txtApe;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtFecEmi;
    private javax.swing.JTextField txtIR;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImpNeto;
    private javax.swing.JTextField txtImpTotal;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNroRecibo;
    private javax.swing.JTextField txtRuc;
    // End of variables declaration//GEN-END:variables
}
