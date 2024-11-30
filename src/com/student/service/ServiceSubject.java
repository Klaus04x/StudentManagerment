package com.student.service;

import com.student.connection.SQLConnection;
import com.student.model.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceSubject {

    private Connection con;

    public ServiceSubject() {
        con = SQLConnection.getConnection();
    }

    public boolean departmentExists(String departmentID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Department WHERE DepartmentID = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, departmentID);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu tồn tại
            }
        }
        return false; // Trả về false nếu không tồn tại
    }

    public boolean subjectExists(String subjectName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Subject WHERE SubjectName = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, subjectName);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu môn học đã tồn tại
            }
        }
        return false; // Trả về false nếu không tồn tại
    }

    public boolean isSubjectNameExists(String subjectName, String subjectID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Subject WHERE SubjectName = ? AND SubjectID != ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, subjectName);
            pstmt.setString(2, subjectID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public boolean isSubjectExists(String subjectID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Subject WHERE SubjectID = ?";
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subjectID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Trả về true nếu tồn tại ít nhất một kết quả
                }
            }
        }
        return false; // Trả về false nếu không tìm thấy
    }

    public List<Subject> getAllSubject() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT SubjectID, SubjectName, Credits, DepartmentID FROM Subject";

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                Subject subject = new Subject(
                        r.getString("SubjectID"),
                        r.getString("SubjectName"),
                        r.getString("Credits"),
                        r.getString("DepartmentID")
                );
                subjects.add(subject);
            }
        }
        return subjects;
    }

    public void addSubject(Subject subject) throws SQLException {
        String sql = "INSERT INTO Subject (SubjectName, Credits, DepartmentID) VALUES (?, ?, ?)";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, subject.getSubjectName());
            p.setString(2, subject.getCredits());
            p.setString(3, subject.getDepartmentID());
            p.executeUpdate(); // Thực hiện câu lệnh thêm
        }
    }

    public void updateSubject(String subjectID, String subjectName, String credits, int departmentID) throws SQLException {
        String sql = "UPDATE Subject SET SubjectName=?, Credits=?, DepartmentID=? WHERE SubjectID=?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, subjectName);
            pstmt.setString(2, credits);
            pstmt.setInt(3, departmentID);
            pstmt.setString(4, subjectID);
            pstmt.executeUpdate();
        }
    }

    public void removeSubject(String subjectID) throws SQLException {
        String sql = "DELETE FROM Subject WHERE SubjectID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, subjectID);
            pstmt.executeUpdate(); // Thực hiện câu lệnh xóa
        }
    }
}
