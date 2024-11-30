package com.student.component;

import com.student.model.ModelLogin;
import com.student.model.ModelUser;
import com.student.swing.Button;
import com.student.swing.MyTextField;
import com.student.swing.MyPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
    
    private ModelUser user;
    private ModelLogin dataLogin;

    public ModelLogin getDataLogin() {
        return dataLogin;
    }
    
    public ModelUser getUser() {
        return user;
    }
    
    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
    }
    
    private void initRegister(ActionListener eventRegister){
        register.setLayout(new MigLayout("wrap" , "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel lable = new JLabel("Create Account");
        lable.setFont(new Font("sansserif", 1, 30));
        lable.setForeground(new Color(7, 164, 121));
        register.add(lable);
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/student/icon/user.png")));
        txtUser.setHint("Username");
        register.add(txtUser, "w 60%");
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/student/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 60%");
        
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/com/student/icon/pass.png")));
        txtPassword.setHint("Password");
        register.add(txtPassword, "w 60%");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");
        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = txtUser.getText().trim();
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                user = new ModelUser(0, userName, email, password);
            }
        });
        
    }
    
    private void initLogin(ActionListener eventLogin){
        login.setLayout(new MigLayout("wrap" , "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel lable = new JLabel("Sign In");
        lable.setFont(new Font("sansserif", 1, 30));
        lable.setForeground(new Color(7, 164, 121));
        login.add(lable);
        
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/student/icon/mail.png")));
        txtEmail.setHint("Email");
        login.add(txtEmail, "w 60%");
        
        MyPasswordField txtPassword = new MyPasswordField();
        txtPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/com/student/icon/pass.png")));
        txtPassword.setHint("Password");
        login.add(txtPassword, "w 60%");
        
//        JButton cmdForget = new JButton("Forgot password?");
//        cmdForget.setForeground(new Color(100, 100, 100));
//        cmdForget.setFont(new Font("sansserif", 1, 12));
//        cmdForget.setContentAreaFilled(false);
//        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        login.add(cmdForget);
        
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");
        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String email = txtEmail.getText().trim();
                String password = String.valueOf(txtPassword.getPassword());
                dataLogin = new ModelLogin(email, password);
            }
        });
    }
    
    public void showRegister(boolean show){
        if(show){
            register.setVisible(true);
            login.setVisible(false);
        }
        else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
