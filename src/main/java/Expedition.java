import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Expedition {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int participants = scanner.nextInt();
        int amountOfFoodPackages = scanner.nextInt();
        int[] foodPackages = new int[amountOfFoodPackages];
        for (int i = 0; i < amountOfFoodPackages; i++) {
            foodPackages[i] = scanner.nextInt();
        }
        System.out.println(new Expedition().run(participants, foodPackages));
    }

    int run(int requiredParticipants, int[] foodPackages) {
        Map<Integer, Integer> amountPackagesByType = new HashMap<>();
        for (int foodPackage : foodPackages) {
            amountPackagesByType.merge(foodPackage, 1, (l, r) -> l + r);
        }

        int days = 1;
        while (true) {
            int amountOfPossibleParticipants = 0;
            for (int packages : amountPackagesByType.values()) {
                if (packages < days) {
                    continue;
                }
                amountOfPossibleParticipants += packages / days;
                if (amountOfPossibleParticipants >= requiredParticipants) {
                    days++;
                    break;
                }
            }
            if (amountOfPossibleParticipants < requiredParticipants) {
                return days - 1;
            }
        }
    }
}
