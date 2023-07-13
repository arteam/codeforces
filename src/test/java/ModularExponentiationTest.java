import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModularExponentiationTest {

    @ParameterizedTest
    @CsvSource({
            "4,42,10",
            "1,58,0",
            "98765432,23456789,23456789"
    })
    void test(int n, int m, int result) {
        assertEquals(result, new ModularExponentiation().run(n, m));
    }
}