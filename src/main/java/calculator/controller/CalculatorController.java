package calculator.controller;

import calculator.model.calculator.Calculator;
import calculator.model.positivenum.PositiveNum;
import calculator.model.str.Str;
import calculator.service.DelimiterService;
import calculator.service.SeparationService;
import calculator.view.InputView;
import java.util.List;

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
        Str str = new Str(inputStr);

        delimiterService.checkCustomDelimiter(inputStr);
        List<PositiveNum> positiveNumList = separationService.separate(inputStr);
        Calculator calculator = new Calculator(positiveNumList);
        int result = calculator.plus();
    }

}
