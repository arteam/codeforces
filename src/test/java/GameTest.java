import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @ParameterizedTest
    @CsvSource({
            "1, 5, 5",
            "3, 2 1 3, 2",
            "3, 2 2 2, 2",
            "9, 44 53 51 80 5 27 74 79 94, 53",
            "10, 38 82 23 37 96 4 81 60 67 86, 60"
    })
    void testRun(int amount, String source, int result) {
        assertEquals(result, new Game().getLastNumber(source, amount));
    }
}
