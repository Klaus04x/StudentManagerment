package com.student.model;

public class Class {

    private String classID;
    private String className;
    private String departmentID;

    public Class(String className, String departmentID) {
        this.className = className;
        this.departmentID = departmentID;
    }

    public Class(String classID, String className, String departmentID) {
        this.classID = classID;
        this.className = className;
        this.departmentID = departmentID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
}
