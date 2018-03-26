import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NavigableSet;
import java.util.TreeSet;

public class PhoneNumbers {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int sourceLength = Integer.parseInt(firstLine[0]);
        int resultLength = Integer.parseInt(firstLine[1]);
        char[] source = reader.readLine().toCharArray();
        NavigableSet<Character> alphabet = new TreeSet<>();
        for (char c : source) {
            alphabet.add(c);
        }
        char firstChar = alphabet.first();
        char lastChar = alphabet.last();

        char[] result = new char[resultLength];
        System.arraycopy(source, 0, result, 0, Math.min(resultLength, sourceLength));
        if (resultLength > sourceLength) {
            Arrays.fill(result, sourceLength, resultLength, firstChar);
            System.out.println(result);
            return;
        }
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] < lastChar) {
                result[i] = alphabet.higher(result[i]);
                System.out.println(result);
                return;
            }
            result[i] = firstChar;
        }
    }
}
