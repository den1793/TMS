package lesson5_homework;
import java.util.Random;

/**
 * @author Denis Smirnov
 *
 * 1. Create a two-dimensional array and initialize it with numbers from 1 to 100;
 * 2. Initialize array 1 in the form of a triangle;
 * 3. Implement convenient triangle derivation.
 *
 */
public class Main {
        public static void main(String[] args) {
//point 1
            int[][] array1 = new int[10][10];

            Random random = new Random();

            int num = 1;

            for (int i = 0; i < array1.length; i++){
                for (int j = 0; j < array1[i].length; j++ ){
                    array1[i][j] = random.nextInt(1, 100);
                    System.out.print(array1[i][j] + " ");
                }
                System.out.println();
            }
//point 2
            int[][] array2 = new int[4][5];

            for (int i = 0; i < array2.length; i++){
                for (int j = 0; j < array2[i].length; j++ ){

                    if (j <= i){
                        array2[i][j] = 1;
                    }

                    System.out.print((array2[i][j]) + " ");
                }
                System.out.println();
            }
//point 3
            int[][] array3 = new int[5][5];
            for (int i = 0; i < array3.length; i++) {
                for (int j = 0; j < array3[i].length; j++) {
                    if (j <= i) {
                        array3[i][j] = 1;

                        System.out.print(array3[i][j] + " ");
                    }
                }
                System.out.println(" ");
            }

        }
    }


