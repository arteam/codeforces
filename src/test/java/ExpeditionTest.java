import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpeditionTest {

    @ParameterizedTest
    @CsvSource({
            "4, 1 5 2 1 1 1 2 5 7 2, 2",
            "100, 1, 0",
            "2, 5 4 3 2 1, 1",
            "3, 42 42 42 42 42 42 42 42 42, 3",
            "1, 100, 1",
    })
    void test(int participants, String input, int tenure) {
        assertEquals(tenure, new Expedition().run(participants,
                Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt)
                        .toArray()));
    }
}