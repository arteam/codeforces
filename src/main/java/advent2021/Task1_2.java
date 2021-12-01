package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Task1_2 {

    public static void main(String[] args) {
        int[] lines = new BufferedReader(new InputStreamReader(System.in)).lines().mapToInt(Integer::parseInt).toArray();
        System.out.println(IntStream.range(3, lines.length)
                .filter(i -> lines[i] - lines[i - 3] > 0)
                .count());
    }
}
