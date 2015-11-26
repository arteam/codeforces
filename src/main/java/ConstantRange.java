import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Stream;

/**
 * Date: 11/26/15
 * Time: 11:41 AM
 *
 * @author Artem Prigoda
 */
public class ConstantRange {

    public static void main(String[] args) throws Exception {
        new ConstantRange().run();
    }

    private void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(reader.readLine());
        int maxLength = getMaxLength(amount, reader.readLine());
        new PrintWriter(System.out, true).println(maxLength);
    }

    public int getMaxLength(int amount, String input) {
        int[] sequence = new int[amount];
        String[] split = input.split(" ");
        for (int i = 0; i < amount; i++) {
            sequence[i] = Integer.parseInt(split[i]);
        }

        int maxLength = 0;
        for (int i = 0; i < sequence.length - 1; i++) {
            Result result = getRangeLength(sequence, i);
            if (result.length > maxLength) {
                maxLength = result.length;
            }
            if (result.end) {
                break;
            }
        }
        return maxLength;
    }

    private Result getRangeLength(int[] sequence, int start) {
        float m = sequence[start];
        int length = 1;
        for (int j = start + 1; j < sequence.length; j++) {
            float diff = Math.abs(sequence[j] - m);
            if (diff > 1) {
                return new Result(false, length);
            } else if (diff == 1) {
                m = (m + sequence[j]) / 2;
            }
            length++;
        }
        return new Result(true, length);
    }

    private static class Result {
        boolean end;
        int length;

        public Result(boolean end, int length) {
            this.end = end;
            this.length = length;
        }
    }
}
