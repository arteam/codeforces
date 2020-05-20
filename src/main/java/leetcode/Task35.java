package leetcode;

import java.util.Arrays;

public class Task35 {

    public static void main(String[] args) {
        System.out.println(new Task35().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new Task35().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new Task35().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new Task35().searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(new Task35().searchInsert(new int[]{1}, 1));
    }

    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        return pos >= 0 ? pos : -pos - 1;
    }
}
