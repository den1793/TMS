package lesson6_homework;

import java.math.BigDecimal;

/**
 * @author Denis Smirnov
 */
public class ConsoleWriter {
    public void write(String message) { System.out.print(message); }
    public void writeln(String message) { System.out.println(message); }

    public void write(double number) { System.out.println(number); }

    public void write(boolean isTrue) { System.out.println(isTrue); }
    public void writeln(boolean isTrue) { System.out.println(isTrue); }

    public void write(int num) { System.out.println(num); }

    public void write(BigDecimal num) { System.out.println(num); }


}
