package com.student.component;

import com.student.service.ServiceLecture;
import com.student.view.LectureFrame;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class EditLecturePanel extends javax.swing.JPanel {

    private LectureFrame lectureFrame;
    private ServiceLecture serviceLecture;
    private String lectureID;

    public EditLecturePanel() {
        initComponents();
    }

    public EditLecturePanel(LectureFrame lectureFrame, ServiceLecture serviceLecture) {
        this.serviceLecture = serviceLecture; // Khởi tạo serviceLecture
        this.lectureFrame = lectureFrame; // Khởi tạo lectureFrame
        initComponents();
    }

    public void setLectureInfo(String lectureID, String name, int departmentID) {
        this.lectureID = lectureID;
        txtName.setText(name);
        txtDepartmentID.setText(String.valueOf(departmentID));
    }

    private void submit() {
        String name = txtName.getText();
        String departmentIDStr = txtDepartmentID.getText();
        int departmentID;

        // Kiểm tra xem các trường có trống hay không
        if (name.isEmpty() || departmentIDStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            departmentID = Integer.parseInt(departmentIDStr); // Chuyển đổi String thành int

            // Kiểm tra xem phòng ban có tồn tại không
            if (!serviceLecture.departmentExists(departmentID)) {
                JOptionPane.showMessageDialog(this, "Department ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra xem giảng viên có tồn tại không
            if (serviceLecture.lectureExists(name, departmentID)) {
                JOptionPane.showMessageDialog(this, "Lecturer with this name and department ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Cập nhật thông tin giảng viên
            serviceLecture.updateLectureInfo(lectureID, name, departmentID);
            JOptionPane.showMessageDialog(this, "Update successful!"); // Thông báo thành công
            lectureFrame.showMainPanel();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid department ID!", "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel3 = new javax.swing.JLabel();
        txtDepartmentID = new com.student.swing.MyTextField();
        OKbtn = new com.student.swing.ButtonOutLine();
        Cancelbtn = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Edit Lecture");

        jLabel2.setText("Name Lecture");

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
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDepartmentID, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)))
                .addContainerGap(28, Short.MAX_VALUE))
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
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDepartmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
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
