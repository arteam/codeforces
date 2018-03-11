import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Pancakes {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numberOfPancakes = reader.readLine();
        System.out.println(new Pancakes().run(reader.readLine()));
    }

    public String run(String input) {
        int[] pancackes = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int flips = 0;
        for (int j = pancackes.length - 1; j >= 1; j--) {
            int idx = 0;
            int maxPancake = 0;
            for (int i = 0; i <= j; i++) {
                if (pancackes[i] > maxPancake) {
                    maxPancake = pancackes[i];
                    idx = i;
                }
            }
            if (idx > 0) {
                flip(pancackes, idx);
                flips++;
            }
            flip(pancackes, j);
            flips++;
        }
        return String.valueOf(flips);
    }

    private void flip(int[] pancackes, int j) {
        for (int i = 0; i < (j / 2) + 1; i++) {
            int temp = pancackes[i];
            pancackes[i] = pancackes[j - i];
            pancackes[j - i] = temp;
        }
    }
}
