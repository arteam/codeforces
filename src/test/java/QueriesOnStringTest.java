import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.params.provider.Arguments.of;

class QueriesOnStringTest {

    static Stream<Arguments> data() {
        return Stream.of(
                of("abacaba", singletonList("3 6 1"), "abbacaa"),
                of("abbacaa", singletonList("1 4 2"), "baabcaa"),
                of("abacaba", asList("3 6 1", "1 4 2"), "baabcaa")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void test(String source, List<String> rotations, String result) {
        Assertions.assertEquals(result, new QueriesOnString().shift(source, rotations));
    }
}