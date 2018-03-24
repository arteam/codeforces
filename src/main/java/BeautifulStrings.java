import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BeautifulStrings {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : reader.readLine().toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        int size = frequencyMap.size();
        if (size < 2 || size > 4) {
            System.out.println("NO");
        } else if (size == 2) {
            for (Integer frequency : frequencyMap.values()) {
                if (frequency == 1) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        } else if (size == 3) {
            for (Integer frequency : frequencyMap.values()) {
                if (frequency > 1) {
                    System.out.println("YES");
                    return;
                }
            }
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
