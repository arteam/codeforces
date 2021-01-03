package leetcode;

import java.util.Arrays;

public class Task1365 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Task1365().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(new Task1365().smallerNumbersThanCurrent(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(new Task1365().smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        return Arrays.stream(nums)
                .map(num -> (int) Arrays.stream(nums)
                        .filter(otherNum -> otherNum < num)
                        .count())
                .toArray();
    }
}
