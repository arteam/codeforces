import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompatiblePairTest {

    @ParameterizedTest
    @CsvSource({
            "'2 2\n20 18\n2 14', 252",
            "'5 3\n-1 0 1 2 3\n-1 0 1', 2"
    })
    public void test(String input, int output) throws IOException {
        assertEquals(output, new CompatiblePair().solve(new BufferedReader(new StringReader(input))));
    }
}