package calculator.config;

import calculator.controller.CalculatorController;
import calculator.model.CustomDelimiterExtractor;
import calculator.view.InputView;

public class CalculatorConfig {

    private CalculatorController calculatorController;
    private InputView inputView;
    private CustomDelimiterExtractor customDelimiterExtractor;

    public CalculatorController calculatorController() {
        if (calculatorController == null) {
            calculatorController = new CalculatorController(inputView(), customDelimiterExtractor());
        }
        return calculatorController;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private CustomDelimiterExtractor customDelimiterExtractor() {
        if (customDelimiterExtractor == null) {
            customDelimiterExtractor = new CustomDelimiterExtractor();
        }
        return customDelimiterExtractor;
    }
}
