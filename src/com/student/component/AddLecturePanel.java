package com.student.component;

import com.student.model.Lecture;
import com.student.service.ServiceLecture;
import com.student.view.LectureFrame;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddLecturePanel extends javax.swing.JPanel {

    private final LectureFrame lectureFrame;
    private final ServiceLecture serviceLecture;

    public AddLecturePanel(LectureFrame lectureFrame) {
        this.lectureFrame = lectureFrame;
        this.serviceLecture = new ServiceLecture();
        initComponents();
    }

    private void submit() {
        String name = txtName.getText();
        String departmentIDStr = txtDepartmentID.getText();

        // Kiểm tra dữ liệu nhập vào
        if (name.isEmpty() || departmentIDStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chuyển đổi departmentID sang int
        int departmentID;
        try {
            departmentID = Integer.parseInt(departmentIDStr); // Chuyển đổi
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Department ID must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra xem departmentID có tồn tại không
        try {
            if (!serviceLecture.departmentExists(departmentID)) {
                JOptionPane.showMessageDialog(this, "Department ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error checking department ID: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Lecture newLecture = new Lecture(name, departmentID); // Sử dụng int cho departmentID

        // Thêm vào cơ sở dữ liệu
        try {
            serviceLecture.addLecture(newLecture);
            JOptionPane.showMessageDialog(this, "Lecture added successfully!");
            lectureFrame.show();
            txtName.setText("");
            txtDepartmentID.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding lecture: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDepartmentID = new com.student.swing.MyTextField();
        txtName = new com.student.swing.MyTextField();
        OKbtn = new com.student.swing.ButtonOutLine();
        Cancelbtn = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Lecture");

        jLabel2.setText("Lecture Name");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                                .addComponent(txtDepartmentID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
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
                    .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        submit();
    }//GEN-LAST:event_OKbtnActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        lectureFrame.showMainPanel();
    }//GEN-LAST:event_CancelbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine Cancelbtn;
    private com.student.swing.ButtonOutLine OKbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private com.student.swing.MyTextField txtDepartmentID;
    private com.student.swing.MyTextField txtName;
    // End of variables declaration//GEN-END:variables
}
