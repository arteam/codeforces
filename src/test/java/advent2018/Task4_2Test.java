package advent2018;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task4_2Test {

    @Test
    void test() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/advent2018/test4.txt")))) {
            assertEquals(134511, new Task4_2().solve(reader));
        }
    }
}