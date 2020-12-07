package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task739 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Task739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        return IntStream.range(0, temperatures.length)
                .map(i -> IntStream.range(i + 1, temperatures.length)
                        .filter(j -> temperatures[j] > temperatures[i])
                        .map(j -> j - i)
                        .findFirst()
                        .orElse(0))
                .toArray();
    }
}
