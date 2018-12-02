package advent2018;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task1_2 {

    public long solve(BufferedReader reader) {
        List<String> lines = reader.lines().collect(Collectors.toList());
        Set<Integer> frequencies = new HashSet<>();
        int result = 0;
        int i = 0;
        do {
            result += Integer.parseInt(lines.get(i++ % lines.size()));
        } while (frequencies.add(result));
        return result;
    }
}
