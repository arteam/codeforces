import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BerOs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        int amountOfLines = scanner.nextInt();
        for (int i = 0; i < amountOfLines; i++) {
            lines.add(scanner.next());
        }
        List<String> queries = new ArrayList<>();
        int amountOfQueries = scanner.nextInt();
        for (int i = 0; i < amountOfQueries; i++) {
            queries.add(scanner.next());
        }
        List<String> results = new BerOs().find(lines, queries);
        for (String result : results) {
            System.out.println(result);
        }
    }

    public List<String> find(List<String> lines, List<String> queries) {
        List<String> results = new ArrayList<>();
        Map<String, Set<String>> reverseIndex = new HashMap<>();
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                for (int j = i + 1; j < line.length() + 1; j++) {
                    reverseIndex.computeIfAbsent(line.substring(i, j), k -> new HashSet<>()).add(line);
                }
            }
        }
        for (String query : queries) {
            Set<String> matches = reverseIndex.getOrDefault(query, Collections.emptySet());
            results.add(matches.size() + " " + (matches.isEmpty() ? "-" : matches.iterator().next()));
        }
        return results;
    }
}
