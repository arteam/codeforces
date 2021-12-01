package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Task1 {

    public static void main(String[] args) {
        int[] lines = new BufferedReader(new InputStreamReader(System.in)).lines().mapToInt(Integer::parseInt).toArray();
        System.out.println(IntStream.range(1, lines.length)
                .filter(i -> lines[i] - lines[i - 1] > 0)
                .count());
    }
}
