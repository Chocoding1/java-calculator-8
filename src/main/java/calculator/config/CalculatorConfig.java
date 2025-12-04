package calculator.config;

import calculator.controller.CalculatorController;
import calculator.model.CustomDelimiterExtractor;
import calculator.model.ExpressionExtractor;
import calculator.model.ExpressionSeparator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorConfig {

    private CalculatorController calculatorController;
    private InputView inputView;
    private CustomDelimiterExtractor customDelimiterExtractor;
    private ExpressionExtractor expressionExtractor;
    private ExpressionSeparator expressionSeparator;
    private OutputView outputView;

    public CalculatorController calculatorController() {
        if (calculatorController == null) {
            calculatorController = new CalculatorController(inputView(), customDelimiterExtractor(),
                    expressionExtractor(), expressionSeparator(), outputView());
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

    private ExpressionExtractor expressionExtractor() {
        if (expressionExtractor == null) {
            expressionExtractor = new ExpressionExtractor();
        }
        return expressionExtractor;
    }

    private ExpressionSeparator expressionSeparator() {
        if (expressionSeparator == null) {
            expressionSeparator = new ExpressionSeparator();
        }
        return expressionSeparator;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }
}
