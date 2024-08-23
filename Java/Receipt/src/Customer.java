public class Customer {
    private String name;
    private String address;
    private String electricityCode;

    public Customer() {
    }

    public Customer(String name, String address, String electricityCode) {
        this.name = name;
        this.address = address;
        this.electricityCode = electricityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getElectricityCode() {
        return electricityCode;
    }

    public void setElectricityCode(String electricityCode) {
        this.electricityCode = electricityCode;
    }
}
