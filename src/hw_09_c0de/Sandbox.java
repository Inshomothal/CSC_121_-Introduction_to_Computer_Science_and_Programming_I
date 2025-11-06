package hw_09_c0de;

import java.util.Scanner;

class Sandbox {
// Suppose you have the following set of quiz scores of students in a class.
// QUIZ  SCORES
// ______________
// Amanda: 80
// Jose: 82
// Carlos: 91
// Sarah: 76
// Fred: 72

// Write a program that places the quiz scores in a decimal value array. Then, calculate the class's
// average score.

// To calculate an average: Use a loop to add up all of the quiz scores, then divide the total by the number
// of quiz scores. Do not just divide the total by the literal value 5.0 - Instead, divide by the array's "length"
// field value. The average with the values above should be around 80.2. Then, try making your array
// larger by adding more values. Do you continue to get the correct results?

// [x] make double array to store class's scores.
// [ ] calculate average
// [ ] randomly add values
    static int amanda = 80;
    static int jose = 82;
    static int carlos = 91;
    static int sarah = 76;
    static int fred = 72;
    static double[] classScores = {amanda, jose, carlos, sarah, fred};
    static boolean addingMore = true;

    private static void checkAverage (double[] scores, String answer)
    {
        answer = answer.toLowerCase();
        if (answer == "n" || answer=="no")
        {
            addingMore = false;
            return;
        }
        else if (answer == "y" || answer == "ye" || answer == "yes")
        {
            double[] scoreCopy = scores;
            scores = new double[scores.length + 1];
            for (int i = 0; i < (scores.length - 1); i++)
            {
                scores[i] = scoreCopy[i];
            }
            scores[scores.length - 1] = (Math.random() * 100);
            classScores = new double[scores.length];
            classScores = scores;

            System.out.println(
                String.format(
                    "Okay! The new score added will be: %f.2!\n" +
                    "New average is %f.2\n" +
                    "Do you want to add another score?", scores[scores.length - 1], average(scores))
            );
        }
        else
        {
            System.out.println("Please choose 'yes' or 'no'.");
        }

        
    }

    public static void main(String[] args) {
        double classAverage = average(classScores);

        Scanner input = new Scanner(System.in);
        String answer = "";

        System.out.println( 
            String.format(
                "Class average is: %f.2.\n\n" +
                "Would you like to add another score?", classAverage
            ));

        while(addingMore)
        {
            answer = input.nextLine();
            classScores = checkAverage(classScores, answer);
        }

        input.close();
    }
}