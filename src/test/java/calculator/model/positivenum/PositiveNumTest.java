package calculator.model.positivenum;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumTest {

    @Test
    @DisplayName("문자를 숫자로 변환할 수 없는 경우, 예외 발생")
    void throwException_when_convertToInt_fail() {
        //given
        String incorrectStr = "1*2";

        //when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new PositiveNum(incorrectStr))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("변환된 수가 음수인 경우, 예외 발생")
    void throwException_when_negativeNumber() {
        //given
        String incorrectStr = "-1";

        //when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new PositiveNum(incorrectStr))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}