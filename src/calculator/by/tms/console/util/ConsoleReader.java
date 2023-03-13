package calculator.by.tms.console.util;
import calculator.by.tms.console.exception.OperationNotFoundException;
import calculator.by.tms.entity.OperationType;
import calculator.by.tms.util.Reader;
import java.util.Scanner;

/**
 * @author Denis Smirnov
 */
public class ConsoleReader implements Reader {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readString() { return scanner.next(); }

    @Override
    public double readDouble() {
        return scanner.nextDouble();
    }

    @Override
    public int readInt() { return scanner.nextInt(); }


    @Override
    public OperationType readOperationType() throws OperationNotFoundException {
        String next = scanner.next();
        String operation = next.trim().toUpperCase();

        for (OperationType operationType : OperationType.values()) {
            if (operation.equals(operationType.toString())) {
                return operationType;
            }
        }
        throw new OperationNotFoundException("Invalid operation");
    }
}
