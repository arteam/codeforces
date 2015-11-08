import java.io.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: artem
 * Date: 27.08.11
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class Pows {

    private Set<Long> numberList;

    public static void main(String[] args) {
         new Pows().run();
    }

    private void run() {
        readDataFromConsole();
        writeDataToConsole(checkNumberList() ? "NO" : "YES");
    }

    private boolean checkNumberList() {
        Iterator<Long> iterator = numberList.iterator();
        long prev = iterator.next();
        while (iterator.hasNext()) {
            Long current = iterator.next();
            if (2 * prev > current) {
                return false;
            }
            prev = current;
        }
        return true;
    }


    private void readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String amountNumbers = in.readLine();
            String numbers = in.readLine();
            numberList = new TreeSet<Long>();
            Scanner scanner = new Scanner(numbers);
            while (scanner.hasNextLong()) {
                numberList.add(scanner.nextLong());
            }
        } catch (IOException e) {
            e.printStackTrace();
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
