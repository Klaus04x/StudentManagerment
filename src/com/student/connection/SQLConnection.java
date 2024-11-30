package com.student.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private static String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=StudentManagement;user=sa;password=123456;encrypt=false";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Kết nối thành công!");
        } catch (SQLException ex) {
            System.out.println("Kết nối thất bại: " + ex.getMessage()); // In ra thông báo lỗi chi tiết
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}