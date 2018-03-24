import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeedTheCat {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] timeInput = reader.readLine().split(" ");
        int time = Integer.parseInt(timeInput[0]) * 60 + Integer.parseInt(timeInput[1]);

        String[] line = reader.readLine().split(" ");
        BigDecimal catHungerLevel = new BigDecimal(line[0]);
        BigDecimal hungerIncreasePerMinute = new BigDecimal(line[1]);
        BigDecimal bunCost = new BigDecimal(line[2]);
        BigDecimal hungerDecreasePerBun = new BigDecimal(line[3]);

        int discountTime = 20 * 60;
        BigDecimal hungerLevelWhenDiscountStarts = catHungerLevel.add(hungerIncreasePerMinute
                .multiply(BigDecimal.valueOf(Math.max(discountTime - time, 0))));

        BigDecimal costToFeedWithDiscount = bunCost
                .multiply(BigDecimal.valueOf(0.8))
                .multiply(hungerLevelWhenDiscountStarts.divide(hungerDecreasePerBun, RoundingMode.UP))
                .setScale(4, RoundingMode.HALF_UP);
        BigDecimal costToFeedImmediately = bunCost
                .multiply(catHungerLevel.divide(hungerDecreasePerBun, RoundingMode.UP))
                .setScale(4, RoundingMode.HALF_UP);

        System.out.println(costToFeedImmediately.min(costToFeedWithDiscount));
    }
}
