import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Game {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(reader.readLine());
        System.out.println(new Game().getLastNumber(reader.readLine(), amount));
    }

    public int getLastNumber(String line, int amount) {
        int[] numbers = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        return numbers[(amount + amount % 2) / 2 - 1];
    }
}
