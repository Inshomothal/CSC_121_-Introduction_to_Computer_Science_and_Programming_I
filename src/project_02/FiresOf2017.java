package project_02;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class FiresOf2017 {
    public static void main (String [] args) {
        File fireFile = new File("C:\\Users\\Trevon Collins\\OneDrive\\Documents\\Education\\2025 Fall Semester\\CSC 121 Intro to CSC and Prog\\files\\Fires_100_2017.csv");
        try {
            Scanner fires2017 = new Scanner(fireFile);
            HashMap <Integer, String> tableNames = new HashMap<>();

            HashMap <Integer, String> localeLists = new HashMap<>();
            int localeIndex = 0;

            HashMap <Integer, HashMap<String, String>> recordMap = new HashMap<>();
            
            for (int i = 0; fires2017.hasNextLine(); i++ ) {
                int entryIndex = 0;

                if (i == 0) {
                    Scanner firesLabels = new Scanner(fires2017.nextLine());
                    firesLabels.useDelimiter(",");
                    int index = 0;

                    
                    while (firesLabels.hasNext()) {
                        tableNames.put(index, firesLabels.next());
                        index++;
                    }
                    System.out.println(tableNames);
                    firesLabels.close();
                } else {
                    while (fires2017.hasNextLine()) {
                        Scanner firesInfo = new Scanner(fires2017.nextLine());
                        firesInfo.useDelimiter(",");
                        HashMap<String, String> entryMap = new HashMap<>();

                        for (int index = 0; tableNames.containsKey(index); index++) {
                            String entryString = firesInfo.next(), listingString = "UNIT_ID";
                            entryMap.put(tableNames.get(index), entryString);

                            if (!localeLists.containsValue(entryString) && tableNames.get(index).equals(listingString)) {
                                localeLists.put(localeIndex, entryString);
                                localeIndex++;
                            }
                        }
                        
                        recordMap.put(entryIndex, entryMap);
                        entryIndex++;
                        //firesInfo.close();
                    }
                }
            }
            
            fires2017.close();
            usersPick(recordMap, localeLists);


        } catch (Exception e) {
            System.out.println("File does not exist.");
        }

        
    }

    static void usersPick(HashMap<Integer, HashMap<String, String>> records, HashMap <Integer, String> categories) {
        Scanner input = new Scanner(System.in);
        int pick = 0, pickLimit = 0, pickCount = 0;

        System.out.println("Here are your options:");
        for (int i = 0; categories.containsKey(i); i++){
            System.out.println(i+1 + ": " + categories.get(i));
            pickLimit = i+1;
        }
        System.out.print("Please pick a number from the options: ");
        String sysExCheck = "";
        while (true){
            try {
                sysExCheck = input.nextLine();
                pick = Integer.parseInt(sysExCheck) - 1;
                if (pick < 0 || pick >= pickLimit) throw new Exception("Beyond limit.");
                break;
            } catch (Exception e) {
                if (sysExCheck.isEmpty()) System.exit(0);
                System.out.print("Please pick a proper option... ");
                
            }
        }
        input.close();

        for (int i = 0; records.containsKey(i); i++) {
            String localeSearch = categories.get(pick);
            if (records.get(i).containsValue(localeSearch)) pickCount++;
        }

        System.out.println( "For " + categories.get(pick) +
                            " there were " + pickCount +
                            " fires in 2017!!!");

    }
}