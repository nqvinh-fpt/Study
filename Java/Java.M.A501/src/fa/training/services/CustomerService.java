package fa.training.services;
import fa.training.utils.Constants;
import fa.training.utils.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public List<String> createCustomer(List<String> customerDataList) {

        while (true) {
            System.out.println("Enter customer information:");
            String name = Validator.inputString("Enter Name: ");

            String phoneNumber;
            while (true) {
                phoneNumber = Validator.inputString("Enter phone : ");
                if (Validator.isValidPhoneNumber(phoneNumber)) {
                    break;
                }
            }
            String address = Validator.inputString("Enter address: ");

            List<String> ordersDataList = new ArrayList<>();
            String orderNumber;
            String orderDate;
            while (true) {
                System.out.println("Enter order infor:");
                while (true) {
                    orderNumber = Validator.inputString("+ number: ");
                    if (Validator.isValidOrderNumber(orderNumber)) {
                        break;
                    }
                }
                while (true) {
                    orderDate = Validator.inputString("+ date: ");
                    if (Validator.isValidDate(orderDate)) {
                        break;
                    }
                }
                String orderData = "Order Number=" + orderNumber + ", Date=" + orderDate;
                ordersDataList.add(orderData);
                break;
            }
            String customerData = " Customer[name=" + name + ", phone=" + phoneNumber + ", address=" + address + " Orders[ " + String.join(", ", ordersDataList) + "]";

            customerDataList.add(customerData);
            String anotherCustomer = Validator.inputString("Do you want to add another customer (Y/N)? ");
            if (!anotherCustomer.equalsIgnoreCase("Y")) {
                break;
            }
        }

        return customerDataList;
    }

    public List<String> createCustomer() {
        List<String> customerDataList = new ArrayList<>();
        while (true) {
            System.out.println("Enter customer information:");
            String name = Validator.inputString("Enter Name: ");

            String phoneNumber;
            while (true) {
                phoneNumber = Validator.inputString("Enter phone : ");
                if (Validator.isValidPhoneNumber(phoneNumber)) {
                    break;
                }
            }
            String address = Validator.inputString("Enter address: ");

            List<String> ordersDataList = new ArrayList<>();
            String orderNumber;
            String orderDate;
            while (true) {
                System.out.println("Enter order infor:");
                while (true) {
                    orderNumber = Validator.inputString("+ number: ");
                    if (Validator.isValidOrderNumber(orderNumber)) {
                        break;
                    }
                }
                while (true) {
                    orderDate = Validator.inputString("+ date: ");
                    if (Validator.isValidDate(orderDate)) {
                        break;
                    }
                }
                String orderData = "Order Number=" + orderNumber + ", Date=" + orderDate;
                ordersDataList.add(orderData);
                break;
            }
            String customerData = " Customer[name=" + name + ", phone=" + phoneNumber + ", address=" + address + " Orders[ " + String.join(", ", ordersDataList) + "]";

            customerDataList.add(customerData);
            String anotherCustomer = Validator.inputString("Do you want to add another customer (Y/N)? ");
            if (!anotherCustomer.equalsIgnoreCase("Y")) {
                break;
            }
        }

        return customerDataList;
    }

    public String save(List<String> customers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Constants.CUSTOMER_DATA_FILE))) {
            for (String updatedCustomerData : customers) {
                writer.println(updatedCustomerData);
            }
            return "Data saved successfully.";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error saving data.";
    }

    public List<String> findAll() {
        List<String> customersData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Constants.CUSTOMER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                customersData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customersData;
    }

    public List<String> search(String phone, List<String> customers) {
        if (customers != null) {
            List<String> matchingOrders = new ArrayList<>();
            for (String orderData : customers) {
                if (orderData.contains("phone=" + phone)) {
                    matchingOrders.add(orderData);
                }
            }
            return matchingOrders;
        } else {
            return null;
        }
    }


    public void display(List<String> customers) {
        if (customers != null) {
            System.out.println("------LIST OF CUSTOMER--------");
            for (String customer : customers) {
                System.out.println(customer);
            }
        } else {
            System.out.println("List null");
        }
    }

}