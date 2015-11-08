import java.io.*;
import java.security.PrivateKey;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: artem
 * Date: 25.08.11
 * Time: 22:20
 */
public class TimePalindrom {

    private NavigableSet<String> times = new TreeSet<String>();

    private void initSet() {
        int hours = 24;
        int minute = 59;
        String delimiter = ":";
        for (int i = 0; i < hours; i++) {
            int r = (i % 10) * 10 + i / 10;
            if (r <= minute) {
                String hour = String.format("%02d", i);
                String second = "" + hour.charAt(1) + hour.charAt(0);
                times.add(hour + delimiter + second);
            }
        }
    }

    private String getNextTime(String currentTime) {
        String higher = times.higher(currentTime);
        if (higher == null) {
            higher = times.first();
        }
        return higher;
    }

    private void run() {
        initSet();
        String currentTime = IOUtils.readDataFromConsole();
        String higher = getNextTime(currentTime);
        IOUtils.writeDataToConsole(higher);
    }

    public static void main(String[] args) {
        //new TimePalindrom().run();
        Scanner sc = new Scanner(System.in);
        String s1, s2;
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        System.out.println(s1 + s2);
    }

    private static class IOUtils {

        private static String readDataFromConsole() {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String s;
            try {
                while ((s = in.readLine()) != null && s.length() != 0) {
                    return s;
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
            return null;
        }

        private static void writeDataToConsole(String s) {
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

}
