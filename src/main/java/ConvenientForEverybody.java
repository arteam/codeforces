import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConvenientForEverybody {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new ConvenientForEverybody().run(reader));
    }

    public String run(BufferedReader reader) throws IOException {
        int amountOfTimezones = Integer.parseInt(reader.readLine());
        int[] amountOfPeopleInTimezones = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] hours = reader.readLine().split(" ");
        int s = Integer.parseInt(hours[0]);
        int f = Integer.parseInt(hours[1]);
        int interval = f - s;
        int maxIntervalPosition = 0;
        long maxIntervalSum = 0;
        long dynamicSum = 0;
        for (int i = 0; i < interval; i++) {
            dynamicSum += amountOfPeopleInTimezones[i];
        }
        for (int i = 1; i < amountOfTimezones; i++) {
            dynamicSum = dynamicSum + amountOfPeopleInTimezones[(i + interval - 1) % amountOfTimezones]
                    - amountOfPeopleInTimezones[(i - 1) % amountOfTimezones];
            if (dynamicSum >= maxIntervalSum) {
                maxIntervalPosition = i;
                maxIntervalSum = dynamicSum;
            }
        }
        int localTime = s - maxIntervalPosition;
        return String.valueOf(localTime > 0 && localTime < amountOfTimezones ? localTime : amountOfTimezones + localTime);
    }
}
