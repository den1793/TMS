package calculator.by.tms.console;
import calculator.by.tms.Application;
import calculator.by.tms.console.exception.OperationNotFoundException;
import calculator.by.tms.console.util.ConsoleReader;
import calculator.by.tms.console.util.ConsoleWriter;
import calculator.by.tms.entity.Operation;
import calculator.by.tms.entity.OperationType;
import calculator.by.tms.service.CalculatorService;
import calculator.by.tms.storage.FileOperationStorage;
import calculator.by.tms.storage.OperationStorage;
import calculator.by.tms.util.Reader;
import calculator.by.tms.util.Writer;
import calculator.by.tms.validator.OperationValidator;
import java.io.IOException;
import java.util.List;

/**
 * @author Denis Smirnov
 */
public class ConsoleApplication implements Application {
    private final CalculatorService calculatorService = new CalculatorService();
    private final Reader reader = new ConsoleReader();
    private final Writer writer = new ConsoleWriter();
    private final OperationStorage storage = new FileOperationStorage();
    private final OperationValidator operationValidator = new OperationValidator();

    @Override
    public void run() {
        double num1 = 0;
        double num2 = 0;
        String temp = "";
        boolean isValid = false;


        while (true) {
            do {
                writer.write("Enter the first number: ");
                temp = reader.readString();

            } while (isValid == operationValidator.validNum(temp));
            num1 = Double.parseDouble(temp);

            do {
                writer.write("Enter the second number: ");
                temp = reader.readString();

            } while (isValid == operationValidator.validNum(temp));
            num2 = Double.parseDouble(temp);

            writer.write("Enter operation type: SUM, SUB, MUL, DIV");

            Operation op;

            try {
                OperationType type = reader.readOperationType();
                op = new Operation(num1, num2, type);
            } catch (OperationNotFoundException e) {
                writer.write(e.getMessage());
                continue;
            }

            Operation result = calculatorService.calculate(op);
            try {
                storage.save(result);
            } catch (IOException e) {
                writer.write("Error, file not found");
                continue;
            }
            writer.write("Your result = " + result.getResult());
            writer.write("");

            do {
                writer.write("Press 1 - to see the history, 2 - to continue, 3 - to close the program.");
                temp = reader.readString();

            } while (isValid == operationValidator.validSelectionType(temp));

            String next = temp;
            switch (next) {
                case "1":
                    try {
                        printFileHistory(storage.findAll());
                    } catch (IOException e) {
                        writer.write("Error, file not found");
                        continue;
                    }
                    break;
                case "2":
                    break;
                case "3":
                    writer.write("Program completed");
                    return;
                default:
                    writer.write("Invalid operation");
            }
        }
    }
    private void printFileHistory(List<Operation> operations) throws IOException {
        for (Operation operation : operations) {
            writer.write(operation.toString());
        }
    }
}
