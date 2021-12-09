package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task9 {

    public static void main(String[] args) {
        int[][] map = new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .map(s -> s.chars().map(Character::getNumericValue).toArray())
                .toArray(int[][]::new);

        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i > 0 && map[i][j] >= map[i - 1][j]) {
                    continue;
                } else if (i < map.length - 1 && map[i][j] >= map[i + 1][j]) {
                    continue;
                } else if (j > 0 && map[i][j] >= map[i][j - 1]) {
                    continue;
                } else if (j < map[0].length - 1 && map[i][j] >= map[i][j + 1]) {
                    continue;
                }
                sum += map[i][j] + 1;
            }
        }
        System.out.println(sum);
    }
}
