package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        //int[] nums = {2, 7, 11, 15};
        int[] nums = {3, 2, 4};
        int[] twoSum = new Task1().twoSum(nums, 6);
        System.out.println(Arrays.toString(twoSum));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexedNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indexedNums.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            Integer indexToTarget = indexedNums.get(target - nums[i]);
            if (indexToTarget != null && indexToTarget != i) {
                return new int[]{i, indexToTarget};
            }
        }
        return new int[]{};
    }

}
