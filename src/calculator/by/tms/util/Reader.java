package calculator.by.tms.util;
import calculator.by.tms.console.exception.OperationNotFoundException;
import calculator.by.tms.entity.OperationType;
/**
 * @author Denis Smirnov
 */
public interface Reader {

    String readString();
    double readDouble();
    int readInt();
    OperationType readOperationType() throws OperationNotFoundException;
}
