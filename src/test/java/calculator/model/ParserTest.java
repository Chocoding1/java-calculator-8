package calculator.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Test
    @DisplayName("입력값 파싱 성공")
    void parse_success() {
        //given
        String input = "//*\\n1,2:3*4";
        Parser parser = new Parser();

        //when
        ParsedInput parsedInput = parser.parse(input);

        //then
        assertThat(parsedInput.customDelimiters().length()).isEqualTo(1);
        assertThat(parsedInput.expression().length()).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//*1,2:3*4", "*\\n1,2:3*4"})
    @DisplayName("입력값에 //나 \n 중 하나만 존재하는 경우 예외 발생")
    void parse_fail_when_contain_only_prefix_or_postfix(String input) {
        //given
        Parser parser = new Parser();

        //when & then
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}