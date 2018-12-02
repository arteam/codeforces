import java.math.BigDecimal;
import java.util.Scanner;

public class PetyaOrigami {

    public static void main(String[] args) {
        System.out.println(new PetyaOrigami().solve(new Scanner(System.in).nextLine()));
    }

    long solve(String input) {
        String[] split = input.split(" ");
        BigDecimal friends = new BigDecimal(split[0]);
        BigDecimal notebookSheets = new BigDecimal(split[1]);
        BigDecimal redSheets = BigDecimal.valueOf(2);
        BigDecimal greenSheets = BigDecimal.valueOf(5);
        BigDecimal blueSheets = BigDecimal.valueOf(8);
        BigDecimal redNotebooks = friends.multiply(redSheets).divide(notebookSheets, BigDecimal.ROUND_UP);
        BigDecimal greenNotebooks = friends.multiply(greenSheets).divide(notebookSheets, BigDecimal.ROUND_UP);
        BigDecimal blueNotebooks = friends.multiply(blueSheets).divide(notebookSheets, BigDecimal.ROUND_UP);
        return redNotebooks.add(greenNotebooks).add(blueNotebooks).longValue();
    }
}
