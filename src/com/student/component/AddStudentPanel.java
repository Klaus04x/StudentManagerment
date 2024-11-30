package com.student.component;

import com.student.model.Student;
import com.student.view.StudentFrame;
import javax.swing.JOptionPane;
import com.student.service.ServiceStudent;
import java.util.Date;
import java.sql.SQLException;

public class AddStudentPanel extends javax.swing.JPanel {

    private final StudentFrame studentFrame;
    private final ServiceStudent serviceStudent;

    public AddStudentPanel(StudentFrame studentFrame) {
        this.studentFrame = studentFrame; // Gán đối tượng StudentFrame
        this.serviceStudent = new ServiceStudent(); // Khởi tạo ServiceStudent
        initComponents();
    }

    private void submit() {
        String name = txtName.getText();
        String birthdayStr = txtBirthday.getText();
        String classID = txtClassID.getText();

        // Kiểm tra dữ liệu nhập vào
        if (name.isEmpty() || birthdayStr.isEmpty() || classID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the information!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chuyển đổi ngày sinh
        Date birthday;
        try {
            birthday = java.sql.Date.valueOf(birthdayStr); // Đảm bảo định dạng đúng
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Invalid date of birth!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tạo đối tượng Student mà không cần idStudent
        Student newStudent = new Student(name, birthday, classID);

        // Thêm vào cơ sở dữ liệu
        try {
            serviceStudent.addStudent(newStudent);
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            studentFrame.showMainPanel();
//            studentFrame.loadStudentData();

            // Làm sạch các trường nhập liệu
            txtName.setText("");
            txtBirthday.setText("");
            txtClassID.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error adding student: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new com.student.swing.MyTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBirthday = new com.student.swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        txtClassID = new com.student.swing.MyTextField();
        OKbtn = new com.student.swing.ButtonOutLine();
        cancelbtn = new com.student.swing.ButtonOutLine();

        jLabel2.setText("jLabel2");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Student");

        jLabel3.setText("Student Name");

        jLabel4.setText("Birthday(yyyy-mm-dd)");

        txtBirthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBirthdayActionPerformed(evt);
            }
        });

        jLabel5.setText("Class ID");

        OKbtn.setBackground(new java.awt.Color(20, 137, 61));
        OKbtn.setText("OK");
        OKbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbtnActionPerformed(evt);
            }
        });

        cancelbtn.setBackground(new java.awt.Color(188, 25, 25));
        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtClassID, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtClassID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBirthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBirthdayActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        studentFrame.showMainPanel();
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void OKbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKbtnActionPerformed
        submit();
    }//GEN-LAST:event_OKbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.ButtonOutLine OKbtn;
    private com.student.swing.ButtonOutLine cancelbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private com.student.swing.MyTextField txtBirthday;
    private com.student.swing.MyTextField txtClassID;
    private com.student.swing.MyTextField txtName;
    // End of variables declaration//GEN-END:variables

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
