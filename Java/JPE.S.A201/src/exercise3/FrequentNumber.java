package exercise3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FrequentNumber {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        int len = inputNumber("Enter the length of the array: ");
        int[] intArray = new int[len];
        int currentIndex = 0;
        String input;
        do {
            int value = 0;
            while (true) {
                try {
                    input = inputString("Enter an integer (or 'N' to stop): ");
                    if (input.equalsIgnoreCase("N")) {
                        System.out.println("Do you want to continue?");
                        input = inputString("Enter option ('N' or 'Y'): ");
                        if(input.equalsIgnoreCase("Y")){
                            for(int i=currentIndex;i<len;i++){
                                intArray[i] = value;
                                currentIndex++;
                            }
                            break;
                        }
                        if(input.equalsIgnoreCase("N")){
                            input = inputString("Enter an integer (or 'N' to stop): ");
                        }
                    }
                    value = Integer.parseInt(input);
                    intArray[currentIndex] = value;
                    currentIndex++;
                    break;
                } catch (Exception e) {
                    System.out.println("Wrong format, please re-enter! ");
                }
            }
        } while (currentIndex < len);
        System.out.print("List integer: ");
        for(int i = 0; i < currentIndex; i++){
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
        int value = inputNumber("Enter the value to count: ");

        int frequency = 0;
        System.out.print("Indexes: ");
        for (int i = 0; i < currentIndex; i++) {
            if (intArray[i] == value) {
                frequency++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nAmount of frequency: " + frequency);
    }

    public static String inputString(String mess) {
        String realString;
        while (true) {
            try {
                System.out.print(mess);
                realString = reader.readLine();
                break;
            } catch (Exception e) {
                System.out.println("Wrong format, please re-enter!");
            }
        }
        return realString;
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
                System.out.println("Wrong format, please re-enter! ");
            }
        }
        return realNumber;
    }
}
