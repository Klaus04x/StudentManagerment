package com.student.model;

public class Lecture {

    private String lectureID;
    private String name;
    private Integer departmentID; // Thay đổi từ String thành Integer

    public Lecture(String LectureID, String Name, Integer DepartmentID) {
        this.lectureID = LectureID;
        this.name = Name;
        this.departmentID = DepartmentID;
    }

    public Lecture(String Name, Integer DepartmentID) {
        this.name = Name;
        this.departmentID = DepartmentID;
    }

    public String getLectureID() {
        return lectureID;
    }

    public void setLectureID(String LectureID) {
        this.lectureID = LectureID;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer DepartmentID) {
        this.departmentID = DepartmentID;
    }
}