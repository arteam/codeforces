import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ModularExponentiationTest {

    @ParameterizedTest
    @CsvSource({
            "4,42,10",
            "1,58,0",
            "98765432,23456789,23456789"
    })
    void test(int n, int m, int result) {
        Assertions.assertEquals(result, new ModularExponentiation().run(n, m));
    }
}