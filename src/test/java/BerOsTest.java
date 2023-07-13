import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BerOsTest {

    @Test
    void testFind1() {
        List<String> results = new BerOs().find(Arrays.asList("test",
                "contests",
                "test.",
                ".test"), Arrays.asList(
                "ts",
                ".",
                "st.",
                ".test",
                "contes.",
                "st"
        ));
        assertEquals(Arrays.asList(
                "1 contests",
                "2 test.",
                "1 test.",
                "1 .test",
                "0 -",
                "4 test"
        ), results);
    }

    @Test
    void testFind2() {
        List<String> results = new BerOs().find(Arrays.asList(
                ".a",
                "a.",
                "aa",
                "a",
                "aaa"
        ), Arrays.asList(
                ".",
                "a",
                "aa",
                ".a",
                "a.",
                "..",
                "aaa",
                ".aa",
                "      ..a",
                "a.."
        ));
        assertEquals(Arrays.asList("2 .a", "5 aa", "2 aa", "1 .a", "1 a.", "0 -",
                "1 aaa", "0 -", "0 -", "0 -"), results);
    }
}