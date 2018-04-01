import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringTyping {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String input = reader.readLine();
        System.out.println(new StringTyping().run(length, input));
    }

    public int run(int length, String input) {
        for (int i = length / 2; i > 0; i--) {
            if (input.substring(0, i).equals(input.substring(i, 2 * i))) {
                return length - i + 1;
            }
        }
        return length;
    }
}
