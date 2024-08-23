package fa.training.main;

import fa.training.entities.Person;
import fa.training.entities.Student;
import fa.training.entities.Teacher;
import fa.training.utils.Validator;

import java.awt.*;

public class PersonManage {
    static Person[] people = new Person[10];
    public static void main(String[] args) {
        int optionInput=0;
        for (int i = 0; i < 10; i++) {
            while (true){
                optionInput = Validator.inputNumber("Enter option input (1.Input Student, 2.Input Teacher): ");
                if(optionInput==1){
                    people[i] = InputStudent();
                    break;
                }
                if(optionInput==2){
                    people[i] = InputTeacher();
                    break;
                }
            }
        }
        int option;
        while (true) {
            System.out.println("----JPE.M.A301---");
            System.out.println("1.Update Student");
            System.out.println("2.Display Teacher");
            System.out.println("3.Report");
            System.out.println("0.Exit");
            option = Validator.inputNumber("Enter option(0-3): ");
            switch (option) {
                case 1:
                    UpdateStudent();
                    break;
                case 2:
                    DisplayPerson();
                    break;
                case 3:
                    Report();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void Report() {
        System.out.println("Students who qualify to pass the course:");
        for (Person person : people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.calculateFinalMark() >= 6) {
                    System.out.println(student.toString());
                }
            }
        }
    }

    private static void DisplayPerson() {
        System.out.println("Teachers with a salary higher than $1000:");
        for (Person person : people) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.calculateSalary() > 1000) {
                    System.out.println(teacher.toString());
                }
            }
        }
    }

    private static void UpdateStudent() {
        String studentIdUpdate=Validator.inputString("Enter Student ID To Update: ");
        for (int i = 0; i < 10; i++) {
            if (people[i] instanceof Student) {
                Student student = (Student) people[i];
                if (student.getStudentID().equals(studentIdUpdate)) {
                    int option;
                    while (true) {
                        System.out.println("----JPE.M.A301---");
                        System.out.println("1.Update Student Name ");
                        System.out.println("2.Update Student Gender ");
                        System.out.println("3.Update Student Birth Date ");
                        System.out.println("4.Update Student Email ");
                        System.out.println("5.Update Student Phone ");
                        System.out.println("6.Update Student Theory ");
                        System.out.println("7.Update Student Practice ");
                        System.out.println("0.Exit");
                        option = Validator.inputNumber("Enter option(0-7): ");
                        switch (option) {
                            case 1:
                                student.setFullName(Validator.inputString("Enter Student Name: "));
                                break;
                            case 2:
                                student.setGender(Validator.inputString("Enter Student Gender: "));
                                break;
                            case 3:
                                String birthDate;
                                while (true) {
                                    birthDate = Validator.inputString("Enter Student Birth Date: ");
                                    if (Validator.isValidDate(birthDate)) {
                                        break;
                                    }
                                }
                                student.setDateOfBirth(birthDate);
                                break;
                            case 4: 
                                String email;                                
                                while (true) {                                   
                                    email = Validator.inputString("Enter Student Email: ");
                                    if (Validator.isValidEmail(email)) {
                                        break;
                                    }
                                }                                
                                break;
                            case 5:
                                student.setPhone(Validator.inputString("Enter Student Phone Number: "));
                                break;
                                
                            case 6:
                                student.setTheory( Validator.inputDouble("Enter Theory:", 10));
                                break;
                            case 7:
                                student.setPractice(Validator.inputDouble("Enter Practice:", 10));
                                break;
                            case 0:
                                return;
                        }                        
                    }
                }
            }
        }
    }

    private static Student InputStudent() {
        String studentID = Validator.inputString("Enter Student ID: ");
        String name = Validator.inputString("Enter Student Name: ");
        String gender = Validator.inputString("Enter Student Gender: ");
        String birthDate;
        while (true) {
            birthDate = Validator.inputString("Enter Student Birth Date: ");
            if (Validator.isValidDate(birthDate)) {
                break;
            }
        }
        String phone = Validator.inputString("Enter Student Phone Number: ");
        String email;
        while (true) {
            email = Validator.inputString("Enter Student Email: ");
            if (Validator.isValidEmail(email)) {
                break;
            }
        }
        double theory = Validator.inputDouble("Enter Theory:", 10);
        double practice = Validator.inputDouble("Enter Practice:", 10);

        return new Student(name, gender, birthDate, phone, email, studentID, theory, practice);
    }

    public static Teacher InputTeacher() {
        String name = Validator.inputString("Enter Teacher Name: ");
        String gender = Validator.inputString("Enter Teacher Gender: ");
        String birthDate;
        while (true) {
            birthDate = Validator.inputString("Enter Teacher Birth Date: ");
            if (Validator.isValidDate(birthDate)) {
                break;
            }
        }
        String phone = Validator.inputString("Enter Teacher Phone Number: ");
        String email;
        while (true) {
            email = Validator.inputString("Enter Teacher Email: ");
            if (Validator.isValidEmail(email)) {
                break;
            }
        }
        double basicSalary = Validator.inputDouble("Enter Basic Salary:", 0);
        double subsidy = Validator.inputDouble("Enter Subsidy:", 0);


        return new Teacher(name, gender, birthDate, phone, email, basicSalary, subsidy);
    }
}
