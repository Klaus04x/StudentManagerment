package com.student.service;

import com.student.connection.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.student.model.Lecture;

public class ServiceLecture {

    private Connection con;

    public ServiceLecture() {
        con = SQLConnection.getConnection();
    }

    public List<Lecture> getAllLectures() throws SQLException {
        List<Lecture> lectures = new ArrayList<>();
        String sql = "SELECT LectureID, Name, DepartmentID FROM Lecture";

        try (PreparedStatement p = con.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                Lecture lecture = new Lecture(
                        r.getString("LectureID"),
                        r.getString("Name"),
                        r.getInt("DepartmentID")
                );
                lectures.add(lecture);
            }
        }

        return lectures;
    }

    public boolean departmentExists(int departmentID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Department WHERE DepartmentID = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setInt(1, departmentID);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                return r.getInt(1) > 0; // Trả về true nếu có ít nhất một bản ghi
            }
        }
        return false;
    }

    public boolean lectureExists(String name, int departmentID) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Lecture WHERE Name = ? AND DepartmentID = ?";
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

    public void addLecture(Lecture lecture) throws SQLException {
        String sql = "INSERT INTO Lecture (Name, DepartmentID) VALUES (?, ?)"; // Cập nhật tên bảng
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, lecture.getName());
            p.setInt(2, lecture.getDepartmentID()); // Đúng chỉ số tham số
            p.executeUpdate();
        }
    }

    public void updateLectureInfo(String lectureID, String name, int departmentID) throws SQLException {
        String query = "UPDATE Lecture SET Name = ?, DepartmentID = ? WHERE LectureID = ?";
        try (Connection connection = SQLConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, departmentID); // Sử dụng setInt cho kiểu int
            statement.setString(3, lectureID);
            statement.executeUpdate();
        }
    }

    public void deleteLecture(String lectureID) throws SQLException {
        String query = "DELETE FROM Lecture WHERE LectureID = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, lectureID);
            statement.executeUpdate();
        }
    }
}
