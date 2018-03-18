import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryingOutLoud {

    public static void main(String[] args) throws Exception {
        System.out.println(run(new BufferedReader(new InputStreamReader(System.in))));
    }

    public static long run(BufferedReader reader) throws IOException {
        long n = Long.parseLong(reader.readLine());
        long k = Long.parseLong(reader.readLine());
        long a = Long.parseLong(reader.readLine());
        long b = Long.parseLong(reader.readLine());

        long cost = 0;
        while (true) {
            long nextDivided = n / k * k;
            long costToGoToDivision = (n - nextDivided) * a;
            cost += costToGoToDivision;
            n = nextDivided;

            long costToGoToBySubtraction = (n - n / k) * a;
            if (costToGoToBySubtraction <= b) {
                return cost + (n - 1) * a;
            } else {
                n /= k;
                cost += b;
            }
        }
    }
}
