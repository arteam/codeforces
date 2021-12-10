package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Task_10 {
    private static final Map<Character, Character> OPENER_CLOSERS = Map.of('[', ']', '{', '}', '<', '>', '(', ')');
    private static final Map<Character, Integer> CLOSING_ERROR_SCORES = Map.of(']', 57, ')', 3, '}', 1197, '>', 25137);

    public static void main(String[] args) {
        System.out.println(new BufferedReader(new InputStreamReader(System.in)).lines().mapToLong(line -> {
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
                   return CLOSING_ERROR_SCORES.get(c);
                }
            }
            return 0L;
        }).sum());
    }
}
