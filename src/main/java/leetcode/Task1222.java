package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1222 {

    public static void main(String[] args) {
        System.out.println(new Task1222().queensAttacktheKing(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}}, new int[]{3, 3}));
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int kingX = king[0];
        int kingY = king[1];

        List<List<Integer>> results = new ArrayList<>();
        for (int[] queen : queens) {
            int queenX = queen[0];
            int queenY = queen[1];
            if (queenX == kingX && !isAnotherQueenBlockingByX(queen, queens, kingY)) {
                results.add(Arrays.asList(queenX, queenY));
            } else if (queenY == kingY && !isAnotherQueenBlockingByY(queen, queens, kingX)) {
                results.add(Arrays.asList(queenX, queenY));
            } else if (areOnSameDiagonal(kingX, kingY, queenX, queenY) && !isAnotherQueenBlockingByDiagonal(queen, queens, kingX, kingY)) {
                results.add(Arrays.asList(queenX, queenY));
            }
        }
        return results;
    }

    private boolean isAnotherQueenBlockingByX(int[] queen, int[][] queens, int kingY) {
        for (int[] anotherQueen : queens) {
            if (anotherQueen == queen) {
                continue;
            }
            if (anotherQueen[0] == queen[0]) {
                if (anotherQueen[1] > kingY && anotherQueen[1] < queen[1]) {
                    return true;
                }
                if (anotherQueen[1] < kingY && anotherQueen[1] > queen[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAnotherQueenBlockingByY(int[] queen, int[][] queens, int kingX) {
        for (int[] anotherQueen : queens) {
            if (anotherQueen == queen) {
                continue;
            }
            if (anotherQueen[1] == queen[1]) {
                if (anotherQueen[0] > kingX && anotherQueen[0] < queen[0]) {
                    return true;
                }
                if (anotherQueen[0] < kingX && anotherQueen[0] > queen[0]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAnotherQueenBlockingByDiagonal(int[] queen, int[][] queens, int kingX, int kingY) {
        for (int[] anotherQueen : queens) {
            if (anotherQueen == queen) {
                continue;
            }
            if (areOnSameDiagonal(queen[0], queen[1], anotherQueen[0], anotherQueen[1]) &&
                    areOnSameDiagonal(kingX, kingY, anotherQueen[0], anotherQueen[1])) {
                if (anotherQueen[0] > kingX && anotherQueen[0] < queen[0]) {
                    return true;
                }
                if (anotherQueen[0] < kingX && anotherQueen[0] > queen[0]) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean areOnSameDiagonal(int firstX, int firstY, int secondX, int secondY) {
        return Math.abs(secondX - firstX) == Math.abs(secondY - firstY);
    }
}
