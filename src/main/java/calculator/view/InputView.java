package calculator.view;

import calculator.controller.CalculatorController;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {

    private final CalculatorController calculatorController = new CalculatorController();

    public void startCalculation() {
        String inputStr = inputViewRendering();

        calculatorController.calculate(inputStr);
    }

    private String inputViewRendering() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        return Console.readLine();
    }
}
