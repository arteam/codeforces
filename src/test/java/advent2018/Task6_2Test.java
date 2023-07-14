package advent2018;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task6_2Test {

    @Test
    void solve() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/advent2018/task6.txt")))) {
            assertEquals(42966, new Task6_2().solve(reader));
        }
    }
}