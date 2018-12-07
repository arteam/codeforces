package advent2018;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task6_2 {

    private static final int SIZE = 1000;

    public int solve(BufferedReader reader) throws IOException {
        String line;
        List<Point> coordinates = new ArrayList<>();
        int[][] grid = new int[SIZE][SIZE];
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(", ");
            coordinates.add(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int totalManhattenDistance = 0;
                for (Point point : coordinates) {
                    totalManhattenDistance += Math.abs(i - point.x) + Math.abs(j - point.y);
                }
                if (totalManhattenDistance < 10000) {
                    grid[j][i] = totalManhattenDistance;
                }
            }
        }
        int areaSize = 0;
        for (int i = 1; i < SIZE - 1; i++) {
            for (int j = 1; j < SIZE - 1; j++) {
                int v = grid[i][j];
                boolean inRegion = grid[i][j - 1] > 0 || grid[i][j + 1] > 0 || grid[i + 1][j] > 0 || grid[i - 1][j] > 0;
                if (v > 0 && inRegion) {
                    areaSize++;
                }
            }
        }
        return areaSize;
    }

}