package calculator.by.tms.storage;
import calculator.by.tms.entity.Operation;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Denis Smirnov
 */
public class FileOperationStorage implements OperationStorage {

    public void save(Operation operation) throws IOException {
        String result = String.format("%s,%s,%s,%s",
                operation.getNum1(),
                operation.getNum2(),
                operation.getResult(),
                operation.getType());

        FileOutputStream fileOutputStream = new  FileOutputStream("history.csv", true);

        fileOutputStream.write(result.getBytes());
        fileOutputStream.write(10);
        fileOutputStream.close();


    }

    public List<Operation> findAll() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("history.csv"));

        List<Operation> operations = new ArrayList<>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {

            operations.add(convertToOperation(line));

        }

        return new ArrayList<>(operations);
    }

    private Operation convertToOperation(String operation) {
        String[] s = operation.split(",");
        double num1 = Double.parseDouble(s[0]);
        double num2 = Double.parseDouble(s[1]);
        double result = Double.parseDouble(s[2]);
        return new Operation(num1, num2, result, s[3]);
    }
}
