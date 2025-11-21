public class SamplingTests {
    public static void main(String[] args) {
        int x = 0, y = 0;

        System.out.println(x + ", " + y);
        changeValues(x,y);
        System.out.println(x + ", " + y);


    }

    public static void changeValues(int a, int b)
    {
        a = 10;
        b = 10;
    }
}
