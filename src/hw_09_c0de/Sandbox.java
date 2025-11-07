package hw_09_c0de;

import java.util.Scanner;

class Sandbox {
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
                    "Do you want to add another score?", scores[scores.length - 1]/*, average(scores)*/)
            );
        }
        else
        {
            System.out.println("Please choose 'yes' or 'no'.");
        }

        
    }

    public static void main(String[] args) {
        // double classAverage = average(classScores);

        Scanner input = new Scanner(System.in);
        String answer = "";

        System.out.println( 
            String.format(
                "Class average is: %f.2.\n\n" +
                "Would you like to add another score?"/*, classAverage*/
            ));

        while(addingMore)
        {
            answer = input.nextLine();
            // classScores = checkAverage(classScores, answer);
        }

        input.close();
    }
}