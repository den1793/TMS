package Calculator;

/**
 * @author Denis Smirnov
 */
public class ConsoleWriter implements Writer {


    public Operation write(String message) { System.out.println(message);
        return null;
    }


}