import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LuckyStrings {

    private static List<String> luckyStrings = (List<String>) Arrays.asList
            ("4", "7", "44", "47", "74", "77", "444", "447", "474", "477", "744", "747", "774", "777");

    public static void main(String[] args) {
        new LuckyStrings().run();
    }

    private void run() {
        String number = readDataFromConsole();
        int maxEntry = 0;
        String luckyStringWithMaxEntry = "";
        for (String luckyString : luckyStrings) {
            int entry = getNumbersOfSubstrings(number, luckyString);
            if (entry > maxEntry) {
                maxEntry = entry;
                luckyStringWithMaxEntry = luckyString;
            }
        }
        if (maxEntry > 0) {
            writeDataToConsole(luckyStringWithMaxEntry);
        } else {
            writeDataToConsole("-1");
        }
    }

    private Integer getNumbersOfSubstrings(String number, String substring) {
        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(number);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
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
