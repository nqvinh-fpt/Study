package fa.training.main;

import fa.training.entities.Course;
import fa.training.utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CourseManagement {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Course[] courses = new Course[10];
    public CourseManagement(Course[] courses) {
        this.courses = courses;
    }
    public static int inputNumber(String mess) {
        int realNumber = 0;
        while (true) {
            try {
                System.out.println(mess);
                String number = reader.readLine();
                realNumber = Integer.parseInt(number);
                break;
            } catch (Exception e) {
                System.err.println("Who format, please re-enter!   ");
            }
        }
        return realNumber;
    }
    public static String inputString(String mess) {
        String realString;
        while (true) {
            try {
                System.out.print(mess);
                realString = reader.readLine();
                    break;
            } catch (Exception e) {
                System.err.println("Who format, please re-enter!  ");
            }
        }
        return realString;
    }
    public static String inputStringSearch(String mess) {
        String realString;
        while (true) {
            try {
                System.out.print(mess);
                realString = reader.readLine();
                if (Validator.isValidSearch(realString)){
                    break;
                }
                System.out.println("Who format, please re-enter!  ");
            } catch (Exception e) {
                System.err.println("Who format, please re-enter!  ");
            }
        }
        return realString;
    }
    public static void main(String[] args) {

        for (int i = 0; i < courses.length; i++) {
            Course course = new Course();
                course.input();
            courses[i] = course;
        }
        for (Course course : courses) {
            if (course.getFlag().equals("mandatory")) {
                System.out.println(course);
            }
        }

        while (true) {
            int input;
            try {
                if(find(inputStringSearch("Type to search for (course code,course name,duration,status,flag): "),inputString("Data: "))){
                    System.out.println("Not searched data");
                }
                input=inputNumber("Tiếp tục:1 ,Kết thúc:0");
                if(input==0){
                    break;
                }else {
                    System.out.println("Who format, please re-enter! ");
                }
            }catch (Exception e) {
                System.out.println("Who format, please re-enter! "+e);
            }
        }


    }

    public static boolean find(String attribute, Object data) {
        System.out.println("Courses with " + attribute + " = " + data + ":");
        boolean check=true;

        for (Course course : courses) {
            if (attribute.equalsIgnoreCase("course code") && course.getCourseCode().equals(data)) {
                System.out.println(course);
                check=false;
            } else if (attribute.equalsIgnoreCase("course name") && course.getCourseName().equals(data)) {
                System.out.println(course);
                check=false;
            } else if (attribute.equalsIgnoreCase("duration") && Double.parseDouble(data.toString()) == course.getDuration()) {
                System.out.println(course);
                check=false;
            } else if (attribute.equalsIgnoreCase("status") && course.getStatus().equalsIgnoreCase(data.toString())) {
                System.out.println(course);
                check=false;
            } else if (attribute.equalsIgnoreCase("flag") && course.getFlag().equalsIgnoreCase(data.toString())) {
                System.out.println(course);
                check=false;
            }
        }
        return check;
    }
}

