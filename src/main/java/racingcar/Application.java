package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String namesLine = Console.readLine();
            List<String> names = Input.parseNames(namesLine);

            System.out.println("시도할 횟수는 몇 회인가요?");
            String attemptsLine = Console.readLine();
            int attempts = Input.parseAttempts(attemptsLine);

            System.out.println();
            System.out.println("실행 결과");

            MoveStrategy strategy = new RandomMoveStrategy();
            Race race = new Race(Cars.from(names), attempts, strategy);
            race.run();

            List<String> winners = race.findWinners();
            System.out.println();
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        } finally {
            Console.close();
        }
    }
} // TODO: 프로그램 구현
