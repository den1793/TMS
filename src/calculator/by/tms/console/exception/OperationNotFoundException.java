package calculator.by.tms.console.exception;

/**
 * @author Denis Smirnov
 */
public class OperationNotFoundException extends Exception {
    public OperationNotFoundException (String description) {
        super(description);
    }
}
