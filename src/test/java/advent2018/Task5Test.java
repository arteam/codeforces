package advent2018;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class Task5Test {

    @Test
    void solve() {
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/advent2018/test5.txt"))) {
            System.out.println(new Task5().solve(scanner.nextLine()));
        }
    }
}