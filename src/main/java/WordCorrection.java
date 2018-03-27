import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordCorrection {

    private static final char[] VOWELS = "aeiouy".toCharArray();

    private static boolean isVowel(char cur) {
        return Arrays.binarySearch(VOWELS, cur) >= 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfSymbols = Integer.parseInt(reader.readLine());
        String word = reader.readLine();
        StringBuilder result = new StringBuilder();
        char previous = '\0';
        for (int i = 0; i < amountOfSymbols; i++) {
            char current = word.charAt(i);
            if (isVowel(current) && isVowel(previous)) {
                continue;
            }
            result.append(current);
            previous = current;
        }
        System.out.println(result.toString());
    }
}
