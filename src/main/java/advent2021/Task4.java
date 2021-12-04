package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    private static final int BOARD_SIZE = 5;
    private static final int MARKED = -1;

    public static void main(String[] args) {
        List<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines().toList();
        int[] numbers = Arrays.stream(lines.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        List<int[][]> boards = new ArrayList<>();
        for (int l = 2; l < lines.size(); l += BOARD_SIZE + 1) {
            int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                board[i] = Arrays.stream(lines.get(l + i).trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            boards.add(board);
        }

        for (int number : numbers) {
            System.out.println("Number: " + number);
            for (int[][] board : boards) {
                for (int i = 0; i < BOARD_SIZE; i++) {
                    for (int j = 0; j < BOARD_SIZE; j++) {
                        if (board[i][j] == number) {
                            board[i][j] = MARKED;
                        }
                    }
                }
            }

            for (int[][] board : boards) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    int[] row = board[j];
                    if (Arrays.stream(row).allMatch(bn -> bn == MARKED)) {
                        bingo(board, number);
                        return;
                    }
                }
                for (int j = 0; j < BOARD_SIZE; j++) {
                    boolean allMarkedInColumn = true;
                    for (int k = 0; k < BOARD_SIZE; k++) {
                        if (board[k][j] != MARKED) {
                            allMarkedInColumn = false;
                            break;
                        }
                    }
                    if (allMarkedInColumn) {
                        bingo(board, number);
                        return;
                    }
                }
            }
        }
    }

    private static void bingo(int[][] board, int number){
        System.out.println("Bingo!");
        int sumOfUnmarkedNumbers = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != MARKED) {
                    sumOfUnmarkedNumbers += board[i][j];
                }
            }
        }
        System.out.println(sumOfUnmarkedNumbers * number);
    }
}
