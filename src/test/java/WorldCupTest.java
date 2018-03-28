import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class WorldCupTest {

    @Parameterized.Parameters
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {4, 1, 2, "1"},
                {8, 2, 6, "Final!"},
                {8, 7, 5, "2"},
                {2, 1, 2, "Final!"},
                {256, 1, 256, "Final!"},
                {4, 2, 3, "Final!"},
                {8, 8, 7, "1"},
                {32, 25, 28, "2"},
        });
    }

    private int numberOfTeams;
    private int firstTeamId;
    private int secondTeamId;
    private String result;

    public WorldCupTest(int numberOfTeams, int firstTeamId, int secondTeamId, String result) {
        this.numberOfTeams = numberOfTeams;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.result = result;
    }

    @Test
    public void test() {
        Assert.assertEquals(result, new WorldCup().run(numberOfTeams, firstTeamId, secondTeamId));
    }
}