package lab_04b;

public class Lab4bTester {
    public static void main (String[] args) {
        int size = 20;
        boolean pyramid = true;
        for (int y = 0; y < size ; y++) {
            for (int x = size ; x > y ; x--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
