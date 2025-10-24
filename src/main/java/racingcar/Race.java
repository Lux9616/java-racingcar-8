package racingcar;

import java.util.List;

public class Race {
    private final Cars cars;
    private final int attempts;
    private final MoveStrategy strategy;

    public Race(Cars cars, int attempts, MoveStrategy strategy) {
        this.cars = cars;
        this.attempts = attempts;
        this.strategy = strategy;
    }

    public void run() {
        for (int i = 0; i < attempts; i++) {
            cars.moveAll(strategy);
            printRound();
        }
    }

    private void printRound() {
        for (Car c : cars.asList()) {
            System.out.println(c.render());
        }
        System.out.println();
    }

    public List<String> findWinners() {
        return cars.winnerNames();
    }
}
