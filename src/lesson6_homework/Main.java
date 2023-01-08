package lesson6_homework;

/**
 * @author Denis Smirnov
 */
public class Main {
    public static void main(String[] args) {

        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();

        lesson3 lesson3 = new lesson3();
        lesson4 lesson4 = new lesson4();
        lesson5 lesson5 = new lesson5();

        lesson3.calculator();
        lesson3.loops();

        lesson4.point1();
        lesson4.point2();
        lesson4.point3();
        lesson4.point4();
        lesson4.point5();
        lesson4.point6();

        lesson5.point1();
        lesson5.point2();
        lesson5.point3();



    }
}
