package lk.kingsland.pos.view.TM;

public class CourseTM {
    private String RegNO;
    private String StudentID;
    private int ContactNumber;
    private String CourseCode;
    private double regFree;

    public CourseTM(String regNO, String studentID, int contactNumber, String courseCode, double regFree) {
        RegNO = regNO;
        StudentID = studentID;
        ContactNumber = contactNumber;
        CourseCode = courseCode;
        this.regFree = regFree;
    }

    public CourseTM() {
    }

    public String getRegNO() {
        return RegNO;
    }

    public void setRegNO(String regNO) {
        RegNO = regNO;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public double getRegFree() {
        return regFree;
    }

    public void setRegFree(double regFree) {
        this.regFree = regFree;
    }
}
