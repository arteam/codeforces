import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Date: 11/27/15
 * Time: 1:29 PM
 *
 * @author Artem Prigoda
 */
public class QueriesOnStringTest {

    QueriesOnString queriesOnString = new QueriesOnString();

    @Test
    public void test1() throws Exception {
        String result = queriesOnString.shift("abacaba", Collections.singletonList("3 6 1"));
        Assert.assertEquals(result, "abbacaa");
    }

    @Test
    public void test2() throws Exception {
        String result = queriesOnString.shift("abbacaa", Collections.singletonList("1 4 2"));
        Assert.assertEquals(result, "baabcaa");
    }

    @Test
    public void test3() throws Exception {
        String result = queriesOnString.shift("abacaba", Arrays.asList("3 6 1", "1 4 2"));
        Assert.assertEquals(result, "baabcaa");
    }
}