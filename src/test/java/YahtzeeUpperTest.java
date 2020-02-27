import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YahtzeeUpperTest {


    @ParameterizedTest
    @CsvSource(value = {"2, 3, 5, 5, 6 | 10",
                        "1, 1, 1, 1, 3 | 4",
                        "1, 1, 1, 3, 3 | 6",
                        "1, 2, 3, 4, 5 | 5",
                        "6, 6, 6, 6, 6 | 30",
                        "1654, 1654, 50995, 30864, 1654, 50995, 22747," +
                        "1654, 1654, 1654, 1654, 1654, 30864, 4868, 1654, 4868, 1654," +
                        "30864, 4868, 30864 | 123456",
    }, delimiter = '|')
    void test(String input, int result) {
        assertEquals(result, YahtzeeUpper.maximum(Arrays.stream(input.split(",")).map(s -> Integer.valueOf(s.trim())).collect(Collectors.toList())));
    }
}