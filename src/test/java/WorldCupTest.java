import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorldCupTest {

    @ParameterizedTest
    @CsvSource({
            "4, 1, 2, 1",
            "8, 2, 6, Final!",
            "8, 7, 5, 2",
            "2, 1, 2, Final!",
            "256, 1, 256, Final!",
            "4, 2, 3, Final!",
            "8, 8, 7, 1",
            "32, 25, 28, 2"
    })
    void test(int numberOfTeams, int firstTeamId, int secondTeamId, String result) {
        assertEquals(result, new WorldCup().run(numberOfTeams, firstTeamId, secondTeamId));
    }
}