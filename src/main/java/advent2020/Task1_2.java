package advent2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Task1_2 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Task1_2().solve(new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))));
    }

    private int solve(BufferedReader reader) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            numbers.add(Integer.valueOf(line));
        }
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                for (int k = j + 1; k < numbers.size(); k++) {
                    if (numbers.get(i) + numbers.get(j) + numbers.get(k) == 2020) {
                        return numbers.get(i) * numbers.get(j) * numbers.get(k);
                    }
                }
            }
        }
        return 0;
    }
}
