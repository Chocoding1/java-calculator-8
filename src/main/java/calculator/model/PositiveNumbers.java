package calculator.model;

import java.util.Arrays;
import java.util.List;

/**
 * 리팩토링 가이드
 * https://chatgpt.com/s/t_693287c436808191a1ce205c74c5aef8
 * https://chatgpt.com/s/t_69328d2c154481919df5b4fb92a13038
 * https://chatgpt.com/s/t_693288a453dc8191b7ffc5c14e8dae28
 * https://chatgpt.com/s/t_693288feff388191afb937e2a83787ce
 * https://chatgpt.com/s/t_6932896922d08191ad5e4a43f54d38b8
 * https://chatgpt.com/s/t_69328cc157d8819191f5e04b3f39b722
 * https://chatgpt.com/s/t_69328c9a3edc819188126182765bba7f
 * https://chatgpt.com/s/t_69328ef746408191ab13a9c1390ea357
 */
public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = List.copyOf(positiveNumbers);
    }

    public static PositiveNumbers from(String[] tokens) {
        return new PositiveNumbers(
                Arrays.stream(tokens)
                        .map(PositiveNumber::new)
                        .toList()
        );
    }

    public int sum() {
        return positiveNumbers.stream()
                .mapToInt(PositiveNumber::getNumber)
                .sum();
    }
}
