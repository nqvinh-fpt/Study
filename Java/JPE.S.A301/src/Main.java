import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int option;
        while (true) {
            System.out.println("----JPE.S.A301---");
            System.out.println("1.Exercise1");
            System.out.println("2.Exercise2");
            System.out.println("3.Exercise3");
            System.out.println("4.Exercise4");
            option = inputNumber("Nhập chức năng(0-4): ");
            switch (option) {
                case 1:
                    Exercise1();
                    break;
                case 2:
                    Exercise2();
                    break;
                case 3:
                    Exercise3();
                    break;
                case 4:
                    CylinderComputation();
                    break;
                case 0:
                    return;
            }
        }
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
                if (realDouble > 0 ) {
                    break;
                }
                System.err.println("Số đã nhập bé hơn 0, vui lòng nhập lại!");

            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập lại! ");
            }
        }
        return realDouble;
    }
    private static void CylinderComputation() {

        double radius ;
        double height ;
        radius=inputDouble("Input radius:");
        height=inputDouble("Input height:");
        System.out.println("r" +Math.sqrt(490.8738515625/Math.PI));
        System.out.println("h"+ (1963.49540625/Math.PI/12.5/12.5));
        System.out.println("Surface area = " +  2*Math.PI*radius*(height+radius));

        System.out.println("Base area = "+ Math.PI * radius*radius);
        System.out.println("Volume = " +Math.PI*radius*radius*height);

    }

    private static void Exercise3() {
        int sum=0;
        int [] number = new int[5];
        number[0]=inputNumber("Input first number:");
        number[1]=inputNumber("Input second number:");
        number[2]=inputNumber("Input third number:");
        number[3]=inputNumber("Input fourth number:");
        number[4]=inputNumber("Input fifth number:");

        for (int i=0;i<number.length;i++){
            sum+=number[i];
        }
        System.out.println("The sum is "+sum);


    }

    private static void Exercise2() {
        boolean check=true;
        int [] number = new int[4];
        number[0]=inputNumber("Input first number:");
        number[1]=inputNumber("Input second number:");
        number[2]=inputNumber("Input third number:");
        number[3]=inputNumber("Input fourth number:");

        if (number[0]==number[1] && number[1]==number[2]&&number[2]==number[3]){
            System.out.println("Numbers are equal!");
        }else {
            System.out.println("Numbers are not equal!");
        }
    }

    private static void Exercise1() {
        System.out.println("Exercise1 Output:");
        System.out.println("(101 + 0) / 3)->"+((101 + 0) / 3));
        System.out.println("(3.0e-6 * 10000000.1->)"+(3.0e-6 * 10000000.1));
        System.out.println("(true && true)->"+(true && true));
        System.out.println("(false && true)->"+(false && true));
        System.out.println("((false && false) || (true && true))->"+((false && false) || (true && true)));
        System.out.println("(false || false) && (true && true)->"+((false || false) && (true && true)));

    }



}