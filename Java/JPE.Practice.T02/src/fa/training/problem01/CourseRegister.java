package fa.training.problem01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CourseRegister {
    public Map<String, Integer> countStudentsByCourse(String filePath) {
        Map<String, Integer> courseCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("_");

                if (parts.length >= 2) {
                    String course = parts[2];
                    courseCounts.put(course, courseCounts.getOrDefault(course, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseCounts;
    }

    public static void main(String[] args) {
        CourseRegister courseRegister = new CourseRegister();
        String filePath = "course_register.txt";
        Map<String, Integer> courseCounts = courseRegister.countStudentsByCourse(filePath);

        for (Map.Entry<String, Integer> entry : courseCounts.entrySet()) {
            System.out.println(String.format("%-10s  %-20s", entry.getKey(),entry.getValue()));
        }
    }
}
