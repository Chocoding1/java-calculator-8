package calculator.controller;

import calculator.model.CustomDelimiterExtractor;
import calculator.model.Delimiter;
import calculator.model.ExpressionSeparator;
import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final ExpressionSeparator expressionSeparator;

    public CalculatorController(InputView inputView, CustomDelimiterExtractor customDelimiterExtractor,
                                ExpressionSeparator expressionSeparator) {
        this.inputView = inputView;
        this.customDelimiterExtractor = customDelimiterExtractor;
        this.expressionSeparator = expressionSeparator;
    }

    public void run() {
        String input = inputView.getInput();

        String customDelimiters = customDelimiterExtractor.extractCustomDelimiter(input);

        Delimiter delimiter = new Delimiter(customDelimiters);

        String expression = expressionSeparator.separate(input);
    }
}
