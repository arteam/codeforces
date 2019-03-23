package leetcode;

import java.util.Arrays;

public class Task167 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] twoSum = new Task167().twoSum(nums, 9);
        System.out.println(Arrays.toString(twoSum));
    }

    public int[] twoSum(int[] nums, int target) {
        int higherBound = Math.max(Math.min(Math.abs(Arrays.binarySearch(nums, target)), nums.length - 1), 1);
        for (int i = 0; i < higherBound; i++) {
            for (int j = i + 1; j < higherBound + 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{};
    }
}
