package lesson6_homework;

/**
 * @author Denis Smirnov
 */
public class Main {
    public static void main(String[] args) {

        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();

        Lesson3 lesson3 = new Lesson3();
        Lesson4 lesson4 = new Lesson4();
        Lesson5 lesson5 = new Lesson5();

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
