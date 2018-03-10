import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Partition {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberOfElements = reader.readLine();
        String elements = reader.readLine();
        System.out.println(new Partition().run(elements));
    }

    public String run(String input) {
        long result = 0;
        StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            result += Math.abs(Integer.parseInt(tokenizer.nextToken()));
        }
        return String.valueOf(result);
    }
}
