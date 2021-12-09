package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task9_2 {

    record Point(int i, int j) {
    }

    private static final int[][] map = new BufferedReader(new InputStreamReader(System.in))
            .lines()
            .map(s -> s.chars().map(Character::getNumericValue).toArray())
            .toArray(int[][]::new);

    public static void main(String[] args) {
        System.out.println(IntStream.range(0, map.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, map[0].length).mapToObj(j -> new Point(i, j)))
                .filter(point -> map[point.i][point.j] != 9)
                .map(point -> flood(point))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Point, Long>comparingByValue().reversed())
                .limit(3)
                .mapToLong(Map.Entry::getValue)
                .reduce(1, (a, b) -> a * b));
    }

    private static Point flood(Point source) {
        Point sink = null;
        for (Point neighbour : List.of(new Point(source.i - 1, source.j), new Point(source.i + 1, source.j),
                new Point(source.i, source.j - 1), new Point(source.i, source.j + 1))) {
            if (neighbour.i >= 0 && neighbour.i < map.length && neighbour.j >= 0 && neighbour.j < map[0].length &&
                    map[source.i][source.j] > map[neighbour.i][neighbour.j]) {
                sink = flood(new Point(neighbour.i, neighbour.j));
            }
        }
        return sink != null ? sink : source;
    }

}
