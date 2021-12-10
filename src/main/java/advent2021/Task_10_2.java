package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Task_10_2 {
    private static final Map<Character, Character> OPENER_CLOSERS = Map.of('[', ']', '{', '}', '<', '>', '(', ')');
    private static final Map<Character, Integer> CLOSING_ERROR_SCORES = Map.of(']', 2, ')', 1, '}', 3, '>', 4);

    public static void main(String[] args) {
        long[] scores = new BufferedReader(new InputStreamReader(System.in)).lines().mapToLong(line -> {
            Deque<Character> openersDeque = new ArrayDeque<>();
            for (char c : line.toCharArray()) {
                if (OPENER_CLOSERS.containsKey(c)) {
                    openersDeque.addFirst(c);
                    continue;
                }
                if (openersDeque.isEmpty()) {
                    break;
                }
                if (c != OPENER_CLOSERS.get(openersDeque.removeFirst())) {
                    return 0L;
                }
            }
            long score = 0;
            for (Character c : openersDeque) {
                score = score * 5 + CLOSING_ERROR_SCORES.get(OPENER_CLOSERS.get(c));
            }
            return score;
        }).filter(l -> l > 0).sorted().toArray();
        System.out.println(scores[scores.length / 2]);
    }
}
