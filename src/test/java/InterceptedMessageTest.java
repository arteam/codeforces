import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterceptedMessageTest {

    @ParameterizedTest
    @CsvSource({
            "2 5 3 1 11 4 4, 7 8 2 4 1 8, 3",
            "1 10 100, 1 100 10, 2",
            "4, 1 1 1 1, 1"
    })
    void testRun(String firstMessage, String secondMessage, String result) {
        assertEquals(result, new InterceptedMessage().run(firstMessage, secondMessage));
    }
}