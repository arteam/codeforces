import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ambidexters {

    public static void main(String[] args) throws Exception {
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String result = new Ambidexters().run(input);
        System.out.write(result.getBytes());
    }

    public String run(String input) {
        String[] parts = input.split(" ");
        int l = Integer.parseInt(parts[0]);
        int r = Integer.parseInt(parts[1]);
        int a = Integer.parseInt(parts[2]);
        int min = Math.min(l, r);
        int max = Math.max(l, r);

        int diff = max - min;
        if (diff == 0) {
            min += a / 2;
        } else if (a <= diff) {
            min += a;
        } else {
            min = (a - diff) / 2 + max;
        }
        return String.valueOf(min * 2);
    }
}
