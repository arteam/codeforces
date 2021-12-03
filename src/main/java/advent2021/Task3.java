package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task3 {

    public static void main(String[] args) {
        List<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines().collect(Collectors.toList());
        String gammaRate = IntStream.range(0, lines.get(0).length())
                .mapToObj(i -> lines.stream()
                        .collect(Collectors.groupingBy(e -> e.charAt(i), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElseThrow())
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        String epsilonRate = gammaRate.chars()
                .mapToObj(c -> c == '1' ? '0' : '1')
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println(Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2));
    }
}
