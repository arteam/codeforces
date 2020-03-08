import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Emirp {

    public List<Integer> getEmirpNumbers(int from, int to) {
        return IntStream.range(from, to)
                .filter(Emirp::isEmirp)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isEmirp(int n) {
        return isPrime(n) && isPrime(reverse(n));
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int reverse(int n) {
        String source = String.valueOf(n);
        StringBuilder reversed = new StringBuilder();
        for (int i = source.length() - 1; i >= 0; i--) {
            reversed.append(source.charAt(i));
        }
        return Integer.parseInt(reversed.toString());
    }
}
