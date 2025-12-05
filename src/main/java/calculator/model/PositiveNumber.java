package calculator.model;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(String initialNumber) {
        int number = convertToInt(initialNumber);
        validateNumber(number);
        this.number = number;
    }

    public int toInt() {
        return number;
    }

    private int convertToInt(String initialNumber) {
        try {
            return Integer.parseInt(initialNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어 있습니다.");
        }
    }

    private void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }
}
