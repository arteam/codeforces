import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class CheeseBoardTest {

    @ParameterizedTest
    @CsvSource({
            "'9\nbrie soft\ncamembert soft\nfeta soft\ngoat soft\nmuenster soft\nasiago hard\ncheddar hard\ngouda hard\nswiss hard', 3",
            "'6\nparmesan hard\nemmental hard\nedam hard\ncolby hard\ngruyere hard\nasiago hard', 4",
            "'9\ngorgonzola soft\ncambozola soft\nmascarpone soft\nricotta soft\nmozzarella soft\nbryndza soft\njarlsberg soft\nhavarti soft\nstilton soft\n', 5",
            "'2\nmuenster soft\nasiago hard', 2",
            "'1\nprovolone hard', 1"
    })
    void test(String input, int result) throws IOException {
        Assertions.assertEquals(result, new CheeseBoard().run(new BufferedReader(new StringReader(input))));
    }
}