package com.student.view;

import com.student.component.AddDepartmentPanel;
import com.student.component.CenterTableData;
import com.student.component.EditDepartmentPanel;
import com.student.model.Department;
import com.student.service.ServiceDepartment;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class DepartmentFrame extends javax.swing.JFrame {

    private final Home home;
    private final ServiceDepartment serviceDepartment;

    public DepartmentFrame(Home home) {
        this.home = home;
        this.serviceDepartment = new ServiceDepartment();
        initComponents();
        loadDepartmentData();
    }

    public void loadDepartmentData(String searchTerm) {
        try {
            List<Department> departments = serviceDepartment.getAllDepartment();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (Department department : departments) {
                if (department.getDepartmentName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    model.addRow(new Object[]{
                        department.getDepartmentID(),
                        department.getDepartmentName(),
                        department.getLocation()
                    });
                }
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadDepartmentData() {
        try {
            List<Department> departments = serviceDepartment.getAllDepartment();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (Department department : departments) {
                model.addRow(new Object[]{
                    department.getDepartmentID(),
                    department.getDepartmentName(),
                    department.getLocation()
                });
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showAddDeparmentPanel() {
        AddDepartmentPanel addDepartmentPanel = new AddDepartmentPanel(this);
        this.setContentPane(addDepartmentPanel);
        this.revalidate();
        this.repaint();
    }

    public void showMainPanel() {
        getContentPane().removeAll();
        initComponents();
        loadDepartmentData(); // Gọi để tải dữ liệu
        revalidate();
        repaint();
    }

    private void showEditDepartmentPanel() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String departmentID = jTable1.getValueAt(selectedRow, 0).toString();
            String departmentName = jTable1.getValueAt(selectedRow, 1).toString();
            String location = jTable1.getValueAt(selectedRow, 2).toString();

            EditDepartmentPanel editPanel = new EditDepartmentPanel(this, serviceDepartment);
            editPanel.setDepartmentInfo(departmentID, departmentName, location);

            this.setContentPane(editPanel);
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a department to edit!");
        }
    }

    private void removeDepartment() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String departmentID = jTable1.getValueAt(selectedRow, 0).toString();
            int confirmation = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to remove this department?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    serviceDepartment.removeDepartment(departmentID);
                    loadDepartmentData(); // Tải lại dữ liệu sau khi xóa
                    JOptionPane.showMessageDialog(this, "Department removed successfully!");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error removing department: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a department to remove!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        returnbtn = new com.student.swing.Button();
        addbtn = new com.student.swing.Button();
        editbtn = new com.student.swing.Button();
        removebtn = new com.student.swing.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new com.student.swing.MyTextField();
        searchbtn = new com.student.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 137, 61));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Department Manager");

        returnbtn.setBackground(new java.awt.Color(0, 210, 133));
        returnbtn.setText("Return");
        returnbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnbtnActionPerformed(evt);
            }
        });

        addbtn.setBackground(new java.awt.Color(0, 197, 185));
        addbtn.setText("Add Department");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(204, 167, 45));
        editbtn.setText("Edit Department");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        removebtn.setBackground(new java.awt.Color(255, 110, 9));
        removebtn.setText("Remove Department");
        removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Department ID", "Name", "Location"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 137, 61));
        jLabel2.setText("Search Department");

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_returnbtnActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchTerm = txtSearch.getText().trim(); // Lấy tên sinh viên từ ô tìm kiếm
        loadDepartmentData(searchTerm);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        showAddDeparmentPanel();
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        showEditDepartmentPanel();
    }//GEN-LAST:event_editbtnActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        removeDepartment();
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
