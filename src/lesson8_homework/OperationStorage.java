package lesson8_homework;

/**
 * @author Denis Smirnov
 */
public interface OperationStorage {

    void save(Operation operation);
    Operation[] findAll();
    int getCountOperations();

}

