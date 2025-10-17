package calculator.view;

import java.math.BigDecimal;

public class OutputView {

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            return new OutputView();
        }
        return instance;
    }

    public void renderingOutputView(BigDecimal result) {
        System.out.println("결과 : " + result);
    }
}
