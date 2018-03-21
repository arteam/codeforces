import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntegerComplexity {

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(new IntegerComplexity().run(n));
    }

    public long run(long n) {
        long minSum = n + 1;
        long cap = (long) Math.sqrt(n) + 1;
        for (int a = 2; a < cap; a++) {
            if (n % a != 0) {
                continue;
            }
            long b = n / a;
            if (a + b < minSum) {
                minSum = a + b;
            }
        }
        return minSum;
    }
}
