public class SamplingTests {
    public static void main(String[] args) {
        int[] array = {5, 6, 2, 4, 8, 9, 3, 7, 1};
        int value = 3;

        // System.out.println("Target at " + sequentialSearch(array, value));

        
        printArray(array);
        bubbleSort(array);
        printArray(array);

        System.out.println("Value at " + binarySearch(array, value));

    }

    public static void selectionSort(int[] array)
    {
        for (int j = 0; j < array.length; ++j)
        {
            int smallest = 9999;
            int smallestIndex = -1;
            for (int i =j; i < array.length; ++i)
            {
                if (array[i] < smallest)
                {
                    smallest = array[i];
                    smallestIndex = i;
                }
            }

            int temp = array[j];
            array[j] = smallest;
            array[smallestIndex] = temp;
        }
    }

    public static void bubbleSort(int[] array)
    {
        for (int j = 0; j < array.length; ++j)
        {
            for (int i = 0; i < array.length-1-j; ++i)
            {
                if (array[i] > array[i+1])
                {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }

        }
    }

    public static int binarySearch(int[] array, int value)
    {
        int first = 0;
        int last = array.length-1;
        int middle;

        while (first <= last)
        {
            middle = (first + last) / 2;

            if (array[middle] == value)
            {
                return middle;
            }
            else if (array[middle] > value)
            {
                last = middle - 1;
            }
            else
            {
                first = middle + 1;
            }
        }
        return -1;
    }
    
    public static int sequentialSearch(int[] array, int value)
    {
        int i = 0;
        
        return i;
    }

    public static void printArray(int[] array)
    {
        System.out.print("Elements are:");
        for (int element : array)
        {
            System.out.print(" " + element);
            System.out.print((element == array[(array.length - 1)]) ? ".\n" : ",");
        }
    }
}
