package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Task131 {

    public static void main(String[] args) {
        System.out.println(new Task131().partition("aab"));
        System.out.println(new Task131().partition("bb"));
    }

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) {
            return List.of();
        }
        if (s.length() == 1) {
            return List.of(List.of(s));
        }
        List<List<String>> results = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String head = s.substring(0, i);
            if (!isPalindrome(head)) {
                continue;
            }
            String tail = s.substring(i);
            if (tail.isEmpty()) {
                results.add(List.of(head));
                break;
            }
            for (List<String> parts : partition(tail)) {
                List<String> merged = new ArrayList<>();
                merged.add(head);
                merged.addAll(parts);
                results.add(merged);
            }
        }
        return results;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
