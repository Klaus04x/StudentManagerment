package com.student.service;

import com.student.connection.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.student.model.Student;

public class ServiceStudent {

    private Connection con;

    public ServiceStudent() {
        con = SQLConnection.getConnection();
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT StudentID, Name, Birthday, ClassID FROM Student";

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                Student student = new Student(
                        r.getString("StudentID"),
                        r.getString("Name"),
                        r.getDate("Birthday"),
                        r.getString("ClassID")
                );
                students.add(student);
            }
        }
        return students;
    }

    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO Student ( Name, Birthday, ClassID) VALUES (?, ?, ?)";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, student.getName());
            p.setDate(2, new java.sql.Date(student.getBirthday().getTime()));
            p.setString(3, student.getClassID());
            p.executeUpdate();
        }
    }

    public void updateStudentInfo(String studentID, String name, String birthday, String classID) throws SQLException {
        String query = "UPDATE Student SET name = ?, birthday = ?, classID = ? WHERE studentID = ?";
        try (Connection connection = SQLConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, birthday);
            statement.setString(3, classID);
            statement.setString(4, studentID);
            statement.executeUpdate();
        }
    }

    public void deleteStudent(String studentID) throws SQLException {
        // Xóa các bản ghi trong bảng Score liên quan đến StudentID
        String deleteScoreQuery = "DELETE FROM Score WHERE StudentID = ?";
        try (Connection connection = SQLConnection.getConnection(); PreparedStatement deleteScoreStatement = connection.prepareStatement(deleteScoreQuery)) {
            deleteScoreStatement.setString(1, studentID);
            deleteScoreStatement.executeUpdate();
        }

        // Sau đó xóa sinh viên
        String deleteStudentQuery = "DELETE FROM Student WHERE StudentID = ?";
        try (Connection connection = SQLConnection.getConnection(); PreparedStatement deleteStudentStatement = connection.prepareStatement(deleteStudentQuery)) {
            deleteStudentStatement.setString(1, studentID);
            deleteStudentStatement.executeUpdate();
        }
    }
}
