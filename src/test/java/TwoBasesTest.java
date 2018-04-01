import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TwoBasesTest {

    @ParameterizedTest
    @CsvSource({
            "2, 1 0 1 1 1 1, 10, 4 7, =",
            "3, 1 0 2, 5, 2 4, <",
            "16, 15 15 4 0 0 7 10, 9, 4 8 0 3 1 5 0, >"
    })
    void test(int xRadix, String xSymbols, int yRadix, String ySymbols, String result) {
        Assertions.assertEquals(result, new TwoBases().compare(xRadix, xSymbols, yRadix, ySymbols));
    }

}