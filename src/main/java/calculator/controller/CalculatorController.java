package calculator.controller;

import calculator.service.DelimiterService;
import calculator.service.SeparationService;
import calculator.view.InputView;

public class CalculatorController {

    private static CalculatorController instance;
    private final InputView inputView = InputView.getInstance();
    private final DelimiterService delimiterService = DelimiterService.getInstance();
    private final SeparationService separationService = SeparationService.getInstance();

    private CalculatorController() {
    }

    public static CalculatorController getInstance() {
        if (instance == null) {
            return new CalculatorController();
        }
        return instance;
    }

    public void startApp() {
        String inputStr = inputView.inputViewRendering();

        delimiterService.checkCustomDelimiter(inputStr);
        int[] numbers = separationService.separate(inputStr);
    }

}
