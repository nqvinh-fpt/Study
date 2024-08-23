package fa.training.entities;

public class Student extends Person{
    private String StudentID;
    private double Theory;

    private double Practice;

    public Student() {
    }

    public Student(String studentID, double theory, double practice) {
        StudentID = studentID;
        Theory = theory;
        Practice = practice;
    }

    public Student(String fullName, String gender, String dateOfBirth, String phone, String email, String studentID, double theory, double practice) {
        super(fullName, gender, dateOfBirth, phone, email);
        StudentID = studentID;
        Theory = theory;
        Practice = practice;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public double getTheory() {
        return Theory;
    }

    public void setTheory(double theory) {
        Theory = theory;
    }

    public double getPractice() {
        return Practice;
    }

    public void setPractice(double practice) {
        Practice = practice;
    }

    public double calculateFinalMark() {
        return  (getTheory() + getPractice()) / 2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", Theory=" + Theory +
                ", Practice=" + Practice +
                '}';
    }
}
