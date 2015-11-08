import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MagicNumbers {

    private enum State {ONE, FOURTEEN, ONE_HUNDRED_FOURTEEN}

    public static void main(String[] args) {
        new MagicNumbers().run();
    }

    private void run() {
        char[] checkedNumber = readDataFromConsole().toCharArray();
        boolean count = countBorders(checkedNumber);
        writeDataToConsole(count ? "YES" : "NO");
    }

    private boolean countBorders(char[] checkedNumber) {
        State state = State.ONE_HUNDRED_FOURTEEN;
        for (char c : checkedNumber) {
            if (state == State.ONE) {
                if (c == '1') {
                    continue;
                }
                if (c == '4') {
                    state = State.FOURTEEN;
                    continue;
                }
            } else if (state == State.FOURTEEN) {
                if (c == '1') {
                    state = State.ONE;
                    continue;
                }
                if (c == '4') {
                    state = State.ONE_HUNDRED_FOURTEEN;
                    continue;
                }
            } else {
                if (c == '1') {
                    state = State.ONE;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    private String readDataFromConsole() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {
           return in.readLine();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void writeDataToConsole(String s) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));) {
            out.write(s);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }
}
