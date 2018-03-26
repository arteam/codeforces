import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FifaCompany {

    public static void main(String[] args) throws IOException {
        int numberOfEmployees = Integer.parseInt(
                new BufferedReader(new InputStreamReader(System.in)).readLine());
        int ways = 1;
        for (int teams = 2; teams <= numberOfEmployees / 2; teams++) {
            if (numberOfEmployees % teams == 0) {
                ways++;
            }
        }
        System.out.println(ways);
    }
}
