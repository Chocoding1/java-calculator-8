package calculator.model;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_6932a43907248191871d924077ca49d9
 * https://chatgpt.com/s/t_6932a44647488191906e88a7f959a2e2
 */
public class Parser {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";

    public ParsedInput parse(String input) {
        validateInputSyntax(input);

        if (isContainCustomDelimiter(input)) {
            return parseCustomDelimiterInput(input);
        }

        return new ParsedInput("", input);
    }

    private void validateInputSyntax(String input) {
        boolean startsWithPrefix = input.startsWith(CUSTOM_DELIMITER_PREFIX);
        boolean containsPostfix = input.contains(CUSTOM_DELIMITER_POSTFIX);

        if (startsWithPrefix && !containsPostfix) {
            throw new IllegalArgumentException(
                    "커스텀 구분자는 " + CUSTOM_DELIMITER_PREFIX + "와 " + CUSTOM_DELIMITER_POSTFIX + "로 감싸야 합니다.");
        }

        if (!startsWithPrefix && containsPostfix) {
            throw new IllegalArgumentException(
                    "커스텀 구분자는 " + CUSTOM_DELIMITER_PREFIX + "와 " + CUSTOM_DELIMITER_POSTFIX + "로 감싸야 합니다.");
        }
    }

    private boolean isContainCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private ParsedInput parseCustomDelimiterInput(String input) {
        int postfixIndex = input.indexOf(CUSTOM_DELIMITER_POSTFIX);

        String customDelimiters = input.substring(CUSTOM_DELIMITER_PREFIX.length(), postfixIndex);

        String expression = input.substring(postfixIndex + CUSTOM_DELIMITER_POSTFIX.length());

        return new ParsedInput(customDelimiters, expression);
    }
}
