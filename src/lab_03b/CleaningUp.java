package lab_03b;


import java.util.Scanner;

public class CleaningUp {
    public static void main(String[] args) {
        /*
         * [] Print a list of options
         * [] Create a switch case to catch their choice
         * [] Handle multiple choices
         * [] Tally price of choices plus tax
         * [x] Tax = 9.5% or 0.095
         * [] Print total with tax
         */

         final double TAX = 0.095;

         final String pkg = "Basic Package";
         final double pkgPrice = 10.00;

         final String pkgPrem = "Premium Package";
         final double pkgPremPrice = 25.00;

         final String pkgVIP = "VIP Package (Very Important Pup!)";
         final double pkgVIPPrice = 50.00;

         final String svc1 = "Shower";
         final String svc2 = "Pest Removal";
         final String svc3 = "Fur Styling";

         Scanner input = new Scanner(System.in);
         System.out.printf("Welcome to The Mudded Pup!!! \n"+
         "We have a wonderful selection of services to fit your needs!:\n"+
         "Here our menu for you to choose from!\n"+
         "1. %10s: %8.2f ", pkg, pkgPrice);


    }

}
