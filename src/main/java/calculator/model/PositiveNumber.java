package calculator.model;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("숫자는 양수여야 합니다.");
        }
    }
}
