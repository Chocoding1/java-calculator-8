package calculator.controller;

import calculator.service.DelimiterService;
import calculator.service.SeparationService;

public class CalculatorController {

    private final DelimiterService delimiterService = DelimiterService.getInstance();
    private final SeparationService separationService = SeparationService.getInstance();

    public int calculate(String inputStr) {
        delimiterService.checkCustomDelimiter(inputStr);
        int[] numbers = separationService.separate(inputStr);

        return 0;
    }
}
