package com.student.view;

import com.student.component.AddScorePanel;
import com.student.model.Score;
import com.student.component.CenterTableData;
import com.student.component.EditScorePanel;
import com.student.service.ServiceScore;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ScoreFrame extends javax.swing.JFrame {

    private final Home home;
    private final ServiceScore serviceScore;

    public ScoreFrame(Home home) {
        this.home = home;
        this.serviceScore = new ServiceScore();
        initComponents();
        loadScoreData();
    }

    public void showMainPanel() {
        getContentPane().removeAll();
        initComponents();
        loadScoreData(); // Gọi để tải dữ liệu
        revalidate();
        repaint();
    }

    private void showAddScorePanel() {
        AddScorePanel addScorePanel = new AddScorePanel(this);
        this.setContentPane(addScorePanel);
        this.revalidate();
        this.repaint();
    }

    private void showEditScore() {
        // Lấy thông tin từ jTable1 (giả sử bạn đã chọn dòng)
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy thông tin từ dòng đã chọn
            String studentID = jTable1.getValueAt(selectedRow, 1).toString();
            String subjectID = jTable1.getValueAt(selectedRow, 2).toString();
            String marks = jTable1.getValueAt(selectedRow, 3).toString();

            // Tạo EditScorePanel và truyền thông tin
            EditScorePanel editScorePanel = new EditScorePanel(this);
            editScorePanel.setValues(studentID, subjectID, marks); // Phương thức mới để thiết lập giá trị

            this.setContentPane(editScorePanel);
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void loadScoreData() {
        try {
            List<Score> score = serviceScore.getAllScore();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (Score scores : score) {
                model.addRow(new Object[]{
                    scores.getMarkID(),
                    scores.getStudentID(),
                    scores.getSubjectID(),
                    scores.getMarks()
                });
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadScoreData(String searchTerm) {
        try {
            List<Score> score = serviceScore.getAllScore();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (Score scores : score) {
                if (scores.getStudentID().toLowerCase().contains(searchTerm.toLowerCase())) {
                    model.addRow(new Object[]{
                        scores.getMarkID(),
                        scores.getStudentID(),
                        scores.getSubjectID(),
                        scores.getMarks()
                    });
                }
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeScore() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String markID = jTable1.getValueAt(selectedRow, 0).toString(); // Lấy ID của đối tượng để xóa

            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this score?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    serviceScore.removeScore(markID); // Gọi phương thức xóa
                    JOptionPane.showMessageDialog(this, "Remove successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Cập nhật lại bảng sau khi xóa
                    loadScoreData(); // Phương thức để tải lại dữ liệu vào bảng
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error removing: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to remove!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addbtn = new com.student.swing.Button();
        editbtn = new com.student.swing.Button();
        removebtn = new com.student.swing.Button();
        returnbtn = new com.student.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new com.student.swing.MyTextField();
        searchbtn = new com.student.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Score Manager");

        addbtn.setBackground(new java.awt.Color(0, 197, 185));
        addbtn.setText("Add Score");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(204, 167, 45));
        editbtn.setText("Edit Score");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        removebtn.setBackground(new java.awt.Color(255, 110, 9));
        removebtn.setText("Remove Score");
        removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtnActionPerformed(evt);
            }
        });

        returnbtn.setBackground(new java.awt.Color(0, 210, 133));
        returnbtn.setText("Return");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Marks ID", "Student ID", "Subject ID", "Marks"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 137, 61));
        jLabel2.setText("Search Student ID");

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
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
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
                    .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchTerm = txtSearch.getText().trim(); // Lấy tên sinh viên từ ô tìm kiếm
        loadScoreData(searchTerm);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        showAddScorePanel();
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        showEditScore();
    }//GEN-LAST:event_editbtnActionPerformed

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        this.setVisible(false); // Đóng StudentFrame
        home.setVisible(true);
    }//GEN-LAST:event_returnbtnActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        removeScore();
    }//GEN-LAST:event_removebtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.Button addbtn;
    private com.student.swing.Button editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.student.swing.Button removebtn;
    private com.student.swing.Button returnbtn;
    private com.student.swing.Button searchbtn;
    private com.student.swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}