package Calculator;
/**
 * @author Denis Smirnov
 */
public class Calculator {

    public Operation calculate (Operation operation) {

        switch (operation.getType()) {
            case SUM -> operation.setResult(operation.getNum1() + operation.getNum2());

            case SUB -> operation.setResult(operation.getNum1() - operation.getNum2());

            case MUL -> operation.setResult(operation.getNum1() * operation.getNum2());

            case DIV -> operation.setResult(operation.getNum1() / operation.getNum2());

        }
        return operation;
    };

}

