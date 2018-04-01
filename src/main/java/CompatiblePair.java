import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompatiblePair {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new CompatiblePair().solve(reader));
    }

    public long solve(BufferedReader reader) throws IOException {
        String[] firstLine = reader.readLine().split(" ");
        int firstLanternsAmount = Integer.parseInt(firstLine[0]);
        int secondLanternsAmount = Integer.parseInt(firstLine[1]);
        long[] firstLanterns = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] secondLanterns = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        return Arrays.stream(firstLanterns)
                .map(i -> Arrays.stream(secondLanterns)
                        .map(j -> j * i)
                        .max()
                        .getAsLong())
                .sorted()
                .skip(firstLanternsAmount - 2)
                .findFirst()
                .getAsLong();
    }
}
