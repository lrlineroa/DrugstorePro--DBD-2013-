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
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;

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
        this.setSize(350, 200);
        initComponents();
        panelAccesoAPP.setVisible(false);
        this.frame = frame;
//        new RegexFormatter(RegularExpression.NATURAL_NUMBERS).install(IdentificationTf);
        this.usuarioAPPTf.getCursor();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAccesoBDS = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        passwordBDTf = new javax.swing.JPasswordField();
        Contraseña4 = new javax.swing.JLabel();
        usuarioBDTf = new javax.swing.JFormattedTextField();
        Contraseña5 = new javax.swing.JLabel();
        rdbmsCombo = new javax.swing.JComboBox();
        checkBox = new javax.swing.JCheckBox();
        panelAccesoAPP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        passwordAPPTf = new javax.swing.JPasswordField();
        Contraseña = new javax.swing.JLabel();
        usuarioAPPTf = new javax.swing.JFormattedTextField();
        AceptarButton = new javax.swing.JButton();

        panelAccesoBDS.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IDENTIFICACION BASE DE DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel3.setText("Usuario");

        passwordBDTf.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        passwordBDTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordBDTfKeyPressed(evt);
            }
        });

        Contraseña4.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        Contraseña4.setText("Contraseña");

        usuarioBDTf.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        Contraseña5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        Contraseña5.setText("Base de Datos");

        rdbmsCombo.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
        rdbmsCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MS SQL Server", "SyBase", "Oracle" }));

        checkBox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        checkBox.setSelected(true);
        checkBox.setText("Deseo utilizar esta cuenta para acceder también a la aplicación");
        checkBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelAccesoBDSLayout = new javax.swing.GroupLayout(panelAccesoBDS);
        panelAccesoBDS.setLayout(panelAccesoBDSLayout);
        panelAccesoBDSLayout.setHorizontalGroup(
            panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccesoBDSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAccesoBDSLayout.createSequentialGroup()
                        .addComponent(Contraseña5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdbmsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAccesoBDSLayout.createSequentialGroup()
                        .addGroup(panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Contraseña4))
                        .addGap(18, 18, 18)
                        .addGroup(panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordBDTf)
                            .addComponent(usuarioBDTf)))
                    .addGroup(panelAccesoBDSLayout.createSequentialGroup()
                        .addComponent(checkBox)
                        .addGap(0, 55, Short.MAX_VALUE))))
        );
        panelAccesoBDSLayout.setVerticalGroup(
            panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccesoBDSLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(usuarioBDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contraseña4)
                    .addComponent(passwordBDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelAccesoBDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Contraseña5)
                    .addComponent(rdbmsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBox))
        );

        panelAccesoAPP.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IDENTIFICACION APLICACIÓN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Usuario");

        passwordAPPTf.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        passwordAPPTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordAPPTfKeyPressed(evt);
            }
        });

        Contraseña.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        Contraseña.setText("Contraseña");

        usuarioAPPTf.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N

        javax.swing.GroupLayout panelAccesoAPPLayout = new javax.swing.GroupLayout(panelAccesoAPP);
        panelAccesoAPP.setLayout(panelAccesoAPPLayout);
        panelAccesoAPPLayout.setHorizontalGroup(
            panelAccesoAPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccesoAPPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAccesoAPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Contraseña))
                .addGap(18, 18, 18)
                .addGroup(panelAccesoAPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordAPPTf, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(usuarioAPPTf)))
        );
        panelAccesoAPPLayout.setVerticalGroup(
            panelAccesoAPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAccesoAPPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAccesoAPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usuarioAPPTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelAccesoAPPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contraseña)
                    .addComponent(passwordAPPTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        AceptarButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AceptarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Copia de icon_check.png"))); // NOI18N
        AceptarButton.setText("ACEPTAR");
        AceptarButton.setBorder(new javax.swing.border.MatteBorder(null));
        AceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AceptarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelAccesoBDS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelAccesoAPP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAccesoBDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelAccesoAPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarButtonActionPerformed
        login();
    }//GEN-LAST:event_AceptarButtonActionPerformed

    private void passwordAPPTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordAPPTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_passwordAPPTfKeyPressed

    private void passwordBDTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordBDTfKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordBDTfKeyPressed

    private void checkBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkBoxItemStateChanged
        panelAccesoAPP.setVisible(false);
        panelAccesoAPP.setVisible(evt.getStateChange() == ItemEvent.DESELECTED);
        if (evt.getStateChange() == ItemEvent.DESELECTED) {
            frame.setSize(560, 580);
        } else {
            frame.setSize(560, 440);
        }
        frame.repaint();
        this.repaint();
    }//GEN-LAST:event_checkBoxItemStateChanged

    private void login() {
        if (checkBox.isSelected()) {
            if (usuarioBDTf.getText().equals("") || new String(passwordBDTf.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacíos", "MENSAJE", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            if (usuarioAPPTf.getText().equals("") || new String(passwordAPPTf.getPassword()).equals("")
                    || usuarioBDTf.getText().equals("") || new String(passwordBDTf.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "Campos vacíos", "MENSAJE", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        ViewPersona login = null;

        if (checkBox.isSelected()) {
            try {
                login = logCon.login(rdbmsCombo.getSelectedItem().toString(),
                        usuarioBDTf.getText(),
                        new String(passwordBDTf.getPassword()));
            } catch (DataBaseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            try {
                login = logCon.login(rdbmsCombo.getSelectedItem().toString(),
                        usuarioBDTf.getText(),
                        new String(passwordBDTf.getPassword()),
                        usuarioAPPTf.getText(),
                        new String(passwordAPPTf.getPassword()));
            } catch (DataBaseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (login != null) {
            JOptionPane.showMessageDialog(null, "Login Exitoso", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);

            if (login.getIdCargo() == 1) {
                frame.setToolBarAdmin(login.getNombrePersona());
            } else if (login.getIdCargo() == 2) {
                frame.setToolBarSeller(login.getNombrePersona());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al Ingersar a la aplicación\n\n"
                    + "Combinación Usuario/Contraseña Errados", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanFields(false);
        }
    }

    public void cleanFields(boolean full) {
        if (full) {
            this.usuarioAPPTf.setText("");
            this.passwordAPPTf.setText("");
            this.usuarioBDTf.setText("");
            this.passwordBDTf.setText("");
        } else {
            this.usuarioAPPTf.setText("");
            this.passwordAPPTf.setText("");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarButton;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel Contraseña2;
    private javax.swing.JLabel Contraseña3;
    private javax.swing.JLabel Contraseña4;
    private javax.swing.JLabel Contraseña5;
    private javax.swing.JFormattedTextField IdentificationTf1;
    private javax.swing.JPasswordField PasswordTf1;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panelAccesoAPP;
    private javax.swing.JPanel panelAccesoBD1;
    private javax.swing.JPanel panelAccesoBDS;
    private javax.swing.JPasswordField passwordAPPTf;
    private javax.swing.JPasswordField passwordBDTf;
    private javax.swing.JComboBox rdbmsCombo;
    private javax.swing.JComboBox rdbmsCombo1;
    private javax.swing.JFormattedTextField usuarioAPPTf;
    private javax.swing.JFormattedTextField usuarioBDTf;
    // End of variables declaration//GEN-END:variables
}
