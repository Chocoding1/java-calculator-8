package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

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

    public String getInputStr() {
        renderingInputView();

        String inputStr;
        try {
            inputStr = Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
        return inputStr.strip();

    }

    private void renderingInputView() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
}
