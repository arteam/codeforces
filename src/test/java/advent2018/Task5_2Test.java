package advent2018;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class Task5_2Test {

    @Test
    void solve() {
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/advent2018/test5.txt"))) {
            Assertions.assertEquals(5148, new Task5_2().getShortestPolymerWithRemovedUnitsOfSameType(scanner.nextLine()));
        }
    }
}