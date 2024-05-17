package advent2018;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    @Test
    void testSolve() throws Exception {
        try (InputStream is = Task1Test.class.getResourceAsStream("task1.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            assertEquals(442, new Task1().solve(reader));
        }
    }
}