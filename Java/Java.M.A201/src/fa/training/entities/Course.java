package fa.training.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import fa.training.utils.Validator;

public class Course {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String courseCode;

    private String courseName;

    private double duration;

    private String status;

    private String flag;


    public Course() {
        this.courseCode="";
        this.courseName="";
        this.duration=0.0;
        this.status="";
        this.flag="";
    }

    public Course(String courseCode, String courseName, double duration, String status, String flag) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.duration = duration;
        this.status = status;
        this.flag = flag;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return  courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                ", flag='" + flag + '\'' +
                '}';
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

    public static double inputDouble(String mess) {
        double realDouble;
        while (true) {
            try {
                System.out.print(mess);
                String input = reader.readLine();
                realDouble = Double.parseDouble(input);
                    break;

            } catch (Exception e) {
                System.err.println("Who format, please re-enter!  ");
            }
        }
        return realDouble;
    }

    public void input() {
        String courseCode;
        String courseName;
        double duration;
        String status;
        String flag;
        while (true) {
            try {
                courseCode = inputString("Enter Course Code (FWXXX): ");
                if(Validator.isValidCourseCode(courseCode)){
                    break;
                }
                System.out.println("Who format, please re-enter! ");
        }catch (Exception e) {
                System.err.println("Who format, please re-enter! ");
            }
        }
        courseName = inputString("Enter Course Name: ");


        duration = inputDouble("Enter Duration (in weeks): ");

        while (true) {
            try {
                status = inputString("Enter Status (active/in-active):  ");
                if(Validator.isValidStatus(status)){
                    break;
                }
                System.out.println("Who format, please re-enter! ");
            }catch (Exception e) {
                System.err.println("Who format, please re-enter! ");
            }
        }

        while (true) {
            try {
                flag = inputString("Enter Flag (optional/mandatory/N/A):  ");
                if(Validator.isValidFlag(flag)){
                    break;
                }
                System.out.println("Who format, please re-enter! ");
            }catch (Exception e) {
                System.err.println("Who format, please re-enter! ");
            }
        }

        // Gán giá trị cho các biến thành viên
        this.courseCode=courseCode;
        this.courseName = courseName;
        this.duration = duration;
        this.status = status;
        this.flag = flag;
    }


}
