package Calculator;

/**
 * @author Denis Smirnov
 */
public class InMemoryOperationStorage implements OperationStorage {

     private final Operation[] operations = new Operation[10];
     private final Operation[] temp = new Operation[operations.length + 1];
     private int countOperations = 0;

    public void save(Operation operation) {

        operations[operations.length - 1] = operation;

        for (int i = 0; i <= operations.length-1; i++) {

            if (operations[i] == null){
                operations[i] = operation;
                break;

            } else if (countOperations == operations.length-1) {
                moveRight(operations);
                operations[0] = operation;
                return;
            }
        }
        countOperations++;
    }
    private void moveRight (Operation[] operations) {
        for (int i = 0; i < operations.length; i++) {
            temp[i + 1] = operations[i];
            operations[i] = temp[i];
        }
    }
    @Override
    public Operation[] findAll() {
        return operations;
    }
    @Override
    public int getCountOperations(){
        return this.countOperations;
    }
}


