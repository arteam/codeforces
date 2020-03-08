import java.util.stream.IntStream;

public class RuthAaron {

    public static void main(String[] args) {
        System.out.println(new RuthAaron().check(714, 715));
        System.out.println(new RuthAaron().check(77, 78));
        System.out.println(new RuthAaron().check(20, 21));
    }

    boolean check(int first, int second) {
        return sumOfPrimeFactors(first) == sumOfPrimeFactors(second);
    }

    private int sumOfPrimeFactors(int n) {
        return IntStream.rangeClosed(2, n / 2)
                .filter(i -> isPrime(i) && n % i == 0)
                .sum();
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
