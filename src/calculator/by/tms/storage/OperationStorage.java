package calculator.by.tms.storage;
import calculator.by.tms.entity.Operation;
import java.io.IOException;
import java.util.List;

/**
 * @author Denis Smirnov
 */
public interface OperationStorage {

    void save(Operation operation) throws IOException;
    List<Operation> findAll() throws IOException;
}
