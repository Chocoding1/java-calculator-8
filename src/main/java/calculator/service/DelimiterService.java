package calculator.service;

import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_SUFFIX;

import calculator.model.delimiter.Delimiters;

public class DelimiterService {

    private static DelimiterService instance;
    private final Delimiters delimiters = Delimiters.getInstance();

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
        String customDelimiterWrapper = inputStr.substring(inputStr.indexOf(CUSTOM_DELIMITER_PREFIX),
                inputStr.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);

        for (int i = 2; i < customDelimiterWrapper.length(); i++) {
            if (customDelimiterWrapper.charAt(i) == '\\') {
                break;
            }
            delimiters.addDelimiter(customDelimiterWrapper.charAt(i) + "");
        }
    }


}
