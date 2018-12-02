package advent2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class Task1_2Test {

    @Test
    void testSolve() throws Exception {
        try (InputStream inputStream = Task1_2Test.class.getResourceAsStream("task1.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            Assertions.assertEquals(59908, new Task1_2().solve(reader));
        }
    }
}