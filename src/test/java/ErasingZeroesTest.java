import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ErasingZeroesTest {

    @ParameterizedTest
    @CsvSource({"010011,2", "0,0", "1111000,0",})
    void amountOfNonLeadingTrailingZeroes(String input, long expected) {
        Assertions.assertEquals(expected, ErasingZeroes.amountOfNonLeadingTrailingZeroes(input));
    }
}