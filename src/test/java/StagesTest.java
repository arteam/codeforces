import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StagesTest {

    @ParameterizedTest
    @CsvSource({
            "3,xyabd,29",
            "4,problem,34",
            "2,ab,-1",
            "1,abaabbaaabbb,1"
    })
    void test(int requiredStages, String stages, int expectedWeight) {
        assertEquals(expectedWeight, new Stages().run(requiredStages, stages));
    }
}