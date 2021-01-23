package advent2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task2 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Task2().solve(new BufferedReader(new InputStreamReader(System.in, UTF_8))));
    }

    private int solve(BufferedReader reader) throws IOException {
        int validPasswords = 0;
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            String[] minMax = parts[0].split("-");
            int min = Integer.parseInt(minMax[0]);
            int max = Integer.parseInt(minMax[1]);
            char symbol = parts[1].charAt(0);
            String password = parts[2];
            int encounters = 0;
            for (char c : password.toCharArray()) {
                if (c == symbol) {
                    encounters++;
                }
            }
            if (encounters >= min && encounters <= max) {
                validPasswords++;
            }
        }
        return validPasswords;
    }
}
