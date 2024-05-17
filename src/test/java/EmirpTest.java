import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmirpTest {


    @ParameterizedTest
    @CsvSource({
            "10000, 10100, [10007; 10009; 10039; 10061; 10067; 10069; 10079; 10091]",
            "999810, 999999, [999853; 999931; 999983]",
    })
    void test(int from, int to, String result) {
        assertEquals(result, new Emirp().getEmirpNumbers(from, to)
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining("; ", "[", "]")));
    }
}