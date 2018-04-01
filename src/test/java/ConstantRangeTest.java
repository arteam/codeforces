import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConstantRangeTest {

    @ParameterizedTest
    @CsvSource({
            "5, 1 2 3 3 2, 4",
            "11, 5 4 5 5 6 7 8 8 8 7 6, 5",
            "2, 1 2, 2",
            "2, 1 3, 1",
            "5, 2 4 5 5 5 3, 4",
    })
    void test(int amount, String input, int maxLength) {
        Assertions.assertEquals(maxLength, new ConstantRange().getMaxLength(amount, input));
    }

}