package calculator.model;

import java.util.Arrays;
import java.util.List;

public class ExpressionSeparator {
    public List<PositiveNumber> separateExpression(String expression, Delimiter delimiter) {
        String delimiters = delimiter.getDelimiters();

        return Arrays.stream(expression.split(delimiters))
                .map(PositiveNumber::new)
                .toList();
    }

}
