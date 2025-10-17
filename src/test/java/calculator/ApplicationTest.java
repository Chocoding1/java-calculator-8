package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("빈 문자열(\"\") 입력 시 0 반환")
    void 성공_테스트_1() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("숫자만 입력 시 그대로 반환")
    void 성공_테스트_2() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 + 숫자만 입력 시 그대로 반환")
    void 성공_테스트_3() {
        assertSimpleTest(() -> {
            run("//*\\n123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 없이 등록틀만 입력 시 정상 반환")
    void 성공_테스트_4() {
        assertSimpleTest(() -> {
            run("//\\n1:23");
            assertThat(output()).contains("결과 : 24");
        });
    }

    @Test
    @DisplayName("소수 입력 테스트")
    void 성공_테스트_5() {
        assertSimpleTest(() -> {
            run("//;\\n1:2.3");
            assertThat(output()).contains("결과 : 3.3");
        });
    }

    @Test
    @DisplayName("커스텀 구분자로 . 추가 + 소수 입력 테스트")
    void 성공_테스트_6() {
        assertSimpleTest(() -> {
            run("//.\\n1:2.3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("음수 입력 시 예외 발생")
    void 예외_테스트_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,-3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("구분자만 연속 입력 시 예외 발생")
    void 예외_테스트_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,:3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("등록된 구분자 외의 구분자 입력 시 예외 발생")
    void 예외_테스트_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2-3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("등록된 구분자 외의 구분자 입력 시 예외 발생")
    void 예외_테스트_4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2*3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
