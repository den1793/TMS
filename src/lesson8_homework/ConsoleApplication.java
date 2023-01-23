package lesson8_homework;

/**
 * @author Denis Smirnov
 */
public class ConsoleApplication implements Application {

    private final OperationStorage storage = new InMemoryOperationStorage();
    private final Calculator calculator = new Calculator();
    private final Reader reader = new ConsoleReader();
    private final Writer writer = new ConsoleWriter();
    private final ConsoleSelection selector = new ConsoleSelection();
    private final PrintMemoryOperations printMemoryOperations = new PrintMemoryOperations();

    @Override
    public void run() {
        while (true) {
            writer.write("Enter the first number: ");
            double num1 = reader.readDouble();
            writer.write("Enter the second number: ");
            double num2 = reader.readDouble();
            OperationType type = selector.select();

            Operation op = new Operation(num1, num2, type);
            Operation result = calculator.calculate(op);
            storage.save(result);
            writer.write("Your result = " + result.getResult());
            writer.write("");

            writer.write("Want to continue? 1 - Yes , 2 - No");
            String next = reader.readString();
            switch (next) {
                case "1":
                    break;
                case "2":
                    writer.write("Program completed");
                    return;
                default:
                    writer.write("Invalid operation");
            }

            writer.write("Want to see the history of operation ? 1 - Yes, 2 - No");
            String next2 = reader.readString();
            switch (next2) {
                case "1":
                    printMemoryOperations.printHistory((InMemoryOperationStorage) storage);
                    break;
                case "2":
                    break;
                default:
                    writer.write("Invalid operation");
            }
        }
    }
}



