package lesson3_homework.task1;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Denis Smirnov
 *
 * Create calculator
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calculator.");

        while (true) {
            System.out.println("Enter the first number");
            String snum1 = scanner.next();
            System.out.println("Enter the second number");
            String snum2 = scanner.next();
            System.out.println("Enter the type of operation: \n" +
                    "sum - summation, sub - subtraction, mul - multiplication, div - division ");
            String type = scanner.next();

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
                    System.out.println("Operation not found");
                    continue;
            }

            System.out.println("Your result: " + result);
            System.out.println("If you want to continue - press - y. If not - press - n");

            String next = scanner.next();
            switch (next) {
                case "n":
                    System.out.println("Program completed");
                    return;
                case "y":
                    break;
                default:
                    System.out.println("Operation not found");
                    continue;
            }
        }


    }
}
