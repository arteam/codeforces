import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StringTypingTest {

    @ParameterizedTest
    @CsvSource({
            "7,abcabca,5",
            "8,abcdefgh,8",
            "8,aaaaaaaa,5",
            "4,abab,3"
    })
    void test(int length, String input, int result) {
        assertEquals(result, new StringTyping().run(length, input));
    }
}