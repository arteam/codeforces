import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class StockMarket {

    static class Trade {
        double buy;
        double sell;

        Trade(double buy, double sell) {
            this.buy = buy;
            this.sell = sell;
        }

        @Override
        public String toString() {
            return buy + " " + sell;
        }
    }

    public static void main(String[] args) {
        System.out.println(new StockMarket().run("19.35 19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98"));
        System.out.println(new StockMarket().run("9.20 8.03 10.02 8.08 8.14 8.10 8.31 8.28 8.35 8.34 8.39 8.45 8.38 8.38\n" +
                "8.32 8.36 8.28 8.28 8.38 8.48 8.49 8.54 8.73 8.72 8.76 8.74 8.87\n" +
                "8.82 8.81 8.82 8.85 8.85 8.86 8.63 8.70 8.68 8.72 8.77 8.69 8.65\n" +
                "8.70 8.98 8.98 8.87 8.71 9.17 9.34 9.28 8.98 9.02 9.16 9.15 9.07\n" +
                "9.14 9.13 9.10 9.16 9.06 9.10 9.15 9.11 8.72 8.86 8.83 8.70 8.69\n" +
                "8.73 8.73 8.67 8.70 8.69 8.81 8.82 8.83 8.91 8.80 8.97 8.86 8.81\n" +
                "8.87 8.82 8.78 8.82 8.77 8.54 8.32 8.33 8.32 8.51 8.53 8.52 8.41\n" +
                "8.55 8.31 8.38 8.34 8.34 8.19 8.17 8.16"));
    }

    Trade run(String stockPrices) {
        return run(Arrays.stream(stockPrices.split("\\s")).mapToDouble(Double::parseDouble).toArray());
    }


    Trade run(double[] stockPrices) {
        return IntStream.range(0, stockPrices.length - 1)
                .boxed()
                .flatMap(i -> IntStream.range(i + 2, stockPrices.length)
                        .mapToObj(j -> new Trade(stockPrices[i], stockPrices[j])))
                .max(Comparator.comparingDouble(t -> t.sell - t.buy))
                .orElse(null);
    }
}
