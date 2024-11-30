package com.student.model;

public class Score {

    private String markID;
    private String studentID;
    private String subjectID;
    private String marks;

    public Score(String markID, String studentID, String subjectID, String marks) {
        this.markID = markID;
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.marks = marks;
    }

    public Score(String studentID, String subjectID, String marks) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.marks = marks;
    }

    public String getMarkID() {
        return markID;
    }

    public void setMarkID(String markID) {
        this.markID = markID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

}
