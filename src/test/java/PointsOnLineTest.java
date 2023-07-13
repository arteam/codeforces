import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointsOnLineTest {

    @ParameterizedTest
    @CsvSource({
            "'3 1\n2 1 4',1",
            "'3 0\n7 7 7',0",
            "'6 3\n1 3 4 6 9 10',3",
            "'7 4\n1 3 4 9 10 11 12',3"
    })
    void testRun(String input, String output) throws Exception {
        assertEquals(output, new PointsOnLine().run(new BufferedReader(new StringReader(input))));
    }
}