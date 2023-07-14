package advent2018;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5_2Test {

    @Test
    void solve() {
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/advent2018/test5.txt"))) {
            assertEquals(5148, new Task5_2().getShortestPolymerWithRemovedUnitsOfSameType(scanner.nextLine()));
        }
    }
}