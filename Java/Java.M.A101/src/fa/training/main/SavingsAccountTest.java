package fa.training.main;

import fa.training.entities.SavingsAccount;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SavingsAccountTest {
    static List<SavingsAccount> savingsAccountList =new ArrayList<>();
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
        SavingsAccount saver1 = new SavingsAccount(0.04, 2000.0);
        SavingsAccount saver2 = new SavingsAccount(0.04, 3000.0);
        System.out.println("Tài khoản ban đầu:");
        System.out.println("Tài khoản saver1: $" + saver1.getSavingsBalance());
        System.out.println("Tài khoản saver2: $" + saver2.getSavingsBalance());
        System.out.println();
        System.out.println("Lãi xuất hàng tháng (4%/năm):");
        System.out.println("Tài khoản saver1: $" + saver1.amountMonthlyInterest());
        System.out.println("Tài khoản saver2: $" + saver2.amountMonthlyInterest());
        System.out.println();
        System.out.println("Số tiền tháng tiếp theo:");
        System.out.println("Tài khoản saver1: $" + saver1.calculateMonthlyInterest());
        System.out.println("Tài khoản saver2: $" + saver2.calculateMonthlyInterest());
        saver1.setAnnualInterestRate(0.05);
        saver2.setAnnualInterestRate(0.05);
        System.out.println();
        System.out.println("Lãi xuất hàng tháng (5%/năm):");
        System.out.println("Tài khoản saver1: $" + saver1.amountMonthlyInterest());
        System.out.println("Tài khoản saver2: $" + saver2.amountMonthlyInterest());
        System.out.println();
        System.out.println("Số tiền tháng tiếp theo:");
        System.out.println("Tài khoản saver1: $" + saver1.calculateMonthlyInterest());
        System.out.println("Tài khoản saver2: $" + saver2.calculateMonthlyInterest());
    }


}
