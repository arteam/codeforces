import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetyaOrigamiTest {

    @ParameterizedTest
    @CsvSource({
            "3 5,10",
            "15 6,38",
            "1 1,15",
    })
    void testRun(String input, long output) {
        assertEquals(output, new PetyaOrigami().solve(input));
    }
}