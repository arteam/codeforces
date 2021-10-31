package advent2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Task5_2 {

    public static void main(String[] args) {
        new Task5_2().solve(new BufferedReader(new InputStreamReader(System.in)));
    }

    void solve(BufferedReader reader) {
        List<Integer> ids = reader.lines().map(line -> {
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
        }).sorted().collect(Collectors.toList());
        for (int i = 0; i < ids.size() - 1; i++) {
            if (ids.get(i + 1) - ids.get(i) == 2) {
                System.out.println(ids.get(i+1));
            }
        }
    }
}
