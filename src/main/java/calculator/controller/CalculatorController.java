package calculator.controller;

import calculator.model.CustomDelimiterExtractor;
import calculator.model.Delimiter;
import calculator.view.InputView;

public class CalculatorController {

    private final InputView inputView;
    private final CustomDelimiterExtractor customDelimiterExtractor;

    public CalculatorController(InputView inputView, CustomDelimiterExtractor customDelimiterExtractor) {
        this.inputView = inputView;
        this.customDelimiterExtractor = customDelimiterExtractor;
    }

    public void run() {
        String input = inputView.getInput();

        String customDelimiters = customDelimiterExtractor.addCustomDelimiter(input);

        Delimiter delimiter = new Delimiter(customDelimiters);
    }
}
