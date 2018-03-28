import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunForYourPrize {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfPrizes = Integer.parseInt(reader.readLine());
        int timeSpent = 0;
        for (String s : reader.readLine().split(" ")) {
            int prizePosition = Integer.parseInt(s);
            int distanceToFirst = prizePosition - 1;
            int distanceToSecond = 1_000_000 - prizePosition;
            timeSpent = Math.max(timeSpent, Math.min(distanceToFirst, distanceToSecond));
        }
        System.out.println(timeSpent);
    }
}
