package com.student.component;

import com.student.model.Class;
import com.student.service.ServiceClass;
import com.student.view.ClassFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddClassPanel extends javax.swing.JPanel {

    private final ServiceClass serviceClass;
    private final ClassFrame classFrame;
    public AddClassPanel(ClassFrame classFrame) {
        this.classFrame = classFrame;
        this.serviceClass = new ServiceClass();
        initComponents();
    }

    private void submit() {
    String name = txtName.getText();
    String departmentID = txtDepartmentID.getText();

    // Kiểm tra dữ liệu nhập vào
    if (name.isEmpty() || departmentID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the information.!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Kiểm tra xem departmentID có tồn tại không
        int depID = Integer.parseInt(departmentID); // Chuyển đổi sang kiểu int
        if (!serviceClass.departmentExists(depID)) {
            JOptionPane.showMessageDialog(this, "Department ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra xem lớp đã tồn tại chưa
        if (serviceClass.classExists(name, depID)) {
            JOptionPane.showMessageDialog(this, "Class already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Class newClass = new Class(name, departmentID);

        // Thêm vào cơ sở dữ liệu
        serviceClass.addClass(newClass);
        JOptionPane.showMessageDialog(this, "Class added successfully!");
        classFrame.show();
        txtName.setText("");
        txtDepartmentID.setText("");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error adding class: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Department ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new com.student.swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDepartmentID = new com.student.swing.MyTextField();
        OKbtn = new com.student.swing.ButtonOutLine();
        buttonOutLine1 = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Class");

        jLabel2.setText("Class Name");

        jLabel3.setText("Department ID");

        OKbtn.setBackground(new java.awt.Color(20, 137, 61));
        OKbtn.setText("OK");
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbtnActionPerformed(evt);
            }
        });

        buttonOutLine1.setBackground(new java.awt.Color(188, 25, 25));
        buttonOutLine1.setText("Cancel");
        buttonOutLine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutLine1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDepartmentID, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        submit();
    }//GEN-LAST:event_OKbtnActionPerformed

    private void buttonOutLine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutLine1ActionPerformed
        classFrame.showMainPanel();
    }//GEN-LAST:event_buttonOutLine1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine OKbtn;
    private com.student.swing.ButtonOutLine buttonOutLine1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.student.swing.MyTextField txtDepartmentID;
    private com.student.swing.MyTextField txtName;
    // End of variables declaration//GEN-END:variables
}
