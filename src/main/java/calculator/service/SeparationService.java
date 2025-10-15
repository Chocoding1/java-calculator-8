package calculator.service;

import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.delimiter.DelimiterConstant.CUSTOM_DELIMITER_SUFFIX;

import calculator.model.delimiter.Delimiter;
import java.util.Arrays;

public class SeparationService {

    private static SeparationService instance;
    private final Delimiter delimiter = Delimiter.getInstance();

    private SeparationService() {
    }

    public static SeparationService getInstance() {
        if (instance == null) {
            return new SeparationService();
        }
        return instance;
    }

    public int[] separate(String inputStr) {
        if (isContainCustomDelimiter(inputStr)) {
            inputStr = extractInputStr(inputStr);
        }

        String delimiters = delimiter.getDelimiters();

        return Arrays.stream(inputStr.split(delimiters))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private boolean isContainCustomDelimiter(String inputStr) {
        return inputStr.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private String extractInputStr(String inputStr) {
        return inputStr.substring(inputStr.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
    }
}
