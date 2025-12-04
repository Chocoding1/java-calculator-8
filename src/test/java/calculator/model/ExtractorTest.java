package calculator.model;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExtractorTest {

    @Test
    @DisplayName("커스텀 구분자 추출")
    void extractCustomDelimiter_success() {
        //given
        String input = "//*\\n1,2:3*4";
        Extractor extractor = new Extractor();

        //when
        String customDelimiters = extractor.extractCustomDelimiter(input);

        //then
        assertThat(customDelimiters.length()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//*1,2:3*4", "*\\n1,2:3*4"})
    @DisplayName("커스텀 구분자 추출 시, //나 \n 중 하나만 존재하는 경우 예외 발생")
    void extractCustomDelimiter_fail_when_contain_only_prefix_or_postfix(String input) {
        //given
        Extractor extractor = new Extractor();

        //when & then
        assertThatThrownBy(() -> extractor.extractCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "//*\\n1,2,3"})
    @DisplayName("계산식 추출 성공")
    void extractExpression_success(String input) {
        //given
        Extractor extractor = new Extractor();
        int expressionLength = 5;

        //when
        String expression = extractor.extractExpression(input);

        //then
        assertThat(expression.length()).isEqualTo(expressionLength);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//*1,2:3*4", "*\\n1,2:3*4"})
    @DisplayName("계산식 추출 시, //나 \n 중 하나만 존재하는 경우 예외 발생")
    void extractExpression_fail_when_contain_only_prefix_or_postfix(String input) {
        //given
        Extractor extractor = new Extractor();

        //when & then
        assertThatThrownBy(() -> extractor.extractExpression(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}