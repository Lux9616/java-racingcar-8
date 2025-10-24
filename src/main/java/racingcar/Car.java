package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void moveIf(MoveStrategy strategy) {
        if (strategy.movable()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
