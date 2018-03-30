import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class LaboratoryWorkTest {
    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"6\n-1 1 1 0 0 -1", "2\n0 0 0 0 0 0 "},
                {"3\n100 100 101", "3\n100 100 101 "},
                {"7\n-10 -9 -10 -8 -10 -9 -9", "5\n-10 -10 -9 -9 -9 -9 -9 "},
        });
    }

    private String input;
    private String output;

    public LaboratoryWorkTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Test
    public void test() throws IOException {
        Assert.assertEquals(output, new LaboratoryWork().run(new BufferedReader(new StringReader(input))));
    }
}