package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Task394 {

    public static void main(String[] args) {
        System.out.println(new Task394().decodeString("3[a]2[bc]"));
        System.out.println(new Task394().decodeString("3[a2[c]]"));
        System.out.println(new Task394().decodeString("10[abc]"));
    }

    public String decodeString(String s) {
        Deque<EncodedString> encodedStrings = new ArrayDeque<>();
        encodedStrings.addLast(new EncodedString(1));
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) {
                encodedStrings.getLast().content.append(ch);
            } else if (Character.isDigit(ch)) {
                int j = i + 1;
                while (Character.isDigit(s.charAt(j))) {
                    j++;
                }
                encodedStrings.addLast(new EncodedString(Integer.parseInt(s.substring(i, j))));
                i = j;
            } else if (ch == ']') {
                EncodedString lastEncodedString = encodedStrings.removeLast();
                for (int j = 0; j < lastEncodedString.amount; j++) {
                    encodedStrings.getLast().content.append(lastEncodedString.content);
                }
            }
        }
        return encodedStrings.removeLast().content.toString();
    }

    private static class EncodedString {
        private final StringBuilder content = new StringBuilder();
        private final int amount;

        private EncodedString(int amount) {
            this.amount = amount;
        }
    }
}
