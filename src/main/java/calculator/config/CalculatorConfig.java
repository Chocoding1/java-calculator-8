package calculator.config;

import calculator.controller.CalculatorController;
import calculator.model.CustomDelimiterExtractor;
import calculator.model.ExpressionSeparator;
import calculator.view.InputView;

public class CalculatorConfig {

    private CalculatorController calculatorController;
    private InputView inputView;
    private CustomDelimiterExtractor customDelimiterExtractor;
    private ExpressionSeparator expressionSeparator;

    public CalculatorController calculatorController() {
        if (calculatorController == null) {
            calculatorController = new CalculatorController(inputView(), customDelimiterExtractor(), expressionSeparator());
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

    private ExpressionSeparator expressionSeparator() {
        if (expressionSeparator == null) {
            expressionSeparator = new ExpressionSeparator();
        }
        return expressionSeparator;
    }
}
