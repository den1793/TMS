package calculator.by.tms.validator;
import java.util.regex.Pattern;

/**
 * @author Denis Smirnov
 */
public class OperationValidator {

    private static final Pattern NUM = Pattern.compile("[0-9]*.?[0-9]+");
    private static final Pattern OPERATION = Pattern.compile("(SUM)|(SUB)|(MUL)|(DIV)");
    private static final Pattern SELECTION = Pattern.compile("[1-5]");


    public boolean validNum(String string) { return NUM.matcher(string).matches(); }
    public boolean validOperationType(String string) {
        return OPERATION.matcher(string).matches();
    }
    public boolean validSelectionType(String string) { return SELECTION.matcher(string).matches(); }


}
