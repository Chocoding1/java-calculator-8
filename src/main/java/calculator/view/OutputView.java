package calculator.view;

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

    public void renderingOutputView(int result) {
        System.out.println("결과 : " + result);
    }
}
