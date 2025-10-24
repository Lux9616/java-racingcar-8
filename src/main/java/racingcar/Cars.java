package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> values;

    private Cars(List<Car> values) {
        this.values = values;
    }

    public static Cars from(List<String> names) {
        List<Car> list;
        list = new ArrayList<>();
        for (String name : names) {
            list.add(Car.of(name));
        }
        return new Cars(list);
    }

    public void moveAll(MoveStrategy strategy) {
        for (Car c : values) {
            c.moveIf(strategy);
        }
    }

    public List<Car> asList() {
        return values;
    }

    public int maxPosition() {
        int max = 0;
        for (Car c : values) {
            if (c.getPosition() > max) {
                max = c.getPosition();
            }
        }
        return max;
    }

    public List<String> winnerNames() {
        int max = maxPosition();
        return values.stream()
                .filter(c -> c.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}

