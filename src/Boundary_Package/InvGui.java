/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary_Package;

import Boundary_Package.SellGui;
//import Helpers.*;
import Control_Package.AutoCompleteControl;
import Control_Package.BussinesControl;
import Entities.Views.ViewMedicamento;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.text.BadLocationException;
import utilities.helpers.InventaryTableModel;
import utilities.helpers.ReportTableModel;
import utilities.helpers.MyEditor;
import utilities.helpers.MyRender;
import utilities.helpers.RegInventary;
import utilities.helpers.RegReport;
import utilities.helpers.RegexFormatter;
import utilities.helpers.RegularExpression;

public class InvGui extends javax.swing.JPanel {

    private InventaryTableModel tableModel = new InventaryTableModel();
    private ReportTableModel tablereport = new ReportTableModel();
    private BussinesControl buscon = new BussinesControl();
    private AutoCompleteControl aCControl = new AutoCompleteControl();
    private String resultado;

    /**
     *
     * @author Administrador
     */
    /**
     * Creates new form InvGui
     */
    public InvGui() {
        initComponents();
        
        this.TableInv.setModel(tableModel);
        fillButtons();
        Integrity();

    }

    //Se añadio funcionalidad con la base de datos
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportjDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reportjTable = new javax.swing.JTable();
        acceptjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        OkjButton = new javax.swing.JButton();
        NextjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableInv = new javax.swing.JTable();
        CantjFormattedTextField = new javax.swing.JFormattedTextField();
        IdjFormattedTextField = new javax.swing.JFormattedTextField();
        ProductNamejFormattedTextField = new javax.swing.JFormattedTextField();
        ReportjButton = new javax.swing.JButton();

        reportjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Cantid"
            }
        ));
        jScrollPane2.setViewportView(reportjTable);

        acceptjButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        acceptjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Copia de icon_check.png"))); // NOI18N
        acceptjButton.setText("ACEPTAR");
        acceptjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(378, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(acceptjButton)
                        .addGap(116, 116, 116))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acceptjButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout reportjDialogLayout = new javax.swing.GroupLayout(reportjDialog.getContentPane());
        reportjDialog.getContentPane().setLayout(reportjDialogLayout);
        reportjDialogLayout.setHorizontalGroup(
            reportjDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportjDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        reportjDialogLayout.setVerticalGroup(
            reportjDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportjDialogLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INVENTARIO", 0, 0, new java.awt.Font("Verdana", 0, 18))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1240, 640));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Cant:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Nombre de Producto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Id:");

        OkjButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        OkjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/downarrow.png"))); // NOI18N
        OkjButton.setText("Ingresar");
        OkjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkjButtonActionPerformed(evt);
            }
        });

        NextjButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        NextjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Copia de icon_check.png"))); // NOI18N
        NextjButton.setText("SIGUIENTE");
        NextjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextjButtonActionPerformed(evt);
            }
        });

        TableInv.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        TableInv.setModel(new javax.swing.table.DefaultTableModel(
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
        TableInv.setRowHeight(18);
        jScrollPane1.setViewportView(TableInv);

        CantjFormattedTextField.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        CantjFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CantjFormattedTextFieldFocusLost(evt);
            }
        });

        IdjFormattedTextField.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        IdjFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdjFormattedTextFieldActionPerformed(evt);
            }
        });
        IdjFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                IdjFormattedTextFieldFocusLost(evt);
            }
        });

        ProductNamejFormattedTextField.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        ProductNamejFormattedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProductNamejFormattedTextFieldFocusLost(evt);
            }
        });
        ProductNamejFormattedTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ProductNamejFormattedTextFieldKeyReleased(evt);
            }
        });

        ReportjButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ReportjButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/playlist.png"))); // NOI18N
        ReportjButton.setText("REPORTE");
        ReportjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdjFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(ProductNamejFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(420, 420, 420)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(CantjFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(OkjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ReportjButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NextjButton)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductNamejFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CantjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OkjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NextjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReportjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void IdjFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdjFormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdjFormattedTextFieldActionPerformed

    private void ProductNamejFormattedTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProductNamejFormattedTextFieldKeyReleased

        if (evt.getKeyCode() != 8 && evt.getKeyCode() != 127) {
            if (!ProductNamejFormattedTextField.getText().isEmpty()) {
                try {
                    aCControl.AddTextToTextField(ProductNamejFormattedTextField, ProductNamejFormattedTextField.getText(), true);
                } catch (BadLocationException ex) {
                    Logger.getLogger(SellGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_ProductNamejFormattedTextFieldKeyReleased

    private void CantjFormattedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CantjFormattedTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_CantjFormattedTextFieldFocusLost

    private void ProductNamejFormattedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProductNamejFormattedTextFieldFocusLost
        ViewMedicamento searchProduct = buscon.searchProductByName(ProductNamejFormattedTextField.getText());
        if (searchProduct != null) {
            IdjFormattedTextField.setText("" + searchProduct.getIdProducto());
        } else {
            JOptionPane.showMessageDialog(null, "Ops.. no se encuentra producto", "advertencia", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_ProductNamejFormattedTextFieldFocusLost

    private void OkjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkjButtonActionPerformed
//        String nom=this.ProductNamejFormattedTextField.getText();
//        if(!(nom.length()<51)){

        if (!IdjFormattedTextField.getText().equals("") && !CantjFormattedTextField.getText().equals("")) {
        }


        if (this.CantjFormattedTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tienes que llenar Cantidad", "advertencia", JOptionPane.OK_OPTION);
        } else if (IdjFormattedTextField.getText().equals("") && this.ProductNamejFormattedTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan Datos por llenar", "advertencia", JOptionPane.OK_OPTION);
        } else if (IdjFormattedTextField.getText().equals("") && !ProductNamejFormattedTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Faltan Datos por llenar", "advertencia", JOptionPane.OK_OPTION);
        } else if (!IdjFormattedTextField.getText().equals("")) {
            Long identi = Long.parseLong(this.IdjFormattedTextField.getText());

            if (!ProductNamejFormattedTextField.getText().equals("")) {
                tableModel.add(new RegInventary(identi, this.ProductNamejFormattedTextField.getText(), Integer.parseInt(CantjFormattedTextField.getText()), tableModel));
                TableInv.updateUI();
                cleanFields();


            } else if (ProductNamejFormattedTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "tienes que llenar el nombre", "advertencia", JOptionPane.OK_OPTION);

            }
        }
//        }else{
//        JOptionPane.showMessageDialog(null,"menos de 50 caracteres","advertencia",JOptionPane.OK_OPTION);
//        }

    }//GEN-LAST:event_OkjButtonActionPerformed

    private void NextjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextjButtonActionPerformed
        boolean bandera = true;
        for (RegInventary ri : tableModel.getProducts()) {
            Long Id = ri.getId();
            int quantity = ri.getQuantity();
            try {
                buscon.makeInventary(Id, quantity);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error de conexion a la Base de Datos\n\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
                bandera = false;
            }
        }
        for (int i = 0; i <= tableModel.getRowCount(); i++) {
            tableModel.delete(0);
            TableInv.updateUI();
        }
        if (!tableModel.getProducts().isEmpty()) {
            tableModel.delete(0);
            TableInv.updateUI();
        }

        if (bandera) {
            JOptionPane.showMessageDialog(null, "INVENTARIO EXITOSO", "URRA!!!", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/Icons/happyFace.png")));
        } else {
            JOptionPane.showMessageDialog(null, "INVENTARIO FRACASO", "OOPS!!!", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/Icons/triste.png")));
        }
    }//GEN-LAST:event_NextjButtonActionPerformed

    private void IdjFormattedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IdjFormattedTextFieldFocusLost
        if (!this.IdjFormattedTextField.getText().isEmpty()) {
            ViewMedicamento searchProduct = buscon.searchProductById(Long.parseLong(this.IdjFormattedTextField.getText()));

            if (searchProduct != null) {
                String s = searchProduct.getNombreProducto();
                if (ProductNamejFormattedTextField.getText().isEmpty()) {
                    this.ProductNamejFormattedTextField.setText(s);
                } else if (!ProductNamejFormattedTextField.getText().equals(s)) {
                    this.ProductNamejFormattedTextField.setText(s);
                }
            }
        }
    }//GEN-LAST:event_IdjFormattedTextFieldFocusLost

    private void ReportjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportjButtonActionPerformed
        // TODO add your handling code here:
        this.reportjTable.setModel(tablereport);
        
       //tablereport.add(new RegInventary(identi, this.ProductNamejFormattedTextField.getText(), Integer.parseInt(CantjFormattedTextField.getText()), tableModel));
         //reportjTable.updateUI();
        reportjDialog.setVisible(true);
        reportjDialog.setTitle("reporte-inventario");
        reportjDialog.setBounds(100, 100, 750, 429);
        
        
    }//GEN-LAST:event_ReportjButtonActionPerformed

    private void acceptjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptjButtonActionPerformed
        // TODO add your handling code here:
        reportjDialog.setVisible(false);
    }//GEN-LAST:event_acceptjButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CantjFormattedTextField;
    private javax.swing.JFormattedTextField IdjFormattedTextField;
    private javax.swing.JButton NextjButton;
    private javax.swing.JButton OkjButton;
    private javax.swing.JFormattedTextField ProductNamejFormattedTextField;
    private javax.swing.JButton ReportjButton;
    private javax.swing.JTable TableInv;
    private javax.swing.JButton acceptjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog reportjDialog;
    private javax.swing.JTable reportjTable;
    // End of variables declaration//GEN-END:variables

    private void Integrity() {
        new RegexFormatter(RegularExpression.NATURAL_NUMBERS).install(IdjFormattedTextField);
        new RegexFormatter(RegularExpression.NATURAL_NUMBERS).install(CantjFormattedTextField);
//        new RegexFormatter(RegularExpression.WORDS).install(ProductNamejFormattedTextField);
    }

    private void fillButtons() {
        TableInv.setLayout(new FlowLayout());
        TableInv.setRowHeight(40);
        TableColumn tablecol0;
        tablecol0 = TableInv.getColumnModel().getColumn(0);
        tablecol0.setPreferredWidth(20);
        TableColumn tablecol2;
        tablecol2 = TableInv.getColumnModel().getColumn(2);
        tablecol2.setPreferredWidth(15);
        TableColumn tablecol;
        tablecol = TableInv.getColumnModel().getColumn(3);
        System.out.println(TableInv.getColumnModel());
        tablecol.setCellRenderer(new MyRender());
        tablecol.setCellEditor(new MyEditor(TableInv));
        tablecol.setPreferredWidth(40);

    }
    
    

    private void cleanFields() {
        this.IdjFormattedTextField.setText("");
        this.ProductNamejFormattedTextField.setText("");
        this.CantjFormattedTextField.setText("");
    }
}
