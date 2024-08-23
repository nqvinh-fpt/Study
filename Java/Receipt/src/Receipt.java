public class Receipt {
    private Customer customer;
    private double oldElectricity;
    private double newElectricity;

    public Receipt() {
    }

    public Receipt(Customer customer, double oldElectricity, double newElectricity) {
        this.customer = customer;
        this.oldElectricity = oldElectricity;
        this.newElectricity = newElectricity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getOldElectricity() {
        return oldElectricity;
    }

    public void setOldElectricity(double oldElectricity) {
        this.oldElectricity = oldElectricity;
    }

    public double getNewElectricity() {
        return newElectricity;
    }

    public void setNewElectricity(double newElectricity) {
        this.newElectricity = newElectricity;
    }

    public double priceElectrictity(){
        return (newElectricity- oldElectricity)*5;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "name=" + customer.getName() +
                "address=" + customer.getAddress() +
                "Electricity Code=" + customer.getElectricityCode() +
                ", oldElectricity=" + oldElectricity +
                ", newElectricity=" + newElectricity +
                '}';
    }
}
