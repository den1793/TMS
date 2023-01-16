package lesson8_homework;

/**
 * @author Denis Smirnov
 */
public class Calculator {

    Writer writer = new ConsoleWriter();

    Operation calculate(Operation operation) {

        switch (operation.getType()) {
            case "sum":
                operation.setResult(operation.getNum1() + operation.getNum2());
                return operation;
            case "sub":
                operation.setResult(operation.getNum1() - operation.getNum2());
                return operation;
            case "mul":
                operation.setResult(operation.getNum1() * operation.getNum2());
                return operation;
            case "div":
                operation.setResult(operation.getNum1() / operation.getNum2());
                return operation;
        }
        return operation;
    }
}
