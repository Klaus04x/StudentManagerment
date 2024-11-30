package com.student.view;

import com.student.component.AddLecturePanel;
import com.student.component.CenterTableData;
import com.student.component.EditLecturePanel;
import com.student.model.Lecture;
import com.student.service.ServiceLecture;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class LectureFrame extends javax.swing.JFrame {

    private final Home home;
    private final ServiceLecture serviceLecture;

    public LectureFrame(Home home) {
        this.home = home;
        this.serviceLecture = new ServiceLecture();
        initComponents();
        loadLectureData();
    }

    public void loadLectureData(String searchTerm) {
        try {
            List<Lecture> lectures = serviceLecture.getAllLectures();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Lecture lecture : lectures) {
                if (lecture.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    model.addRow(new Object[]{
                        lecture.getLectureID(),
                        lecture.getName(),
                        lecture.getDepartmentID()
                    });
                }
            }
            CenterTableData.centerTableData(table);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadLectureData() {
        try {
            List<Lecture> lectures = serviceLecture.getAllLectures();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            for (Lecture lecture : lectures) {
                model.addRow(new Object[]{
                    lecture.getLectureID(),
                    lecture.getName(),
                    lecture.getDepartmentID()
                });
            }
            CenterTableData.centerTableData(table);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAddLecturePanel() {
        AddLecturePanel addLecturePanel = new AddLecturePanel(this);
        this.setContentPane(addLecturePanel);
        this.revalidate();
        this.repaint();
    }

    public void showMainPanel() {
        getContentPane().removeAll();
        initComponents();
        loadLectureData(); // Gọi để tải dữ liệu
        revalidate();
        repaint();
    }

    private void showEditLecturePanel() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy thông tin bài giảng từ dòng được chọn
            String lectureID = table.getValueAt(selectedRow, 0).toString(); // Sửa từ studentID thành lectureID
            String name = table.getValueAt(selectedRow, 1).toString();
            int departmentID; // Đổi kiểu thành int

            try {
                departmentID = Integer.parseInt(table.getValueAt(selectedRow, 2).toString()); // Chuyển đổi sang int
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid department ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Trở về nếu có lỗi
            }

            // Tạo và hiển thị panel EditLecturePanel
            EditLecturePanel editPanel = new EditLecturePanel(this, serviceLecture); // Truyền cả serviceLecture và this
            editPanel.setLectureInfo(lectureID, name, departmentID); // Truyền departmentID là int
            this.setContentPane(editPanel);
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a lecture to edit!");
        }
    }

    private void removeLecture() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String lectureID = table.getValueAt(selectedRow, 0).toString(); // Lấy LectureID từ dòng được chọn

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this lecture?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    serviceLecture.deleteLecture(lectureID); // Gọi phương thức xóa
                    loadLectureData(); // Tải lại dữ liệu bảng
                    JOptionPane.showMessageDialog(this, "Remove successful!");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error removing lecture: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a lecture to remove!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addbtn = new com.student.swing.Button();
        editbtn = new com.student.swing.Button();
        deletebtn = new com.student.swing.Button();
        returnbtn = new com.student.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new com.student.swing.MyTextField();
        searchbtn = new com.student.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lecture Manager");

        addbtn.setBackground(new java.awt.Color(0, 197, 185));
        addbtn.setText("Add Lecture");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(204, 167, 45));
        editbtn.setText("Edit Lecture");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        deletebtn.setBackground(new java.awt.Color(255, 110, 9));
        deletebtn.setText("Remove Lecture");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        returnbtn.setBackground(new java.awt.Color(0, 210, 133));
        returnbtn.setText("Return");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Lecture ID", "Name", "Department ID"
            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 137, 61));
        jLabel2.setText("Search Lecture");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        searchbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/student/icon/search.png"))); // NOI18N
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        this.setVisible(false); // Đóng StudentFrame
        home.setVisible(true);
    }//GEN-LAST:event_returnbtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        showAddLecturePanel();
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        showEditLecturePanel();
    }//GEN-LAST:event_editbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        removeLecture();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchTerm = txtSearch.getText().trim(); // Lấy tên sinh viên từ ô tìm kiếm
        loadLectureData(searchTerm);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.Button addbtn;
    private com.student.swing.Button deletebtn;
    private com.student.swing.Button editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.student.swing.Button returnbtn;
    private com.student.swing.Button searchbtn;
    private javax.swing.JTable table;
    private com.student.swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
