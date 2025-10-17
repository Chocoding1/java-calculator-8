package calculator.model.positivenum;

import java.math.BigDecimal;

public class PositiveNum {

    private final BigDecimal number;

    public PositiveNum(String str) {
        BigDecimal number = convertToNumber(str);
        validatePositive(number);
        this.number = number;
    }

    public BigDecimal getNumber() {
        return number;
    }

    private BigDecimal convertToNumber(String str) {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주십시오.");
        }
    }

    private void validatePositive(BigDecimal number) {
        if (number.compareTo(new BigDecimal("0")) <= 0) {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }
}
