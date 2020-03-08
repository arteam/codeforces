public class Atbash {

    private static final int SHIFT = 'z' + 'a';

    public String run(String input) {
        return input.chars()
                .map(c -> c >= 'a' && c <= 'z' ? SHIFT - c : c)
                .collect(StringBuilder::new, (sb, i) -> sb.append((char) i), StringBuilder::append)
                .toString();
    }
}
