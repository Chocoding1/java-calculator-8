package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 리팩토링 가이드 https://chatgpt.com/s/t_69329672acfc81918f3725dc384fdcea
 * https://chatgpt.com/s/t_6932967b344c8191bb123a9b196005b8
 */
public class InputView {

    private static final String INPUT_NOTICE = "덧셈할 문자열을 입력해 주세요.";

    public String getInput() {
        System.out.println(INPUT_NOTICE);
        return Console.readLine();
    }
}
