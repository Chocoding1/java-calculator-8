package calculator.controller;

import calculator.model.calculator.Calculator;
import calculator.model.delimiter.Delimiter;
import calculator.model.positivenum.PositiveNum;
import calculator.model.str.Str;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.math.BigDecimal;
import java.util.List;

public class CalculatorController {

    private static CalculatorController instance;
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    private CalculatorController() {
    }

    public static CalculatorController getInstance() {
        if (instance == null) {
            return new CalculatorController();
        }
        return instance;
    }

    public void startApp() {
        String inputStr = inputView.getInputStr();
        if (isEmpty(inputStr)) {
            return;
        }

        Str str = new Str(inputStr);

        Delimiter delimiter = new Delimiter();
        delimiter.addCustomDelimiters(str);

        List<PositiveNum> positiveNumList = str.separateStr(delimiter.getDelimiters());

        Calculator calculator = new Calculator(positiveNumList);
        BigDecimal result = calculator.plus();

        outputView.renderingOutputView(result);
    }

    private boolean isEmpty(String inputStr) {
        if (inputStr.isEmpty()) {
            outputView.renderingOutputView(new BigDecimal("0"));
            return true;
        }
        return false;
    }

}
