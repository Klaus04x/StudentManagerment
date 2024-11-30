package com.student.model;

import java.util.Date;

public class Student {

    private String studentID;
    private String name;
    private Date birthday;
    private String classID;

    // Constructor
    public Student(String name, Date birthday, String classID) {
        this.name = name;
        this.birthday = birthday;
        this.classID = classID;
    }
    
    public Student(String studentID, String name, Date birthday, String classID) {
        this.studentID = studentID;
        this.name = name;
        this.birthday = birthday;
        this.classID = classID;
    }

    // Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}