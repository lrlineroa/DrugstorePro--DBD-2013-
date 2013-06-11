/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary_Package;

import Control_Package.LoginControl;
import Entities.Views.ViewDrogueria;
import utilities.helpers.VentaTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.plaf.metal.MetalBorders;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jvnet.substance.SubstanceLookAndFeel;

/**
 *
 * @author Administrador
 */
public class MainFrame extends javax.swing.JFrame {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DrugstorePro--DBD-2013-PU");
//    private ViewDrogueriaDAO DrS= new ViewDrogueriaDAO(MainFrame.emf);
    private Dimension d;
    private VentaTableModel vTbM = new VentaTableModel();
    private DefaultComboBoxModel headQModel = new DefaultComboBoxModel();
    private LoginGui log = new LoginGui(this);
    
    //private RegisterGui reg=new RegisterGui(this);

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        
        initComponents();
        initialitation();
        this.LoggedLabel1.setLayout(new BorderLayout());
        AdjustToCenter();
        this.pack();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        CloseSesionButton = new javax.swing.JButton();
        LoggedLabel1 = new javax.swing.JLabel();
        panelRolSellAndAdmin = new javax.swing.JPanel();
        inventaryButton = new javax.swing.JButton();
        QueryButton = new javax.swing.JButton();
        orderButton = new javax.swing.JButton();
        sellButton = new javax.swing.JButton();
        panelRolAdmin = new javax.swing.JPanel();
        modifyButton = new javax.swing.JButton();
        balanceButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));
        setBounds(new java.awt.Rectangle(350, 200, 0, 0));
        setMinimumSize(new java.awt.Dimension(111, 45));

        MainPanel.setLayout(new java.awt.BorderLayout());

        CloseSesionButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        CloseSesionButton.setText("CERRAR SESION");
        CloseSesionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseSesionButtonActionPerformed(evt);
            }
        });

        LoggedLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        LoggedLabel1.setBorder(new javax.swing.border.MatteBorder(null));
        LoggedLabel1.setPreferredSize(new java.awt.Dimension(315, 41));

        panelRolSellAndAdmin.setPreferredSize(new java.awt.Dimension(553, 300));

        inventaryButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        inventaryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/db_add.png"))); // NOI18N
        inventaryButton.setText("INVENTARIO");
        inventaryButton.setBorder(new javax.swing.border.MatteBorder(null));
        inventaryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventaryButtonActionPerformed(evt);
            }
        });

        QueryButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        QueryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/kappfinder.png"))); // NOI18N
        QueryButton.setText("CONSULTA   ");
        QueryButton.setBorder(new javax.swing.border.MatteBorder(null));
        QueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QueryButtonActionPerformed(evt);
            }
        });

        orderButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        orderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/carrito.png"))); // NOI18N
        orderButton.setText("PEDIDOS      ");
        orderButton.setBorder(new javax.swing.border.MatteBorder(null));
        orderButton.setMaximumSize(new java.awt.Dimension(111, 45));
        orderButton.setMinimumSize(new java.awt.Dimension(111, 45));
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        sellButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        sellButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dinero.png"))); // NOI18N
        sellButton.setText("VENTA           ");
        sellButton.setBorder(new javax.swing.border.MatteBorder(null));
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRolSellAndAdminLayout = new javax.swing.GroupLayout(panelRolSellAndAdmin);
        panelRolSellAndAdmin.setLayout(panelRolSellAndAdminLayout);
        panelRolSellAndAdminLayout.setHorizontalGroup(
            panelRolSellAndAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRolSellAndAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRolSellAndAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(QueryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(panelRolSellAndAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventaryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelRolSellAndAdminLayout.setVerticalGroup(
            panelRolSellAndAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRolSellAndAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRolSellAndAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inventaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(panelRolSellAndAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QueryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        panelRolAdmin.setPreferredSize(new java.awt.Dimension(553, 300));

        modifyButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/lapiz.png"))); // NOI18N
        modifyButton.setText("<html><p>MODIFICAR</p><p>DATOS</p></html>");
        modifyButton.setBorder(new javax.swing.border.MatteBorder(null));
        modifyButton.setMaximumSize(new java.awt.Dimension(111, 45));
        modifyButton.setMinimumSize(new java.awt.Dimension(111, 45));
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        balanceButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        balanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/graficos.png"))); // NOI18N
        balanceButton.setText("BALANCE     ");
        balanceButton.setBorder(new javax.swing.border.MatteBorder(null));
        balanceButton.setMaximumSize(new java.awt.Dimension(111, 45));
        balanceButton.setMinimumSize(new java.awt.Dimension(111, 45));
        balanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceButtonActionPerformed(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        aboutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/interrogacion.png"))); // NOI18N
        aboutButton.setText("<html><p>ACERCA DE</p><p>DrugstorePro</p></html>");
        aboutButton.setBorder(new javax.swing.border.MatteBorder(null));
        aboutButton.setMaximumSize(new java.awt.Dimension(111, 45));
        aboutButton.setMinimumSize(new java.awt.Dimension(111, 45));
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Apu2.png"))); // NOI18N
        registerButton.setText("REGISTRAR   ");
        registerButton.setBorder(new javax.swing.border.MatteBorder(null));
        registerButton.setMaximumSize(new java.awt.Dimension(111, 45));
        registerButton.setMinimumSize(new java.awt.Dimension(111, 45));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRolAdminLayout = new javax.swing.GroupLayout(panelRolAdmin);
        panelRolAdmin.setLayout(panelRolAdminLayout);
        panelRolAdminLayout.setHorizontalGroup(
            panelRolAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRolAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRolAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRolAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(balanceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelRolAdminLayout.setVerticalGroup(
            panelRolAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRolAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRolAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(panelRolAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CloseSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LoggedLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRolSellAndAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRolAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CloseSesionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoggedLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addComponent(panelRolSellAndAdmin, 296, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(panelRolAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseSesionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseSesionButtonActionPerformed
        if (CloseSesionButton.getText().equals("CERRAR SESION")) {
            this.LoggedLabel1.setVisible(false);
            CloseSesionButton.setVisible(false);
            this.MainPanel.removeAll();
            LoginControl.usuarioActivo = null;
            setMainPanel(log);
            AdjustToCenter();
            this.pack();
        } else {
            if (LoginControl.usuarioActivo.getIdCargo().getIdCargo() == 1) {
                setToolBarAdmin(LoginControl.usuarioActivo.getNombrePersona());
                CloseSesionButton.setText("CERRAR SESION");
                AdjustToCenter();
            } else {
                setToolBarSeller(LoginControl.usuarioActivo.getNombrePersona());
                CloseSesionButton.setText("CERRAR SESION");
                AdjustToCenter();
            }

        }

    }//GEN-LAST:event_CloseSesionButtonActionPerformed

    private void inventaryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventaryButtonActionPerformed
        setMainPanel(new InvGui());
        CloseSesionButton.setText("MENU PRINCIPAL");
        AdjustToCenter();
    }//GEN-LAST:event_inventaryButtonActionPerformed

    private void balanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceButtonActionPerformed
//        setMainPanel(new BalanceGui());
//        CloseSesionButton.setText("MENU PRINCIPAL");
//        AdjustToCenter();
    }//GEN-LAST:event_balanceButtonActionPerformed

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        setMainPanel(new SellGui());
        CloseSesionButton.setText("MENU PRINCIPAL");
    }//GEN-LAST:event_sellButtonActionPerformed

    private void QueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QueryButtonActionPerformed
//       setMainPanel(new QueryGui());
//       CloseSesionButton.setText("MENU PRINCIPAL");
//       AdjustToCenter();
    }//GEN-LAST:event_QueryButtonActionPerformed

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed
//        setMainPanel(new OrderGui());
//        CloseSesionButton.setText("MENU PRINCIPAL");
//        AdjustToCenter();
    }//GEN-LAST:event_orderButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
//        setMainPanel(new ModifyDataGui());
//        CloseSesionButton.setText("MENU PRINCIPAL");
//        AdjustToCenter();
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
//        setMainPanel(new RegisterGui(this));
//        CloseSesionButton.setText("MENU PRINCIPAL");
//        AdjustToCenter();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
//        setMainPanel(new AboutGui());
//        CloseSesionButton.setText("MENU PRINCIPAL");
//        AdjustToCenter();
    }//GEN-LAST:event_aboutButtonActionPerformed

    public void setMainPanel(JPanel panel) {
        panel.setVisible(true);
        MainPanel.removeAll();
        MainPanel.setVisible(false);
        MainPanel.add(panel, BorderLayout.CENTER);
        MainPanel.setSize(panel.getPreferredSize());
        MainPanel.setVisible(true);
        log.cleanFields();
        d = new Dimension(panel.getPreferredSize().width, panel.getPreferredSize().height + 100);
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        AdjustToCenter();
        this.pack();
    }

    public void setMainPanel(JPanel panel1, JPanel panel2) {
        MainPanel.removeAll();
        int totalHeight = panel1.getPreferredSize().height + panel2.getPreferredSize().height;
        d = new Dimension(panel1.getPreferredSize().width, totalHeight);
        MainPanel.setSize(d);
        panel1.setVisible(true);
        panel2.setVisible(true);
        MainPanel.setVisible(false);
        MainPanel.removeAll();
        MainPanel.add(panel1, BorderLayout.NORTH);
        MainPanel.add(panel2, BorderLayout.SOUTH);
        MainPanel.setVisible(true);
        log.cleanFields();
        d = new Dimension(panel1.getPreferredSize().width + 20, totalHeight + 100);
        this.setMinimumSize(d);
        AdjustToCenter();
        this.pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        JFrame.setDefaultLookAndFeelDecorated(true);
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteGlassSkin");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseSesionButton;
    private javax.swing.JLabel LoggedLabel1;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton QueryButton;
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton balanceButton;
    private javax.swing.JButton inventaryButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton orderButton;
    private javax.swing.JPanel panelRolAdmin;
    private javax.swing.JPanel panelRolSellAndAdmin;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton sellButton;
    // End of variables declaration//GEN-END:variables

    public void initialitation() {
        this.panelRolAdmin.setVisible(false);
        this.panelRolSellAndAdmin.setVisible(false);
        setMainPanel(log);
        this.setMinimumSize(new Dimension(270, 200));
        this.repaint();
        this.setTitle("DrugStorePro- bienvenido");
        this.CloseSesionButton.setVisible(false);
        this.pack();
    }

    public void setToolBarSeller(String n) {
        d = new Dimension(70, 23);
        this.MainPanel.setVisible(false);
        MainPanel.setBorder(new MetalBorders.Flush3DBorder());
        this.LoggedLabel1.setLayout(new BorderLayout());
        this.LoggedLabel1.setVisible(false);
        this.LoggedLabel1.setSize(d);
        this.LoggedLabel1.setVisible(true);
        this.LoggedLabel1.setLocation(200, 1);
        this.add(LoggedLabel1);

//            CloseSesionButton.setLocation(44,1);
        this.CloseSesionButton.setVisible(true);
        this.LoggedLabel1.setText(n);
        setMainPanel(this.panelRolSellAndAdmin);

        this.pack();

    }

    public void setToolBarAdmin(String n) {
        d = new Dimension(70, 23);
        this.MainPanel.setVisible(false);
        MainPanel.setBorder(new MetalBorders.Flush3DBorder());
        this.LoggedLabel1.setLayout(new BorderLayout());
        this.LoggedLabel1.setVisible(false);
        this.LoggedLabel1.setSize(d);
        this.LoggedLabel1.setVisible(true);
        this.LoggedLabel1.setLocation(200, 1);
        this.add(LoggedLabel1);
        this.CloseSesionButton.setVisible(true);
        this.LoggedLabel1.setText(n);
        setMainPanel(this.panelRolSellAndAdmin, this.panelRolAdmin);
        this.pack();


    }

    private void AdjustToCenter() {
        this.setLocationRelativeTo(null);

    }
}
