package Calculator;
import static Calculator.OperationType.*;

/**
 * @author Denis Smirnov
 */
public class Calculator {

    public Calculable calculable = (operation) -> {

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
    };

}

