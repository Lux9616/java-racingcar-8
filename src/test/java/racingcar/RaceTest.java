package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {
    @Test
    @DisplayName("우승자는 최대 위치의 모든 자동차")
    void winners() {
        Cars cars = Cars.from(List.of("pobi", "woni", "jun"));

        MoveStrategy yes = () -> true;
        MoveStrategy no = () -> false;
        cars.asList().get(0).moveIf(yes); // pobi:1
        cars.asList().get(1).moveIf(no); // woni:0
        cars.asList().get(2).moveIf(yes); // jun:1
        cars.asList().get(0).moveIf(yes); // pobi:2
        cars.asList().get(2).moveIf(yes); // jun:2

        Race race = new Race(cars, 0, no);
        assertThat(race.findWinners()).containsExactlyInAnyOrder("pobi", "jun");
    }
}