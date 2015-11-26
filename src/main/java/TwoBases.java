import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Date: 11/26/15
 * Time: 4:32 PM
 */
public class TwoBases {

    public String compare(int xRadix, String xSymbols, int yRadix, String ySymbols) {
        long x10x = parseInt(xSymbols, xRadix);
        long y10x = parseInt(ySymbols, yRadix);
        if (x10x < y10x) {
            return "<";
        } else if (x10x > y10x) {
            return ">";
        }
        return "=";
    }

    private long parseInt(String symbols, int radix) {
        String[] numbers = symbols.split(" ");
        long result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += Integer.parseInt(numbers[numbers.length - 1 - i]) * pow(radix, i);
        }
        return result;
    }

    private long pow(int argument, int power) {
        long result = 1;
        for (int i = 0; i < power; i++) {
            result *= argument;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int xRadix = Integer.parseInt(reader.readLine().split(" ")[1]);
        String xSymbols = reader.readLine();
        int yRadix = Integer.parseInt(reader.readLine().split(" ")[1]);
        String ySymbols = reader.readLine();
        String result = new TwoBases().compare(xRadix, xSymbols, yRadix, ySymbols);
        System.out.println(result);
    }
}
