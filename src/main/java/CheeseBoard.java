import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheeseBoard {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new CheeseBoard().run(reader));
    }

    public int run(BufferedReader reader) throws IOException {
        int cheeses = Integer.parseInt(reader.readLine());
        int soft = 0;
        int hard = 0;
        for (int i = 0; i < cheeses; i++) {
            String[] line = reader.readLine().split(" ");
            if (line[1].equals("soft")) {
                soft++;
            } else {
                hard++;
            }
        }
        int max = Math.max(soft, hard);
        int isEven = soft == hard ? 0 : 1;
        return (int) Math.ceil(Math.sqrt(max * 2 - isEven));
    }
}
