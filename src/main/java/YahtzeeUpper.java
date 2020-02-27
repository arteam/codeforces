import java.util.List;
import java.util.stream.Collectors;

public class YahtzeeUpper {

    static int maximum(List<Integer> rolls) {
        return rolls.stream().collect(Collectors.toMap(i -> i, i -> i, Integer::sum)).values().stream().max(Integer::compareTo).orElse(0);
    }
}
