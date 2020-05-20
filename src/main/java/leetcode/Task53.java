package leetcode;

public class Task53 {

    public static void main(String[] args) {
        System.out.println(new Task53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Task53().maxSubArray(new int[]{-1}));
        System.out.println(new Task53().maxSubArray(new int[]{-2, -1}));
    }

    public int maxSubArray(int[] nums) {
        int bestSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
