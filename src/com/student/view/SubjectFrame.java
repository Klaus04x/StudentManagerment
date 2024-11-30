package com.student.view;

import com.student.component.AddSubjectPanel;
import com.student.component.CenterTableData;
import com.student.component.EditSubjectPanel;
import com.student.model.Subject;
import com.student.service.ServiceSubject;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SubjectFrame extends javax.swing.JFrame {

    private final Home home;
    private final ServiceSubject serviceSubject;

    public SubjectFrame(Home home) {
        this.home = home;
        this.serviceSubject = new ServiceSubject();
        initComponents();
        loadSubjectData();
    }

    public void loadSubjectData() {
        try {
            List<Subject> subjects = serviceSubject.getAllSubject();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (Subject subject : subjects) {
                model.addRow(new Object[]{
                    subject.getSubjectID(),
                    subject.getSubjectName(),
                    subject.getCredits(),
                    subject.getDepartmentID()
                });
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadSubjectData(String searchTerm) {
        try {
            List<Subject> subjects = serviceSubject.getAllSubject();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (Subject subject : subjects) {
                if (subject.getSubjectName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    model.addRow(new Object[]{
                        subject.getSubjectID(),
                        subject.getSubjectName(),
                        subject.getCredits(),
                        subject.getDepartmentID()
                    });
                }
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAddSubjectPanel() {
        AddSubjectPanel addSubjectPanel = new AddSubjectPanel(this);
        this.setContentPane(addSubjectPanel);
        this.revalidate();
        this.repaint();
    }

    private void showEditSubjectPanel() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy thông tin môn học từ dòng được chọn
            String subjectID = jTable1.getValueAt(selectedRow, 0).toString();
            String subjectName = jTable1.getValueAt(selectedRow, 1).toString();
            String credits = jTable1.getValueAt(selectedRow, 2).toString();
            String departmentID = jTable1.getValueAt(selectedRow, 3).toString(); // Lấy DepartmentID

            // Tạo và hiển thị panel EditSubjectPanel
            EditSubjectPanel editPanel = new EditSubjectPanel(this, serviceSubject);
            editPanel.setSubjectInfo(subjectID, subjectName, credits, departmentID); // Gọi phương thức để thiết lập thông tin
            this.setContentPane(editPanel);
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a subject to edit!");
        }
    }

    private void removeSubject() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String subjectID = jTable1.getValueAt(selectedRow, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this subject?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Gọi phương thức xóa từ ServiceSubject
                    serviceSubject.removeSubject(subjectID);
                    JOptionPane.showMessageDialog(this, "Subject removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadSubjectData(); // Tải lại dữ liệu
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error removing subject: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a subject to remove!");
        }
    }

    public void showMainPanel() {
        getContentPane().removeAll();
        initComponents();
        loadSubjectData(); // Gọi để tải dữ liệu
        revalidate();
        repaint();
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
        jLabel1.setText("Subject Manager");

        addbtn.setBackground(new java.awt.Color(0, 197, 185));
        addbtn.setText("Add Subject");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(204, 167, 45));
        editbtn.setText("Edit Subject");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        removebtn.setBackground(new java.awt.Color(255, 110, 9));
        removebtn.setText("Remove Subject");
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
                "Subject ID", "Subject Name", "Credits", "Department ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 137, 61));
        jLabel2.setText("Search Subject");

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
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_returnbtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchTerm = txtSearch.getText().trim();
        loadSubjectData(searchTerm);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        showAddSubjectPanel();
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        showEditSubjectPanel();
    }//GEN-LAST:event_editbtnActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        removeSubject();
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
