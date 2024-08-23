package exercise1;

public class SumAverageRunningInt {
    public static void main(String[] args) {
        int lowerbound = 1;
        int upperbound = 100;
        int sum = 0;
        for (int i = lowerbound; i <= upperbound; i++) {
            sum += i;
        }

        int average =sum / (upperbound - lowerbound + 1);
        System.out.println("Average of all 100 first numbers: " + (double)average);
    }}
