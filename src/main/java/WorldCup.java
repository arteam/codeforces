import java.util.Scanner;

public class WorldCup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new WorldCup().run(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
    }

    public String run(int numberOfTeams, int firstTeamId, int secondTeamId) {
        int finalRoundNumber = (int) (Math.log(numberOfTeams) / Math.log(2));
        int roundNumber = finalRoundNumber;
        int roundDiff = numberOfTeams / 2;
        int middle = roundDiff;
        int min = Math.min(secondTeamId, firstTeamId);
        int max = Math.max(secondTeamId, firstTeamId);
        while (roundNumber > 1) {
            if (max > middle && min <= middle) {
                break;
            }
            roundNumber--;
            middle = min < middle ? middle - roundDiff / 2 : middle + roundDiff / 2;
            roundDiff /= 2;
        }
        return roundNumber == finalRoundNumber ? "Final!" : String.valueOf(roundNumber);
    }
}
