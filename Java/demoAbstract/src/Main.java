import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        ConcretePhoneManagementSystem phoneSystem = new ConcretePhoneManagementSystem();
        
        phoneSystem.insertPhone("Vinh", "12345");
        phoneSystem.insertPhone("Quang", "67890");
        phoneSystem.insertPhone("Nguyen", "54321");

        System.out.println("Phone book before sorting:");
        for (PhoneManagementSystem.PhoneNumber entry : phoneSystem.phoneBook) {
            System.out.println("Name: " + entry.getName() + ", Phone: " + entry.getPhone());
        }

        phoneSystem.sort();

        System.out.println("Phone book after sorting:");
        for (PhoneManagementSystem.PhoneNumber entry : phoneSystem.phoneBook) {
            System.out.println("Name: " + entry.getName() + ", Phone: " + entry.getPhone());
        }
    }
}
