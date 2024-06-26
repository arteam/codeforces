import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FriendsMeetingTest {

    @ParameterizedTest
    @CsvSource({
            "3,4,1",
            "101,99,2",
            "5,10,9"
    })
    void test(int a, int b, int result) {
        assertEquals(result, new FriendsMeeting().run(a, b));
    }

}