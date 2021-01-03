import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerfulIntegers {

    public static void main(String[] args) {
        System.out.println(new PowerfulIntegers().powerfulIntegers(2, 3, 10));
        System.out.println(new PowerfulIntegers().powerfulIntegers(3, 5, 15));
        System.out.println(new PowerfulIntegers().powerfulIntegers(2, 1, 10));
        System.out.println(new PowerfulIntegers().powerfulIntegers(1, 2, 100));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> results = new HashSet<>();
        int maxExponentX = x > 1 ? (int) (Math.log(bound) / Math.log(x)) : 1;
        int maxExponentY = y > 1 ? (int) (Math.log(bound) / Math.log(y)) : 1;
        for (int i = 0; i <= maxExponentX; i++) {
            int powX = (int) Math.pow(x, i);
            for (int j = 0; j <= maxExponentY; j++) {
                int powY = (int) Math.pow(y, j);
                if (powX + powY <= bound) {
                    results.add(powX + powY);
                }
            }
        }
        return new ArrayList<>(results);
    }
}
