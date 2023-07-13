package advent2018;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task6Test {

    @Test
    void solve() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/advent2018/task6.txt")))) {
            assertEquals(4342, new Task6().solve(reader));
        }
    }
}