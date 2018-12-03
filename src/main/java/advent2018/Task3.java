package advent2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private static final Pattern REQUEST_PATTERN = Pattern.compile("#\\d+ @ (\\d+),(\\d+): (\\d+)x(\\d+)");

    public int solve(BufferedReader reader) throws IOException {
        String line;
        int[][] matrix = new int[1000][1000];
        while ((line = reader.readLine()) != null) {
            Matcher matcher = REQUEST_PATTERN.matcher(line);
            if (matcher.find()) {
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));
                int width = Integer.parseInt(matcher.group(3));
                int height = Integer.parseInt(matcher.group(4));
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        matrix[i][j]++;
                    }
                }
            }
        }
        int overlaps = 0;
        for (int[] row : matrix) {
            for (int i : row) {
                if (i > 1) {
                    overlaps++;
                }
            }
        }
        return overlaps;
    }
}
