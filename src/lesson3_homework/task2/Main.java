package lesson3_homework.task2;
import java.util.Scanner;
/**
 * @author Denis Smirnov
 *
 * 1. Print number in reverse format;
 * 2. Print max & min digits from the number;
 * 3. Check if number contains digits duplicates;
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String snum = scanner.next();
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
        System.out.println("Number in reverse order: " + reverseNum);
        System.out.println("Maximum number: " + max);
        System.out.println("Minimum number: " + min);
        System.out.println(isTrue);

    }
}
