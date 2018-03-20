import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LoveTriangle {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(run(reader));
    }

    private static String run(BufferedReader reader) throws IOException {
        int amountOfPlanes = Integer.parseInt(reader.readLine());
        String[] planes = reader.readLine().split(" ");
        Map<Integer, Integer> planePairs = new HashMap<>(amountOfPlanes * 2);
        for (int i = 0; i < amountOfPlanes; i++) {
            planePairs.put(i + 1, Integer.parseInt(planes[i]));
        }

        for (Map.Entry<Integer, Integer> entry : planePairs.entrySet()) {
            Integer first = entry.getKey();
            Integer second = entry.getValue();
            Integer third = planePairs.get(second);
            if (third != null && first.equals(planePairs.get(third))) {
                return "YES";
            }
        }
        return "NO";
    }
}
