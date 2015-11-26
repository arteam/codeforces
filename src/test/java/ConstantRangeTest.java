import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.*;

/**
 * Date: 11/26/15
 * Time: 12:09 PM
 *
 * @author Artem Prigoda
 */
public class ConstantRangeTest {

    ConstantRange constantRange = new ConstantRange();

    @Test
    public void test1() {
        int maxLength = constantRange.getMaxLength(5, "1 2 3 3 2");
        Assert.assertEquals(maxLength, 4);
    }

    @Test
    public void test2() {
        int maxLength = constantRange.getMaxLength(11, "5 4 5 5 6 7 8 8 8 7 6");
        Assert.assertEquals(maxLength, 5);
    }

    @Test
    public void test3() {
        int maxLength = constantRange.getMaxLength(2, "1 2");
        Assert.assertEquals(maxLength, 2);
    }

    @Test
    public void test4() {
        int maxLength = constantRange.getMaxLength(2, "1 3");
        Assert.assertEquals(maxLength, 1);
    }

    @Test
    public void test5() {
        int maxLength = constantRange.getMaxLength(5, "2 4 5 5 5 3");
        Assert.assertEquals(maxLength, 4);
    }

    @Test
    public void tl() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        int amount = 85897;
        for (int i = 0; i < amount; i++) {
            stringJoiner.add("10000");
        }
        long time = System.nanoTime();
        int maxLength = constantRange.getMaxLength(amount, stringJoiner.toString());
        System.out.println(maxLength);
        System.out.println((System.nanoTime() - time) / 1000000);
    }
}