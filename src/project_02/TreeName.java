package project_02;

import java.util.HashMap;
import java.util.Scanner;

public class TreeName {
    static String treeOptions = (   "1. Oak Tree\n" +
                                    "2. Tuscarora Crape Myrtle Tree\n" +
                                    "3. Compact Italian Cypress\n" +
                                    "4. Cold Hardy Tree");
    static String   Oak = "Oak Tree",
                    Tuscarora = "Tuscarora Crape Myrtle Tree",
                    Compact = "Compact Italian Cypress",
                    Cold = "Cold Hardy Tree";
    
    public static void main (String[] args){
        /**
         * 6 ways trees help
         * 1. air; 2. water; 3. bio diversity; 4. social impact; 5. health; 6. climate
         */

        int choice = 0;
        String welcome = (  "Welcome to the project!\n" + 
        "Let's figure out which trees you can plant in California.");
        
        System.out.println(welcome);
        
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        int loops = 0;
        while (true)
        {
            System.out.println(treeOptions);
            System.out.print("Enter a Tree" + ((loops > 0) ? " or press Enter to exit: " : ": "));
            String treeName = input.nextLine();
            choice = stringParsing(treeName);
            System.out.println(treeType(choice));

            loops++;
        }




    }

    public static String treeType (int tree) {
        String name = "";
        
        @SuppressWarnings("unused")
        int size_min=0, size_max=0; // size
        HashMap<String, Integer> zones = new HashMap<>();
        double soil_min=0.0, soil_max=0.0; // soil
        boolean poleTest=false, zoneTest=false, soilTest=false, fitTest=false;
        


        switch (tree) {
            
            case 1:
                name = Oak;
                size_min=40;
                size_max=80;
                zones.put("z1",9);
                zones.put("z2", 10);
                soil_min=5.06;
                soil_max=7.0;
                break;
            case 2:
                name = Tuscarora;
                size_min=10;
                size_max=14;
                zones.put("z1",7);
                zones.put("z2", 8);
                zones.put("z3", 9);
                zones.put("z4", 10);
                zones.put("z5", 11);
                soil_min=5.0;
                soil_max=7.5;
                break;
            case 3:
                name = Compact;
                size_min=25;
                size_max=30;
                zones.put("z1",7);
                zones.put("z2", 8);
                zones.put("z2", 9);
                zones.put("z2", 10);
                soil_min=5.0;
                soil_max=6.5;
                break;
            case 4:
                name = Cold;
                size_min=8;
                size_max=10;
                zones.put("z1",4);
                soil_min=5.5;
                soil_max=6.5;
                break;
            default:
                return "Please make a valid choice.";
        }

        poleTest = (size_max < 15);

        for (int i=5; i<=11; i++){
            if (zones.containsValue(i))
            zoneTest=true;
        }

        if (soil_min >= 5.0 || soil_max <= 8.5)
            soilTest=true;

        fitTest = (zoneTest && soilTest);

        String canFit = fitTest ? "can" : "can't";
        String nearPole = poleTest ? "." : " but keep them away from power lines.";

        String output = String.format("The %s %s survive in California%s", name, canFit, nearPole);

        return output;
    }

    public static int stringParsing (String tree){
        int matchingNumber = 0;
        Scanner parsingScanner = new Scanner(tree);

        if (tree == "")
        System.exit(0);

        try {
            matchingNumber = parsingScanner.nextInt();
        } catch (Exception e) {
            int oakMatch = 0, tuscMatch = 0, compMatch = 0, coldMatch =0;
            String  oak = Oak.toLowerCase(),
                    tuscarora = Tuscarora.toLowerCase(),
                    compact = Compact.toLowerCase(),
                    cold = Cold.toLowerCase();
            for (int i = 0; i < tree.length(); i++) {
                oakMatch += (i < oak.length() && oak.charAt(i) == tree.charAt(i)) ? 1 : 0;
                tuscMatch += (i < tuscarora.length() && tuscarora.charAt(i) == tree.charAt(i)) ? 1 : 0;
                compMatch += (i < compact.length() && compact.charAt(i) == tree.charAt(i)) ? 1 : 0;
                coldMatch += (i < cold.length() && cold.charAt(i) == tree.charAt(i)) ? 1 : 0;
            }

            if (Math.max(oakMatch, Math.max(tuscMatch, Math.max(compMatch, coldMatch))) < 3){
                parsingScanner.close();
                return matchingNumber = 0;
            }
            
            if (oakMatch > tuscMatch && oakMatch > compMatch && oakMatch > coldMatch) {
                matchingNumber = 1;
            } else if (tuscMatch > compMatch && tuscMatch > coldMatch) {
                matchingNumber = 2;
            } else if (compMatch > coldMatch) {
                matchingNumber = 3;
            } else {
                matchingNumber = 4;
            }
        }
        parsingScanner.close();
        return matchingNumber;
    };
}