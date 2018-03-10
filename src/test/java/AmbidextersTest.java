import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AmbidextersTest {

    Ambidexters ambidexters = new Ambidexters();

    private String input;
    private String output;

    public AmbidextersTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"1 4 2", "6"},
                {"5 5 5", "14"},
                {"0 2 0", "0"},
                {"1 4 7", "12"},
        });
    }

    @Test
    public void testRun() throws Exception {
        assertEquals(output, ambidexters.run(input));
    }
}