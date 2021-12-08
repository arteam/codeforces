package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Task8_2 {
    private static final Pattern VERTICAL_BAR = Pattern.compile(" \\| ");
    private static final Map<String, Integer> SIGNAL_PATTERN_DIGITS = Map.of(
            "abcdefg", 8, "bcdef", 5, "cdfg", 2, "abcdf", 3, "abd", 7,
            "abcdef", 9, "bcdefg", 6, "abef", 4, "abcdeg", 0, "ab", 1);
    private static final String ALPHABET = "abcdefg";
    private static final List<String> PERMUTATIONS = new ArrayList<>();

    public static void main(String[] args) {
        permute("", ALPHABET);

        System.out.println(new BufferedReader(new InputStreamReader(System.in)).lines()
                .map(VERTICAL_BAR::split)
                .mapToLong(line -> outputValue(line[0], line[1]))
                .sum());
    }

    private static void permute(String prefix, String postfix) {
        if (postfix.isEmpty()) {
            PERMUTATIONS.add(prefix);
            return;
        }
        for (int i = 0; i < postfix.length(); i++) {
            permute(prefix + postfix.charAt(i), postfix.substring(0, i) + postfix.substring(i + 1));
        }
    }

    private static int outputValue(String inputPatterns, String outputPatterns) {
        return PERMUTATIONS.stream()
                .filter(p -> Arrays.stream(inputPatterns.split(" "))
                        .map(s -> decode(s, p))
                        .allMatch(SIGNAL_PATTERN_DIGITS::containsKey))
                .map(p -> Arrays.stream(outputPatterns.split(" "))
                        .map(s -> decode(s, p))
                        .mapToInt(SIGNAL_PATTERN_DIGITS::get)
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString())
                .mapToInt(Integer::parseInt)
                .findFirst()
                .orElse(0);
    }

    private static String decode(String signalPattern, String permutation) {
        return signalPattern.chars()
                .map(c -> ALPHABET.charAt(permutation.indexOf(c)))
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
