package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    @Override
    public boolean movable() {
        int n = Randoms.pickNumberInRange(0, 9);
        return n >= 4;
    }
}