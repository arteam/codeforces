import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kaprekar {

    public static void main(String[] args) {
        System.out.println(new Kaprekar().findNumbers(2, 100));
        System.out.println(new Kaprekar().findNumbers(101, 9000));
    }

    public List<Integer> findNumbers(int from, int to) {
        return IntStream.range(from, to).filter(this::isKaprekarNumber).boxed().collect(Collectors.toList());
    }

    private boolean isKaprekarNumber(int i) {
        String strSquare = String.valueOf((long) i * i);
        for (int j = 1; j < strSquare.length() / 2; j++) {
            int firstPart = Integer.parseInt(strSquare.substring(0, j + 1));
            int secondPart = Integer.parseInt(strSquare.substring(j + 1, strSquare.length()));
            if (i == firstPart + secondPart) {
                return true;
            }
        }
        return false;
    }
}
