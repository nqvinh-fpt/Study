package fa.training.entities;

public class SavingsAccount {
    private double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount() {
    }

    public SavingsAccount(double annualInterestRate, double savingsBalance) {
        this.annualInterestRate = annualInterestRate;
        this.savingsBalance = savingsBalance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public double calculateMonthlyInterest() {
      return   savingsBalance +((savingsBalance * annualInterestRate) / 12);
    }
    public double  amountMonthlyInterest(){
        return savingsBalance*annualInterestRate/12;
    }

}
