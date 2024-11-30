package com.student.view;

import com.student.component.AddClassPanel;
import com.student.component.CenterTableData;
import com.student.component.EditClassPanel;
import com.student.model.Class;
import com.student.service.ServiceClass;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClassFrame extends javax.swing.JFrame {

    private final Home home;
    private final ServiceClass serviceClass;

    public ClassFrame(Home home) {
        this.home = home;
        this.serviceClass = new ServiceClass();
        initComponents();
        loadClassData();
    }

    public void showMainPanel() {
        getContentPane().removeAll();
        initComponents();
        loadClassData(); // Gọi để tải dữ liệu
        revalidate();
        repaint();
    }

    private void showAddClassPanel() {
        AddClassPanel addClassPanel = new AddClassPanel(this);
        this.setContentPane(addClassPanel);
        this.revalidate();
        this.repaint();
    }

    public void loadClassData(String searchTerm) {
        try {
            List<Class> classes = serviceClass.getAllClass();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (Class Class : classes) {
                if (Class.getClassName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    model.addRow(new Object[]{
                        Class.getClassID(),
                        Class.getClassName(),
                        Class.getDepartmentID()
                    });
                }
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadClassData() {
        try {
            List<Class> classes = serviceClass.getAllClass();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (Class Class : classes) {
                model.addRow(new Object[]{
                    Class.getClassID(),
                    Class.getClassName(),
                    Class.getDepartmentID()
                });
            }
            CenterTableData.centerTableData(jTable1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showEditClassPanel() {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String classID = jTable1.getValueAt(selectedRow, 0).toString(); // Class ID
            String className = jTable1.getValueAt(selectedRow, 1).toString(); // Class Name
            int departmentID;

            try {
                departmentID = Integer.parseInt(jTable1.getValueAt(selectedRow, 2).toString()); // Department ID
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid department ID!", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Trở về nếu có lỗi
            }

            // Tạo và hiển thị panel EditClassPanel
            EditClassPanel editPanel = new EditClassPanel(this, serviceClass);
            editPanel.setClassInfo(classID, className, departmentID); // Truyền thông tin lớp
            this.setContentPane(editPanel);
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a class to edit!");
        }
    }

    private void removeClass(){
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String classID = jTable1.getValueAt(selectedRow, 0).toString();

            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this class?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    serviceClass.deleteClass(classID); // Gọi phương thức xóa
                    loadClassData(); // Tải lại dữ liệu bảng
                    JOptionPane.showMessageDialog(this, "Remove successful!");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error removing class: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a class to remove!");
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
        jLabel1.setText("Class Manager");

        addbtn.setBackground(new java.awt.Color(0, 197, 185));
        addbtn.setText("Add Class");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(204, 167, 45));
        editbtn.setText("Edit Class");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        removebtn.setBackground(new java.awt.Color(255, 110, 9));
        removebtn.setText("Remove Class");
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Class ID", "Class Name", "Department ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 137, 61));
        jLabel2.setText("Search Class");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        String searchTerm = txtSearch.getText().trim(); // Lấy tên sinh viên từ ô tìm kiếm
        loadClassData(searchTerm);
    }//GEN-LAST:event_searchbtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        showAddClassPanel();
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        showEditClassPanel();
    }//GEN-LAST:event_editbtnActionPerformed

    private void returnbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnbtnActionPerformed
        this.setVisible(false); // Đóng StudentFrame
        home.setVisible(true);
    }//GEN-LAST:event_returnbtnActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        removeClass();
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
