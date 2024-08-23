package exercise;

public class Test {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int number1 = 20, number2 = 2;
        System.out.println("Sum: " + calculator.sum(number1, number2));
        System.out.println("Subtraction: " + calculator.sub(number1, number2));
        System.out.println("Multiplication: " + calculator.mul(number1, number2));
        System.out.println("Division: " + calculator.div(number1, number2));
    }
}
