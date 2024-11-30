package com.student.service;

import com.student.connection.SQLConnection;
import com.student.model.ModelLogin;
import com.student.model.ModelUser;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import com.student.model.Student;

public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = SQLConnection.getConnection();
//        SFStudent sf1 = new SFStudent();
        load();
    }

    private void load() {
        List<Student> list = new ArrayList<>();
    }

    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        String sql = "SELECT UserID, Username, Email FROM [User] "
                + "WHERE [Email] = ? AND [Password] = ? AND [Status] = 'Verified'";

        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, login.getEmail());
            p.setString(2, login.getPassword());

            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    int userID = r.getInt("UserID");
                    String userName = r.getString("UserName");
                    String email = r.getString("Email");
                    data = new ModelUser(userID, userName, email, "");
                }
            }
        }
        return data;
    }

    public void insertUser(ModelUser user) throws SQLException {
        String code = generateVerifyCode();
        String sql = "INSERT INTO [User] (Username, Email, [Password], VerifyCode, [Status]) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement p = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            p.setString(1, user.getUserName());
            p.setString(2, user.getEmail());
            p.setString(3, user.getPassword());
            p.setString(4, code);
            p.setString(5, "Pending");
            p.executeUpdate();

            try (ResultSet r = p.getGeneratedKeys()) {
                if (r.next()) {
                    int userID = r.getInt(1);
                    user.setUserID(userID);
                }
            }
            user.setVerifyCode(code);
        }
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("0000000");
        Random ran = new Random();
        String code;

        do {
            code = df.format(ran.nextInt(1000000));
        } while (checkDuplicateCode(code));

        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        String sql = "SELECT TOP 1 UserID FROM [User] WHERE VerifyCode = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, code);
            try (ResultSet r = p.executeQuery()) {
                return r.next(); // Trả về true nếu có kết quả
            }
        }
    }

    public boolean checkDuplicateUser(String user) throws SQLException {
        String sql = "SELECT TOP 1 UserID FROM [User] WHERE UserName = ? AND [Status] = 'Verified'";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, user);
            try (ResultSet r = p.executeQuery()) {
                return r.next(); // Trả về true nếu có kết quả
            }
        }
    }

    public boolean checkDuplicateEmail(String email) throws SQLException {
        String sql = "SELECT TOP 1 UserID FROM [User] WHERE Email = ? AND [Status] = 'Verified'";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, email);
            try (ResultSet r = p.executeQuery()) {
                return r.next(); // Trả về true nếu có kết quả
            }
        }
    }

    public void doneVerify(int userID) throws SQLException {
        String sql = "UPDATE [User] SET VerifyCode = '', [Status] = 'Verified' WHERE UserID = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setInt(1, userID);
            p.executeUpdate(); // Thực hiện cập nhật
        }
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        String sql = "SELECT TOP 1 UserID FROM [User] WHERE UserID = ? AND VerifyCode = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setInt(1, userID);
            p.setString(2, code);
            try (ResultSet r = p.executeQuery()) {
                return r.next(); // Trả về true nếu có kết quả
            }
        }
    }
}
