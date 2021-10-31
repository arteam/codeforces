package advent2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task5 {

    public static void main(String[] args) {
        new Task5().solve(new BufferedReader(new InputStreamReader(System.in)));
    }

    void solve(BufferedReader reader) {
        System.out.println(reader.lines().mapToInt(line -> {
            int fromRow = 0;
            int toRow = 127;
            for (int i = 0; i < 7; i++) {
                int middle = (fromRow + toRow) / 2;
                char c = line.charAt(i);
                if (c == 'F') {
                    toRow = middle;
                } else if (c == 'B') {
                    fromRow = middle;
                }
            }
            int row = Math.max(fromRow, toRow);
            int fromSeat = 0;
            int toSeat = 7;
            for (int i = 7; i < 10; i++) {
                int middle = (fromSeat + toSeat) / 2;
                char c = line.charAt(i);
                if (c == 'L') {
                    toSeat = middle;
                } else if (c == 'R') {
                    fromSeat = middle;
                }
            }
            int seat = Math.max(fromSeat, toSeat);
            return row * 8 + seat;
        }).max().orElse(0));
    }
}
