package calculator.view;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693297b9a2cc8191ae62231c486f5e6b
 * https://chatgpt.com/s/t_693297ca51ac8191884fb90ee1dd3a12
 */
public class OutputView {

    private static final String OUTPUT_PREFIX = "결과 : ";

    public void printResult(int result) {
        System.out.println(OUTPUT_PREFIX + result);
    }
}
