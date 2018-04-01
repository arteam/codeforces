import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExamineTest {

    @ParameterizedTest
    @CsvSource({
            "1,'1\n1'",
            "2,'1\n1'",
            "3,'2\n3 1'",
            "4,'4\n3 1 4 2'",
            "5,'5\n3 1 4 2 5'",
            "6,'6\n4 1 5 2 6 3'",
            "7,'7\n4 1 5 2 6 3 7'",
            "8,'8\n5 1 6 2 7 3 8 4'"
    })
    void testRun(String number, String expectedOutput) {
        Assertions.assertEquals(expectedOutput, new Examine().run(number));
    }
}
