package leetcode;

public class Task832 {

    public static void main(String[] args) {
        new Task832().flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}});
    }

    public int[][] flipAndInvertImage(int[][] a) {
        int[][] result = new int[a.length][];
        for (int i = 0; i < a.length; i++) {
            int[] row = a[i];
            int[] reversedAndFlippedRow = new int[row.length];
            for (int j = row.length - 1; j >= 0; j--) {
                reversedAndFlippedRow[row.length - 1 - j] = row[j] == 0 ? 1 : 0;
            }
            result[i] = reversedAndFlippedRow;
        }
        return result;
    }
}
