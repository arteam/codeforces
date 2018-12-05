package advent2018;

public class Task5 {

    public int solve(CharSequence input) {
        boolean stable = false;
        CharSequence polymers = input;
        while (!stable) {
            stable = true;
            StringBuilder newPolymer = new StringBuilder(polymers.length());
            int i = 0;
            while (i < polymers.length() - 1) {
                char unit = polymers.charAt(i);
                char nextUnit = polymers.charAt(i + 1);
                if (Math.abs(unit - nextUnit) == 32) {
                    stable = false;
                    i += 2;
                } else {
                    newPolymer.append(unit);
                    i++;
                }
            }
            polymers = newPolymer.append(polymers.charAt(polymers.length() - 1));
        }
        return polymers.length();
    }
}
