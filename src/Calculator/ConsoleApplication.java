package Calculator;

import javax.imageio.IIOException;
import java.io.IOException;

/**
 * @author Denis Smirnov
 */
public class ConsoleApplication implements Application {
    private final Calculator calculator = new Calculator();
    private final Reader reader = new ConsoleReader();
    private final Writer writer = new ConsoleWriter();
    private final ConsoleSelection selector = new ConsoleSelection();

    private final OperationStorage storage = new InMemoryOperationStorage();
    private final OperationStorage storageFile = new FileOperationStorage();

    @Override
    public void run() {
        while (true) {
            writer.write("Enter the first number: ");
            double num1 = reader.readDouble();
            writer.write("Enter the second number: ");
            double num2 = reader.readDouble();
            OperationType type = selector.select();
            Operation op = new Operation(num1, num2, type);

            Operation result = calculator.calculate(op) ;
            try {
                storageFile.save(result);
            } catch (IOException e) {
                writer.write("Error, file not found");
                continue;
            }
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
                    try {
                        printFileHistory((FileOperationStorage) storageFile);
                    } catch (IOException e) {
                        writer.write("Error, operations not found");
                        continue;
                    }
                    break;
                case "2":
                    break;
                default:
                    writer.write("Invalid operation");
            }
        }
    }
    private void printFileHistory(FileOperationStorage storageFile) throws IOException {
        for (Operation operation : storageFile.findAll()) {
            writer.write(operation.toString());
        }

    }
}



