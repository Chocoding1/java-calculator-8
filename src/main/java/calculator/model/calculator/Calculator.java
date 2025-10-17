package calculator.model.calculator;

import calculator.model.positivenum.PositiveNum;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculator {

    private final List<PositiveNum> numbers;

    public Calculator(List<PositiveNum> numbers) {
        this.numbers = numbers;
    }

    public BigDecimal plus() {
        BigDecimal result = new BigDecimal("0");

        for (PositiveNum number : numbers) {
            result = result.add(number.getNumber());
        }

        if (isInteger(result)) {
            result = removeScale(result);
        }
        return result;
    }

    private boolean isInteger(BigDecimal result) {
        BigDecimal remainder = result.remainder(new BigDecimal("1"));
        return remainder.compareTo(new BigDecimal("0")) == 0;
    }

    private BigDecimal removeScale(BigDecimal result) {
        return result.setScale(0, RoundingMode.FLOOR);
    }
}
