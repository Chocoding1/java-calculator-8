package calculator.model.positivenum;

public class PositiveNum {

    private final int number;

    public PositiveNum(String str) {
        int number = isNumeric(str);
        validatePositive(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int isNumeric(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("커스텀 구분자를 추가해주십시오.");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }
}
