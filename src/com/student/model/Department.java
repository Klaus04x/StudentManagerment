package com.student.model;

public class Department {

    private String departmentID;
    private String departmentName;
    private String location;

    public Department(String departmentName, String location) {
        this.departmentName = departmentName;
        this.location = location;
    }

    public Department(String departmentID, String departmentName, String location) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.location = location;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
