package calculator.model.calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.model.positivenum.PositiveNum;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("덧셈 연산 테스트")
    void plus_test() {
        //given
        List<PositiveNum> numbers = List.of(
                new PositiveNum("1"),
                new PositiveNum("2"),
                new PositiveNum("3")
        );
        Calculator calculator = new Calculator(numbers);

        //when & then
        assertSimpleTest(() -> {
            int result = calculator.plus();
            assertEquals(result, 6);
        });
    }
}