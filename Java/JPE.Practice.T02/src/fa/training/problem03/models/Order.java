package fa.training.problem03.models;

public class Order {
    private int orderID;
    private String orderDate;
    private String requiredDate;
    private String customerID;
    private double totalPrice;

    public Order() {
    }

    public Order(int orderID, String orderDate, String requiredDate, String customerID, double totalPrice) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.customerID = customerID;
        this.totalPrice = totalPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
