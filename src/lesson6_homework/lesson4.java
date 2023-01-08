package lesson6_homework;

import java.util.Arrays;

/**
 * @author Denis Smirnov
 */
public class lesson4 {

    ConsoleWriter consoleWriter = new ConsoleWriter();


    public void point1() {
        int[] array = new int[]{12, 678, 4, 553, 554, 2442, 97, 871, 9000, 9};

        for (int i = 0; i < array.length; i++)

            consoleWriter.write(array[i] + " ");
        consoleWriter.writeln("");
    }

    public void point2() {
        int[] array = new int[]{12, 678, 4, 553, 554, 2442, 97, 871, 9000, 9};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int element : array) {
            if (element > max) {
                max = element;
            } else if (element < min)
                min = element;
        }
        consoleWriter.write("Maximum array element: " + max + "\n");
        consoleWriter.write("Minimum array element: " + min + "\n");
    }

    public void point3() {
        int[] array = new int[]{12, 678, 4, 553, 554, 2442, 97, 871, 9000, 9};

        consoleWriter.write("The even elements of array: ");
        for (int even : array) {
            if (even % 2 == 0) {
                consoleWriter.write(even + " ");
            }
        }
        consoleWriter.writeln("");
        consoleWriter.write("The odd elements of array: ");
        for (int odd : array) {
            if (odd % 2 != 0) {
                System.out.print(odd + " ");
            }
        }
        consoleWriter.writeln(" ");
    }


    public void point4() {
        int[] array = new int[]{12, 678, 4, 553, 554, 2442, 97, 871, 9000, 9};
        Arrays.sort(array);

        consoleWriter.write("The shortest array number: " + array[0] + " \n"
                + "The longest array number: " + array[array.length - 1] + "\n");
    }


    public void point5() {
        int[] array = new int[]{17, 144, 7447, 2, 76, 634, 5445};

        String[] strArray = new String[array.length];
        consoleWriter.write("Palindrome numbers in an array: ");
        for (int i = 0; i < array.length; i++) {

            strArray[i] = String.valueOf(array[i]);
            StringBuffer buffer = new StringBuffer(strArray[i]);
            buffer.reverse();
            String rev = buffer.toString();

            if (strArray[i].equals(rev)) {
                consoleWriter.write(strArray[i] + " ");
            }
        }
        consoleWriter.writeln(" ");
    }

    public void point6() {

        int[] array = {115, 37, 1444, 4, 78};

        boolean isSorted = false;
        int tmp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
        consoleWriter.write("Bubbles sort of array : " + Arrays.toString(array));
    }
}
