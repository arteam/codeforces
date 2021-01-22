package leetcode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task187 {

    public static void main(String[] args) {
        System.out.println(new Task187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(new Task187().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return List.of();
        }
        return IntStream.rangeClosed(10, s.length())
                .mapToObj(i -> s.substring(i - 10, i))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
