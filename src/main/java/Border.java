import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Border {

    public static void main(String[] args) {
        new Border().run();
    }

    private void run() {
        String[] borders = readDataFromConsole();
        int count = countBorders(borders);
        writeDataToConsole(String.valueOf(count));
    }

    private int countBorders(String[] inputBorders) {
        Set<Integer> borders = new HashSet<Integer>();
        boolean existCandidate = false;
        int bordersCount = 0;
        for (String border : inputBorders) {
            Integer borderLength = Integer.parseInt(border);
            if (!borders.add(borderLength)) {
                borders.remove(borderLength);
                if (existCandidate) {
                    bordersCount++;
                }
                existCandidate = !existCandidate;
            }
        }
        return bordersCount;
    }

    private String[] readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int amountBorders = Integer.parseInt(in.readLine());
            String[] borders = in.readLine().split(" ");
            if (borders.length == amountBorders) {
                return borders;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeDataToConsole(String s) {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            out.write(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
