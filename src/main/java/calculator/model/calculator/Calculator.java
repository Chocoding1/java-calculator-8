package calculator.model.calculator;

import calculator.model.positivenum.PositiveNum;
import java.util.List;

public class Calculator {

    private final List<PositiveNum> numbers;

    public Calculator(List<PositiveNum> numbers) {
        this.numbers = numbers;
    }

    public int plus() {
        int result = 0;
        for (PositiveNum number : numbers) {
            result += number.getNumber();
        }
        return result;
    }
}
