package leetcode;

public class Task26 {

    public static void main(String[] args) {
        System.out.println(new Task26().removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(new Task26().removeDuplicates(new int[]{1, 2}));
        System.out.println(new Task26().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(new Task26().removeDuplicates(new int[]{1}));
    }

    public int removeDuplicates(int[] nums) {
        int uniq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                uniq++;
                nums[uniq - 1] = nums[i];
            }
        }
        return uniq;
    }
}
