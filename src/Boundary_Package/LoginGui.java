/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary_Package;

import Entities.Views.ViewPersona;
import utilities.helpers.RegexFormatter;
import utilities.helpers.RegularExpression;
import Control_Package.LoginControl;
import DAOS.exceptions.DataBaseException;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class LoginGui extends javax.swing.JPanel {

    private LoginControl logCon = new LoginControl();
    private MainFrame frame;

    /**
     * Creates new form LoginGui
     */
    public LoginGui(MainFrame frame) {
        this.setSize(350, 175);
        initComponents();
        this.frame = frame;
//        new RegexFormatter(RegularExpression.NATURAL_NUMBERS).install(IdentificationTf);
        this.IdentificationTf.getCursor();
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
        jLabel1 = new javax.swing.JLabel();
        PasswordTf = new javax.swing.JPasswordField();
        AceptarButton = new javax.swing.JButton();
        Contraseña = new javax.swing.JLabel();
        IdentificationTf = new javax.swing.JFormattedTextField();
        Contraseña1 = new javax.swing.JLabel();
        rdbmsCombo = new javax.swing.JComboBox();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Identificación");

        PasswordTf.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        PasswordTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordTfKeyPressed(evt);
            }
        });

        AceptarButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Copia de icon_check.png"))); // NOI18N
        AceptarButton.setText("ACEPTAR");
        AceptarButton.setBorder(new javax.swing.border.MatteBorder(null));
        AceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarButtonActionPerformed(evt);
            }
        });

        Contraseña.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        Contraseña.setText("Contraseña");

        IdentificationTf.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        Contraseña1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        Contraseña1.setText("Base de Datos");

        rdbmsCombo.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        rdbmsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SyBase", "MS SQL Server", "Oracle" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Contraseña1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(AceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdbmsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(Contraseña))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdentificationTf, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IdentificationTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contraseña)
                    .addComponent(PasswordTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Contraseña1)
                    .addComponent(rdbmsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(AceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarButtonActionPerformed
        login();
    }//GEN-LAST:event_AceptarButtonActionPerformed

    private void PasswordTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_PasswordTfKeyPressed

    private void login() {
        if (IdentificationTf.getText().equals("") || new String(PasswordTf.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacíos", "MENSAJE", JOptionPane.ERROR_MESSAGE);
            cleanFields();
        } else {
            ViewPersona login = null;
            try {
                login = logCon.login(rdbmsCombo.getSelectedItem().toString(),
                        IdentificationTf.getText(),
                        new String(PasswordTf.getPassword()));
            } catch (DataBaseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (login != null) {
                JOptionPane.showMessageDialog(null, "Login Exitoso", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

                if (login.getIdCargo().getIdCargo() == 1) {
                    frame.setToolBarAdmin(login.getNombrePersona());
                } else if (login.getIdCargo().getIdCargo() == 2) {
                    frame.setToolBarSeller(login.getNombrePersona());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Combinación Usuario/Contraseña Errados", "ERROR", JOptionPane.ERROR_MESSAGE);
                cleanFields();
            }
        }
    }

    public void cleanFields() {
        this.IdentificationTf.setText("");
        this.PasswordTf.setText("");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarButton;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel Contraseña1;
    private javax.swing.JFormattedTextField IdentificationTf;
    private javax.swing.JPasswordField PasswordTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox rdbmsCombo;
    // End of variables declaration//GEN-END:variables
}
