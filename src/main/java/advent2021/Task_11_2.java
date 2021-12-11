package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Task_11_2 {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        int[][] map = new BufferedReader(new InputStreamReader(System.in)).lines()
                .map(s -> s.chars().map(Character::getNumericValue).toArray())
                .toArray(int[][]::new);
        for (int step = 1; ; step++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j]++;
                }
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] > 9) {
                        flash(i, j, map);
                    }
                }
            }
            if (Arrays.stream(map).allMatch(row -> Arrays.stream(row).allMatch(e -> e == 0))) {
                System.out.println(step);
                break;
            }
        }
    }

    static void flash(int i, int j, int[][] map) {
        map[i][j] = 0;
        for (int stepI : List.of(0, -1, 1)) {
            for (int stepJ : List.of(0, -1, 1)) {
                int ni = i + stepI;
                int nj = j + stepJ;
                if (ni < 0 || ni >= SIZE || nj < 0 || nj >= SIZE) {
                    continue;
                }
                if (map[ni][nj] == 0) {
                    continue;
                }
                if (++map[ni][nj] > 9) {
                    flash(ni, nj, map);
                }
            }
        }
    }
}
