import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LaboratoryWork {

    public static void main(String[] args) throws IOException {
        System.out.println(new LaboratoryWork().run(new BufferedReader(new InputStreamReader(System.in))));
    }

    public String run(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] points = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(points).max().getAsInt();
        int min = Arrays.stream(points).min().getAsInt();
        if (max - min < 2) {
            StringBuilder result = new StringBuilder().append(n).append("\n");
            for (int x : points) {
                result.append(x).append(" ");
            }
            return result.toString();
        }

        int avg = min + 1;
        int amountMin = (int) Arrays.stream(points).filter(x -> x == min).count();
        int amountAvg = (int) Arrays.stream(points).filter(x -> x == avg).count();
        int amountMax = (int) Arrays.stream(points).filter(x -> x == max).count();

        int t = Math.max(amountAvg / 2, Math.min(amountMin, amountMax));
        if (t == Math.min(amountMin, amountMax)) {
            amountMin -= t;
            amountAvg += 2 * t;
        } else {
            amountMin += t;
            amountAvg -= 2 * t;
        }

        StringBuilder result = new StringBuilder().append(n - 2 * t).append("\n");
        for (int i = 0; i < n; i++) {
            result.append((i < amountMin) ? min : (i < amountMin + amountAvg) ? avg : max).append(" ");
        }
        return result.toString();
    }
}
