import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WeirdSubstraction {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(" ");
        long a = Long.parseLong(numbers[0]);
        long b = Long.parseLong(numbers[1]);
        while (true) {
            if (a == 0 || b == 0) {
                break;
            }
            if (a >= 2 * b) {
                long r = a / (2 * b);
                a -= r * 2 * b;
            } else if (b >= 2 * a) {
                long r = b / (2 * a);
                b -= r * 2 * a;
            } else {
                break;
            }
        }
        System.out.println(a + " " + b);
    }
}
