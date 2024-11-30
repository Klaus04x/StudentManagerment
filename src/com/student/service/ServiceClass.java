package com.student.service;

import com.student.connection.SQLConnection;
import com.student.model.Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceClass {

    private Connection con;

    public ServiceClass() {
        con = SQLConnection.getConnection();
    }

    public List<Class> getAllClass() throws SQLException {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT ClassID, ClassName, DepartmentID FROM Class";

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                Class Class = new Class(
                        r.getString("ClassID"),
                        r.getString("ClassName"),
                        r.getString("DepartmentID")
                );
                classes.add(Class);
            }
        }
        return classes;
    }

    public boolean departmentExists(int departmentID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Department WHERE DepartmentID = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setInt(1, departmentID);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0;
            }
        }
        return false;
    }

    public boolean classExists(String name) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Class WHERE ClassName = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, name);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu có ít nhất một bản ghi
            }
        }
        return false;
    }
    
    public boolean classExists(String name, int departmentID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Class WHERE ClassName = ? AND DepartmentID = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, name);
            p.setInt(2, departmentID);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu có ít nhất một bản ghi
            }
        }
        return false;
    }

    public void addClass(Class classes) throws SQLException {
        String sql = "INSERT INTO Class (ClassName , DepartmentID ) VALUES (?, ?)";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, classes.getClassName());
            p.setString(2, classes.getDepartmentID());
            p.executeUpdate();
        }
    }
    
    public void updateClassInfo(String classID, String name, int departmentID) throws SQLException {
        String query = "UPDATE Class SET ClassName = ?, DepartmentID = ? WHERE ClassID = ?";
        try (Connection connection = SQLConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, departmentID); // Sử dụng setInt cho kiểu int
            statement.setString(3, classID);
            statement.executeUpdate();
        }
    }
    public void deleteClass(String classID) throws SQLException {
        String query = "DELETE FROM Class WHERE ClassID = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, classID);
            statement.executeUpdate();
        }
    }
}
