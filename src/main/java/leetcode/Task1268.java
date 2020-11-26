package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1268 {

    public static void main(String[] args) {
        System.out.println(new Task1268().suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println(new Task1268().suggestedProducts(new String[]{"havana"}, "havana"));
        System.out.println(new Task1268().suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        SortedSet<String> sortedProducts = new TreeSet<>(Arrays.asList(products));
        return IntStream.range(0, searchWord.length())
                .mapToObj(i -> sortedProducts.subSet(searchWord.substring(0, i + 1), searchWord.substring(0, i + 1) + Character.MAX_VALUE)
                        .stream()
                        .limit(3)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

}
