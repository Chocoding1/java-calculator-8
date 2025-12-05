package calculator.controller;

import calculator.model.Delimiter;
import calculator.model.ParsedInput;
import calculator.model.Parser;
import calculator.model.PositiveNumbers;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_69327b86bf04819196721febecc2d61c
 * https://chatgpt.com/s/t_69327baf7cec8191b10369f15b622e0d
 * https://chatgpt.com/s/t_693292476668819188c092c6f69f1143
 */
public class CalculatorController {

    private final InputView inputView;
    private final Parser parser;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, Parser parser,
                                OutputView outputView) {
        this.inputView = inputView;
        this.parser = parser;
        this.outputView = outputView;
    }

    public void run() {
        String input = getInput();

        ParsedInput parsedInput = parseInput(input);

        Delimiter delimiter = createDelimiter(parsedInput.customDelimiters());

        PositiveNumbers positiveNumbers = parseExpression(delimiter, parsedInput.expression());

        int result = calculate(positiveNumbers);

        print(result);
    }

    private ParsedInput parseInput(String input) {
        return parser.parse(input);
    }

    private String getInput() {
        return inputView.getInput();
    }

    private Delimiter createDelimiter(String customDelimiters) {
        return new Delimiter(customDelimiters);
    }

    private PositiveNumbers parseExpression(Delimiter delimiter, String expression) {
        String[] tokens = delimiter.split(expression);
        return PositiveNumbers.from(tokens);
    }

    private static int calculate(PositiveNumbers positiveNumbers) {
        return positiveNumbers.sum();
    }

    private void print(int result) {
        outputView.printResult(result);
    }
}
