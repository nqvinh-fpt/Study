package fa.training.problem02;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Reversenlnt {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int reverseInt(int input) {
        int reversed = 0;

        while (input != 0) {
            int digit = input % 10;
            reversed = reversed * 10 + digit;
            input /= 10;
        }

        return reversed;
    }

    @Test
    public void testReverseInt1() {
        int result = reverseInt(12345);
        System.out.println("Enter a positive interger: 12345");
        System.out.println("The reverse is: "+result);
        if (result == 54321) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    @Test
    public void testReverseInt2() {
        int result = reverseInt(987654321);
        System.out.println("Enter a positive interger: 987654321");
        System.out.println("The reverse is: "+result);
        if (result == 123456789) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    @Test
    public void testReverseInt3() {
        int result = reverseInt(1001);
        System.out.println("Enter a positive interger: 1001");
        System.out.println("The reverse is: "+result);
        if (result == 1001) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    @Test
    public void testReverseInt4() {
        int result = reverseInt(7);
        System.out.println("Enter a positive interger: 7");
        System.out.println("The reverse is: "+result);
        if (result == 7) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    @Test
    public void testReverseInt5() {
        int result = reverseInt(0);
        System.out.println("Enter a positive interger: 0");
        System.out.println("The reverse is: "+result);
        if (result == 0) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    public static void main(String[] args) {
        int result = reverseInt(inputNumber("Enter a positive interger:"));
        System.out.println("The reverse is: "+result);
    }
    public static int inputNumber(String mess) {
        int realNumber = 0;
        while (true) {
            try {
                System.out.print(mess);
                String number = reader.readLine();
                realNumber = Integer.parseInt(number);
                if(realNumber>0){
                    break;
                }
                System.out.println("Nunber bigger than 0");
            } catch (Exception e) {
                System.out.println("Who format, please re-enter!   ");
            }
        }
        return realNumber;
    }
}
