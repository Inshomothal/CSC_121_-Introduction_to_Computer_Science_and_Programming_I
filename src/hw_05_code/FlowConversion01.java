package hw_05_code;

import java.util.Scanner;

public class FlowConversion01 {
    
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        int x;
        
        System.out.print("Enter a number: ");
        x = input.nextInt();

        if ( x != 0 && (x % 2) == 0) {
            System.out.println("'x' is even.");
        } else if (x != 0 ) {
            System.out.println("'x' is odd.");
        } else {
            System.out.println("Error: Please enter a nonzero number.");
        }
    }

}
