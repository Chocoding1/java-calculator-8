package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculationView {

    public void startCalculation() {
        String inputStr = inputViewRendering();
    }

    private String inputViewRendering() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        return Console.readLine();
    }
}
