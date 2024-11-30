package com.student.component;

import com.student.model.Subject;
import com.student.service.ServiceSubject;
import com.student.view.SubjectFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddSubjectPanel extends javax.swing.JPanel {

    private final SubjectFrame subjectFrame;
    private final ServiceSubject serviceSubject;

    public AddSubjectPanel(SubjectFrame subjectFrame) {
        this.subjectFrame = subjectFrame;
        this.serviceSubject = new ServiceSubject();
        initComponents();
    }

    private void submit() {
        String name = txtName.getText();
        String credits = txtCredits.getText();
        String departmentID = txtdepartmentID.getText();

        // Kiểm tra dữ liệu nhập vào
        if (name.isEmpty() || credits.isEmpty() || departmentID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Kiểm tra xem departmentID có tồn tại không
            if (!serviceSubject.departmentExists(departmentID)) {
                JOptionPane.showMessageDialog(this, "Department ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra xem tên môn học có tồn tại không
            if (serviceSubject.subjectExists(name)) {
                JOptionPane.showMessageDialog(this, "Subject name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Thêm môn học vào cơ sở dữ liệu
            Subject newSubject = new Subject(name, credits, departmentID);
            serviceSubject.addSubject(newSubject);
            JOptionPane.showMessageDialog(this, "Subject added successfully!");

            // Reset các trường nhập liệu
            txtName.setText("");
            txtCredits.setText("");
            txtdepartmentID.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding subject: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new com.student.swing.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCredits = new com.student.swing.MyTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdepartmentID = new com.student.swing.MyTextField();
        OKbtn = new com.student.swing.ButtonOutLine();
        Cancelbtn = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Subject");

        jLabel2.setText("Subject Name");

        jLabel3.setText("Credits");

        jLabel4.setText("Department ID");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdepartmentID, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)))
                .addGap(0, 30, Short.MAX_VALUE))
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
                .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JLabel jLabel4;
    private com.student.swing.MyTextField txtCredits;
    private com.student.swing.MyTextField txtName;
    private com.student.swing.MyTextField txtdepartmentID;
    // End of variables declaration//GEN-END:variables
}
