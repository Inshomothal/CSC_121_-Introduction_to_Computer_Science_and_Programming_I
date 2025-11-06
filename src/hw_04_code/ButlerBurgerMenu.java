package hw_04_code;

import java.util.Scanner;

public class ButlerBurgerMenu {

    public static void main (String[] args) {
                
        final double TAX = 0.095;
        final String menu1 = "Baron's Burger";
        final double price1 = 15.00;
        final String addon11 = "Worcestershire Sauce";
        final double addonPrice11 = 5.00;
        final String addon12 = "Pork Belly Bacon";
        final double addonPrice12 = 10.00;
        final String addon13 = "Caviar";
        final double addonPrice13 = 50.00;
        String choice1, choice11, choice12, choice13;

        final String menu2 = "Dutchess's Fries";
        final double price2 = 8.00;
        final String addon21 = "Capers";
        final double addonPrice21 = 5.00;
        final String addon22 = "Caviar";
        final double addonPrice22 = 30.00;
        String choice2, choice21, choice22;

        final String menu3 = "Marie Antoinette's Cake Shake";
        final double price3 = 12.00;
        final String addon31 = "Champagne Sprinkles";
        final double addonPrice31 = 10.00;
        String choice3, choice31;

        double total=0.00, subtotal=0.00, taxToPlus=0.00;
        

        Scanner input = new Scanner(System.in);
        System.out.println("Welcometoquickburger! Hurryup-Hurryup!");
        System.out.printf("Let's get you started!\n"+
        "We have our classic menu to choose from!\n"+
        "%-15s $%8.2f\n"+
        "%-15s $%8.2f\n"+
        "%-15s $%8.2f\n"+
        "So, would you like the Baron's Burger? ",
        menu1,price1,
        menu2,price2,
        menu3,price3
        );
        choice1 = input.nextLine();
        if(choice1.compareToIgnoreCase("y")>=0){
            System.out.printf("Would you like to add %s? ", addon11);
            choice11 = input.nextLine();
            System.out.printf("Would you like to add %s? ", addon12);
            choice12 = input.nextLine();
            System.out.printf("Would you like to add %s? ", addon13);
            choice13 = input.nextLine();
        } else {
            choice11 = "n";
            choice12 = "n";
            choice13 = "n";
        }

        System.out.print("Would you like Dutchess's Fries? ");
        choice2 = input.nextLine();
        if(choice2.compareToIgnoreCase("y")>=0){
            System.out.printf("Would you like to add %s? ", addon21);
            choice21 = input.nextLine();
            System.out.printf("Would you like to add %s? ", addon22);
            choice22 = input.nextLine();
        } else {
            choice21 = "n";
            choice22 = "n";
        }
        
        System.out.print("Will you finish this order with a Marie Antoinette's Cake Shake? ");
        choice3 = input.nextLine();
        if(choice3.compareToIgnoreCase("y")>=0){
            System.out.printf("Would you like to add %s? ", addon31);
            choice31 = input.nextLine();
        } else {
            choice31 = "n";
        }
        input.close();

        System.out.println("FINAL");
        System.out.println("=======================");
                
        if(choice1.compareToIgnoreCase("y")>=0){
            subtotal+=price1;
            System.out.printf("%-19s$%8.2f%n",menu1,price1);
            if(choice11.compareToIgnoreCase("y")>=0){
                subtotal+=addonPrice11;
                System.out.printf("    %-15s$%8.2f%n",addon11,addonPrice11);
            };
            if(choice12.compareToIgnoreCase("y")>=0){
                subtotal+=addonPrice12;
                System.out.printf("    %-15s$%8.2f%n",addon12,addonPrice12);
            };
            if(choice13.compareToIgnoreCase("y")>=0){
                subtotal+=addonPrice13;
                System.out.printf("    %-15s$%8.2f%n",addon13,addonPrice13);
            };
        //System.out.printf("DEBUG: Because choice1 was %s, the subtotal is %f.\n",choice1, subtotal);
        }
        
        if(choice2.compareToIgnoreCase("y")>=0){
            subtotal+=price2;
            System.out.printf("%-15s$%8.2f%n",menu2,price2);
            if(choice21.compareToIgnoreCase("y")>=0){
                subtotal+=addonPrice21;
                System.out.printf("    %-15s$%8.2f%n",addon21,addonPrice21);
            };
            if(choice22.compareToIgnoreCase("y")>=0){
                subtotal+=addonPrice22;
                System.out.printf("    %-15s$%8.2f%n",addon22,addonPrice22);
            };
        //System.out.printf("DEBUG: Because choice1 was %s, the subtotal is %f.\n",choice2, subtotal);
        }
        
        if(choice3.compareToIgnoreCase("y")>=0){
            subtotal+=price3;
            System.out.printf("%-15s$%8.2f%n",menu3,price3);
            if(choice31.compareToIgnoreCase("y")>=0){
                subtotal+=addonPrice31;
                System.out.printf("    %-15s$%8.2f%n",addon31,addonPrice31);
            };
        //System.out.printf("DEBUG: Because choice1 was %s, the subtotal is %f.\n",choice3, subtotal);
        }

        taxToPlus = subtotal * TAX;
        total = subtotal + taxToPlus;
        System.out.printf("_______________________%n"+
        "%-15s$%8.2f%n"+
        "%-15s$%8.2f%n"+
        "%-15s$%8.2f%n"+
        "Thank you for being such a sophisticated individual with refined tastes%n"+
        "here at Butler Burger!",
        "Subtotal:", subtotal, "Tax:", taxToPlus, "Total:", total);
        

        
        

        
        //System.out.println(choice1.compareToIgnoreCase("y"));
            
        
        
    }
}
