import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProsperousLotTest {

    @ParameterizedTest
    @CsvSource({
            "1, 4",
            "2, 8",
            "6, 888",
            "5, 884",
            "37, -1",
            "36, 888888888888888888",
    })
    void test(int numberOfLoops, String result) {
        assertEquals(result, new ProsperousLot().solve(numberOfLoops));
    }
}