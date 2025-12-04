package calculator.config;

import calculator.controller.CalculatorController;
import calculator.view.InputView;

public class CalculatorConfig {

    private CalculatorController calculatorController;
    private InputView inputView;

    public CalculatorController calculatorController() {
        if (calculatorController == null) {
            calculatorController = new CalculatorController(inputView());
        }
        return calculatorController;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }
}
