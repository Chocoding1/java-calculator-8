package calculator.controller;

import calculator.service.DelimiterService;

public class CalculatorController {

    private final DelimiterService delimiterService = DelimiterService.getInstance();

    public int calculate(String inputStr) {
        delimiterService.checkCustomDelimiter(inputStr);

        return 0;
    }
}
