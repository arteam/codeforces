import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FriendsMeeting {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        System.out.println(new FriendsMeeting().run(a, b));
    }

    public int run(int a, int b) {
        int tiredness = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int rate = 1;
        while (min < max) {
            if (min + 1 == max) {
                tiredness += rate;
                break;
            }
            min++;
            max--;
            tiredness += 2 * rate++;
        }
        return tiredness;
    }
}
