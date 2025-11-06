package lab_04c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PizzaTime {
    public static void main (String [] args) throws FileNotFoundException
    {
        File sales = new File ("files/lab_04c_pizza_time.csv");
        Scanner salesReader = new Scanner(sales);
        salesReader.useDelimiter(",|\\r?\\n");

        double priceTotal = 0.0;

        salesReader.nextLine();
        while (salesReader.hasNext()) {
            String name = salesReader.next();
            String date = salesReader.next();
            double price = salesReader.nextDouble();
            String pizzaType = salesReader.next();

            //System.out.println(token);
            priceTotal += price;

            System.out.printf("Name: %-20s Price: %8.2f\n", name, price);
        }

        System.out.printf("Today's total purchase is: $%.2f", priceTotal);

        salesReader.close();

    }
}
