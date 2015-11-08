import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeTask {

    public static void main(String[] args) {
        new HomeTask().run();
    }

    private void run() {
        List<Integer> numbers = readDataFromConsole();
        if (numbers.isEmpty() || numbers.get(0) != 0) {
            writeDataToConsole("-1");
            return;
        }
        StringBuilder maxNumber = new StringBuilder();
        maxNumber.append(numbers.get(0));
    }

    private List<Integer> readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String amountNumbers = in.readLine();
            List<Integer> numbers = new ArrayList<Integer>(Integer.parseInt(amountNumbers));

            String[] stringNumbers = in.readLine().split(" ");
            for (String stringNumber : stringNumbers) {
                numbers.add(Integer.parseInt(stringNumber));
            }
            Collections.sort(numbers);
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Integer>();
        } finally {
            closeQuietly(in);
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
            closeQuietly(out);
        }

    }

    private void closeQuietly(Closeable stream) {
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
