package calculator.config;

import calculator.controller.CalculatorController;
import calculator.model.Extractor;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorConfig {

    private CalculatorController calculatorController;
    private InputView inputView;
    private Extractor extractor;
    private OutputView outputView;

    public CalculatorController calculatorController() {
        if (calculatorController == null) {
            calculatorController = new CalculatorController(inputView(), extractor(), outputView());
        }
        return calculatorController;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    private Extractor extractor() {
        if (extractor == null) {
            extractor = new Extractor();
        }
        return extractor;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }
}
