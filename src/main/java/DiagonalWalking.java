import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiagonalWalking {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfMoves = Integer.parseInt(reader.readLine());
        String moves = reader.readLine();
        System.out.println(moves.replaceAll("RU|UR", "D").length());
    }
}
