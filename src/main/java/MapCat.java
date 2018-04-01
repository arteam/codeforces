import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MapCat {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            System.out.println(i);
            System.out.flush();
            String s = reader.readLine();
            if (s.equals("no")) {
                continue;
            }
            if (s.equals("great") || s.equals("not bad") || s.equals("cool") || s.equals("don't think so")
                    || s.equals("don't touch me")) {
                System.out.println("normal");
                break;
            } else {
                System.out.println("grumpy");
                break;
            }
        }
    }

}
