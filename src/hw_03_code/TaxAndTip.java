package hw_03_code;

import java.util.Scanner;


public class TaxAndTip {
    private static final double TAX_RATE = 0.0675;
    private static final double TIP = 0.20;
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the cost of your meal: $");
        double initialBill = input.nextDouble();
        double tax = initialBill * TAX_RATE;
        double tip = (initialBill + tax) * TIP;
        double totalBill = initialBill + tax + tip;
        System.out.printf("With the cost of the meal at $%.2f%n", initialBill);
        System.out.printf("The tax is: $%.2f%n", tax);
        System.out.printf("The tip is: $%.2f%n", tip);
        System.out.printf("Your total is: $%.2f%n", totalBill);
        System.out.println("Thank you for dining with us!");
        input.close();

    }

}
