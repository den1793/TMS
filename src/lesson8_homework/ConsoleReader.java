package lesson8_homework;

import java.util.Scanner;

/**
 * @author Denis Smirnov
 */
public class ConsoleReader implements Reader {

    private Scanner scanner = new Scanner(System.in);


    @Override
    public String readString() { return scanner.next(); }
    @Override
    public double readDouble() {
        return scanner.nextDouble();
    }
}
