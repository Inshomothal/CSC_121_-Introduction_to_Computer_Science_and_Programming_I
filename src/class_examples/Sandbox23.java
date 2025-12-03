package class_examples;

import java.util.ArrayList;

public class Sandbox23 {
    static ArrayList<Integer> fibArrayList = new ArrayList<>();
    static int sum = 0;
    public static void main(String[] args) 
    {
        // System.out.println("Fibonacci attempt: 10 is " + fibo(10));
        fib(10);
        
        // System.out.print("Debug Initial ArrayList: ");
        // for (Integer i : fibArrayList)
        // {
        //     System.out.print(i + " ");
        // }
        // fib(47);
        // System.out.print("\nSum is:" + sum);
        // for (int fib : fibArrayList)
        // {
        //     System.out.print(fib + " ");
        // }
    }

    private static int factorial (int n)
    {
        if (n==0)
            return 1; // <-- Base case
        else
            return n * factorial (n-1);

    }

    private static int fib(int n)
    {
        if (n == 0)
        {
            if (fibArrayList.size() == 0)
            {
                fibArrayList.add(0);
                System.out.print("Start: " + fibArrayList.getFirst() + " ");
            }
            return 1;
        }
        else if (n <= fibArrayList.size())
        {
            return fibArrayList.get(n);
        }
        else
        {
            // sum += fib(n-1,limit) + fib(n-2, limit);
            int i = fib(n-1) + fibArrayList.get((( n - 2 ) < 0 ? 0 : n - 2));
            fibArrayList.add(n, i);
            System.out.print(fibArrayList.get(n) + " ");
            return fibArrayList.get(n);
        }
    }

    private static int fibo (int n)
    {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibo(n-1) + fibo(n-2);
    }
}