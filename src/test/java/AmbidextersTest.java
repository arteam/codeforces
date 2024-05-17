import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmbidextersTest {

    @ParameterizedTest
    @CsvSource({
            "1 4 2, 6",
            "5 5 5, 14",
            "0 2 0, 0",
            "1 4 7, 12"
    })
    void testRun(String input, String output) {
        assertEquals(output, new Ambidexters().run(input));
    }
}