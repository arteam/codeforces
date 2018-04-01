import java.util.Scanner;

public class ProsperousLot {
    public static void main(String[] args) {
        System.out.println(new ProsperousLot().solve(new Scanner(System.in).nextInt()));
    }

    public String solve(int numberOfLoops) {
        if (numberOfLoops > 36) {
            return "-1";
        }
        StringBuilder result = new StringBuilder();
        while (numberOfLoops > 0) {
            if (numberOfLoops == 1) {
                result.append("4");
                break;
            }
            result.append("8");
            numberOfLoops -= 2;
        }
        return result.toString();
    }
}
