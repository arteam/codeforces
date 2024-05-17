package advent2018;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3_2Test {

    @Test
    void solve() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Task3.class.getResourceAsStream("/advent2018/task3.txt")));) {
            assertEquals(Collections.singleton("1276"), new Task3_2().solve(reader));
        }
    }
}