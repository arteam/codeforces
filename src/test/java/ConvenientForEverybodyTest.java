import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class ConvenientForEverybodyTest {

    @ParameterizedTest
    @CsvSource({
            "'3\n1 2 3\n1 3', 3",
            "'2\n5072 8422\n1 2',2",
            "'10\n7171 2280 6982 9126 9490 2598 569 6744 5754 1855\n7 9',4",
            "'10\n5827 8450 8288 5592 6627 8234 3557 7568 4607 6949\n2 10',4"
    })
    void testRun(String input, String expectedOutput) throws IOException {
        Assertions.assertEquals(expectedOutput, new ConvenientForEverybody().run(new BufferedReader(new StringReader(input))));
    }
}