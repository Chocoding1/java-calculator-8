package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.ExpressionSeparator;
import calculator.model.Extractor;
import calculator.model.PositiveNumbers;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final Extractor extractor;
    private final ExpressionSeparator expressionSeparator;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, Extractor extractor,
                                ExpressionSeparator expressionSeparator, OutputView outputView) {
        this.inputView = inputView;
        this.extractor = extractor;
        this.expressionSeparator = expressionSeparator;
        this.outputView = outputView;
    }

    public void run() {
        String input = inputView.getInput();

        String customDelimiters = extractor.extractCustomDelimiter(input);

        Delimiter delimiter = new Delimiter(customDelimiters);

        String expression = extractor.extractExpression(input);

        PositiveNumbers positiveNumbers = expressionSeparator.separateExpression(expression, delimiter);

        int result = positiveNumbers.sum();

        outputView.printResult(result);
    }
}
