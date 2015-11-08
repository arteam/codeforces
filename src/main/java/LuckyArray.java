import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LuckyArray {


    private static List<Integer> luckyNumbers =
            (List<Integer>) Arrays.asList(4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777);


    public static void main(String[] args) {
        new LuckyArray().run();
    }

    private void run() {
        String result = readDataFromConsole();
        writeDataToConsole(result);
    }

    private String readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] firstLine = in.readLine().split(" ");
            int arraySize = Integer.parseInt(firstLine[0]);
            int amountClause = Integer.parseInt(firstLine[1]);

            List<Integer> numberArray = new ArrayList<Integer>(arraySize);
            Scanner scanner = new Scanner(in.readLine());
            while (scanner.hasNextInt()) {
                numberArray.add(scanner.nextInt());
            }

            StringBuffer result = new StringBuffer("");
            for (int i = 0; i < amountClause; i++) {
                String clause = in.readLine();
                if (clause.startsWith("count")) {
                    String[] arguments = clause.split(" ");
                    int startIndex = Integer.parseInt(arguments[1]);
                    int endIndex = Integer.parseInt(arguments[2]);
                    int count = 0;
                    for (int j = startIndex - 1; j < endIndex; j++) {
                        if (luckyNumbers.contains(numberArray.get(j))) {
                            count++;
                        }
                    }
                    if (!result.toString().equals("")) {
                        result.append("\n");
                    }
                    result.append(Integer.toString(count));
                } else if (clause.startsWith("add")) {
                    String[] arguments = clause.split(" ");
                    int startIndex = Integer.parseInt(arguments[1]);
                    int endIndex = Integer.parseInt(arguments[2]);
                    int addableValue = Integer.parseInt(arguments[3]);
                    for (int j = startIndex - 1; j < endIndex; j++) {
                        Integer currentValue = numberArray.get(j);
                        numberArray.set(j, currentValue += addableValue);
                    }
                }
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
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
