package calculator.model.positivenum;

public class PositiveNum {

    private final int number;

    public PositiveNum(String str) {
        int number = convertToInt(str);
        validatePositive(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private int convertToInt(String str) { // 숫자인지 체크하는 것이 아닌 숫자 변경하는 것이기 때문에 메서드명 수정 필요
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주십시오.");
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }
}
