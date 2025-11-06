package hw_03_code;

import java.util.Scanner;

public class CityStringTricks {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your favorite city and I'll show you something cool: ");
        String favCity = input.nextLine();
        int cityLength = favCity.length();
        String upperCaseCity = favCity.toUpperCase();
        String lowerCaseCity = favCity.toLowerCase();
        char firstLetter = favCity.charAt(0);
        System.out.println("Ok, here's the cool stuff:");
        System.out.println("Your favorite city is " + cityLength + " characters long.");
        System.out.println("In all uppercase, that's " + upperCaseCity + ".");
        System.out.println("In all lowercase, that's " + lowerCaseCity + ".");
        System.out.println("The first letter is '" + firstLetter + "'.");
        input.close();
    }

}
