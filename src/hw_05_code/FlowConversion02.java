package hw_05_code;

import java.util.Scanner;

public class FlowConversion02 {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        
        double powerLevel;

        System.out.print("Please tell me your device's power level: ");
        powerLevel = input.nextDouble();
        input.nextLine();

        if (powerLevel > 50.0) {
            if (powerLevel > 75.0) {
                System.out.println("Full Battery.");
            } else {
                System.out.println("High Battery.");
            };
        } else {
            System.out.println("Warning: Charge Soon!");

            if (powerLevel > 25.0) {
                System.out.println("Low Battery.");
            } else {
                System.out.println("Empty Battery.");
            }
        }


        
    }
}
