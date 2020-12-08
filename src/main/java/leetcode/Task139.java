package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task139 {

    public static void main(String[] args) {
        System.out.println(new Task139().wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(new Task139().wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(new Task139().wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        System.out.println(new Task139().wordBreak("cars", List.of("car", "ca", "rs")));
        System.out.println(new Task139().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    private final Set<Integer> visited = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak0(s, 0, wordDict);
    }

    private boolean wordBreak0(String s, int index, List<String> wordDict) {
        if (visited.contains(index)) {
            return false;
        }
        if (index >= s.length()) {
            return true;
        }
        String substring = s.substring(index);
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (substring.startsWith(word)) {
                boolean success = wordBreak0(s, index + word.length(), wordDict);
                if (success) {
                    return true;
                } else {
                    visited.add(index);
                }
            }
        }
        return false;
    }
}
