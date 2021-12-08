package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Task8 {
    private static final Pattern VERTICAL_BAR = Pattern.compile(" \\| ");

    public static void main(String[] args) {
        System.out.println(new BufferedReader(new InputStreamReader(System.in)).lines()
                .mapToLong(l -> Arrays.stream(VERTICAL_BAR.split(l)[1].split(" "))
                        .filter(x -> x.length() == 2 || x.length() == 3 || x.length() == 4 || x.length() == 7)
                        .count())
                .sum());
    }
}
