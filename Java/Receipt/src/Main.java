import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static List<Customer> customerList =new ArrayList<>();
    static List<Receipt> receiptList =new ArrayList<>();

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int inputNumber(String mess, int min, int max) {
        int realNumber = 0;
        while (true) {
            try {
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
    public static double inputDouble(String mess,double min) {
        double realDouble;
        while (true) {
            try {
                System.out.println(mess);
                String input = reader.readLine();
                realDouble = Double.parseDouble(input);
               if (min <= realDouble ) {
                    break;
                }
                System.err.println("Số đã nhập vượt quá giới , vui lòng nhập lại!");
            } catch (Exception e) {
                System.err.println("Sai định dạng, vui lòng nhập lại! ");
            }
        }
        return realDouble;
    }

    public static void main(String[] args) {
        int option;
        while (true) {
            System.out.println("----Quản Lý Biên Lai---");
            System.out.println("1.Thêm Khách Hàng");
            System.out.println("2.Xóa Khách Hàng");
            System.out.println("3.Sửa Thông Tin Khách Hàng");
            System.out.println("4.Tính Tiền Điện");
            System.out.println("5.Danh sách");
            System.out.println("0.Kết thúc");
            option = inputNumber("Nhập chức năng(0-5): ", 0, 5);
            switch (option) {
                case 1:
                    CreateCustomer();
                    break;
                case 2:
                    DeleteCustomer();
                    break;
                case 3:
                    UpdateCustomer();
                    break;
                case 4:
                    ElectricityBill();
                    break;
                case 5:
                    DisplayList();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void DisplayList() {
        System.out.println("tên khách hàng      số nhà       mã công tơ     số điện cũ      số điện mới");
        for (int i=0;i< receiptList.size();i++){
            String nameCustomer = receiptList.get(i).getCustomer().getName();
            String numberAddress = receiptList.get(i).getCustomer().getAddress();
            String codeElec = receiptList.get(i).getCustomer().getElectricityCode();
            double oldElec = receiptList.get(i).getOldElectricity();
            double newElec = receiptList.get(i).getNewElectricity();
            String formatSoDienCu = (oldElec % 1 == 0) ? String.format("%.0f", oldElec) : String.format("%.2f", oldElec);
            String formatSoDienMoi = (newElec % 1 == 0) ? String.format("%.0f", newElec) : String.format("%.2f", newElec);

            System.out.printf("%-20s %-12s %-14s %-14s %-14s %n", nameCustomer, numberAddress, codeElec, formatSoDienCu, formatSoDienMoi);
        }
    }

    private static void ElectricityBill() {
        String codeElectric =inputString("Nhập mã công tơ");
        for (int i=0;i< receiptList.size();i++){
            if(receiptList.get(i).getCustomer().getElectricityCode().equals(codeElectric)){
                System.out.println("Số tiền điện: "+ receiptList.get(i).priceElectrictity());
            }
        }

    }

    private static void UpdateCustomer() {
        String codeElectric =inputString("Nhập mã công tơ");
        for (int i=0;i< receiptList.size();i++){
            if(receiptList.get(i).getCustomer().getElectricityCode().equals(codeElectric)){
                System.out.println("tên khách hàng: "+receiptList.get(i).getCustomer().getName());
                System.out.println("số nhà: "+receiptList.get(i).getCustomer().getAddress());
                System.out.println("mã công tơ: "+receiptList.get(i).getCustomer().getElectricityCode());
                System.out.println("số điện cũ: "+receiptList.get(i).getOldElectricity());
                System.out.println("số điện mới: "+receiptList.get(i).getNewElectricity());
                int option;
                while (true) {
                    System.out.println("----Update Biên Lai---");
                    System.out.println("1.Tên Khách Hàng");
                    System.out.println("2.Số nhà Khách Hàng");
                    System.out.println("3.Mã công tơ");
                    System.out.println("4.số điện cũ");
                    System.out.println("5.số điện mới");
                    System.out.println("0.Kết thúc");
                    option = inputNumber("Nhập chức năng(0-5): ", 0, 5);
                    switch (option) {
                        case 1:
                            String name =  inputString("Nhập tên: ");
                            receiptList.get(i).getCustomer().setName(name);
                            break;
                        case 2:
                            String address =  inputString("Nhập Số nhà Khách Hàng: ");
                            receiptList.get(i).getCustomer().setAddress(address);
                            break;
                        case 3:
                            String code =  inputString("Nhập Mã công tơ: ");
                            receiptList.get(i).getCustomer().setElectricityCode(code);
                            break;
                        case 4:
                            double oldNumber =  inputDouble("Nhập Mã công tơ: ",0);
                            receiptList.get(i).setOldElectricity(oldNumber);
                            break;
                        case 5:
                            double newNumber =  inputDouble("Nhập Mã công tơ: ",receiptList.get(i).getOldElectricity());
                            receiptList.get(i).setNewElectricity(newNumber);
                            break;
                        case 0:
                            return;
                    }
                }
            }else{
                System.out.println("Khoong có thông tin khách hàng");
                return;
            }
        }
    }

    private static void DeleteCustomer() {
        String codeElectric =inputString("Nhập mã công tơ");
        for (int i=0;i< receiptList.size();i++){
            if(receiptList.get(i).getCustomer().getElectricityCode().equals(codeElectric)){
                receiptList.remove(i);
            }
        }
    }

    private static void CreateCustomer() {
        String name ;
        String address;
        String codeElectric;
        double oldElectricity;
        double newElectricity;
        name = inputString("Nhập tên khách hàng");
        address =inputString("Nhập số nhà ");
        codeElectric= inputString("Nhập mã công tơ");
        oldElectricity =inputDouble("Nhập số điện cũ",0);
        newElectricity =inputDouble("Nhập số điện mới",oldElectricity);
        Customer customer =new Customer(name,address,codeElectric);
        Receipt receipt =new Receipt(customer,oldElectricity,newElectricity);
        customerList.add(customer);
        receiptList.add(receipt);
    }
}