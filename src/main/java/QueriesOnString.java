import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 11/27/15
 * Time: 1:15 PM
 */
public class QueriesOnString {

    public String shift(String source, List<String> rotations) {
        char[] chars = source.toCharArray();
        for (String strRotation : rotations) {
            String[] split = strRotation.split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            int amount = Integer.parseInt(split[2]);
            for (int i = 0; i < amount; i++) {
                rotateShift(chars, from - 1, to - 1);
            }
        }
        return new String(chars);
    }

    private void rotateShift(char[] chars, int from, int to) {
        char last = chars[to];
        for (int i = to - 1; i >= from; i--) {
            chars[i + 1] = chars[i];
        }
        chars[from] = last;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = reader.readLine();
        int amountRotations = Integer.parseInt(reader.readLine());
        List<String> rotations = new ArrayList<>();
        for (int i = 0; i < amountRotations; i++) {
            rotations.add(reader.readLine());
        }
        String result = new QueriesOnString().shift(source, rotations);
        System.out.println(result);
    }
}
