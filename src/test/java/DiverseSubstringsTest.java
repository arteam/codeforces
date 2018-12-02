import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DiverseSubstringsTest {

    @ParameterizedTest
    @CsvSource({
            "oomph,'oomp'",
            "codeforces,co",
            "aaaaa,NO",
            "g,NO",
            "xxxxy,xy",
            "ab,ab",
            "aab,ab",
            "aaabaaa,ab",
            "bbaaaaabaaaabbabaaaababaa,bbaa",
            "aaaabbbbb,aaaabbbb",
    })
    void testRun(String input, String expectedOutput) {
        Assertions.assertEquals(expectedOutput, new DiverseSubstrings().getDiverseSubstring(input).orElse("NO"));
    }
}