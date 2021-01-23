package advent2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Task2_2 {

    public static void main(String[] args) throws IOException {
        System.out.println(new Task2_2().solve(new BufferedReader(new InputStreamReader(System.in, UTF_8))));
    }

    private int solve(BufferedReader reader) throws IOException {
        int validPasswords = 0;
        while (true) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            String[] positions = parts[0].split("-");
            int firstPosition = Integer.parseInt(positions[0]);
            int secondPosition = Integer.parseInt(positions[1]);
            char symbol = parts[1].charAt(0);
            String password = parts[2];
            boolean firstMatch = password.charAt(firstPosition - 1) == symbol;
            boolean secondMatch = password.charAt(secondPosition - 1) == symbol;
            if (firstMatch ^ secondMatch) {
                validPasswords++;
            }
        }
        return validPasswords;
    }
}
