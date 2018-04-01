import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ModularExponentiation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        BigInteger m = new BigInteger(reader.readLine());
        BigInteger result = m.mod(BigInteger.valueOf(2).pow(n));
        System.out.println(result);
    }
}
