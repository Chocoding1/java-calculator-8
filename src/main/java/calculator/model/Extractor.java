package calculator.model;

public class Extractor {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";

    public String extractCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int endIdx = input.indexOf(CUSTOM_DELIMITER_POSTFIX);
            try {
                return input.substring(2, endIdx);
            } catch (Exception e) {
                throw new IllegalArgumentException("커스텀 구분자는 " + CUSTOM_DELIMITER_POSTFIX + "로 감싸야 합니다." + e.getMessage());
            }
        }

        if (input.contains(CUSTOM_DELIMITER_POSTFIX)) {
            throw new IllegalArgumentException("커스텀 구분자는 " + CUSTOM_DELIMITER_PREFIX + "로 시작해야 합니다.");
        }

        return "";
    }

    public String extractExpression(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int endIdx = input.indexOf(CUSTOM_DELIMITER_POSTFIX);
            try {
                return input.substring(endIdx + 2);
            } catch (Exception e) {
                throw new IllegalArgumentException("계산식 추출 중 예외 발생: " + e.getMessage());
            }
        }

        if (input.contains(CUSTOM_DELIMITER_POSTFIX)) {
            throw new IllegalArgumentException("커스텀 구분자는 " + CUSTOM_DELIMITER_PREFIX + "로 시작해야 합니다.");
        }

        return input;
    }
}
