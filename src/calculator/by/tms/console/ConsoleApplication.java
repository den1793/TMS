package calculator.by.tms.console;
import calculator.by.tms.Application;
import calculator.by.tms.console.exception.OperationNotFoundException;
import calculator.by.tms.console.util.ConsoleReader;
import calculator.by.tms.console.util.ConsoleWriter;
import calculator.by.tms.entity.Operation;
import calculator.by.tms.entity.OperationType;
import calculator.by.tms.service.CalculatorService;
import calculator.by.tms.storage.JDBSOperationStorage;
import calculator.by.tms.util.Reader;
import calculator.by.tms.util.Writer;
import calculator.by.tms.validator.OperationValidator;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author Denis Smirnov
 */
public class ConsoleApplication implements Application {
    private final CalculatorService calculatorService = new CalculatorService();
    private final Reader reader = new ConsoleReader();
    private final Writer writer = new ConsoleWriter();
    private final OperationValidator operationValidator = new OperationValidator();
    private final JDBSOperationStorage jdbsOperationStorage = new JDBSOperationStorage();

    @Override
    public void run() {
        while (true) {
           
            writer.write("Enter the first number: ");
            var num1 = reader.readDouble();
            if (!operationValidator.validNum(String.valueOf(num1))) {
                writer.write("num1 is not valid");
                continue;
            }

            writer.write("Enter the second number: ");
            var num2 = reader.readDouble();
            if (!operationValidator.validNum(String.valueOf(num2))) {
                writer.write("num2 is not valid");
                continue;
            }

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
                jdbsOperationStorage.save(result);
            } catch (IOException e) {
                writer.write("Error, file not found");
                continue;
            }
            writer.write("Your result = " + result.getResult());
            writer.write("");

            writer.write("Press 1 - to see the all history, 2 - to find operation by ID, " +
                    "3 - to delete operation by ID, 4 - to continue, 5 - to close the program.");

            var next = reader.readInt();
            if (!operationValidator.validSelectionType(String.valueOf(next))) {
                writer.write("Invalid operation");
                continue;
            }

            switch (next) {
                case 1:
                    try {
                        printFileHistory(jdbsOperationStorage.findAll());
                    } catch (IOException e) {
                        writer.write("Error, file not found");
                        continue;
                    }
                    break;
                case 2:
                    writer.write("Input ID of operation:");
                    findOperationById();
                    break;
                case 3:
                    writer.write("Input ID of operation:");
                    jdbsOperationStorage.deleteById(reader.readInt());
                    break;
                case 4:
                    break;
                case 5:
                    writer.write("Program completed");
                    return;
            }
        }
    }

    private void printFileHistory(List<Operation> operations) throws IOException {
        for (Operation operation : operations) {
            writer.write(operation.toString());
        }
    }

    private void findOperationById() {
        Optional<Operation> byId = jdbsOperationStorage.findById(reader.readInt());
        if (byId.isPresent()) {
            Operation operation = byId.get();
            writer.write(String.valueOf(operation));
        } else {
            writer.write("Operation not found");
        }
    }
}
