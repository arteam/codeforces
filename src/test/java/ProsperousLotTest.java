import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        Assertions.assertEquals(result, new ProsperousLot().solve(numberOfLoops));
    }
}