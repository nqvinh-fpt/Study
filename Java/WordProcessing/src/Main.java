import java.io.BufferedReader;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String inputString(String mess) {
        String realString;
        while (true) {
            try {
                System.out.println(mess);
                realString = reader.readLine();
                break;
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập lại! ");
            }
        }
        return realString;
    }
    public static void main(String[] args) {
        String input =inputString("Nhập chuỗi: ");
        Word word =new Word(input);
        System.out.println("Trong chuỗi có "+word.CountWord()+ " kí tự");
        System.out.println("Trong chuỗi có "+word.CountChacterA()+ " kí tự A");
        word.StandardizeText();
        System.out.println("Chuỗi sau khi chuẩn hóa: "+word.getSt());
    }
}