import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Date: 11/26/15
 * Time: 4:45 PM
 */
public class TwoBasesTest {

    TwoBases twoBases = new TwoBases();

    @Test
    public void test1() throws Exception {
        String result = twoBases.compare(2, "1 0 1 1 1 1", 10, "4 7");
        Assert.assertEquals(result, "=");
    }

    @Test
    public void test2() throws Exception {
        String result = twoBases.compare(3, "1 0 2", 5, "2 4");
        Assert.assertEquals(result, "<");
    }

    @Test
    public void test3() throws Exception {
        String result = twoBases.compare(16, "15 15 4 0 0 7 10", 9, "4 8 0 3 1 5 0");
        Assert.assertEquals(result, ">");
    }
}