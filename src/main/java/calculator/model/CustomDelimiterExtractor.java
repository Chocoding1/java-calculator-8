package calculator.model;

public class CustomDelimiterExtractor {

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_POSTFIX = "\\n";

    public String extractCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return extract(input);
        }
        return "";
    }

    private String extract(String input) {
        int endIdx = input.indexOf(CUSTOM_DELIMITER_POSTFIX);
        try {
            return input.substring(2, endIdx);
        } catch (Exception e) {
            throw new IllegalArgumentException("커스텀 구분자 추출 중 예외 발생: " + e.getMessage());
        }
    }

}
