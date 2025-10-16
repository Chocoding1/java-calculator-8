package calculator.model.delimiter;

import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_SUFFIX;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiter {

    private static Delimiter instance;
    private final Set<Character> delimiters = new HashSet<>(List.of(',', ':'));

    private Delimiter() {
    }

    public static Delimiter getInstance() {
        if (instance == null) {
            return new Delimiter();
        }
        return instance;
    }

    public void addDelimiter(Character delimiter) {
        delimiters.add(delimiter);
    }

    public String getDelimiters() {
        StringBuilder sb = new StringBuilder().append("[");

        for (Character delimiter : delimiters) {
            sb.append(delimiter);
        }
        sb.append("]");

        return sb.toString();
    }

    public String extractCustomDelimiters(String inputStr) {
        String customDelimiterWrapper = inputStr.substring(inputStr.indexOf(CUSTOM_DELIMITER_PREFIX),
                inputStr.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);

        return customDelimiterWrapper.substring(2, customDelimiterWrapper.length() - 2);
    }
}
