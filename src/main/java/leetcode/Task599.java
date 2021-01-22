package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task599 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Task599().findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
        System.out.println(Arrays.toString(new Task599().findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"})));
        System.out.println(Arrays.toString(new Task599().findRestaurant(
                new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Burger King", "Tapioca Express", "Shogun"})));
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        return IntStream.range(0, list1.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, list2.length).boxed().map(j -> Map.entry(i, j)))
                .filter(e -> list1[e.getKey()].equals(list2[e.getValue()]))
                .collect(Collectors.groupingBy(e -> e.getKey() + e.getValue(), TreeMap::new,
                        Collectors.mapping(e -> list1[e.getKey()], Collectors.toList())))
                .entrySet()
                .stream()
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(List.of())
                .toArray(String[]::new);
    }
}
