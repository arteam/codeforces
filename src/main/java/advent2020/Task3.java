package advent2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task3 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Task3().solve(new BufferedReader(new InputStreamReader(System.in, UTF_8))));
    }

    private int solve(BufferedReader reader) throws IOException {
        List<String> grid = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            grid.add(line);
        }
        int height = grid.size();
        int width = grid.get(0).length();
        int i = 0, j = 0, trees = 0;
        while (i < height - 1) {
            i++;
            j = (j + 3) % width;
            if (grid.get(i).charAt(j) == '#') {
                trees++;
            }
        }
        return trees;
    }
}
