import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ConvenientForEverybodyTest {
    ConvenientForEverybody convenientForEverybody = new ConvenientForEverybody();

    private String input;
    private String expectedOutput;

    public ConvenientForEverybodyTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"3\n" +
                        "1 2 3\n" +
                        "1 3", "3"},
                {"5\n" +
                        "1 2 3 4 1\n" +
                        "1 3", "4"},
                {"2\n" +
                        "5072 8422\n" +
                        "1 2\n", "2"},
                {"10\n" +
                        "7171 2280 6982 9126 9490 2598 569 6744 5754 1855\n" +
                        "7 9\n", "4"},
                {"10\n" +
                        "5827 8450 8288 5592 6627 8234 3557 7568 4607 6949\n" +
                        "2 10\n", "4"}
        });
    }

    @Test
    public void testRun() throws Exception {
        assertEquals(expectedOutput, convenientForEverybody.run(new BufferedReader(new StringReader(input))));
    }
}