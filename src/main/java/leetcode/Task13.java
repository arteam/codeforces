package leetcode;

public class Task13 {

    public static void main(String[] args) {
        System.out.println(new Task13().romanToInt("III"));
        System.out.println(new Task13().romanToInt("IV"));
        System.out.println(new Task13().romanToInt("IX"));
        System.out.println(new Task13().romanToInt("LVIII"));
        System.out.println(new Task13().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int[] dict = new int[128];
        dict['I'] = 1;
        dict['V'] = 5;
        dict['X'] = 10;
        dict['L'] = 50;
        dict['C'] = 100;
        dict['D'] = 500;
        dict['M'] = 1000;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int v = dict[s.charAt(i)];
            int v1 = i < s.length() - 1 ? dict[s.charAt(i + 1)] : 0;
            if (v >= v1) {
                result += v;
            } else {
                result -= v;
            }
        }
        return result;
    }
}
