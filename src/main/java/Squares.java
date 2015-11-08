import java.io.*;
import java.util.*;

public class Squares {
    private static final List<Integer> squares = new ArrayList<Integer>();

    static {
        for (int i = 0; i <= 31; i++) {
            squares.add(i * i);
        }
    }

    public static void main(String[] args) {
        new Squares().run();
    }

    private void run() {
        String numbers = readDataFromConsole();
        String[] arguments = numbers.split(" ");
        int n = Integer.parseInt(arguments[0]);
        int m = Integer.parseInt(arguments[1]);

        int amount = 0;
        for (int i = 0; i < squares.size(); i++) {
            Integer square = squares.get(i);
            if (square > n) {
                break;
            }
            Integer b = n - square;
            if ((b * b + i) == m) {
                amount++;
            }
        }

        writeDataToConsole(String.valueOf(amount));
    }


    private String readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
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
