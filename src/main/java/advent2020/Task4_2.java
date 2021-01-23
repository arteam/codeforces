package advent2020;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task4_2 {

    private static final Set<String> MANDATORY_FIELDS = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
    private static final Pattern WHITESPACE = Pattern.compile("\\s");
    private static final Pattern PID_PATTERN = Pattern.compile("\\d{9}");
    private static final Pattern ECL_PATTERN = Pattern.compile("amb|blu|brn|gry|grn|hzl|oth");
    private static final Pattern HCL_PATTERN = Pattern.compile("#[0-9a-f]{6}");
    private static final Pattern HGT_PATTERN = Pattern.compile("(\\d+)(cm|in)");

    public static void main(String[] args) {
        System.out.println(new Task4_2().solve(new Scanner(System.in).useDelimiter("\n\n")));
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
            String value = passport.get(mandatoryField);
            if (value == null) {
                return false;
            }
            if (mandatoryField.equals("byr")) {
                int iValue = Integer.parseInt(value);
                if (iValue < 1920 || iValue > 2002) {
                    return false;
                }
            } else if (mandatoryField.equals("iyr")) {
                int iValue = Integer.parseInt(value);
                if (iValue < 2010 || iValue > 2020) {
                    return false;
                }
            } else if (mandatoryField.equals("eyr")) {
                int iValue = Integer.parseInt(value);
                if (iValue < 2020 || iValue > 2030) {
                    return false;
                }
            } else if (mandatoryField.equals("hgt")) {
                Matcher matcher = HGT_PATTERN.matcher(value);
                if (!matcher.matches()) {
                    return false;
                }
                int height = Integer.parseInt(matcher.group(1));
                String unit = matcher.group(2);
                if (unit.equals("cm")) {
                    if (height < 150 || height > 193) {
                        return false;
                    }
                } else if (unit.equals("in")) {
                    if (height < 59 || height > 76) {
                        return false;
                    }
                }
            } else if (mandatoryField.equals("hcl")) {
                if (!HCL_PATTERN.matcher(value).matches()) {
                    return false;
                }
            } else if (mandatoryField.equals("ecl")) {
                if (!ECL_PATTERN.matcher(value).matches()) {
                    return false;
                }
            } else if (mandatoryField.equals("pid")) {
                if (!PID_PATTERN.matcher(value).matches()) {
                    return false;
                }
            }
        }
        return true;
    }
}
