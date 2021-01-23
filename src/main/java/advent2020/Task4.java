package advent2020;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task4 {

    private static final Pattern WHITESPACE = Pattern.compile("\\s");
    private static final Set<String> MANDATORY_FIELDS = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public static void main(String[] args) {
        System.out.println(new Task4().solve(new Scanner(System.in).useDelimiter("\n\n")));
    }

    private int solve(Scanner scanner) {
        int valid = 0;
        while (scanner.hasNext()) {
            if (isValid(scanner.next())) {
                valid++;
            }
        }
        return valid;
    }

    private boolean isValid(String textPassword) {
        if (textPassword.isEmpty()) {
            return false;
        }
        Map<String, String> passport = Arrays.stream(WHITESPACE.split(textPassword))
                .map(e -> e.split(":"))
                .collect(Collectors.toMap(e -> e[0], e -> e[1]));
        for (String mandatoryField : MANDATORY_FIELDS) {
            if (!passport.containsKey(mandatoryField)) {
                return false;
            }
        }
        return true;
    }
}
