import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringTransformation {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] input = reader.readLine().toCharArray();
        int checkedSymbolIdx = 0;
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            char checkedSymbol = alphabet[checkedSymbolIdx];
            if (c <= checkedSymbol) {
                input[i] = checkedSymbol;
                if (++checkedSymbolIdx >= alphabet.length) {
                    System.out.println(input);
                    return;
                }
            }
        }
        System.out.println("-1");
    }
}
