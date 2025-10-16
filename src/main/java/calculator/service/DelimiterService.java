package calculator.service;

import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;

import calculator.model.delimiter.Delimiter;

public class DelimiterService {

    private static DelimiterService instance;
    private final Delimiter delimiter = Delimiter.getInstance();

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
        String customDelimiters = delimiter.extractCustomDelimiters(inputStr);

        for (int i = 0; i < customDelimiters.length(); i++) {
            delimiter.addDelimiter(customDelimiters.charAt(i));
        }
    }
}
