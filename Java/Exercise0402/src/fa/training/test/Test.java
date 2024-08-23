package fa.training.test;
import fa.training.entities.Student;
public class Test {
    public static void main(String[] args) {
        Student stud1 = new Student(1, "Jason", (byte) 22, 8.0);
        Student stud2 = new Student();
        System.out.println("Enter stud2 information:");
        stud2.input();
        System.out.println("--STUDENT LIST--");
        System.out.println(stud1);
        System.out.println(stud2);
    }
}