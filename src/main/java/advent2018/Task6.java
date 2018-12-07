package advent2018;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Task6 {

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
                int minManhattenDistance = Integer.MAX_VALUE;
                int minManhattenDistanceElement = 0;
                for (int k = 0; k < coordinates.size(); k++) {
                    Point point = coordinates.get(k);
                    if (i == point.x && j == point.y) {
                        minManhattenDistanceElement = k;
                        break;
                    }
                    int manhattenDistance = Math.abs(i - point.x) + Math.abs(j - point.y);
                    if (manhattenDistance < minManhattenDistance) {
                        minManhattenDistance = manhattenDistance;
                        minManhattenDistanceElement = k;
                    } else if (manhattenDistance == minManhattenDistance) {
                        minManhattenDistanceElement = -1;
                    }
                }
                grid[j][i] = minManhattenDistanceElement;
            }
        }
        Set<Integer> infiteLocations = new HashSet<>();
        for (int i = 0; i < SIZE; i++) {
            infiteLocations.add(grid[0][i]);
            infiteLocations.add(grid[SIZE - 1][i]);
            infiteLocations.add(grid[i][0]);
            infiteLocations.add(grid[i][SIZE - 1]);
        }

        int[] areaSizes = new int[SIZE];
        for (int i = 1; i < SIZE - 1; i++) {
            for (int j = 1; j < SIZE - 1; j++) {
                int v = grid[i][j];
                if (!infiteLocations.contains(v)) {
                    areaSizes[v]++;
                }
            }
        }
        return Arrays.stream(areaSizes).max().getAsInt();
    }

}