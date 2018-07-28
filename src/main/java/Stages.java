import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Stages {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int amountOfStages = Integer.parseInt(reader.readLine().split(" ")[1]);
        String stages = reader.readLine();
        System.out.println(new Stages().run(amountOfStages, stages));
    }

    public int run(int requiredAmountOfStages, String stages) {
        char[] chars = stages.toCharArray();
        Arrays.sort(chars);

        char lastStage = 0;
        int totalWeight = 0;
        int i = 0;
        for (char c : chars) {
            if (c == lastStage || c == lastStage + 1) {
                continue;
            }
            lastStage = c;
            totalWeight += c - 'a' + 1;
            if (++i == requiredAmountOfStages) {
                return totalWeight;
            }
        }
        return -1;
    }
}
