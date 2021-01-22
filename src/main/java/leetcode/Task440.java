package leetcode;

import java.util.stream.IntStream;

public class Task440 {

    public static void main(String[] args) {
        System.out.println(new Task440().findKthNumber(13, 2));
        System.out.println(new Task440().findKthNumber(4289384, 1922239));
    }

    public int findKthNumber(int n, int k) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(String::valueOf)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .map(Integer::valueOf)
                .orElse(0);
    }
}
