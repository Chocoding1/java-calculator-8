package calculator.model;

public class ExpressionExtractor {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";

    public String extractExpression(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int endIdx = input.indexOf(CUSTOM_DELIMITER_POSTFIX);
            try {
                return input.substring(endIdx + 2);
            } catch (Exception e) {
                throw new IllegalArgumentException("계산식 추출 중 예외 발생: " + e.getMessage());
            }
        }
        return input;
    }
}
