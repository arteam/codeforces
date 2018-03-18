import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PointsOnLineTest {

    PointsOnLine pointsOnLine = new PointsOnLine();

    private String input;
    private String output;

    public PointsOnLineTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"3 1\n" +
                        "2 1 4", "1"},
                {"3 0\n" +
                        "7 7 7", "0"},
                {"6 3\n" +
                        "1 3 4 6 9 10", "3"},
                {"7 4\n" +
                        "1 3 4 9 10 11 12", "3"}
        });
    }

    @Test
    public void testRun() throws Exception {
        assertEquals(output, pointsOnLine.run(new BufferedReader(new StringReader(input))));
    }
}