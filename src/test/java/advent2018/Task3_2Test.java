package advent2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Task3_2Test {

    @Test
    void solve() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Task3.class.getResourceAsStream("/advent2018/task3.txt")));) {
            Assertions.assertEquals(Collections.singleton("1276"), new Task3_2().solve(reader));
        }
    }
}