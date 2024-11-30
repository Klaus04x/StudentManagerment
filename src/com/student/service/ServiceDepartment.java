package com.student.service;

import com.student.connection.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.student.model.Department;

public class ServiceDepartment {

    private Connection con;

    public ServiceDepartment() {
        con = SQLConnection.getConnection();
    }

    public List<Department> getAllDepartment() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT DepartmentID, DepartmentName, Location FROM Department";

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                Department department = new Department(
                        r.getString("DepartmentID"),
                        r.getString("DepartmentName"),
                        r.getString("Location")
                );
                departments.add(department);
            }
        }
        return departments;
    }

    public boolean departmentExists(String departmentName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Department WHERE DepartmentName = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, departmentName);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu có ít nhất một bản ghi
            }
        }
        return false;
    }

    public boolean departmentExists(String departmentName, String departmentID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Department WHERE DepartmentName = ? AND DepartmentID != ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, departmentName);
            p.setString(2, departmentID);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu có ít nhất một bản ghi
            }
        }
        return false;
    }

    public void addDepartment(Department department) throws SQLException {
        String sql = "INSERT INTO Department (DepartmentName , Location ) VALUES (?, ?)";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, department.getDepartmentName());
            p.setString(2, department.getLocation());
            p.executeUpdate();
        }
    }

    public void updateDepartmentInfo(String departmentID, String departmentName, String location) throws SQLException {
        String query = "UPDATE Department SET DepartmentName = ?, Location = ? WHERE DepartmentID = ?";
        try (Connection connection = SQLConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, departmentName);
            statement.setString(2, location);
            statement.setString(3, departmentID);
            statement.executeUpdate();
        }
    }

    public void removeDepartment(String departmentID) throws SQLException {
        String sql = "DELETE FROM Department WHERE DepartmentID = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, departmentID);
            p.executeUpdate();
        }
    }
}
