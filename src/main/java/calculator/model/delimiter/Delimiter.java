package calculator.model.delimiter;

import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_SUFFIX;

import calculator.model.str.Str;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Delimiter {

    private static Delimiter instance;
    private final Set<String> delimiters = new HashSet<>(List.of(",", ":"));

    private Delimiter() {
    }

    public static Delimiter getInstance() {
        if (instance == null) {
            return new Delimiter();
        }
        return instance;
    }

    public String addCustomDelimiters(Str str) {
        String inputStr = str.getStr();
        if (str.isContainCustomDelimiters()) {
            String customDelimiters = extractCustomDelimiters(inputStr);
            addDelimiter(customDelimiters);
        }
        return getDelimiters();
    }

    public String getDelimiters() {
        StringBuilder sb = new StringBuilder().append("[");

        for (String delimiter : delimiters) {
            sb.append(delimiter);
        }
        sb.append("]");

        return sb.toString();
    }

    private void addDelimiter(String customDelimiters) {
        for (int i = 0; i < customDelimiters.length(); i++) {
            delimiters.add(customDelimiters.charAt(i) + "");
        }
    }

    private String extractCustomDelimiters(String inputStr) {
        String customDelimiterWrapper = inputStr.substring(inputStr.indexOf(CUSTOM_DELIMITER_PREFIX),
                inputStr.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);

        return customDelimiterWrapper.substring(2, customDelimiterWrapper.length() - 2);
    }
}
