package lesson4_homework;
import java.util.Arrays;
/**
 * @author Denis Smirnov
 * 1. Output the maximum and minimum element of an array;
 * 2. Output even and odd elements of an array;
 * 3. Output the shortest and longest number;
 * 4. Output numbers in ascending order;
 * 5. Output all palindromes;
 * 6. Bubble sort array;
 *
 */
public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{12, 678, 4, 553, 554, 2442, 97, 871, 9000, 9};

        for (int i = 0; i < array.length; i++)

            System.out.print(array[i] + " ");
        System.out.println();

//point 1

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int element : array)
            if (element > max)
                max = element;
            else if (element < min)
                min = element;

        System.out.println("Maximum array element: " + max);
        System.out.println("Minimum array element: " + min);

//point 2

        System.out.print("The even elements of array: ");

        for (int even : array)
            if (even % 2 == 0)
                System.out.print(even + " ");
        System.out.println(" ");

        System.out.print("The odd elements of array: ");

        for (int odd : array)
            if (odd % 2 != 0)
                System.out.print(odd + " ");
        System.out.println(" ");

//point 3

        Arrays.sort(array);

        System.out.println("The shortest array number: " + array[0] + " \n"
                + "The longest array number: " + array[array.length - 1]);


//point 4


//point 5

        int[] array3 = new int[]{17, 144, 7447, 2, 76, 634, 5445};

        String[] strArray3 = new String[array3.length];
        System.out.print("Palindrome numbers in an array: ");
        for (int i = 0; i < array3.length; i++) {

            strArray3[i] = String.valueOf(array3[i]);
            StringBuffer buffer = new StringBuffer(strArray3[i]);
            buffer.reverse();
            String rev = buffer.toString();

            if (strArray3[i].equals(rev)) {
                System.out.print(strArray3[i] + " ");
            }
        }
        System.out.println(" ");

//point 6

        int[] array4 = {115, 37, 1444, 4, 78};

        boolean isSorted = false;
        int tmp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array4.length - 1; i++) {
                if (array4[i] > array4[i + 1]) {
                    isSorted = false;

                    tmp = array4[i];
                    array4[i] = array4[i + 1];
                    array4[i + 1] = tmp;
                }
            }
        }
        System.out.println("Bubbles sort of array : " + Arrays.toString(array4));

    }
}

