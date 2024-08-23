package fa.training.problem03.utils.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final String VIETNAMESE_PHONE_NUMBER_PATTERN = "^(09[0-4]|09[678]|08[2-9]|03[2-9]|05[6-9]|07[06-9]|02[2-9])[0-9]{7}$";
    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(VIETNAMESE_PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static double inputDouble(String mess,double max) {
        double realDouble;
        while (true) {
            try {
                System.out.print(mess);
                String input = reader.readLine();
                realDouble = Double.parseDouble(input);
                if (0 <= realDouble ) {
                    if(max!=0){
                        if (realDouble <= max ) {
                            break;
                        }
                    }else{
                        break;
                    }
                }
                System.out.println("The number entered exceeds the limit, please re-enter!");
            } catch (Exception e) {
                System.out.println("Wrong format, please re-enter!");
            }
        }
        return realDouble;
    }
    public static boolean isValidDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateStr);
            LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            LocalDate currentDate = LocalDate.now();
            return !localDate.isAfter(currentDate);
        } catch (Exception e) {
            System.out.println("Invalid date format, please re-enter!");
            return false;
        }
    }

    public static boolean isValidOrderNumber(String orderNumber) {
        String pattern = "^[0-9]{10}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(orderNumber);
        return matcher.matches();
    }
    public static int inputNumber(String mess) {
        int realNumber = 0;
        while (true) {
            try {
                System.out.print(mess);
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


}

