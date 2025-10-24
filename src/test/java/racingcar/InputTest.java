package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    @Test
    @DisplayName("이름 파싱 - 공백 제거 및 유효성")
    void parseNamesOk() {
        List<String> names = Input.parseNames("pobi, woni, jun");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("빈 이름은 예외")
    void emptyName() {
        assertThatThrownBy(() -> Input.parseNames("pobi,,jun")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6자 초과 이름은 예외")
    void longName() {
        assertThatThrownBy(() -> Input.parseNames("pobi123,won"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수는 양의 정수")
    void attemptsOk() {
        assertThat(Input.parseAttempts("3")).isEqualTo(3);
    }

    @Test
    @DisplayName("시도 횟수 - 음수/0/비숫자 예외")
    void attemptsBad() {
        assertThatThrownBy(() -> Input.parseAttempts("0")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Input.parseAttempts("-1")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Input.parseAttempts("a")).isInstanceOf(IllegalArgumentException.class);
    }
}
