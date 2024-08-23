package fa.training.entities;

import java.util.Scanner;

public class Student {
    private int id;
    private String studentName;
    private byte age;
    private double gpa;

    public Student() {
    }

    public Student(int id, String studentName, byte age, double gpa) {
        super();
        this.id = id;
        this.studentName = studentName;
        this.age = age;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id:");
        id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name:");
        studentName = scanner.nextLine();
        System.out.print("Enter age:");
        age = Byte.parseByte(scanner.nextLine());
        System.out.print("Enter gpa:");
        gpa = Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", studentName=" + studentName + ", age="
                + age + ", gpa=" + gpa + "]";
    }
}