package calculator.controller;

import calculator.model.calculator.Calculator;
import calculator.model.delimiter.Delimiter;
import calculator.model.positivenum.PositiveNum;
import calculator.model.str.Str;
import calculator.view.InputView;
import java.util.List;

public class CalculatorController {

    private static CalculatorController instance;
    private final InputView inputView = InputView.getInstance();
    private final Delimiter delimiter = Delimiter.getInstance();

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
        String delimiters = delimiter.addCustomDelimiters(str);
        List<PositiveNum> positiveNumList = str.separateStr(delimiters);

        Calculator calculator = new Calculator(positiveNumList);
        int result = calculator.plus();
    }

}
