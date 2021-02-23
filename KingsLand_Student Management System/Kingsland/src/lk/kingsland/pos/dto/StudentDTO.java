package lk.kingsland.pos.dto;

public class StudentDTO {
    private String StudentID;
    private String StudentName;
    private String Address;
    private int Contact;
    private String Dob;
    private String Gender;

    public StudentDTO() {
    }

    public StudentDTO(String studentID, String studentName, String address, int contact, String dob, String gender) {
        StudentID = studentID;
        StudentName = studentName;
        Address = address;
        Contact = contact;
        Dob = dob;
        Gender = gender;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
