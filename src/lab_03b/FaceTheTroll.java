package lab_03b;

public class FaceTheTroll {

    static int gold, strength;

    static boolean hasSword, goodMood;
    public static void main (String [] args) {

        //goodMood = true;
        strength = 21;
        hasSword = true;
        gold = 100;
        


        if (goodMood && gold >= 100) {

            if (strength > 20) {


                System.out.println((hasSword) ? "You can pass however you like." : "You can pay or pass quickly");


            } else {


                System.out.println("Must pay to cross.");


            };
        } else if (strength > 20) {


            System.out.println((hasSword) ? "Can cross bravely." : "Can cross quickly.");


        } else {


            System.out.println ("Thou shalt not pass!");


        };


    }


}
