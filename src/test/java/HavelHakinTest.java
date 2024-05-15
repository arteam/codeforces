import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HavelHakinTest {

    @ParameterizedTest
    @CsvSource(value = {"5, 3, 0, 2, 6, 2, 0, 7, 2, 5 | false",
            "4, 2, 0, 1, 5, 0 | false",
            "3, 1, 2, 3, 1, 0 | true",
            "16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16 | true",
            "14, 10, 17, 13, 4, 8, 6, 7, 13, 13, 17, 18, 8, 17, 2, 14, 6, 4, 7, 12 | false",
            "15, 18, 6, 13, 12, 4, 4, 14, 1, 6, 18, 2, 6, 16, 0, 9, 10, 7, 12, 3 | false",
            "6, 0, 10, 10, 10, 5, 8, 3, 0, 14, 16, 2, 13, 1, 2, 13, 6, 15, 5, 1 | false",},
            delimiter = '|')
    void run(String input, boolean expected) {
        assertEquals(expected, new HavelHakin().run(Arrays.stream(input.split(",")).map(String::trim).map(Integer::valueOf).collect(Collectors.toList())));
    }
}