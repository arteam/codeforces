import java.util.Optional;
import java.util.Scanner;

public class DiverseSubstrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        Optional<String> result = new DiverseSubstrings().getDiverseSubstring(scanner.nextLine());
        if (result.isPresent()) {
            System.out.println("YES");
            System.out.println(result.get());
        } else {
            System.out.println("NO");
        }
    }

    Optional<String> getDiverseSubstring(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (isDiverse(input, i, j)) {
                    return Optional.of(input.substring(i, j + 1));
                }
            }
        }
        return Optional.empty();
    }

    private boolean isDiverse(String s, int i, int j) {
        if (j - i == 1) {
            return s.charAt(j) != s.charAt(i);
        }
        int[] frequencies = new int[128];
        for (int k = i; k <= j; k++) {
            frequencies[s.charAt(k)]++;
        }
        for (int e : frequencies) {
            if (e > 0 && e > (j - i + 1) / 2) {
                return false;
            }
        }
        return true;
    }
}
