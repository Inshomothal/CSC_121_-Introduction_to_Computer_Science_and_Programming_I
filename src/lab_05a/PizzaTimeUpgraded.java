package lab_05a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PizzaTimeUpgraded {
    public static void main (String [] args) throws FileNotFoundException
    {
        // File sales = new File ("files/lab_04c_pizza_time.csv");
        // Scanner salesReader = new Scanner(sales);
        // salesReader.useDelimiter(",|\\r?\\n");

        // double priceTotal = 0.0;

        // salesReader.nextLine();
        
        // priceTotal = labWay(salesReader).get("Store Total");

        // System.out.printf("Today's total purchase is: $%.2f", priceTotal);

        // salesReader.close();

        crazyLabWay();

    }

    public static HashMap<String, Double> labWay(Scanner sales) {
        double total = 0.0;
        HashMap<String, Double> salesMap = new HashMap<>();
        
        // while (sales.hasNext()) {
        //     String name = sales.next();
        //     String date = sales.next();
        //     double price = sales.nextDouble();
        //     String pizzaType = sales.next();

        //     //System.out.println(token);
        //     total += price;

        //     System.out.printf("Name: %-20s Price: %8.2f\n", name, price);
        // }

        salesMap.put("Store Total", 33.3);

        return salesMap;
    }
    public static void crazyLabWay() {
        double total = 0.0;
        HashMap<String, HashMap<String, Object>> salesMap = new HashMap<>();
        HashMap<String, Object> workersMap = new HashMap<>();
        workersMap.put("sales", 32.0);
        workersMap.put("date", "05-23-1992");
        salesMap.put("Karina", workersMap);

        System.out.println(salesMap.get("Karina").get("date"));


    }
}
