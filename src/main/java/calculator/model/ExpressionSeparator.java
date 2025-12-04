package calculator.model;

import java.util.Arrays;

public class ExpressionSeparator {
    public int[] separateExpression(String expression, Delimiter delimiter) {
        String delimiters = delimiter.getDelimiters();

        return Arrays.stream(expression.split(delimiters))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
