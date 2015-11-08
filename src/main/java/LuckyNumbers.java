import java.io.*;
import java.util.*;

public class LuckyNumbers {

    private static List<Integer> luckyNumbers =
            (List<Integer>) Arrays.asList(4, 7, 44, 47, 74, 77, 444, 447, 474, 477, 744, 747, 774, 777);

    public static void main(String[] args) {
        new LuckyNumbers().run();
    }

    private void run() {
        int number = readDataFromConsole();
        String answer = "NO";
        for (Integer luckyNumber : luckyNumbers) {
            if(number % luckyNumber == 0){
               answer = "YES";
               break;
            }
        }
        writeDataToConsole(answer);
    }


    private int readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
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
