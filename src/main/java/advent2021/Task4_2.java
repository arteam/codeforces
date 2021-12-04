package advent2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task4_2 {
    private static final int BOARD_SIZE = 5;
    private static final int MARKED = -1;

    public static void main(String[] args) throws IOException {
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

        for (int n = 0; n < numbers.length; n++) {
            int number = numbers[n];
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

            Set<int[][]> bingoBoards = new HashSet<>();
            for (int[][] board : boards) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    int[] row = board[j];
                    if (Arrays.stream(row).allMatch(bn -> bn == MARKED)) {
                        bingoBoards.add(board);
                        break;
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
                        bingoBoards.add(board);
                        break;
                    }
                }
            }

            if (!bingoBoards.isEmpty()) {
                System.out.println("Bingo!");
                if (boards.size() > 1 && n < numbers.length - 1) {
                    boards.removeAll(bingoBoards);
                    continue;
                }

                int[][] board = bingoBoards.iterator().next();
                int sumOfUnmarkedNumbers = 0;
                for (int i = 0; i < BOARD_SIZE; i++) {
                    for (int j = 0; j < BOARD_SIZE; j++) {
                        if (board[i][j] != MARKED) {
                            sumOfUnmarkedNumbers += board[i][j];
                        }
                    }
                }
                System.out.println(sumOfUnmarkedNumbers * number);
                return;
            }
        }
    }
}
