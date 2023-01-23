package Calculator;

/**
 * @author Denis Smirnov
 */
public class Operation {

    private final double num1;
    private final double num2;
    private double result;
    private final OperationType type;

    public Operation(double num1, double num2, OperationType type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public OperationType getType() {
        return type;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
