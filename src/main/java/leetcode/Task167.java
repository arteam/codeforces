package leetcode;

import java.util.Arrays;

public class Task167 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 9, 56, 90};
        int[] twoSum = new Task167().twoSum(nums, 8);
        System.out.println(Arrays.toString(twoSum));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int indexOfAddableNumber = Arrays.binarySearch(nums, target - nums[i]);
            if (indexOfAddableNumber > 0) {
                if (indexOfAddableNumber > i) {
                    return new int[]{i + 1, indexOfAddableNumber + 1};
                }
                if (indexOfAddableNumber == i) {
                    return new int[]{i + 1, i + 2};
                }
            }


        }
        return new int[]{};
    }
}
