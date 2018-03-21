import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IntegerComplexityTest {

    IntegerComplexity integerComplexity = new IntegerComplexity();

    private long input;
    private long output;

    public IntegerComplexityTest(long input, long output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {12345, 838},
                {12, 7},
                {456, 43},
                {4567, 4568},
                {1234567891011L, 2544788},
        });
    }

    @Test
    public void testRun() throws Exception {
        assertEquals(output, integerComplexity.run(input));
    }
}