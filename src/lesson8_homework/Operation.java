package lesson8_homework;

/**
 * @author Denis Smirnov
 */
public class Operation {

    private double num1;
    private double num2;
    private String type;
    private double result;

    public Operation(double num1, double num2, String type) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
    }

    public double getNum1() {return num1;}
    public double getNum2() { return num2; }
    public String getType() { return type; }
    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
}
