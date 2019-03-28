package leetcode;

public class Task9 {

    public static void main(String[] args) {
        System.out.println(new Task9().isPalindrome(121));
        System.out.println(new Task9().isPalindrome(12321));
        System.out.println(new Task9().isPalindrome(2458));
        System.out.println(new Task9().isPalindrome(10));
        System.out.println(new Task9().isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long reversed = 0;
        int i = x;
        while (i != 0) {
            reversed = reversed * 10 + i % 10;
            i /= 10;
        }
        return reversed == x;
    }
}
