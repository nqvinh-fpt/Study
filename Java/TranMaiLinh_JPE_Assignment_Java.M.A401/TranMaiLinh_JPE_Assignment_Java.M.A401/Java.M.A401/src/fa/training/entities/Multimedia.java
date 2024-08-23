package fa.training.entities;

import java.util.Scanner;

public abstract class Multimedia {
    private String name;
    private double duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Multimedia() {
    }

    public Multimedia(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public void createMultimedia() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name: ");
        name = sc.nextLine();
        duration = inputDouble("Enter the duration (minutes): ");
    }

    public static double inputDouble(String mess) {
        Scanner sc = new Scanner(System.in);
        double realDouble;
        while (true) {
            try {
                System.out.println(mess);
                String input = sc.nextLine();
                realDouble = Double.parseDouble(input);
                    if (0 <= realDouble) {
                        break;
                    }
                System.err.println("Please re-enter!");
            } catch (Exception e) {
                System.err.println("Wrong format, please re-enter! ");
            }
        }
        return realDouble;
    }

}
