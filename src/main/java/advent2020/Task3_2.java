package advent2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task3_2 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Task3_2().solve(new BufferedReader(new InputStreamReader(System.in, UTF_8))));
    }

    private long solve(BufferedReader reader) throws IOException {
        List<String> grid = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            grid.add(line);
        }
        return solve(grid, 1, 1) *
                solve(grid, 3, 1) *
                solve(grid, 5, 1) *
                solve(grid, 7, 1) *
                solve(grid, 1, 2);
    }

    private long solve(List<String> grid, int right, int down) {
        int height = grid.size();
        int width = grid.get(0).length();
        int i = 0, j = 0;
        long trees = 0;
        while (i < height - 1) {
            i += down;
            j = (j + right) % width;
            if (grid.get(i).charAt(j) == '#') {
                trees++;
            }
        }
        return trees;
    }
}
