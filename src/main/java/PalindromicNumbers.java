import java.math.BigInteger;

public class PalindromicNumbers {

    static class StepsPalindrome {
        int steps;
        BigInteger palindrome;

        StepsPalindrome(int steps, BigInteger palindrome) {
            this.steps = steps;
            this.palindrome = palindrome;
        }
    }

    StepsPalindrome run(int input) {
        int steps = 0;
        BigInteger n = BigInteger.valueOf(input);
        while (!isPalindromic(n)) {
            n = n.add(reverse(n));
            steps++;
        }
        return new StepsPalindrome(steps, n);
    }

    private boolean isPalindromic(BigInteger input) {
        return input.equals(reverse(input));
    }

    private BigInteger reverse(BigInteger input) {
        char[] inputChars = input.toString().toCharArray();
        StringBuilder reversed = new StringBuilder(inputChars.length);
        for (int i = inputChars.length - 1; i >= 0; i--) {
            reversed.append(inputChars[i]);
        }
        return new BigInteger(reversed.toString());
    }
}
