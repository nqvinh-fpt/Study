import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static int inputNumber(String mess, int min, int max) {
        int realNumber = 0;
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(System.in));
                System.out.println(mess);
                String number = reader.readLine();
                realNumber = Integer.parseInt(number);
                if (max == 0) {
                    break;
                } else if (min <= realNumber && realNumber <= max) {
                    break;
                }
                System.err.println("Số đã nhập vượt quá giới , vui lòng nhập lại!");
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập lại! ");
            }
        }
        return realNumber;
    }

    public static LocalTime ChangeTime(int hours, int minute, int second, int option) {
        int timeAdd = 0;
        LocalTime time = LocalTime.of(hours, minute, second);
        if (option == 1) {
            timeAdd = inputNumber("Thêm giây: ", 0, 0);
            time = time.plusSeconds(timeAdd);
        }
        if (option == 2) {
            timeAdd = inputNumber("Thêm phút: ", 0, 0);
            time = time.plusMinutes(timeAdd);
        }
        if (option == 3) {
            timeAdd = inputNumber("Thêm giờ: ", 0, 0);
            time = time.plusHours(timeAdd);
        }
        System.out.println("Thời gian sau khi thêm: " + time);
        return time;
    }

    public static void main(String[] args) {

        int option;
        int hours = 0;
        int minute = 0;
        int second = 0;

        second = inputNumber("Nhập số giây: ", 0, 59);
        minute = inputNumber("Nhập số phút: ", 0, 59);
        hours = inputNumber("Nhập số giờ: ", 0, 23);
        LocalTime time = LocalTime.of(hours, minute, second);
        System.out.println("Thời gian đã nhập: " + time);


        while (true) {
            System.out.println("----Thay đổi thời gian---");
            System.out.println("1.Thêm giây");
            System.out.println("2.Thêm phút");
            System.out.println("3.Thêm giờ");
            System.out.println("4.Xem giờ");
            System.out.println("0.Kết thúc");
            option = inputNumber("Nhập chức năng(0-4): ", 0, 4);
            switch (option) {
                case 1, 2, 3:
                    time = ChangeTime(hours, minute, second, option);
                    hours = time.getHour();
                    minute = time.getMinute();
                    second = time.getSecond();
                    break;
                case 4:
                    System.out.println("Entered Time: " + time);
                    break;
                case 0:
                    return;
            }
        }
    }
}