package lesson8_homework;

/**
 * @author Denis Smirnov
 */
public class ConsoleApplication implements Application {

    OperationStorage storage = new InMemoryOperationStorage();
    Calculator calculator = new Calculator();
    Reader reader = new ConsoleReader();
    Writer writer = new ConsoleWriter();

    @Override
    public void run() {
        boolean isTrue = true;
        while (isTrue) {
            writer.write("Enter the first number: ");
            double num1 = reader.readDouble();
            writer.write("Enter the second number: ");
            double num2 = reader.readDouble();
            writer.write("Enter the operation type: \n " +
                    "sum - summation, sub - subtraction, mul - multiplication, div - division ");
            String type = reader.readString();
            Operation op = new Operation(num1, num2, type);
            Operation result = calculator.calculate(op);
            storage.save(result);
            writer.write("Your result = " + result.getResult());
            writer.write("");

            writer.write("If you want to continue - press - y. If not - press - n");
            String next = reader.readString();
            switch (next) {
                case "y":
                    break;
                case "n":
                    System.out.println("Program completed");
                    return;
                default:
                    isTrue = false;
            }
            Operation[] all = storage.findAll();
            writer.write("If you want to see the history of operation - press - y. If not - press - n");
            String next2 = reader.readString();
            switch (next2) {
                case "y":
                    int countOperations = storage.getCountOperations();
                    if (countOperations < 10) {
                        for (int i = 0; i < countOperations; i++) {
                            writer.write(all[i].getNum1() + " " + all[i].getType() + " " + all[i].getNum2() + " = " + all[i].getResult());
                        }
                    }
                    break;
                case "n":
                    break;
                default:
                    isTrue = false;

            }
        }
    }
}



