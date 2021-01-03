package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task692 {

    public static void main(String[] args) {
        System.out.println(new Task692().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(new Task692().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public List<String> topKFrequent(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
