package advent2018;

public class Task5_2 {

    private final Task5 task5 = new Task5();

    public int getShortestPolymerWithRemovedUnitsOfSameType(String input) {
        return input.chars().map(Character::toLowerCase).distinct().mapToObj(fc -> {
            StringBuilder filtered = new StringBuilder(input.length());
            for (char c : input.toCharArray()) {
                if (c != fc && Character.toLowerCase(c) != fc) {
                    filtered.append(c);
                }
            }
            return filtered;
        }).mapToInt(task5::solve).min().getAsInt();
    }


}
