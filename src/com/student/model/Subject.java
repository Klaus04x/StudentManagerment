package com.student.model;

public class Subject {

    private String subjectID;
    private String subjectName;
    private String credits;
    private String departmentID;

    public Subject(String subjectName, String credits, String departmentID) {
        this.subjectName = subjectName;
        this.credits = credits;
        this.departmentID = departmentID;
    }

    public Subject(String subjectID, String subjectName, String credits, String departmentID) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.credits = credits;
        this.departmentID = departmentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

}
