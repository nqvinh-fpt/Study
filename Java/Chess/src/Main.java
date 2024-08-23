import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        int[][] degrees = new int[3][3];
        int x;
        int y;
        int player = 1;
        while (true) {
            System.out.println("Nhập tọa độ ");
            x = inputNumber("Nhập tọa độ x");
            y = inputNumber("Nhập tọa độ y");
            if (player == 1) {
                degrees[x - 1][y - 1] = 1;
            } else if (player == 2) {
                degrees[x - 1][y - 1] = 2;
            } else {
                degrees[x - 1][y - 1] = 0;
            }

            for (int i = 0; i < degrees.length; i++) {
                for (int j = 0; j < degrees.length; j++) {
                    if (degrees[i][j] == 1) {
                        System.out.print("x |");
                    } else if (degrees[i][j] == 2) {
                        System.out.print("o |");
                    } else {
                        System.out.print(" |");
                    }
                }
                System.out.println();
            }
            if (player == 1) {
                player = 2;
            } else if (player == 2) {
                player = 1;
            }
            if(CheckWin(degrees)){
                break;
            }
        }
    }

    public static int inputNumber(String mess) {
        int realNumber = 0;
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));
                System.out.println(mess);
                String number = reader.readLine();
                realNumber = Integer.parseInt(number);
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập lại! ");
            }
        }
        return realNumber;
    }

    public static boolean CheckWin(int[][] degrees) {
        int checkColumnPlayer1 = 0;
        int checkColumnPlayer2 = 0;
        int checkRowPlayer1 = 0;
        int checkRowPlayer2 = 0;
        int checkCrossPlayer1 = 0;
        int checkCrossPlayer2 = 0;
        for (int i = 0; i < degrees.length; i++) {
            for (int j = 0; j < degrees.length; j++) {
                if (degrees[i][j] == 1) {
                    for(int k=j;k<=j;k++){
                        if(degrees[i][k+1]==degrees[i][j]){
                            checkColumnPlayer1++;
                        }
                    }
                }
                if (degrees[i][j] == 2) {
                    for(int k=j+1;k<=j;k++){
                        if(degrees[i][k]==degrees[i][j]){
                            checkColumnPlayer2++;
                        }
                    }
                }
            }
            System.out.println();
        }
        boolean checkFull=true;
        for (int i = 0; i < degrees.length; i++) {
            for (int j = 0; j < degrees.length; j++) {
                if (degrees[i][j] == 0) {
                    checkFull=false;
                }
            }
        }
        if (checkColumnPlayer1 == 2 || checkColumnPlayer2 == 2||checkRowPlayer1==2||checkRowPlayer2==2||checkCrossPlayer1==2||checkCrossPlayer2==2||checkFull) {

                System.out.println("Game end");
                return true;


        } else {
            checkColumnPlayer1 = 0;
            checkColumnPlayer2 = 0;
            checkRowPlayer1= 0;
            checkRowPlayer2 = 0;
            checkCrossPlayer1 = 0;
            checkCrossPlayer2 = 0;
        }
        return false;
    }
}