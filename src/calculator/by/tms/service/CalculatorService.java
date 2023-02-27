package calculator.by.tms.service;
import calculator.by.tms.entity.Operation;
/**
 * @author Denis Smirnov
 */
public class CalculatorService {
    public Operation calculate (Operation operation) {


        switch (operation.getType()) {
            case SUM:
                operation.setResult(operation.getNum1() + operation.getNum2());
                return operation;
            case SUB:
                operation.setResult(operation.getNum1() - operation.getNum2());
                return operation;
            case MUL:
                operation.setResult(operation.getNum1() * operation.getNum2());
                return operation;
            case DIV:
                operation.setResult(operation.getNum1() / operation.getNum2());
                return operation;
        }
        return operation;
    }
}
