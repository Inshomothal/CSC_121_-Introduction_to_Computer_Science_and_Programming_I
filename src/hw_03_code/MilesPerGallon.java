package hw_03_code;
import java.util.Scanner;

public class MilesPerGallon {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of miles that were driven: ");
        double miles = input.nextDouble();
        System.out.print("Enter the number of gallons used for the trip: ");
        double gallons = input.nextDouble();
        double mpg = miles / gallons;
        System.out.println("Your miles per gallon (mpg) is: " + mpg);
        input.close();
    }

}
