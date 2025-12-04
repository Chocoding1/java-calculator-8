package calculator.controller;

import calculator.model.CustomDelimiterExtractor;
import calculator.model.Delimiter;
import calculator.model.ExpressionExtractor;
import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView;
    private final CustomDelimiterExtractor customDelimiterExtractor;
    private final ExpressionExtractor expressionExtractor;

    public CalculatorController(InputView inputView, CustomDelimiterExtractor customDelimiterExtractor,
                                ExpressionExtractor expressionExtractor) {
        this.inputView = inputView;
        this.customDelimiterExtractor = customDelimiterExtractor;
        this.expressionExtractor = expressionExtractor;
    }

    public void run() {
        String input = inputView.getInput();

        String customDelimiters = customDelimiterExtractor.extractCustomDelimiter(input);

        Delimiter delimiter = new Delimiter(customDelimiters);

        String expression = expressionExtractor.extractExpression(input);
    }
}
