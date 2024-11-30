package com.student.view;

import com.student.component.PanelLogout;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
    }

    public void resetHome() {
        getContentPane().removeAll();
        initComponents();
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        lecturebtn = new com.student.swing.Button();
        classbtn = new com.student.swing.Button();
        logoutbtn = new com.student.swing.Button();
        scorebtn = new com.student.swing.Button();
        studentbtn = new com.student.swing.Button();
        subjectbtn = new com.student.swing.Button();
        departmentbtn = new com.student.swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 137, 61));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student Manager Program");

        lecturebtn.setBackground(new java.awt.Color(255, 204, 112));
        lecturebtn.setText("Lecture Manager");
        lecturebtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lecturebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecturebtnActionPerformed(evt);
            }
        });

        classbtn.setBackground(new java.awt.Color(255, 118, 62));
        classbtn.setText("Class Manager");
        classbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        classbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classbtnActionPerformed(evt);
            }
        });

        logoutbtn.setBackground(new java.awt.Color(255, 146, 83));
        logoutbtn.setText("Logout");
        logoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        scorebtn.setBackground(new java.awt.Color(61, 176, 61));
        scorebtn.setText("Score Manager");
        scorebtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        scorebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scorebtnActionPerformed(evt);
            }
        });

        studentbtn.setBackground(new java.awt.Color(102, 174, 206));
        studentbtn.setText("Student Manager");
        studentbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentbtnActionPerformed(evt);
            }
        });

        subjectbtn.setBackground(new java.awt.Color(0, 182, 142));
        subjectbtn.setText("Subject Manager");
        subjectbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        subjectbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectbtnActionPerformed(evt);
            }
        });

        departmentbtn.setBackground(new java.awt.Color(255, 172, 78));
        departmentbtn.setText("Department Manager");
        departmentbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        departmentbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(classbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lecturebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scorebtn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(departmentbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(departmentbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(studentbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lecturebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scorebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        PanelLogout logoutPanel = new PanelLogout(this);
        this.setContentPane(logoutPanel);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_logoutbtnActionPerformed

    private void scorebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scorebtnActionPerformed
        this.setVisible(false);
        ScoreFrame scoreFrame = new ScoreFrame(this);
        scoreFrame.setVisible(true);
    }//GEN-LAST:event_scorebtnActionPerformed

    private void studentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentbtnActionPerformed
        this.setVisible(false); // Ẩn Home
        StudentFrame studentfr = new StudentFrame(this); // Truyền đối tượng Home
        studentfr.setVisible(true); // Hiển thị StudentFrame
    }//GEN-LAST:event_studentbtnActionPerformed

    private void lecturebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecturebtnActionPerformed
        this.setVisible(false);
        LectureFrame lecturefr = new LectureFrame(this);
        lecturefr.setVisible(true);
    }//GEN-LAST:event_lecturebtnActionPerformed

    private void departmentbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentbtnActionPerformed
        this.setVisible(false);
        DepartmentFrame departmentfr = new DepartmentFrame(this);
        departmentfr.setVisible(true);
    }//GEN-LAST:event_departmentbtnActionPerformed

    private void subjectbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectbtnActionPerformed
        this.setVisible(false);
        SubjectFrame subjectFrame = new SubjectFrame(this);
        subjectFrame.setVisible(true);
    }//GEN-LAST:event_subjectbtnActionPerformed

    private void classbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classbtnActionPerformed
        this.setVisible(false);
        ClassFrame classFrame = new ClassFrame(this);
        classFrame.setVisible(true);
    }//GEN-LAST:event_classbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.student.swing.Button classbtn;
    private com.student.swing.Button departmentbtn;
    private javax.swing.JLabel jLabel2;
    private com.student.swing.Button lecturebtn;
    private com.student.swing.Button logoutbtn;
    private com.student.swing.Button scorebtn;
    private com.student.swing.Button studentbtn;
    private com.student.swing.Button subjectbtn;
    // End of variables declaration//GEN-END:variables
}
