import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Imgur {

    public static void main(String[] args) throws Exception {
        String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int base = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        do {
            System.out.print(alphabet.charAt(base % 62));
        } while ((base /= 62) > 0);
    }
}
