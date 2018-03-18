import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PointsOnLine {

    public static void main(String[] args) throws Exception {
        System.out.println(new PointsOnLine().run(new BufferedReader(new InputStreamReader(System.in))));
    }

    public String run(BufferedReader reader) throws Exception {
        String[] pointsDiameter = reader.readLine().split(" ");
        int amountOfPoints = Integer.parseInt(pointsDiameter[0]);
        int expectedDiameter = Integer.parseInt(pointsDiameter[1]);
        int[] points = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int maxDistance = -1;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[j] - points[i] > expectedDiameter) {
                    maxDistance = Math.max(j - i, maxDistance);
                    break;
                } else if (j == points.length - 1) {
                    maxDistance = Math.max(points.length - i, maxDistance);
                }
            }
        }
        return String.valueOf(maxDistance == -1 ? 0 : points.length - maxDistance);
    }
}
