package fa.training.problem03.dao;

import fa.training.problem03.models.Order;
import fa.training.problem03.models.OrderDetail;
import fa.training.problem03.utils.DAL.DBContext;
import fa.training.problem03.utils.Validator.Validator;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDao extends DBContext {
    public String save(Order order) {

        String insertOrderSQL = "INSERT INTO [dbo].[Orders]\n" +
                "           ([OrderDate]\n" +
                "           ,[RequiredDate]\n" +
                "           ,[CustomerID]\n" +
                "           ,[TotalPrice])\n" +
                "     VALUES\n" +
                "           (?,?,?,?)\n";
        try {
            PreparedStatement ps = connection.prepareStatement(insertOrderSQL);
            ps.setString(1, order.getOrderDate());
            ps.setString(2, order.getRequiredDate());
            ps.setString(3, order.getCustomerID());
            ps.setDouble(4, order.getTotalPrice());
            ps.executeUpdate();
            return "success";
        } catch (SQLException e) {
            System.out.println("SQL error: " + e);
            return "fail";
        }
    }

    public String save(OrderDetail orderDetail) {

        String insertOrderSQL = "INSERT INTO [dbo].[OrderDetails]\n"+
                "            ([OrderID]\n" +
                "           ,[ProductName]\n" +
                "           ,[Quantity]\n" +
                "           ,[PricePerUnit]\n" +
                "           ,[TotalPrice])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(insertOrderSQL);
            ps.setInt(1, orderDetail.getOrderId());
            ps.setString(2, orderDetail.getProductName());
            ps.setInt(3, orderDetail.getQuantity());
            ps.setDouble(4, orderDetail.getPricePerUnit());
            ps.setDouble(5, orderDetail.getTotalPrice());
            ps.executeUpdate();
            return "success";
        } catch (SQLException e) {
            System.out.println("SQL error: " + e);
            return "fail";
        }
    }

    public Order createOrder() {
        Order order;
        int orderID;
        String orderDate;
        String requiredDate;
        String customerID;
        double totalPrice;
        while (true) {
            orderID = Validator.inputNumber("Enter Order ID: ");
            while (true) {
                orderDate = Validator.inputString("Enter Order Date: ");
                if (Validator.isValidDate(orderDate)) {
                    break;
                }
            }
            while (true) {
                requiredDate = Validator.inputString("Enter Required Date: ");
                if (Validator.isValidDate(requiredDate)) {
                    if (requiredDate.compareTo(orderDate) >= 0) {
                        break;
                    } else {
                        System.out.println("Required date must greater than or equals order date");
                    }
                }
            }
            customerID = Validator.inputString("Enter Customer ID: ");
            totalPrice = Validator.inputDouble("Enter Total Price: ", 0);
            order = new Order(orderID, orderDate, requiredDate, customerID, totalPrice);
            OrderDao orderDao = new OrderDao();
            System.out.println(orderDao.save(order));
            break;
        }
        return order;
    }

    public OrderDetail createOrderDetail() {
        OrderDetail orderDetail;
        int orderDetailID;
        int orderID;
        String productName;
        int quantity;
        double pricePerUnit;
        double totalPrice;
        while (true) {
            orderDetailID = Validator.inputNumber("Enter Order Detail ID: ");
            orderID = Validator.inputNumber("Enter Order ID: ");
            productName = Validator.inputString("Enter Product Name: ");
            quantity = Validator.inputNumber("Enter Quantity: ");
            pricePerUnit = Validator.inputDouble("Enter PricePer Unit: ", 0);
            totalPrice = Validator.inputDouble("Enter Total Price: ", 0);
            break;
        }
        orderDetail = new OrderDetail(orderDetailID, orderID, productName, quantity, pricePerUnit, totalPrice);
        OrderDao orderDao = new OrderDao();
        System.out.println(orderDao.save(orderDetail));
        return orderDetail;
    }


    public Map<String, Double> reportOfSale() {
        Map<String, Double> salesReport = new HashMap<>();
        salesReport.put("Customer1", 150.0);
        salesReport.put("Customer2", 200.0);

        return salesReport;
    }

    public List<Order> findOrderByCustomer(String customerId,List<Order> orders) {

        List<Order> customerOrders = new ArrayList<>();

        return customerOrders;
    }

    public double calculateTotalMoney(String customerId, List<Order> orders) {
        double totalMoney = 0.0;
        System.out.println("Total money");
        for (Order order : orders) {
            if (order.getCustomerID().equals(customerId)) {
                totalMoney += order.getTotalPrice();
            }
        }
        return totalMoney;
    }

    public void displayListOrder(List<Order> orders) {
        System.out.println("------List order-------");
        for (Order orderList : orders) {
            System.out.printf("%-10s  %-20s  %-20s %-20s %-20s%n", orderList.getOrderID(), orderList.getOrderDate(), orderList.getRequiredDate(), orderList.getCustomerID(), orderList.getTotalPrice());

        }
    }
}
