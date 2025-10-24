package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {
    private static final int NAME_LIMIT = 5;

    private Input() {
    }

    public static List<String> parseNames(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("이름 입력이 비었습니다.");
        }
        String[] tokens = line.split(",");
        List<String> names = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            String name = token.trim();
            validateName(name);
            if (!seen.add(name)) {
                throw new IllegalArgumentException("이름이 중복됩니다: " + name);
            }
            names.add(name);
        }
        return names;
    }


    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("빈 이름은 허용되지 않습니다.");
        }
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다: " + name);
        }
    }

    public static int parseAttempts(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("시도 횟수 입력이 비었습니다.");
        }
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
            }
        }
        int n;
        try {
            n = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 변환 실패: " + line);
        }
        if (n <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
        return n;
    }
}