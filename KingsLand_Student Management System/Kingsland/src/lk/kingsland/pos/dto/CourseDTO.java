package lk.kingsland.pos.dto;

public class CourseDTO {
    private String CourseCode;
    private String CourseName;
    private String CourseType;
    private String Dueration;
    private double RegFree;

    public CourseDTO() {
    }

    public CourseDTO(String courseCode, String courseName, String courseType, String dueration, double regFree) {
        CourseCode = courseCode;
        CourseName = courseName;
        CourseType = courseType;
        Dueration = dueration;
        RegFree = regFree;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseType() {
        return CourseType;
    }

    public void setCourseType(String courseType) {
        CourseType = courseType;
    }

    public String getDueration() {
        return Dueration;
    }

    public void setDueration(String dueration) {
        Dueration = dueration;
    }

    public double getRegFree() {
        return RegFree;
    }

    public void setRegFree(double regFree) {
        RegFree = regFree;
    }
}
