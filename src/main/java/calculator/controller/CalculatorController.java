package calculator.controller;

import calculator.model.CustomDelimiterExtractor;
import calculator.model.Delimiter;
import calculator.model.ExpressionExtractor;
import calculator.model.ExpressionSeparator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.Arrays;

public class CalculatorController {

    private final InputView inputView;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final ExpressionExtractor expressionExtractor;
    private final ExpressionSeparator expressionSeparator;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, CustomDelimiterExtractor customDelimiterExtractor,
                                ExpressionExtractor expressionExtractor, ExpressionSeparator expressionSeparator,
                                OutputView outputView) {
        this.inputView = inputView;
        this.customDelimiterExtractor = customDelimiterExtractor;
        this.expressionExtractor = expressionExtractor;
        this.expressionSeparator = expressionSeparator;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.getInput();

        String customDelimiters = customDelimiterExtractor.extractCustomDelimiter(input);

        Delimiter delimiter = new Delimiter(customDelimiters);

        String expression = expressionExtractor.extractExpression(input);

        int[] numbers = expressionSeparator.separateExpression(expression, delimiter);

        int result = sumNumbers(numbers);

        outputView.printResult(result);
    }

    private int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }
}
