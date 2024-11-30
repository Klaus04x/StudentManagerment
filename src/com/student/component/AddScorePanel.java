package com.student.component;

import com.student.model.Score;
import com.student.service.ServiceScore;
import com.student.view.ScoreFrame;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddScorePanel extends javax.swing.JPanel {

    private final ScoreFrame scoreFrame;
    private final ServiceScore serviceScore;

    public AddScorePanel(ScoreFrame scoreFrame) {
        initComponents();
        this.scoreFrame = scoreFrame;
        serviceScore = new ServiceScore(); // Khởi tạo dịch vụ
        loadStudentData(); // Tải dữ liệu sinh viên
        loadSubjectData();
    }

    private void loadStudentData() {
        try {
            List<String> studentIDs = serviceScore.getAllStudentIDs();
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (String id : studentIDs) {
                model.addElement(id);
            }
            boxstudentID.setModel(model);
        } catch (SQLException e) {

        }
    }

    private void loadSubjectData() {
        try {
            List<String> subjectIDs = serviceScore.getAllSubjectIDs(); // Lấy danh sách subjectID từ ServiceScore
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (String id : subjectIDs) {
                model.addElement(id);
            }
            boxsubjectID.setModel(model);
        } catch (SQLException e) {
        }
    }

    private void submit() {
        String studentID = (String) boxstudentID.getSelectedItem();
        String subjectID = (String) boxsubjectID.getSelectedItem();
        String marksStr = txtMark.getText();

        // Kiểm tra dữ liệu hợp lệ
        if (studentID == null || subjectID == null || marksStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Kiểm tra xem mark có phải là số và nằm trong khoảng 0 đến 10 không
        double marks;
        try {
            marks = Double.parseDouble(marksStr);
            if (marks < 0 || marks > 10) {
                JOptionPane.showMessageDialog(this, "The score must be between 0 and 10!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid score (number)!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Kiểm tra xem điểm đã tồn tại hay chưa
            if (serviceScore.checkScoreExists(studentID, subjectID)) {
                JOptionPane.showMessageDialog(this, "The score for this student and this subject already exists!", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Tạo đối tượng Score mới mà không cần MarkID
            Score newScore = new Score(studentID, subjectID, marksStr);

            // Gọi phương thức thêm điểm trong ServiceScore
            serviceScore.addScore(newScore);

            JOptionPane.showMessageDialog(this, "Score added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            scoreFrame.showMainPanel(); // Quay lại ScoreFrame
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding score: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxstudentID = new javax.swing.JComboBox<>();
        boxsubjectID = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMark = new com.student.swing.MyTextField();
        Okbtn = new com.student.swing.ButtonOutLine();
        Cancelbtn = new com.student.swing.ButtonOutLine();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Score");

        jLabel2.setText("Student ID");

        jLabel3.setText("Subject ID");

        boxstudentID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxstudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxstudentIDActionPerformed(evt);
            }
        });

        boxsubjectID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxsubjectID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxsubjectIDActionPerformed(evt);
            }
        });

        jLabel4.setText("Mark");

        Okbtn.setBackground(new java.awt.Color(20, 137, 61));
        Okbtn.setText("OK");
        Okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkbtnActionPerformed(evt);
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
                        .addComponent(jLabel4)
                        .addComponent(boxsubjectID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxstudentID, 0, 505, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(txtMark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Okbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)))
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
                .addComponent(boxstudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxsubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Okbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxstudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxstudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxstudentIDActionPerformed

    private void OkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkbtnActionPerformed
        submit();
    }//GEN-LAST:event_OkbtnActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        scoreFrame.showMainPanel();
    }//GEN-LAST:event_CancelbtnActionPerformed

    private void boxsubjectIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxsubjectIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxsubjectIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine Cancelbtn;
    private com.student.swing.ButtonOutLine Okbtn;
    private javax.swing.JComboBox<String> boxstudentID;
    private javax.swing.JComboBox<String> boxsubjectID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private com.student.swing.MyTextField txtMark;
    // End of variables declaration//GEN-END:variables
}
