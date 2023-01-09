package lesson6_homework;

import java.util.Random;

/**
 * @author Denis Smirnov
 */
public class Lesson5 {
    ConsoleWriter consoleWriter = new ConsoleWriter();

    public void point1() {
        int[][] array1 = new int[10][10];
        Random random = new Random();
        int num = 1;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                array1[i][j] = random.nextInt(1, 100);
                consoleWriter.write(array1[i][j] + " ");
            }
            consoleWriter.writeln(" ");
        }
        consoleWriter.writeln(" ");
    }
    public void point2(){
        int[][] array2 = new int[4][5];
        for (int i = 0; i < array2.length; i++){
            for (int j = 0; j < array2[i].length; j++ ){
                if (j <= i){
                    array2[i][j] = 1;
                }
                consoleWriter.write((array2[i][j]) + " ");
            }
            consoleWriter.writeln("");
        }
        consoleWriter.writeln(" ");
    }


    public void point3(){
        int[][] array3 = new int[5][5];
        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                if (j <= i) {
                    array3[i][j] = 1;
                    consoleWriter.write(array3[i][j] + " ");
                }
            }
            consoleWriter.writeln("");
        }
    }
}
