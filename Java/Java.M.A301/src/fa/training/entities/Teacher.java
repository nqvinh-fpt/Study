package fa.training.entities;

public class Teacher extends Person {

    private double basicSalary;

    private double subsidy;



    public Teacher(double basicSalary, double subsidy) {

        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public Teacher(String fullName, String gender, String dateOfBirth, String phone, String email, double basicSalary, double subsidy) {
        super(fullName, gender, dateOfBirth, phone, email);
        this.basicSalary = basicSalary;
        this.subsidy = subsidy;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public double calculateSalary() {
        return basicSalary + subsidy;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "basicSalary=" + basicSalary +
                ", subsidy=" + subsidy +
                '}';
    }
}
