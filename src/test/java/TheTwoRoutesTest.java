import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class TheTwoRoutesTest {

    static Stream<Arguments> data() {
        return Stream.of(
                of(4, 2, asList("1 3", "3 4"), 2),
                of(4, 6, asList("1 2", "1 3", "1 4", "2 3", "2 4", "3 4"), -1),
                of(5, 5, asList("4 2", "3 5", "4 5", "5 1", "1 2"), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void test(int vertexes, int amountEdges, List<String> edges, int result) {
        assertEquals(result, new TheTwoRoutes().shortestPath(vertexes, amountEdges, edges));
    }
}