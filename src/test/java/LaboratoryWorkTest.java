import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class LaboratoryWorkTest {

    @ParameterizedTest
    @CsvSource({
            "'6\n-1 1 1 0 0 -1','2\n0 0 0 0 0 0 '",
            "'3\n100 100 101','3\n100 100 101 '",
            "'7\n-10 -9 -10 -8 -10 -9 -9','5\n-10 -10 -9 -9 -9 -9 -9 '"
    })
    void test(String input, String output) throws IOException {
        assertEquals(output, new LaboratoryWork().run(new BufferedReader(new StringReader(input))));
    }
}