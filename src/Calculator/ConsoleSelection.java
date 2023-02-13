package Calculator;

/**
 * @author Denis Smirnov
 */
public class ConsoleSelection {
    private final ConsoleWriter writer = new ConsoleWriter();
    private final ConsoleReader reader = new ConsoleReader();
    private OperationType operationType;

    public OperationType select() {

            writer.write("Enter the operation type: \n " +
                    "1 - summation, 2 - subtraction, 3 - multiplication, 4 - division ");
            String type = reader.readString();

            switch (type) {
                case "1" -> operationType = OperationType.SUM;
                case "2" -> operationType = OperationType.SUB;
                case "3" -> operationType = OperationType.MUL;
                case "4" -> operationType = OperationType.DIV;
            }
        return operationType;
    }
}
