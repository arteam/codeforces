import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ErasingZeroes {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfTestCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < amountOfTestCases; i++) {
            System.out.println(amountOfNonLeadingTrailingZeroes(reader.readLine()));
        }
    }

    static long amountOfNonLeadingTrailingZeroes(String input) {
        var firstIndex = input.indexOf('1');
        var lastIndex = input.lastIndexOf('1');
        if (firstIndex == -1 || lastIndex == -1) {
            return 0;
        }
        return input.substring(firstIndex, lastIndex).chars().filter(c -> c == '0').count();
    }
}
