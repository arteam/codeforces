package advent2018;

import java.io.BufferedReader;

public class Task1 {

    public long solve(BufferedReader reader) {
        return reader.lines().map(Integer::parseInt).reduce(0, (a, b) -> a + b);
    }
}
