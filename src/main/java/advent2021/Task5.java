package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task5 {

    private static final int SIZE = 1000;

    public static void main(String[] args) {
        System.out.println(Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).lines()
                        .collect(() -> new int[SIZE][SIZE], (m, s) -> {
                            String[] split = s.split(" -> ");
                            String[] from = split[0].split(",");
                            String[] to = split[1].split(",");
                            int fromX = Integer.parseInt(from[0]);
                            int fromY = Integer.parseInt(from[1]);
                            int toX = Integer.parseInt(to[0]);
                            int toY = Integer.parseInt(to[1]);
                            if (fromX == toX) {
                                for (int i = Math.min(fromY, toY); i <= Math.max(fromY, toY); i++) {
                                    m[i][fromX]++;
                                }
                            } else if (fromY == toY) {
                                for (int i = Math.min(fromX, toX); i <= Math.max(fromX, toX); i++) {
                                    m[fromY][i]++;
                                }
                            }
                        }, (a, b) -> {}))
                .mapToLong(value -> Arrays.stream(value).filter(i -> i >= 2).count())
                .sum());
    }
}
