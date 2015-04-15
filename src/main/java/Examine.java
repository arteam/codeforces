import java.io.*;
import java.util.*;

/**
 * Date: 15.04.15
 * Time: 12:45
 */
public class Examine {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(new Examine().run(reader.readLine()));
        writer.flush();
    }

    public String run(String line) {
        StringJoiner joiner = new StringJoiner(" ");
        int amountStudents = Integer.parseInt(line);
        int students = 0;
        if (amountStudents <= 2) {
            return "1\n1";
        }
        if (amountStudents == 3) {
            return "2\n3 1";
        }
        int start = (amountStudents / 2) + 1;
        for (int i = start; i <= amountStudents; i++) {
            joiner.add(String.valueOf(i));
            int last = i - (amountStudents / 2);
            students++;
            if (last != start) {
                joiner.add(String.valueOf(last));
                students++;
            }
        }
        return students + "\n" + joiner.toString();
    }


}
