package calculator.model;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693285e6437c8191b5b20059dea852f0
 * https://chatgpt.com/s/t_6932863d14308191b6843e3430f3547f
 */
public class PositiveNumber {

    private final int number;

    public PositiveNumber(String initialNumber) {
        int number = convertToInt(initialNumber);
        validatePositive(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int convertToInt(String initialNumber) {
        try {
            return Integer.parseInt(initialNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("정수가 아닙니다: " + initialNumber);
        }
    }

    private void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다: " + number);
        }
    }
}
