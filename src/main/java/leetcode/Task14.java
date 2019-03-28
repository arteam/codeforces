package leetcode;

public class Task14 {

    public static void main(String[] args) {
        System.out.println(new Task14().longestCommonPrefix(new String[]{"a"}));
        System.out.println(new Task14().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Task14().longestCommonPrefix(new String[]{"dog", "racer", "car"}));
        System.out.println(new Task14().longestCommonPrefix(new String[]{"apba", "ap"}));
        System.out.println(new Task14().longestCommonPrefix(new String[]{}));
    }

    public String longestCommonPrefix(String[] strs) {
        String first = strs.length > 0 ? strs[0] : "";
        String longestPrefix = "";
        for (int i = 1; i <= first.length(); i++) {
            String prefix = first.substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(prefix)) {
                    return longestPrefix;
                }
            }
            longestPrefix = prefix;
        }
        return longestPrefix;
    }

}

