import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class TimetableTest {

    Timetable timetable = new Timetable();

    private String input;
    private String output;

    public TimetableTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"2 5 1\n" +
                        "01001\n" +
                        "10110", "5"},
                {"2 5 0\n" +
                        "01001\n" +
                        "10110", "8"},
                {"3 4 6\n" +
                        "1111\n" +
                        "1111\n" +
                        "1111", "6"},
                {"10 10 0\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001\n" +
                        "1000000001", "100"},
                {"4 16 11\n" +
                        "1111011101111111\n" +
                        "0111110111111111\n" +
                        "0011101111011000\n" +
                        "0000010000001000", "30"}
        });
    }

    @Test
    public void testRun() throws Exception {
        Assert.assertEquals(output, timetable.run(new BufferedReader(new StringReader(input))));
    }
}