import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class InterceptedMessageTest {
    InterceptedMessage interceptedMessage = new InterceptedMessage();

    private String firstMessage;
    private String secondMessage;
    private String result;

    public InterceptedMessageTest(String firstMessage, String secondMessage, String result) {
        this.firstMessage = firstMessage;
        this.secondMessage = secondMessage;
        this.result = result;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {"2 5 3 1 11 4 4", "7 8 2 4 1 8", "3"},
                {"1 10 100", "1 100 10", "2"},
                {"4", "1 1 1 1", "1"}
        });
    }

    @Test
    public void testRun() {
        assertEquals(result, interceptedMessage.run(firstMessage, secondMessage));
    }
}