import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class FriendsMeetingTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {3, 4, 1},
                {101, 99, 2},
                {5, 10, 9},
        });
    }

    private int a;
    private int b;
    private int result;

    public FriendsMeetingTest(int a, int b, int result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    @Test
    public void test() {
        Assert.assertEquals(result, new FriendsMeeting().run(a, b));
    }

}