import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HamsterFarm {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(run(reader));
    }

    private static String run(BufferedReader reader) throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        long amountOfHamsters = Long.parseLong(firstLine[0]);
        int amountOfBoxesTypes = Integer.parseInt(firstLine[1]);
        String[] amountOfBoxesByTypes = reader.readLine().split(" ");
        long minRest = Long.MAX_VALUE;
        int minRestIdx = 0;
        for (int i = 0; i < amountOfBoxesTypes; i++) {
            long amountOfBoxes = Long.parseLong(amountOfBoxesByTypes[i]);
            long restHamsters = amountOfHamsters % amountOfBoxes;
            if (restHamsters < minRest) {
                minRestIdx = i;
                minRest = restHamsters;
            }
        }
        long numberOfBoxes = amountOfHamsters / Long.parseLong(amountOfBoxesByTypes[minRestIdx]);
        return (minRestIdx + 1) + " " + numberOfBoxes;
    }
}
