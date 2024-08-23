import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        int number = 0;
        int number2 = 0;
        while (!check) {
            System.out.println("Nhap so");
            String numberInput = scanner.nextLine();
            try {
                number = Integer.parseInt(numberInput);
                check = true;
                String mess = number < 5 ? "Nho hon 5"
                        : number > 5 ? "Lon hon 5" :
                        "Bang 5";
                System.out.println(mess);
            } catch (NumberFormatException e) {
                System.out.println(e.toString());
                System.out.println("Nhap so 2");
                String numberInput2 = scanner.nextLine();
                number2 = Integer.parseInt(numberInput2);
            }
        }


    }
}