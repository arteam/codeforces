import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromicNumbersTest {

    @ParameterizedTest
    @CsvSource({
            "24, 1, 66",
            "28, 2, 121",
            "11, 0, 11",
            "68, 3, 1111",
            "123, 1, 444",
            "286, 23, 8813200023188",
            "196196871, 45, 4478555400006996000045558744",
    })
    void test(int input, int steps, BigInteger palindrome) {
        PalindromicNumbers.StepsPalindrome result = new PalindromicNumbers().run(input);
        assertEquals(steps, result.steps);
        assertEquals(palindrome, result.palindrome);
    }
}