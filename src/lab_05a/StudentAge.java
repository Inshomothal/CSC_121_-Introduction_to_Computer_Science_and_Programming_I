package lab_05a;

import java.util.HashMap;
import java.util.Scanner;


public class StudentAge {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,Integer> studentRosterHashMap = new HashMap<String,Integer>();
        
        studentRosterHashMap.put("danny", 17);
        studentRosterHashMap.put("harry", 20);
        studentRosterHashMap.put("jenna", 35);
        studentRosterHashMap.put("backlah", 18);
        studentRosterHashMap.put("dullo", 23);
        studentRosterHashMap.put("esther", 24);
        studentRosterHashMap.put("jesus", 33);
        studentRosterHashMap.put("joseph", 30);
        studentRosterHashMap.put("mary", 54);
        studentRosterHashMap.put("john", 42);

        while (true)
        {
            System.out.print("Enter a student's name: ");
            String name = scanner.nextLine();
            System.out.println();
            if (studentRosterHashMap.containsKey(name.toLowerCase())) 
            {
                System.out.println(name + "'s age is " + studentRosterHashMap.get(name.toLowerCase()));
            } else {
                break;
            }
        }
        scanner.close();
    }
    
}

