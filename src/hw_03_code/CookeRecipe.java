package hw_03_code;

import java.util.Scanner;

public class CookeRecipe {
    private static final double CUPS_SUGAR = 1.5;
    private static final double CUPS_BUTTER = 1.0;
    private static final double CUPS_FLOUR = 2.75;
    private static final double RECIPE_YIELD = 48.0;

    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("How many cookies do you want to make? ");
        double wantedCookies = input.nextDouble();
        System.out.println(
            "Let's do a ratio!\n"
            + "This recipe makes " + RECIPE_YIELD + " cookes with the following ingredients:\n"
            + "\t" + CUPS_SUGAR + " cups of sugar\n"
            + "\t" + CUPS_BUTTER + " cups of butter\n"
            + "\t" + CUPS_FLOUR + " cups of flour\n\n"
            + "==============================\n\n"
        );
        System.out.printf(
        "To make %.1f cookies, you will need:%n" +
        "\t%.2f cups of sugar%n" +
        "\t%.2f cups of butter%n" +
        "\t%.2f cups of flour%n" +
        "Enjoy your cookies!",
        wantedCookies,
        (CUPS_SUGAR * wantedCookies / RECIPE_YIELD),
        (CUPS_BUTTER * wantedCookies / RECIPE_YIELD),
        (CUPS_FLOUR * wantedCookies / RECIPE_YIELD)
        );
        
        input.close();
    }


}
