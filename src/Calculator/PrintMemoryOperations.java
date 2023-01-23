package Calculator;

/**
 * @author Denis Smirnov
 */
public class PrintMemoryOperations {
    private final ConsoleWriter writer = new ConsoleWriter();
    public void printHistory(InMemoryOperationStorage storage) {
        Operation[] all = storage.findAll();
        int countOperations = storage.getCountOperations();
        if (countOperations < 10) {
            for (int i = 0; i < countOperations; i++) {
                writer.write(all[i].getNum1() + " " + all[i].getType() + " " + all[i].getNum2() + " = " + all[i].getResult());
            }
        }
    }
}
