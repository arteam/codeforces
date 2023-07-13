package advent2018;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

class Task2Test {

    @Test
    void test() throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream("task2.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            assertEquals(7470, new Task2().getChecksum(reader));
        }
    }
}