package advent2018;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task7Test {

    @Test
    void solve() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/advent2018/task7.txt")))) {
            assertEquals("MNOUBYITKXZFHQRJDASGCPEVWL", new Task7().solve(reader));
        }
    }
}