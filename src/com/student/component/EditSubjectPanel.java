package com.student.component;

import com.student.service.ServiceSubject;
import com.student.view.SubjectFrame;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class EditSubjectPanel extends javax.swing.JPanel {

    private final SubjectFrame subjectFrame;
    private final ServiceSubject serviceSubject;
    private String subjectID;

    public EditSubjectPanel(SubjectFrame subjectFrame, ServiceSubject serviceSubject) {
        this.subjectFrame = subjectFrame;
        this.serviceSubject = serviceSubject; // Sử dụng đối tượng được truyền vào
        initComponents();
    }

    public void setSubjectInfo(String subjectID, String subjectName, String credits, String departmentID) {
        this.subjectID = subjectID;
        txtName.setText(subjectName);
        txtCredits.setText(credits);
        txtDepartmentID.setText(departmentID);
    }

    private void submit() {
        String subjectName = txtName.getText();
        String credits = txtCredits.getText();
        String departmentIDStr = txtDepartmentID.getText();

        if (subjectName.isEmpty() || credits.isEmpty() || departmentIDStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int departmentID = Integer.parseInt(departmentIDStr);

            // Kiểm tra xem môn học có tồn tại hay không
            if (!serviceSubject.isSubjectExists(subjectID)) {
                JOptionPane.showMessageDialog(this, "Subject does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra xem tên môn học mới có trùng với tên môn học khác không
            if (serviceSubject.isSubjectNameExists(subjectName, subjectID)) {
                JOptionPane.showMessageDialog(this, "Subject name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cập nhật thông tin môn học
            serviceSubject.updateSubject(subjectID, subjectName, credits, departmentID);
            JOptionPane.showMessageDialog(this, "Update successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            subjectFrame.showMainPanel();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Department ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
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
        jLable3 = new javax.swing.JLabel();
        txtCredits = new com.student.swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDepartmentID = new com.student.swing.MyTextField();
        OKbtn = new com.student.swing.ButtonOutLine();
        Cancelbtn = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Subject");

        jLabel2.setText("Subject Name");

        jLable3.setText("Credits");

        jLabel3.setText("Department ID");

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLable3)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDepartmentID, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)))
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
                .addComponent(jLable3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        submit();
    }//GEN-LAST:event_OKbtnActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        subjectFrame.showMainPanel();
    }//GEN-LAST:event_CancelbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine Cancelbtn;
    private com.student.swing.ButtonOutLine OKbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLable3;
    private com.student.swing.MyTextField txtCredits;
    private com.student.swing.MyTextField txtDepartmentID;
    private com.student.swing.MyTextField txtName;
    // End of variables declaration//GEN-END:variables
}
