package lk.kingsland.pos.entity;

public class Registration {
    private String RegNo;
    private String RegDate;
    private String StudentID;
    private String CourseCode;
    private double RegFree;

    public Registration() {
    }

    public Registration(String regNo, String regDate, String studentID, String courseCode, double regFree) {
        RegNo = regNo;
        RegDate = regDate;
        StudentID = studentID;
        CourseCode = courseCode;
        RegFree = regFree;
    }

    public String getRegNo() {
        return RegNo;
    }

    public void setRegNo(String regNo) {
        RegNo = regNo;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public double getRegFree() {
        return RegFree;
    }

    public void setRegFree(double regFree) {
        RegFree = regFree;
    }
}
