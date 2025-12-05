package calculator.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @Test
    @DisplayName("PositiveNumber 정상 생성")
    void PositiveNumber_create_success() {
        //given
        String initialNumber = "1";

        //when
        PositiveNumber positiveNumber = new PositiveNumber(initialNumber);

        //then
        assertThat(positiveNumber.getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 문자일 경우 PositiveNumber 생성 실패")
    void PositiveNumber_fail_when_initialNumber_is_not_number() {
        //given
        String initialNumber = "a";

        //when & then
        assertThatThrownBy(() -> new PositiveNumber(initialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("양수가 아닐 경우 PositiveNumber 생성 실패")
    void PositiveNumber_fail_when_initialNumber_is_not_positive(String initialNumber) {
        //when & then
        assertThatThrownBy(() -> new PositiveNumber(initialNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}