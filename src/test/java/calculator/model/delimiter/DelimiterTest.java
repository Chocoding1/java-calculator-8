package calculator.model.delimiter;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import calculator.model.str.Str;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterTest {

    private final Delimiter delimiter = new Delimiter();

    @Test
    @DisplayName("커스텀 구분자 존재 시, 구분자 추가 확인 테스트")
    void addCustomDelimiters_when_customDelimiters_is_contain() {
        //given
        String inputStr = "//;*\\n1,2,3,4";
        Str str = new Str(inputStr);

        //when & then
        assertSimpleTest(() -> {
            delimiter.addCustomDelimiters(str);
            assertThat(delimiter.getDelimiters()).contains(":", ",", ";", "*");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 미존재 시, 구분자 추가 확인 테스트")
    void addCustomDelimiters_when_customDelimiters_isNot_contain() {
        //given
        String inputStr = "1,2,3,4";
        Str str = new Str(inputStr);

        //when & then
        assertSimpleTest(() -> {
            delimiter.addCustomDelimiters(str);
            assertThat(delimiter.getDelimiters()).contains(":", ",");
        });
    }
}