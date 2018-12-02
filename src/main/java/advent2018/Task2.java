package advent2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task2 {

    public int getChecksum(BufferedReader reader) throws IOException {
        String line;
        int doubleDigits = 0;
        int tripleDigits = 0;
        while ((line = reader.readLine()) != null) {
            Map<Character, Integer> frequencies = new HashMap<>();
            for (char c : line.toCharArray()) {
                frequencies.merge(c, 1, (a, b) -> a + b);
            }
            Set<Integer> uniqueFrequencies = new HashSet<>(frequencies.values());
            if (uniqueFrequencies.contains(2)) doubleDigits++;
            if (uniqueFrequencies.contains(3)) tripleDigits++;
        }
        return doubleDigits * tripleDigits;
    }
}
