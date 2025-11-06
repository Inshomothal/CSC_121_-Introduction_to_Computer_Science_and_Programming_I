package hw_03_code;

import java.util.Scanner;

public class Madlibs {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's make a quick story! I'll ask the info\n" +
        "and then tell you the story.");
        System.out.print("Start with a name...any name: ");
        String name = input.nextLine();
        System.out.print("Now, give me an age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Next, a city: ");
        String cityName = input.nextLine();
        System.out.print("Now a college: ");
        String college = input.nextLine();
        System.out.print("Next, a profession: ");
        String profession = input.nextLine();
        System.out.print("Now, a type of animal: ");
        String animal = input.nextLine();
        System.out.print("Finally, a pet's name: ");
        String petName = input.nextLine();
        System.out.println("Here's your story:");
        System.out.println("There once was a person named " + name + " who lived in " + cityName + ".\n"
        + "At the age of " + age + ", " + name + "went to college at " + college + ".\n"
        + name + " graduated and went to work as a " + profession + ".\n"
        + "Then, " + name + " adopted a(n) " + animal + " named " + petName + ".\n"
        + "They both lived happily ever after!");
        input.close();
    }

}
