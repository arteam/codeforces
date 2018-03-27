import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Olympiad {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfParticipants = Integer.parseInt(reader.readLine());
        long uniquePoints = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(i -> i > 0)
                .distinct()
                .count();
        System.out.println(uniquePoints);
    }
}
