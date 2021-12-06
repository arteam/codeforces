package advent2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task6_2 {

    public static void main(String[] args) throws IOException {
        long[] ageCounts = new long[9];
        for (String s : new BufferedReader(new InputStreamReader(System.in)).readLine().split(",")) {
            ageCounts[Integer.parseInt(s)]++;
        }
        for (int i = 0; i < 256; i++) {
            long newFish = ageCounts[0];
            System.arraycopy(ageCounts, 1, ageCounts, 0, 8);
            ageCounts[6] += newFish;
            ageCounts[8] = newFish;
        }
        System.out.println(Arrays.stream(ageCounts).sum());
    }
}
