import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ClosestString {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> lines = new ArrayList<>();
        int numberOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            lines.add(reader.readLine());
        }
        System.out.println(new ClosestString().run(lines));
    }

    public String run(List<String> lines) {
        int minDistanceSum = Integer.MAX_VALUE;
        int minIdx = Integer.MAX_VALUE;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int distanceSum = 0;
            for (int j = 0; j < lines.size(); j++) {
                if (i != j) {
                    distanceSum += hammingDistance(line, lines.get(j));
                }
            }
            if (distanceSum < minDistanceSum) {
                minDistanceSum = distanceSum;
                minIdx = i;
            }
        }
        return lines.get(minIdx);
    }

    private int hammingDistance(String first, String second) {
        if (first.length() != second.length()) {
            return Integer.MAX_VALUE;
        }
        int diffCount = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount;
    }
}
