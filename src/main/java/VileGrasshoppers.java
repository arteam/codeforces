import java.util.Scanner;

public class VileGrasshoppers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int grasshoppersTop = scanner.nextInt();
        int vileTop = scanner.nextInt();
        for (int i = vileTop; i > grasshoppersTop; i--) {
            if (isPrime(i, grasshoppersTop)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("-1");
    }

    private static boolean isPrime(int i, int grasshoppersTop) {
        for (int j = 2; j <= Math.min((int) Math.sqrt(i), grasshoppersTop); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
