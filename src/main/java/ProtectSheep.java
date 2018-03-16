import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProtectSheep {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsColumns = bufferedReader.readLine().split(" ");
        int rows = Integer.parseInt(rowsColumns[0]);
        int columns = Integer.parseInt(rowsColumns[1]);
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        boolean canProtect = canProtect(rows, columns, matrix);
        if (!canProtect) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
        for (int i = 0; i < rows; i++) {
            System.out.println(matrix[i]);
        }
    }

    private static boolean canProtect(int rows, int columns, char[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char c = matrix[i][j];
                if (c != 'W') {
                    continue;
                }
                if (i > 0 && matrix[i - 1][j] == 'S') {
                    return false;
                } else if (i < rows - 1 && matrix[i + 1][j] == 'S') {
                    return false;
                } else if (j > 0 && matrix[i][j - 1] == 'S') {
                    return false;
                } else if (j < columns - 1 && matrix[i][j + 1] == 'S') {
                    return false;
                }

                if (i > 0 && matrix[i - 1][j] == '.') {
                    matrix[i - 1][j] = 'D';
                }
                if (i < rows - 1 && matrix[i + 1][j] == '.') {
                    matrix[i + 1][j] = 'D';
                }
                if (j > 0 && matrix[i][j - 1] == '.') {
                    matrix[i][j - 1] = 'D';
                }
                if (j < columns - 1 && matrix[i][j + 1] == '.') {
                    matrix[i][j + 1] = 'D';
                }
            }
        }
        return true;
    }
}
