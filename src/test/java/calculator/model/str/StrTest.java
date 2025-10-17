package calculator.model.str;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import calculator.model.positivenum.PositiveNum;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StrTest {

    @Test
    @DisplayName("커스텀 구분자 미포함 시, containCustomDelimiters = false")
    void containCustomDelimiters_is_false_when_customDelimiters_isNot_contained() {
        //given
        String inputStr = "1,2:3,4";

        //when & then
        assertSimpleTest(() -> {
            Str str = new Str(inputStr);
            Assertions.assertFalse(str.isContainCustomDelimiters());
        });
    }

    @Test
    @DisplayName("커스텀 구분자 포함 시, containCustomDelimiters = true")
    void containCustomDelimiters_is_true_when_customDelimiters_is_contained() {
        //given
        String inputStr = "//;\\n1,2:3;4";

        //when & then
        assertSimpleTest(() -> {
            Str str = new Str(inputStr);
            Assertions.assertTrue(str.isContainCustomDelimiters());
        });
    }

    @Test
    @DisplayName("문자열 분리 테스트 - 분리된 숫자 개수 확인")
    void separateStr_check_separated_str_count() {
        //given
        String inputStr = "1,2:3,4";
        Str str = new Str(inputStr);
        String delimiters = "[,:]";

        //when & then
        assertSimpleTest(() -> {
            List<PositiveNum> positiveNumList = str.separateStr(delimiters);
            Assertions.assertEquals(positiveNumList.size(), 4);
        });
    }

}