package advent2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3_2 {

    private static final Pattern REQUEST_PATTERN = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("#1 @ 1,3: 4x4\n" + "#2 @ 3,1: 4x4\n" + "#3 @ 5,5: 2x2"));
        new Task3_2().solve(reader);
    }

    public Set<String> solve(BufferedReader reader) throws IOException {
        String line;
        String[][] matrix = new String[1000][1000];
        Set<String> allIds = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            Matcher matcher = REQUEST_PATTERN.matcher(line);
            if (matcher.find()) {
                String id = matcher.group(1);
                int x = Integer.parseInt(matcher.group(2));
                int y = Integer.parseInt(matcher.group(3));
                int width = Integer.parseInt(matcher.group(4));
                int height = Integer.parseInt(matcher.group(5));
                for (int i = x; i < x + width; i++) {
                    for (int j = y; j < y + height; j++) {
                        matrix[i][j] = matrix[i][j] == null ? id : matrix[i][j] + ";" + id;
                    }
                }
                allIds.add(id);
            }
        }
        for (String[] row : matrix) {
            for (String rowIds : row) {
                if (rowIds != null && rowIds.contains(";")) {
                    for (String id : rowIds.split(";")) {
                        allIds.remove(id);
                    }
                }
            }
        }
        return allIds;
    }

}
