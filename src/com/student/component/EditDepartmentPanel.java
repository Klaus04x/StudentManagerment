package com.student.component;

import com.student.service.ServiceDepartment;
import com.student.view.DepartmentFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EditDepartmentPanel extends javax.swing.JPanel {

    private String departmentID; // Đổi tên biến thành departmentID
    private final DepartmentFrame departmentFrame;
    private final ServiceDepartment serviceDepartment;

    public EditDepartmentPanel(DepartmentFrame departmentFrame, ServiceDepartment serviceDepartment) {
        this.departmentFrame = departmentFrame;
        this.serviceDepartment = serviceDepartment; // Sử dụng serviceDepartment được truyền vào
        initComponents();
    }

    public void setDepartmentInfo(String departmentID, String departmentName, String location) {
        this.departmentID = departmentID; // Gán đúng tên biến
        txtName.setText(departmentName);
        txtLocation.setText(location);
    }

    private void submit() {
        String departmentName = txtName.getText(); // Lấy tên phòng ban từ txtName
        String location = txtLocation.getText(); // Lấy vị trí

        if (departmentName.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (serviceDepartment.departmentExists(departmentName, departmentID)) {
                JOptionPane.showMessageDialog(this, "Department name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            serviceDepartment.updateDepartmentInfo(departmentID, departmentName, location);
            JOptionPane.showMessageDialog(this, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            departmentFrame.showMainPanel();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error updating information: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new com.student.swing.MyTextField();
        iLabel2 = new javax.swing.JLabel();
        txtLocation = new com.student.swing.MyTextField();
        buttonOutLine1 = new com.student.swing.ButtonOutLine();
        buttonOutLine2 = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Department");

        jLabel2.setText("Department Name");

        iLabel2.setText("Location");

        buttonOutLine1.setBackground(new java.awt.Color(20, 137, 61));
        buttonOutLine1.setText("OK");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });

        buttonOutLine2.setBackground(new java.awt.Color(188, 25, 25));
        buttonOutLine2.setText("Cancel");
        buttonOutLine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(iLabel2)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(buttonOutLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(iLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOutLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        submit();
    }//GEN-LAST:event_buttonOutLine1ActionPerformed

    private void buttonOutLine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine2ActionPerformed
        departmentFrame.showMainPanel();
    }//GEN-LAST:event_buttonOutLine2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine buttonOutLine1;
    private com.student.swing.ButtonOutLine buttonOutLine2;
    private javax.swing.JLabel iLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.student.swing.MyTextField txtLocation;
    private com.student.swing.MyTextField txtName;
    // End of variables declaration//GEN-END:variables
}
