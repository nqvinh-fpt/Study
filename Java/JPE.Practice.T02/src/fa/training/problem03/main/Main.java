package fa.training.problem03.main;

import fa.training.problem03.dao.OrderDao;
import fa.training.problem03.models.Order;
import fa.training.problem03.models.OrderDetail;
import fa.training.problem03.utils.Validator.Validator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException {
        List<Order> orders = new ArrayList<>();
        List<OrderDetail> orderDetails = new ArrayList<>();
        Order order ;
        OrderDetail orderDetail;
        int option;
        OrderDao orderDao = new OrderDao();
        while (true) {
            System.out.println("----Final---");
            System.out.println("Choose function");
            System.out.println("1.Create a new order");
            System.out.println("2.Create a new order detail");
            System.out.println("3.Total money");
            System.out.println("4.List order");
            System.out.println("5.Exit");
            option = Validator.inputNumber("Enter option(1-5): ");
            switch (option) {
                case 1:
                    order=orderDao.createOrder();
                    orders.add(order);
                    break;
                case 2:
                    orderDetail=orderDao.createOrderDetail();
                    orderDetails.add(orderDetail);
                    orderDetails.add(orderDao.createOrderDetail());
                    break;
                case 3:

                    System.out.println(orderDao.calculateTotalMoney(Validator.inputString("Enter Customer Id:"), orders));
                   break;
                case 4:
                    orderDao.displayListOrder(orders);

                    break;
                case 5:
                    return;
                default:
            }
        }
    }
}
