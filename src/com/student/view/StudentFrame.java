package com.student.view;

import com.student.component.AddStudentPanel;
import com.student.component.CenterTableData;
import com.student.component.EditStudentPanel;
import com.student.model.Student;
import com.student.service.ServiceStudent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class StudentFrame extends javax.swing.JFrame {

    private final Home home;
    private final ServiceStudent serviceStudent;

    public StudentFrame(Home home) {
        this.home = home;
        this.serviceStudent = new ServiceStudent();
        initComponents();
        loadStudentData();
    }

    public void loadStudentData(String searchTerm) {
    try {
        List<Student> students = serviceStudent.getAllStudents();
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                model.addRow(new Object[]{
                    student.getStudentID(),
                    student.getName(),
                    student.getBirthday(),
                    student.getClassID()
                });
            }
        }
        CenterTableData.centerTableData(tbl);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    public void loadStudentData() {
        try {
            List<Student> students = serviceStudent.getAllStudents();
            DefaultTableModel model = (DefaultTableModel) tbl.getModel();
            model.setRowCount(0);

            for (Student student : students) {
                model.addRow(new Object[]{
                    student.getStudentID(),
                    student.getName(),
                    student.getBirthday(),
                    student.getClassID()
                });
            }
            CenterTableData.centerTableData(tbl);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void showMainPanel() {
        getContentPane().removeAll();
        initComponents();
        loadStudentData();
        revalidate();
        repaint();
    }

    private void showAddStudentPanel() {
        AddStudentPanel addStudentPanel = new AddStudentPanel(this);
        this.setContentPane(addStudentPanel);
        this.revalidate();
        this.repaint();
    }

    private void showEditStudentPanel() {
        int selectedRow = tbl.getSelectedRow();
        if (selectedRow != -1) {
            // Lấy thông tin sinh viên từ dòng được chọn
            String studentID = tbl.getValueAt(selectedRow, 0).toString();
            String name = tbl.getValueAt(selectedRow, 1).toString();
            String birthday = tbl.getValueAt(selectedRow, 2).toString();
            String classID = tbl.getValueAt(selectedRow, 3).toString();

            // Tạo và hiển thị panel EditStudentPanel
            EditStudentPanel editPanel = new EditStudentPanel(serviceStudent, this); // Truyền cả serviceStudent và this
            editPanel.setStudentInfo(studentID, name, birthday, classID);
            this.setContentPane(editPanel);
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to edit!");
        }
    }

    private void deleteStudent() {
        int selectedRow = tbl.getSelectedRow();
        if (selectedRow != -1) {
            String studentID = tbl.getValueAt(selectedRow, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this student?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    serviceStudent.deleteStudent(studentID);
                    JOptionPane.showMessageDialog(this, "Student removed successfully!");
                    showMainPanel();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error removing: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to remove!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        addStudentbtn = new com.student.swing.Button();
        removebtn = new com.student.swing.Button();
        returnbtn = new com.student.swing.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        editbtn = new com.student.swing.Button();
        txtSearch = new com.student.swing.MyTextField();
        jLabel2 = new javax.swing.JLabel();
        searchbtn = new com.student.swing.Button();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Manager");

        addStudentbtn.setBackground(new java.awt.Color(0, 197, 185));
        addStudentbtn.setText("Add Student");
        addStudentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentbtnActionPerformed(evt);
            }
        });

        removebtn.setBackground(new java.awt.Color(255, 110, 9));
        removebtn.setText("Remove Student");
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

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Name Student", "Birthday", "Class ID"
            }
        ));
        jScrollPane2.setViewportView(tbl);

        editbtn.setBackground(new java.awt.Color(204, 167, 45));
        editbtn.setText("Edit Student");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 137, 61));
        jLabel2.setText("Search Student");

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
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addStudentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStudentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addStudentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentbtnActionPerformed
        showAddStudentPanel();
    }//GEN-LAST:event_addStudentbtnActionPerformed

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        this.setVisible(false); // Đóng StudentFrame
        home.setVisible(true); // Hiển thị lại Home
    }//GEN-LAST:event_returnbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        showEditStudentPanel();
    }//GEN-LAST:event_editbtnActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        deleteStudent();
    }//GEN-LAST:event_removebtnActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchTerm = txtSearch.getText().trim(); // Lấy tên sinh viên từ ô tìm kiếm
        loadStudentData(searchTerm);
    }//GEN-LAST:event_searchbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.Button addStudentbtn;
    private com.student.swing.Button editbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.student.swing.Button removebtn;
    private com.student.swing.Button returnbtn;
    private com.student.swing.Button searchbtn;
    private javax.swing.JTable tbl;
    private com.student.swing.MyTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
