package leetcode;

import java.util.Map;
import java.util.stream.IntStream;

public class Task1010 {

    public static void main(String[] args) {
        System.out.println(new Task1010().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(new Task1010().numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    // 20 - 40, 100, 160, 210

    public int numPairsDivisibleBy60(int[] time) {
        return (int) IntStream.range(0, time.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, time.length)
                        .mapToObj(j -> Map.entry(time[i], time[j])))
                .filter(e -> (e.getKey() + e.getValue()) % 60 == 0)
                .count();

    }
}
