package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("이동 조건이 true면 전진한다")
    void moveWhenMovable() {
        Car car = Car.of("pobi");
        MoveStrategy yes = () -> true;
        car.moveIf(yes);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 조건이 false면 멈춘다")
    void stopWhenNotMovable() {
        Car car = Car.of("woni");
        MoveStrategy no = () -> false;
        car.moveIf(no);
        assertThat(car.getPosition()).isZero();
    }
}
