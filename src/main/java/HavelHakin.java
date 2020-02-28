import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HavelHakin {

    boolean run(List<Integer> answers) {
        List<Integer> sorted = answers.stream().filter(i -> i != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if (sorted.isEmpty()) {
            return true;
        }
        if (sorted.get(0) > sorted.size() - 1) {
            return false;
        }
        return run(sorted.stream().map(i -> i - 1).collect(Collectors.toList()));
    }
}
