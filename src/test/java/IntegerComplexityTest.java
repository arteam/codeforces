import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerComplexityTest {

    @ParameterizedTest
    @CsvSource({
            "12345, 838",
            "12, 7",
            "456, 43",
            "4567, 4568",
            "1234567891011, 2544788"
    })
    void testRun(long input, long output) {
        assertEquals(output, new IntegerComplexity().run(input));
    }
}