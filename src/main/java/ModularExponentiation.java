import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ModularExponentiation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        System.out.println(new ModularExponentiation().run(n, m));
    }

    public int run(int n, int m) {
        return BigInteger.valueOf(m).mod(BigInteger.valueOf(2).pow(n)).intValue();
    }
}
