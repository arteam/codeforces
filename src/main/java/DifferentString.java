public class DifferentString {

    String run(String input) {
        String[] lines = input.split("\n");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(lines[0]); i++) {
            String rearranged = rearranged(lines[i + 1]);
            if (rearranged != null) {
                result.append("YES").append("\n").append(rearranged).append("\n");
            } else {
                result.append("NO").append("\n");
            }
        }
        return result.toString();
    }

    private static String rearranged(String s) {
        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j) != s.charAt(0)) {
                char[] chars = s.toCharArray();
                char temp = chars[0];
                chars[0] = chars[j];
                chars[j] = temp;
                return new String(chars);
            }
        }
        return null;
    }
}
