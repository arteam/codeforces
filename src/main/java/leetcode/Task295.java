package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task295 {


    private final List<Integer> numbers = new ArrayList<>();

    public void addNum(int num) {
        int i = Collections.binarySearch(numbers, num);
        numbers.add(i >= 0 ? i : -i - 1, num);
    }

    public double findMedian() {
        if (numbers.size() % 2 == 0) {
            return ((double) numbers.get(numbers.size() / 2 - 1) + numbers.get(numbers.size() / 2)) / 2;
        } else {
            return numbers.get(numbers.size() / 2);
        }
    }

    public static void main(String[] args) {
        Task295 task295 = new Task295();
        task295.addNum(6);
        task295.addNum(10);
        task295.addNum(2);
        task295.addNum(6);
        task295.addNum(5);

        System.out.println(task295.findMedian());
    }
}
