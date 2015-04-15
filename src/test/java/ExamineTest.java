import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Date: 15.04.15
 * Time: 13:06
 *
 * @author Artem Prigoda
 */
@RunWith(value = Parameterized.class)
public class ExamineTest {

    Examine examine = new Examine();

    private String number;
    private String expectedOutput;

    public ExamineTest(String number, String expectedOutput) {
        this.number = number;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"1", "1\n1"},
                {"2", "1\n1"},
                {"3", "2\n3 1"},
                {"4", "4\n3 1 4 2"},
                {"5", "5\n3 1 4 2 5"},
                {"6", "6\n4 1 5 2 6 3"},
                {"7", "7\n4 1 5 2 6 3 7"},
                {"8", "8\n5 1 6 2 7 3 8 4"}});
    }

    @Test
    public void testRun() throws Exception {
       assertEquals(expectedOutput, examine.run(number));
    }
}
