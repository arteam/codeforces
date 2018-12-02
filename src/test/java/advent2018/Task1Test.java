package advent2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Task1Test {

    @Test
    void testSolve() throws Exception {
        try (InputStream is = Task1Test.class.getResourceAsStream("task1.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            Assertions.assertEquals(442, new Task1().solve(reader));
        }
    }
}