package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task3_2 {

    private static final Comparator<Map.Entry<Character, List<String>>> VALUE_LENGTH_COMPARATOR =
            Comparator.comparing((Map.Entry<Character, List<String>> e) -> e.getValue().size())
                    .thenComparing(Map.Entry::getKey);

    public static void main(String[] args) {
        List<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines().collect(Collectors.toList());
        String oxygenGeneratorRating = IntStream.range(0, lines.get(0).length()).boxed()
                .reduce(lines,
                        (list, i) -> list.stream().collect(Collectors.groupingBy(e -> e.charAt(i)))
                                .entrySet()
                                .stream()
                                .max(VALUE_LENGTH_COMPARATOR)
                                .map(Map.Entry::getValue)
                                .orElseThrow(), (a, b) -> b)
                .get(0);
        String co2ScrubberRating = IntStream.range(0, lines.get(0).length()).boxed()
                .reduce(lines,
                        (list, i) -> list.stream().collect(Collectors.groupingBy(e -> e.charAt(i)))
                                .entrySet()
                                .stream()
                                .min(VALUE_LENGTH_COMPARATOR)
                                .map(Map.Entry::getValue)
                                .orElseThrow(), (a, b) -> b)
                .get(0);

        System.out.println(Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(co2ScrubberRating, 2));
    }
}
