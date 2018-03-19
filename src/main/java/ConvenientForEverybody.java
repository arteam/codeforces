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
        long dynamicSum = 0;
        for (int i = 0; i < interval; i++) {
            dynamicSum += amountOfPeopleInTimezones[i];
        }
        long maxIntervalSum = dynamicSum;
        int maxIntervalPosition = s;
        int currentIntervalPosition = s;
        for (int i = 1; i < amountOfTimezones; i++) {
            dynamicSum = dynamicSum + amountOfPeopleInTimezones[(i + interval - 1) % amountOfTimezones]
                    - amountOfPeopleInTimezones[(i - 1) % amountOfTimezones];
            if (--currentIntervalPosition == 0) {
                currentIntervalPosition = amountOfTimezones;
            }
            if (dynamicSum > maxIntervalSum) {
                maxIntervalPosition = currentIntervalPosition;
                maxIntervalSum = dynamicSum;
            } else if (dynamicSum == maxIntervalSum && maxIntervalPosition > currentIntervalPosition) {
                maxIntervalPosition = currentIntervalPosition;
            }
        }
        return String.valueOf(maxIntervalPosition);
    }
}
