package calculator.service;

import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_SUFFIX;

import calculator.model.delimiter.Delimiter;

public class DelimiterService {

    private static DelimiterService instance;
    private final Delimiter delimiters = Delimiter.getInstance();

    private DelimiterService() {
    }

    public static DelimiterService getInstance() {
        if (instance == null) {
            return new DelimiterService();
        }
        return instance;
    }

    public void checkCustomDelimiter(String inputStr) {
        if (isContainCustomDelimiter(inputStr)) {
            addCustomDelimiter(inputStr);
        }
    }

    private boolean isContainCustomDelimiter(String inputStr) {
        return inputStr.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private void addCustomDelimiter(String inputStr) {
        String customDelimiters = extractCustomDelimiters(inputStr);

        for (int i = 0; i < customDelimiters.length(); i++) {
            delimiters.addDelimiter(customDelimiters.charAt(i) + "");
        }
    }

    private static String extractCustomDelimiters(String inputStr) {
        String customDelimiterWrapper = inputStr.substring(inputStr.indexOf(CUSTOM_DELIMITER_PREFIX),
                inputStr.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);

        return customDelimiterWrapper.substring(2, customDelimiterWrapper.length() - 2);
    }
}
