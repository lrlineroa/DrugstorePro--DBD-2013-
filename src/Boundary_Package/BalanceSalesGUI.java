/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary_Package;

import Control_Package.BalanceControl;
import java.sql.Time;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author User
 */
public class BalanceSalesGUI extends javax.swing.JPanel {
        private BalanceControl balanceControl=new BalanceControl();
    /**
     * Creates new form BalanceSalesGUI
     */
    public BalanceSalesGUI() {
        initComponents();
        initialization();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        SettingsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        monthCombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox();
        visualizationCombo = new javax.swing.JComboBox();
        SearchButton = new javax.swing.JButton();
        chartPanel = new javax.swing.JLayeredPane();
        weeklyViewingPanel = new javax.swing.JPanel();
        MonthlyViewingPanel = new javax.swing.JPanel();
        annualViewingPanel = new javax.swing.JPanel();

        title.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        title.setText("VENTAS");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Mes");

        monthCombo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        monthCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Año");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("visualización");

        yearCombo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        yearCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2012", "2013" }));

        visualizationCombo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        visualizationCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semanal", "Mensual", "Anual" }));
        visualizationCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizationComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualizationCombo, 0, 128, Short.MAX_VALUE))
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(monthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(jLabel3)
                .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(visualizationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        SearchButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/kappfinder.png"))); // NOI18N
        SearchButton.setText("CONSULTAR");
        SearchButton.setPreferredSize(new java.awt.Dimension(167, 80));
        SearchButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/kappfinder.png"))); // NOI18N
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        chartPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout weeklyViewingPanelLayout = new javax.swing.GroupLayout(weeklyViewingPanel);
        weeklyViewingPanel.setLayout(weeklyViewingPanelLayout);
        weeklyViewingPanelLayout.setHorizontalGroup(
            weeklyViewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        weeklyViewingPanelLayout.setVerticalGroup(
            weeklyViewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        weeklyViewingPanel.setBounds(0, 0, 560, 340);
        chartPanel.add(weeklyViewingPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MonthlyViewingPanelLayout = new javax.swing.GroupLayout(MonthlyViewingPanel);
        MonthlyViewingPanel.setLayout(MonthlyViewingPanelLayout);
        MonthlyViewingPanelLayout.setHorizontalGroup(
            MonthlyViewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        MonthlyViewingPanelLayout.setVerticalGroup(
            MonthlyViewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        MonthlyViewingPanel.setBounds(0, 0, 560, 340);
        chartPanel.add(MonthlyViewingPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout annualViewingPanelLayout = new javax.swing.GroupLayout(annualViewingPanel);
        annualViewingPanel.setLayout(annualViewingPanelLayout);
        annualViewingPanelLayout.setHorizontalGroup(
            annualViewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        annualViewingPanelLayout.setVerticalGroup(
            annualViewingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        annualViewingPanel.setBounds(0, 0, 560, 340);
        chartPanel.add(annualViewingPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(SettingsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartPanel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title)
                .addGap(14, 14, 14)
                .addComponent(SettingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        int month= monthCombo.getSelectedIndex();
        int year= (int) yearCombo.getSelectedItem();        
        GregorianCalendar date=new GregorianCalendar(year, month, 0);
        String visualization = (String) visualizationCombo.getSelectedItem();
        if(visualization.equals("Semanal")){
        
        }else if(visualization.equals("Mensual")){
            
            this.balanceControl.findTotalSalesForMonth(year);
            
        }else{
            
            this.balanceControl.findSalesForYear(2000,2011);
        
        
        }
        
        
        
        
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void visualizationComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizationComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_visualizationComboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MonthlyViewingPanel;
    private javax.swing.JButton SearchButton;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JPanel annualViewingPanel;
    private javax.swing.JLayeredPane chartPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox monthCombo;
    private javax.swing.JLabel title;
    private javax.swing.JComboBox visualizationCombo;
    private javax.swing.JPanel weeklyViewingPanel;
    private javax.swing.JComboBox yearCombo;
    // End of variables declaration//GEN-END:variables

    private void initialization() {
        
    }
}