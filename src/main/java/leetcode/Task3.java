package leetcode;

public class Task3 {

    public static void main(String[] args) {
        System.out.println(new Task3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Task3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Task3().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Task3().lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] substringCharIndex = new int[128];
            substringCharIndex[s.charAt(i)]++;
            for (int j = i + 1; j < s.length(); j++) {
                if (substringCharIndex[s.charAt(j)] > 0) {
                    break;
                }
                substringCharIndex[s.charAt(j)]++;
            }
            int size = 0;
            for (int c : substringCharIndex) {
                if (c == 1) {
                    size++;
                }
            }
            if (size > maxSize) {
                maxSize = size;
            }
        }
        return maxSize;
    }
}
