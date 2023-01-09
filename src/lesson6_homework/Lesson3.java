package lesson6_homework;

import java.math.BigDecimal;

/**
 * @author Denis Smirnov
 */
public class Lesson3 {
    ConsoleWriter consoleWriter = new ConsoleWriter();
    ConsoleReader consoleReader = new ConsoleReader();

    public void calculator() {

        consoleWriter.writeln("Welcome to the Calculator.");

        while (true) {
            consoleWriter.writeln("Enter the first number");
            String snum1 = consoleReader.read();
            consoleWriter.writeln("Enter the second number");
            String snum2 = consoleReader.read();
            consoleWriter.writeln("Enter the type of operation: \n" +
                    "sum - summation, sub - subtraction, mul - multiplication, div - division ");

            String type = consoleReader.read();

            BigDecimal num1 = new BigDecimal(snum1);
            BigDecimal num2 = new BigDecimal(snum2);
            BigDecimal result;

            switch (type) {

                case "sum":
                    result = num1.add(num2);
                    break;
                case "sub":
                    result = num1.subtract(num2);
                    break;
                case "mul":
                    result = num1.multiply(num2);
                    break;
                case "div":
                    result = num1.divide(num2);
                    break;
                default:
                    consoleWriter.writeln("Operation not found");
                    continue;
            }
            consoleWriter.writeln("Your result is " + result);
            consoleWriter.writeln("If you want to continue - press - y. If not - press - n");

            String next = consoleReader.read();
            switch (next) {
                case "n":
                    consoleWriter.write("Program completed");
                    return;
                case "y":
                    break;
                default:
                    consoleWriter.write("Operation not found");
                    continue;
            }
        }


    }

    public void loops(){

        String snum = consoleReader.read();
        int num = Integer.parseInt(snum);
        int reverseNum = 0;
        int tempNum;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean isTrue = true;

        while (num > 0){

            tempNum = num % 10;
            num = num / 10;
            reverseNum = reverseNum * 10 + tempNum;

            if (tempNum > max){

                max = tempNum;

            } else if (tempNum < min){

                min = tempNum;

            } else if (tempNum == tempNum) {
                isTrue = false;
                break;
            }
        }
        consoleWriter.writeln("Number in reverse order: " + reverseNum);
        consoleWriter.writeln("Maximum number: " + max);
        consoleWriter.writeln("Minimum number: " + min);
        consoleWriter.writeln(isTrue);
    }
}
