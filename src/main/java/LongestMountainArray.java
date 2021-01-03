public class LongestMountainArray {

    public static void main(String[] args) {
        System.out.println(new LongestMountainArray().longestMountain(new int[]{875,884,239,731,723,685}));
        System.out.println(new LongestMountainArray().longestMountain(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        System.out.println(new LongestMountainArray().longestMountain(new int[]{0, 2, 2}));
        System.out.println(new LongestMountainArray().longestMountain(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(new LongestMountainArray().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(new LongestMountainArray().longestMountain(new int[]{2, 2, 2}));
        System.out.println(new LongestMountainArray().longestMountain(new int[]{3, 3, 1}));
        System.out.println(new LongestMountainArray().longestMountain(new int[]{0, 1, 0}));
    }

    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int maxMountainSize = 0;
        for (int j = 0; j < arr.length - 2; j++) {
            int mountainSize = getMountainSize(arr, j);
            if (mountainSize > maxMountainSize) {
                maxMountainSize = mountainSize;
                j += mountainSize - 2;
            }
        }
        return maxMountainSize;
    }

    private int getMountainSize(int[] numbers, int from) {
        if (numbers.length - from < 3) {
            return 0;
        }
        boolean goingUp = true;
        int pickIndex = 0;
        for (int i = from; i < numbers.length - 1; i++) {
            if (goingUp) {
                if (numbers[i] >= numbers[i + 1]) {
                    if (i == from) {
                        return 0;
                    }
                    goingUp = false;
                    pickIndex = i;
                    i--;
                }
            } else {
                if (numbers[i] <= numbers[i + 1]) {
                    if (i == pickIndex) {
                        return 0;
                    }
                    return i - from + 1;
                }
            }
        }
        if (goingUp) {
            return 0;
        }
        return numbers.length - from;
    }
}
