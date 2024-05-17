import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErasingZeroesTest {

    @ParameterizedTest
    @CsvSource({"010011,2", "0,0", "1111000,0",})
    void amountOfNonLeadingTrailingZeroes(String input, long expected) {
        assertEquals(expected, ErasingZeroes.amountOfNonLeadingTrailingZeroes(input));
    }
}