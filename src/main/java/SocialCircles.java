import java.util.Arrays;
import java.util.Scanner;

public class SocialCircles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int j = 0; j < n; j++) {
            left[j] = scanner.nextInt();
            right[j] = scanner.nextInt();
        }
        Arrays.sort(left);
        Arrays.sort(right);
        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.max(left[i], right[i]) + 1;
        }
        System.out.println(answer);
    }
}
