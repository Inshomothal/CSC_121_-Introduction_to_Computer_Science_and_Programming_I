package lab_05a;

import java.util.HashMap;

public class Dic {
    public static void main (String[] args) {
        HashMap<String, Integer> fruitStand = new HashMap<>();
        fruitStand.put("apple", 1);
        fruitStand.put("banana", 2);
        fruitStand.put("cherry", 3);

        System.out.println("The value of an apple is " + fruitStand.get("apple"));
        System.out.println("The value of an banana is " + fruitStand.get("banana"));
        System.out.println("The value of an cherry is " + fruitStand.get("cherry"));
    }
}