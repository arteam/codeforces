package leetcode;

public class Task1539 {

    public static void main(String[] args) {
        System.out.println(new Task1539().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(new Task1539().findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

    public int findKthPositive(int[] arr, int k) {
        int missed = 0;
        int foundIndex = 0;
        for (int i = 1; ; i++) {
            if (i == arr[Math.min(foundIndex, arr.length - 1)]) {
                foundIndex++;
            } else {
                if (++missed == k) {
                    return i;
                }
            }
        }
    }
}
