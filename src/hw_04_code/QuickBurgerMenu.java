package hw_04_code;

import java.util.Scanner;

public class QuickBurgerMenu {
    public static void main(String[] args){
        final double TAX = 0.095;
        final String menu1 = "Quick Burger";
        final double price1 = 5.00;
        final String menu2 = "Quick Fries";
        final double price2 = 2.00;
        final String menu3 = "Quick Shake";
        final double price3 = 3.00;
        double total=0.00, subtotal=0.00, taxToPlus=0.00;

        Scanner input = new Scanner(System.in);
        System.out.println("Welcometoquickburger! Hurryup-Hurryup!");
        System.out.printf("Let's get you started!\n"+
        "We have our classic menu to choose from!\n"+
        "%-15s %8.2f\n"+
        "%-15s %8.2f\n"+
        "%-15s %8.2f\n"+
        "So, would you like the Quick Burger? ",
        menu1,price1,
        menu2,price2,
        menu3,price3
        );
        String choice1 = input.nextLine();
        System.out.print("Would you like Quick Fries? ");
        String choice2 = input.nextLine();
        System.out.print("Will you finish this order with a Quick Shake? ");
        String choice3 = input.nextLine();
        input.close();

        System.out.println("FINAL");
        System.out.println("=======================");
                
        if(choice1.compareToIgnoreCase("y")>=0){
        subtotal+=price1;
        System.out.printf("%-15s%8.2f%n",menu1,price1);
        //System.out.printf("DEBUG: Because choice1 was %s, the subtotal is %f.\n",choice1, subtotal);
        }
        
        if(choice2.compareToIgnoreCase("y")>=0){
        subtotal+=price2;
        System.out.printf("%-15s%8.2f%n",menu2,price2);
        //System.out.printf("DEBUG: Because choice1 was %s, the subtotal is %f.\n",choice2, subtotal);
        }
        
        if(choice3.compareToIgnoreCase("y")>=0){
        subtotal+=price3;
        System.out.printf("%-15s%8.2f%n",menu3,price3);
        //System.out.printf("DEBUG: Because choice1 was %s, the subtotal is %f.\n",choice3, subtotal);
        }

        taxToPlus = subtotal * TAX;
        total = subtotal + taxToPlus;
        System.out.printf("_______________________%n"+
        "%-15s%8.2f%n"+
        "%-15s%8.2f%n"+
        "%-15s%8.2f%n"+
        "ThanksforchoosingQuickBurger! Hurryup-Hurryup!",
        "Subtotal:", subtotal, "Tax:", taxToPlus, "Total:", total);
        

        
        

        
        //System.out.println(choice1.compareToIgnoreCase("y"));
    }
}
