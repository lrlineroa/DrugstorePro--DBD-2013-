/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary_Package;

import Boundary_Package.SellGui;
import Entitys.ProductoGeneral;
import Helpers.RegexFormatter;
import Helpers.RegularExpression;
import Helpers.VentaTableModel;
import control_package.AutoCompleteControl;
import control_package.BussinesControl;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Administrador
 */
public class QueryGui extends javax.swing.JPanel {
    private BussinesControl buscontrol=new BussinesControl();
    private ProductoGeneral producto=new ProductoGeneral();
    private List<ProductoGeneral> lp= new ArrayList<ProductoGeneral>();
    private JList listProducts=new JList();
    private DefaultListModel LisProductsModel=new DefaultListModel();
    private Icon searchIcon;
    private AutoCompleteControl aCControl=new AutoCompleteControl();
    /**
     * Creates new form QueryGui
     */
    public QueryGui() {
        initComponents();
        Integrity();
//       searchIcon=new ImageIcon("kfind.jpg");
//       this.SearchButton.setIcon(searchIcon);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NameProFTF = new javax.swing.JFormattedTextField();
        SearchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        IdProJFTF = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextPane = new javax.swing.JTextPane();
        GeneratejButton = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setPreferredSize(new java.awt.Dimension(1240, 675));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONSULTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1240, 640));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Nombre producto:");

        NameProFTF.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        NameProFTF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                NameProFTFMouseMoved(evt);
            }
        });
        NameProFTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameProFTFFocusLost(evt);
            }
        });
        NameProFTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NameProFTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameProFTFKeyReleased(evt);
            }
        });

        SearchButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/kappfinder.png"))); // NOI18N
        SearchButton.setText("BUSCAR");
        SearchButton.setPreferredSize(new java.awt.Dimension(167, 80));
        SearchButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/kappfinder.png"))); // NOI18N
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setText("Id:");

        IdProJFTF.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        IdProJFTF.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                IdProJFTFMouseMoved(evt);
            }
        });
        IdProJFTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdProJFTFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setText("Detalles");

        TextPane.setEditable(false);
        TextPane.setFont(new java.awt.Font("Verdana", 0, 32)); // NOI18N
        jScrollPane3.setViewportView(TextPane);

        GeneratejButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        GeneratejButton.setText("<html><p>Generar</p><p>Reporte</p></html>");
        GeneratejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneratejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(IdProJFTF, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 862, Short.MAX_VALUE))
                                    .addComponent(NameProFTF, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE))))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(GeneratejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameProFTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdProJFTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GeneratejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
//        String nom=this.NameProFTF.getText();
//        if(!(nom.length()<51)){
        
        String cadena="";
        String drugs="";
        if(this.NameProFTF.getText().equals("")&& this.IdProJFTF.getText().equals("")){
        JOptionPane.showMessageDialog(null, "campos vacíoss", "Mensaje", JOptionPane.OK_OPTION);    
        }else if(!this.NameProFTF.getText().equals("")&& this.IdProJFTF.getText().equals("") ){
             lp=buscontrol.MakeQuery(this.NameProFTF.getText()); 
        }else if(this.NameProFTF.getText().equals("")&& !this.IdProJFTF.getText().equals("")){
             producto=buscontrol.MakeQuery(new Long(Long.parseLong(this.IdProJFTF.getText())));   
        }else if(!this.NameProFTF.getText().equals("")&& !this.IdProJFTF.getText().equals("")){
             producto=buscontrol.MakeQuery(new Long(Long.parseLong(this.IdProJFTF.getText())), this.NameProFTF.getText());
        }
        //aqui falta implementar las Querys para traer el fabricante que está relacionado, otras vainas, y la implementación cuando tenemos un array de productos 
        
        for(String u:buscontrol.getDrugsForProduct(Long.parseLong(IdProJFTF.getText()))){
            if(drugs.isEmpty())
            drugs= drugs+" "+u; 
            else
            drugs= drugs+", "+u;    
        }
        
        cadena=producto.toString()+" Disponible en: "+ drugs +".";
        
        this.TextPane.setText(cadena);
//        }else{
//        JOptionPane.showMessageDialog(null,"menos de 50 caracteres","advertencia",JOptionPane.OK_OPTION);
//        }
      
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void GeneratejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneratejButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GeneratejButtonActionPerformed

    private void NameProFTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameProFTFKeyPressed
//          List<String> noms;
//          LisProductsModel.removeAllElements();
//          if(this.NameProFTF.getText().length()>3){
//             noms= buscontrol.DedicatedSearch(this.NameProFTF.getText());   
//            
//             for(String n:noms){
//                LisProductsModel.addElement(n);
//             }
//            listProducts.setModel(LisProductsModel);
//            jPanel2.setLayout(new BorderLayout());
//            this.jPanel2.add(listProducts);
//            listProducts.setLocation(NameProFTF.getX(), NameProFTF.getY()+NameProFTF.getPreferredSize().width);
//            listProducts.setVisible(true);
//          }
          
    }//GEN-LAST:event_NameProFTFKeyPressed

    private void IdProJFTFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IdProJFTFMouseMoved
        if (!this.IdProJFTF.getText().isEmpty()){
            String s=buscontrol.SearchNameById(Long.parseLong(this.IdProJFTF.getText()));
            
            if(NameProFTF.getText().isEmpty()){
                this.NameProFTF.setText(s);
            }else if(!NameProFTF.getText().equals(s)){
                this.NameProFTF.setText(s);    
            }
        }
    }//GEN-LAST:event_IdProJFTFMouseMoved

    private void NameProFTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameProFTFKeyReleased
        
        if(evt.getKeyCode()!=8 && evt.getKeyCode()!= 127){
             if(!NameProFTF.getText().isEmpty())
                try {
                    aCControl.AddTextToTextField(NameProFTF,NameProFTF.getText(),false);
                } catch (BadLocationException ex) {
                    Logger.getLogger(SellGui.class.getName()).log(Level.SEVERE, null, ex);
             }
        }  
    }//GEN-LAST:event_NameProFTFKeyReleased

    private void NameProFTFMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameProFTFMouseMoved
        
    }//GEN-LAST:event_NameProFTFMouseMoved

    private void NameProFTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameProFTFFocusLost
       Object Id=buscontrol.SearchIdByName(NameProFTF.getText());        
        if(!Id.equals(-1)){
           IdProJFTF.setText(""+Id);
        }else{
            JOptionPane.showMessageDialog(null, "Ops.. no se encuentra producto", "advertencia", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_NameProFTFFocusLost

    private void IdProJFTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdProJFTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdProJFTFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GeneratejButton;
    private javax.swing.JFormattedTextField IdProJFTF;
    private javax.swing.JFormattedTextField NameProFTF;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextPane TextPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    private void Integrity() {
        new RegexFormatter(RegularExpression.NATURAL_NUMBERS).install(IdProJFTF);
//        new RegexFormatter(RegularExpression.WORDS).install(NameProFTF);
    }
}