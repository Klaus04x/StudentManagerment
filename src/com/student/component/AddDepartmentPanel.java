package com.student.component;

import com.student.model.Department;
import com.student.service.ServiceDepartment;
import com.student.view.DepartmentFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddDepartmentPanel extends javax.swing.JPanel {

    private final DepartmentFrame departmentFrame;
    private final ServiceDepartment serviceDepartment;

    public AddDepartmentPanel(DepartmentFrame departmentFrame) {
        this.departmentFrame = departmentFrame;
        this.serviceDepartment = new ServiceDepartment();
        initComponents();
    }

    private void submit() {
        String name = txtName.getText();
        String location = txtLocation.getText();

        // Kiểm tra dữ liệu nhập vào
        if (name.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Kiểm tra xem khoa đã tồn tại chưa
            if (serviceDepartment.departmentExists(name)) {
                JOptionPane.showMessageDialog(this, "Department already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Department newDepartment = new Department(name, location);

            // Thêm vào cơ sở dữ liệu
            serviceDepartment.addDepartment(newDepartment);
            JOptionPane.showMessageDialog(this, "Department added successfully!");
            departmentFrame.show();
            txtName.setText("");
            txtLocation.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding department: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new com.student.swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLocation = new com.student.swing.MyTextField();
        OKbtn = new com.student.swing.ButtonOutLine();
        Cancelbtn = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Department");

        jLabel2.setText("Department Name");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Location");

        OKbtn.setBackground(new java.awt.Color(20, 137, 61));
        OKbtn.setText("OK");
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbtnActionPerformed(evt);
            }
        });

        Cancelbtn.setBackground(new java.awt.Color(188, 25, 25));
        Cancelbtn.setText("Cancel");
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        submit();
    }//GEN-LAST:event_OKbtnActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        departmentFrame.showMainPanel();
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine Cancelbtn;
    private com.student.swing.ButtonOutLine OKbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.student.swing.MyTextField txtLocation;
    private com.student.swing.MyTextField txtName;
    // End of variables declaration//GEN-END:variables
}
