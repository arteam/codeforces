import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PetyaOrigamiTest {

    @ParameterizedTest
    @CsvSource({
            "3 5,10",
            "15 6,38",
            "1 1,15",
    })
    void testRun(String input, long output) {
        Assertions.assertEquals(output, new PetyaOrigami().solve(input));
    }
}