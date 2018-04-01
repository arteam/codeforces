import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

class FriendsMeetingTest {

    @ParameterizedTest
    @CsvSource({
            "3,4,1",
            "101,99,2",
            "5,10,9"
    })
    void test(int a, int b, int result) {
        Assertions.assertEquals(result, new FriendsMeeting().run(a, b));
    }

}