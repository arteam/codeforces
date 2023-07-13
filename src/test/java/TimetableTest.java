import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimetableTest {

    @ParameterizedTest
    @CsvSource({
            "'2 5 1\n01001\n10110',5",
            "'2 5 0\n01001\n10110',8",
            "'3 4 6\n1111\n1111\n1111',6",
            "'10 10 0\n1000000001\n1000000001\n1000000001\n1000000001\n1000000001\n1000000001\n1000000001\n1000000001\n1000000001\n1000000001',100",
            "'4 16 11\n1111011101111111\n0111110111111111\n0011101111011000\n0000010000001000',30"
    })
    void testRun(String input, String output) throws Exception {
        assertEquals(output, new Timetable().run(new BufferedReader(new StringReader(input))));
    }
}