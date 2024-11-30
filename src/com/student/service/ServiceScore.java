package com.student.service;

import com.student.model.Score;
import com.student.connection.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceScore {

    private Connection con;

    public ServiceScore() {
        con = SQLConnection.getConnection();
    }

    public List<Score> getAllScore() throws SQLException {
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT MarkID, StudentID, SubjectID, Marks FROM Score";

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                Score score = new Score(
                        r.getString("MarkID"),
                        r.getString("StudentID"),
                        r.getString("SubjectID"),
                        r.getString("Marks")
                );
                scores.add(score);
            }
        }
        return scores;
    }

    // Phương thức để lấy danh sách studentID
    public List<String> getAllStudentIDs() throws SQLException {
        List<String> studentIDs = new ArrayList<>();
        String sql = "SELECT StudentID FROM Student"; // Thay đổi theo tên bảng của bạn

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                studentIDs.add(r.getString("StudentID"));
            }
        }
        return studentIDs;
    }

    // Phương thức để lấy danh sách subjectID
    public List<String> getAllSubjectIDs() throws SQLException {
        List<String> subjectIDs = new ArrayList<>();
        String sql = "SELECT SubjectID FROM Subject"; // Thay đổi theo tên bảng của bạn

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                subjectIDs.add(r.getString("SubjectID"));
            }
        }
        return subjectIDs;
    }

    public boolean scoreExists(String studentID, String subjectID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Score WHERE StudentID = ? AND SubjectID = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, studentID);
            p.setString(2, subjectID);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu có ít nhất 1 bản ghi
            }
        }
        return false; // Trả về false nếu không có bản ghi nào
    }

    public boolean checkScoreExists(String studentID, String subjectID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Score WHERE StudentID = ? AND SubjectID = ?";
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentID);
            pstmt.setString(2, subjectID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu có ít nhất một bản ghi
            }
        }
        return false;
    }

    public void addScore(Score score) throws SQLException {
        String sql = "INSERT INTO Score (StudentID, SubjectID, Marks) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, score.getStudentID());
            pstmt.setString(2, score.getSubjectID());
            pstmt.setString(3, score.getMarks());
            pstmt.executeUpdate(); // Thực hiện thêm
        }
    }

    public void updateScore(String studentID, String subjectID, String marks) throws SQLException {
        String sql = "UPDATE Score SET Marks = ? WHERE StudentID = ? AND SubjectID = ?"; // Câu lệnh SQL
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, marks);
            pstmt.setString(2, studentID);
            pstmt.setString(3, subjectID);
            pstmt.executeUpdate(); // Thực hiện cập nhật
        }
    }

    public void removeScore(String markID) throws SQLException {
        String sql = "DELETE FROM Score WHERE MarkID = ?"; // Câu lệnh SQL
        try (Connection conn = SQLConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, markID);
            pstmt.executeUpdate(); // Thực hiện xóa
        }
    }
}
