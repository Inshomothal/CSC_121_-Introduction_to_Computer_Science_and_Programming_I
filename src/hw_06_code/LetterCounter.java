package hw_06_code;

import java.util.Scanner;

public class LetterCounter {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Give a word or sentence:");
        String word = input.nextLine();

        System.out.print("Now a letter to find in that word or sentence: ");
        String charCapture = input.nextLine();
        char letter=' ';
        for(int i=0; i<charCapture.length(); i++){
            if (charCapture.charAt(i)!= ' '){
                letter = charCapture.charAt(i);
                break;
            }
        }

        counter (word, letter);
    }

    public static void counter (String str, char letter){
        int count=0;
        for(int i=0; i < str.length(); i++){
            count += (letter == str.charAt(i) ? 1 : 0);
        }

        System.out.printf("Your word, %s has the letter %s %d time", str, letter, count);
        System.out.println((count > 1) ? "s!" : "!");
    }
}