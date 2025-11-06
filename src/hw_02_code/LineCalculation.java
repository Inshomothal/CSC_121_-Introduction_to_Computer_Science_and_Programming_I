package hw_02_code;

public class LineCalculation {
    public static void main (String[] args) {
        /*
         * One acre is 43,560 square feet.
         * We have 389,767 square feet of land.
         * How many acres of land do we have?
         * Variables for 
         *  [] Acres in square feet
         *  [] Total land in square feet
         *  [] Total land in acres
         */

         int acreToSquareFeet = 43560;
         int landInSquareFeet = 389767;
         double landInAcres = (double) landInSquareFeet / acreToSquareFeet;

         System.out.println("We have a total of " + landInAcres + " acres of land.");
    }
}
