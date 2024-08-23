package fa.training.utils;

public class Validator {
    public static boolean isValidCourseCode(String courseCode) {
        if (courseCode.matches("FW\\d{3}")) {
            return true;
        }
        return false;
    }

    public static boolean isValidStatus(String status) {
        if (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("in-active")) {
            return true;
        }
        return false;
    }
    public static boolean isValidSearch(String search) {
        if (search.equalsIgnoreCase("course code") || search.equalsIgnoreCase("course name")||search.equalsIgnoreCase("duration")|| search.equalsIgnoreCase("status")||search.equalsIgnoreCase("flag")) {
            return true;
        }
        return false;
    }

    public static boolean isValidFlag(String flag) {
        if (flag.equalsIgnoreCase("optional") || flag.equalsIgnoreCase("mandatory") || flag.equalsIgnoreCase("N/A")) {
            return true;
        }
        return false;
    }
}
