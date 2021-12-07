package advent2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task7 {

    public static void main(String[] args) throws IOException {
        int[] positions = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.stream(positions)
                .mapToLong(a -> Arrays.stream(positions).map(b -> Math.abs(b - a)).sum())
                .min()
                .orElse(0));
    }
}
