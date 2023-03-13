package calculator.by.tms.storage;
import calculator.by.tms.entity.Operation;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Denis Smirnov
 */
public class JDBSOperationStorage implements OperationStorage {

    private final Connection connection;

    public JDBSOperationStorage() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Operation operation) throws IOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("insert into operation(num1, num2, type, result) values (?, ?, ?, ?)");
            preparedStatement.setDouble(1, operation.getNum1());
            preparedStatement.setDouble(2, operation.getNum2());
            preparedStatement.setString(3, String.valueOf(operation.getType()));
            preparedStatement.setDouble(4, operation.getResult());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAll() throws IOException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from operation");
            List<Operation> operationList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                double num1 = resultSet.getDouble(2);
                double num2 = resultSet.getDouble(3);
                String type = resultSet.getString(4);
                double result = resultSet.getDouble(5);
                Operation operation = new Operation(id, num1, num2, type, result);
                operationList.add(operation);
            }
            return operationList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from operation where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Operation> findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from operation where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int opId = resultSet.getInt(1);
                double num1 = resultSet.getInt(2);
                double num2 = resultSet.getInt(3);
                String type = resultSet.getString(4);
                double result = resultSet.getInt(5);
                Operation operation = new Operation(opId, num1, num2, type, result);
                return Optional.of(operation);
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
