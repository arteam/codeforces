package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task_14_2 {

    public static void main(String[] args) {
        List<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines().toList();
        String template = lines.get(0);
        Map<String, Character> rules = lines.stream().skip(2)
                .map(s -> s.split(" -> "))
                .collect(Collectors.toMap(e -> e[0], e -> e[1].charAt(0)));

        long[] freqChars = new long[128];
        for (char c : template.toCharArray()) {
            freqChars[c]++;
        }
        Map<String, Long> freqPairs = new HashMap<>();
        for (int i = 0; i < template.length() - 1; i++) {
            freqPairs.merge(template.substring(i, i + 2), 1L, Long::sum);
        }
        for (int i = 0; i < 40; i++) {
            Map<String, Long> newFreqPairs = new HashMap<>();
            for (Map.Entry<String, Long> e : freqPairs.entrySet()) {
                char element = rules.get(e.getKey());
                newFreqPairs.merge(e.getKey().substring(0, 1) + element, e.getValue(), Long::sum);
                newFreqPairs.merge(element + e.getKey().substring(1, 2), e.getValue(), Long::sum);
                freqChars[element] += e.getValue();
            }
            freqPairs = newFreqPairs;
        }
        System.out.println(Arrays.stream(freqChars).max().orElse(0) -
                Arrays.stream(freqChars).filter(e -> e > 0).min().orElse(0));
    }

}
