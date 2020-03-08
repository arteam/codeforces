import java.util.stream.IntStream;

public class AbundantNumber {

    public static void main(String[] args) {
        System.out.println(status(18));
        System.out.println(status(21));
        System.out.println(status(9));
    }

    private static String status(int number) {
        int sumOfDivisors = IntStream.range(1, number / 2 + 1).filter(i -> number % i == 0).sum();
        if (sumOfDivisors > number) {
            return "abundant by " + (sumOfDivisors - number);
        } else if (2 * sumOfDivisors > number) {
            return "deficient";
        }
        return "neither";
    }
}
