package com.student.component;

import com.student.view.Home;
import com.student.view.LoginAndRegister;

public class PanelLogout extends javax.swing.JPanel {

    private Home home; // Biến để lưu trữ tham chiếu đến Home

    public PanelLogout(Home home) {
        this.home = home; // Nhận tham chiếu từ Home
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new com.student.swing.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        cmdYes = new com.student.swing.ButtonOutLine();
        cmdNo = new com.student.swing.ButtonOutLine();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Do you want to logout?");

        cmdYes.setBackground(new java.awt.Color(20, 137, 61));
        cmdYes.setText("Yes");
        cmdYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdYesActionPerformed(evt);
            }
        });

        cmdNo.setBackground(new java.awt.Color(188, 25, 25));
        cmdNo.setText("No");
        cmdNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(cmdYes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdNo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdYes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdYesActionPerformed

        LoginAndRegister log = new LoginAndRegister();
        log.setVisible(true);
        home.dispose();
        
    }//GEN-LAST:event_cmdYesActionPerformed

    private void cmdNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNoActionPerformed
        home.resetHome(); // Khôi phục lại giao diện chính
    }//GEN-LAST:event_cmdNoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine cmdNo;
    private com.student.swing.ButtonOutLine cmdYes;
    private javax.swing.JLabel jLabel2;
    private com.student.swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
