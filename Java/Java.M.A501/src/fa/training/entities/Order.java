package fa.training.entities;

import java.util.Date;
import java.util.List;

public class Order {
    private String number;
    private Date date;
    private List<String> orderData;

    public Order(List<String> orderData) {
        this.orderData = orderData;
    }

    public List<String> getOrderData() {
        return orderData;
    }

    public Order() {
    }

    public Order(String number, Date date) {
        this.number = number;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}