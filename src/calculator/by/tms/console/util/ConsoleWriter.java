package calculator.by.tms.console.util;
import calculator.by.tms.entity.Operation;
import calculator.by.tms.util.Writer;

/**
 * @author Denis Smirnov
 */
public class ConsoleWriter implements Writer {

    @Override
    public Operation write(String message) { System.out.println(message);
        return null;
    }
}
