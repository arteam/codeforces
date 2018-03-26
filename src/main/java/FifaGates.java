import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FifaGates {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfMoves = Integer.parseInt(reader.readLine());
        char[] moves = reader.readLine().toCharArray();

        int x = 0;
        int y = 0;
        int toll = 0;
        for (int i = 0; i < amountOfMoves - 1; i++) {
            if (moves[i] == 'R') {
                if (++x == y && moves[i + 1] == 'R') {
                    toll++;
                }
            } else if (moves[i] == 'U') {
                if (x == ++y && moves[i + 1] == 'U') {
                    toll++;
                }
            }
        }

        System.out.println(toll);
    }
}	


