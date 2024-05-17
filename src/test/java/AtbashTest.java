import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AtbashTest {


    @ParameterizedTest
    @CsvSource({
            "foobar, ullyzi",
            "wizard, draziw",
            "/r/dailyprogrammer, /i/wzrobkiltiznnvi",
            "gsrh rh zm vcznkov lu gsv zgyzhs xrksvi, this is an example of the atbash cipher",
    })
    void test(String input, String output) {
        assertEquals(output, new Atbash().run(input));
    }
}