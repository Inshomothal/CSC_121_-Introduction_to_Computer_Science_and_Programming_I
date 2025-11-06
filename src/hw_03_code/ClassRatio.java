package hw_03_code;

import java.util.Scanner;

public class ClassRatio {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("This is an exercise to compute the ratio of boys to girls.\n ");
        System.out.print("Please start by entering how many male students are in the class: ");
        int maleStudents = input.nextInt();
        System.out.print("Now enter the number of female students in the class: ");
        int femaleStudents = input.nextInt();
        int totalStudents = maleStudents + femaleStudents;
        double maleRatio = (double) maleStudents / totalStudents;
        double femaleRatio = (double) femaleStudents / totalStudents;
        System.out.printf("The ratio for male students is: %.2f%n", maleRatio);
        System.out.printf("The ratio for female students is: %.2f%n", femaleRatio);
        System.out.println("Congratulations!!!...");
        input.close();
    }

}
