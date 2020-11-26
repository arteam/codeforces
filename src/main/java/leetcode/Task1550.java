package leetcode;

public class Task1550 {

    public static void main(String[] args) {
        System.out.println(new Task1550().threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(new Task1550().threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            int third = arr[i + 2];
            if (isOdd(first) && isOdd(second) && isOdd(third)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }

}
