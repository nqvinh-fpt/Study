package fa.training.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validator {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static boolean isValidDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        try {
            Date date = dateFormat.parse(dateStr);
            return true;
        } catch (Exception e) {
            System.out.println("Who format, please re-enter!   ");
        }
        return false;
    }
    public static boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailPattern);
        return pattern.matcher(email).matches();
    }

    public static boolean isValidTheoryAndPractice(int value) {
        return value >= 0 && value <= 10;
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

    public static double inputDouble(String mess,double max) {
        double realDouble;
        while (true) {
            try {
                System.out.println(mess);
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
}
