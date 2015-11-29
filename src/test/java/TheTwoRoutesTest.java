import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Date: 11/29/15
 * Time: 8:33 PM
 *
 * @author Artem Prigoda
 */
public class TheTwoRoutesTest {

    @Test
    public void test1() throws Exception {
        int result = new TheTwoRoutes().shortestPath(4, 2, Arrays.asList("1 3", "3 4"));
        assertEquals(result, 2);
    }

    @Test
    public void test2() throws Exception {
        int result = new TheTwoRoutes().shortestPath(4, 6, Arrays.asList("1 2",
                "1 3",
                "1 4",
                "2 3",
                "2 4",
                "3 4")
        );
        assertEquals(result, -1);
    }

    @Test
    public void test3() throws Exception {
        int result = new TheTwoRoutes().shortestPath(5, 5, Arrays.asList("4 2",
                "3 5",
                "4 5",
                "5 1",
                "1 2")
        );
        assertEquals(result, 3);
    }
}