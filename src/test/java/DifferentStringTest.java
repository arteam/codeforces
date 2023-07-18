import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferentStringTest {

    @Test
    void test() {
        String result = new DifferentString().run("""
                8
                codeforces
                aaaaa
                xxxxy
                co
                d
                nutdealer
                mwistht
                hhhhhhhhhh""");
        assertEquals("""
                YES
                ocdeforces
                NO
                YES
                yxxxx
                YES
                oc
                NO
                YES
                untdealer
                YES
                wmistht
                NO
                """, result);
    }
}