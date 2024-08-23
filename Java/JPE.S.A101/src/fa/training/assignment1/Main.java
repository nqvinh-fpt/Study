package fa.training.assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.text.DecimalFormat;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int option;
        while (true) {
            System.out.println("----JPE.S.A101---");
            System.out.println("1.Exercise1");
            System.out.println("2.Exercise2");
            System.out.println("4.Exercise4");
            System.out.println("5.Exercise5");
            System.out.println("6.Exercise6");
            System.out.println("7.Exercise7");
            System.out.println("0.Exit");
            option = inputNumber("Nhập chức năng: ");
            switch (option) {
                case 1:
                    ArithmeticExercise1();
                    break;
                case 2:
                    ArithmeticExercise2();
                    break;
                case 4:
                    ArithmeticExercise3();
                    break;
                case 5:
                    CircleExercise();
                    break;
                case 6:
                    RectangleExercise();
                    break;
                case 7:
                    LogicalExercise();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void LogicalExercise() {
        int number1 = inputNumber("Input first integer:");
        int number2 = inputNumber("Input second integer:");
        if (number1 == number2) {
            System.out.println(number1 + "==" + number2);
        } else {
            System.out.println(number1 + "!=" + number2);
            if (number1 < number2) {
                System.out.println(number1 + "<" + number2);
                System.out.println(number1 + "<=" + number2);
            } else if (number1 > number2) {
                System.out.println(number1 + ">" + number2);
                System.out.println(number1 + "=>" + number2);
            }
        }


}

    private static void RectangleExercise() {
        DecimalFormat df = new DecimalFormat("#0." + "0".repeat(2));
        double width = 5.6, height = 8.5;
        System.out.println("Area is 5.6 * 8.5 = " + df.format(width*height));
        System.out.println("Perimeter is 2 * (5.6 + 8.5) = " + df.format(2 * (width + height)));
    }

    private static void CircleExercise() {
        double radius = 7.5;
        System.out.println("Perimeter is = " + (radius * 2) * Math.PI);
        System.out.println("Area is = " + (radius * radius * Math.PI));
    }

    private static void ArithmeticExercise3() {
        double result = ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));

        System.out.println("Expected Output");
        System.out.println(result);
    }

    private static void ArithmeticExercise2() {
        int number1 = inputNumber("Input first number:");
        int number2 = inputNumber("Input second number:");

        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
        System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
        System.out.println(number1 + " x " + number2 + " = " + (number1 * number2));
        System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
        System.out.println(number1 + " % " + number2 + " = " + (number1 % number2));
    }

    private static void ArithmeticExercise1() {
        System.out.println("Output: ");
        System.out.println(-5 + 8 * 6);
        System.out.println((55 + 9) % 9);
        System.out.println(20 + -3 * 5 / 8);
        System.out.println(5 + 15 / 3 * 2 - 8 % 3);
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
                System.err.println("Sai định dạng, vui lòng nhập lại! ");
            }
        }
        return realNumber;
    }

    public static double inputDouble(String mess) {
        double realDouble;
        while (true) {
            try {
                System.out.println(mess);
                String input = reader.readLine();
                realDouble = Double.parseDouble(input);
                if (realDouble > 0) {
                    break;
                }
                System.err.println("Số đã nhập bé hơn 0, vui lòng nhập lại!");

            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập lại! ");
            }
        }
        return realDouble;
    }



}


