package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            return new InputView();
        }
        return instance;
    }

    public String inputViewRendering() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
