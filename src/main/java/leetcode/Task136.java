package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Task136 {

    public static void main(String[] args) {
        System.out.println(new Task136().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new Task136().singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(new Task136().singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.remove(num)) {
                seen.add(num);
            }
        }
        return seen.iterator().next();
    }
}
