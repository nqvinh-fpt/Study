package fa.training.main;

import fa.training.entities.Customer;
import fa.training.services.CustomerService;
import fa.training.utils.Constants;
import fa.training.utils.Validator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static CustomerService customerService = new CustomerService();
    static List<String> customers = null;
    public static void main(String[] args) {
        int option;

        while (true) {
            System.out.println("----JPE.M.A501---");
            System.out.println("Choose function");
            System.out.println("1.Add a new Customer");
            System.out.println("2.Show all Customer");
            System.out.println("3.Search Customer");
            System.out.println("4.Remove Customer");
            System.out.println("5.Exit");
            option = Validator.inputNumber("Enter option(1-5): ");
            switch (option) {
                case 1:
                    if (customers!=null) {
                    customers=customerService.createCustomer(customers);
                    String result = customerService.save(customers);
                    System.out.println(result);
                }else {
                    customers = customerService.createCustomer();
                    String result = customerService.save(customers);
                    System.out.println(result);
                }
                    break;
                case 2:
                        customerService.display(customers);
                    break;
                case 3:

                        List<String> retrievedCustomers = customerService.search(Validator.inputString("Enter Phone Number: "),customers);
                        customerService.display(retrievedCustomers);

                    break;
                case 4:
                    if(remove(Validator.inputString("Enter Phone Number Want Remove: "))){
                        System.out.println("Remove done!");
                    }else {
                        System.out.println("Remove not done!");
                    }
                    break;
                case 5:
                    return;
                default:
            }
        }

    }
    public static boolean remove(String phone) {
            if (Validator.isValidPhoneNumber(phone)) {
                List<String> updatedCustomersData = new ArrayList<>();
                boolean customerRemoved = false;
                if(customers!=null){

                    for (String customerData : customers) {
                        if (!customerData.contains("phone=" + phone)) {
                            updatedCustomersData.add(customerData);
                        } else {
                            customerRemoved = true;
                        }
                    }
                    customers=updatedCustomersData;
                    if (customerRemoved) {
                        try (PrintWriter writer = new PrintWriter(new FileWriter(Constants.CUSTOMER_DATA_FILE))) {
                            for (String updatedCustomerData : updatedCustomersData) {
                                writer.println(updatedCustomerData);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return true;
                }else {
                    return false;
                }
            }  else {
                return false;
            }
    }
}