package leetcode;

public class Task7 {

    public static void main(String[] args) {
        System.out.println(new Task7().reverse(123));
        System.out.println(new Task7().reverse(-123));
        System.out.println(new Task7().reverse(120));
        System.out.println(new Task7().reverse(1534236469));
        System.out.println(new Task7().reverse(-2147483648));
    }

    public int reverse(int x) {
        StringBuilder reversedX = new StringBuilder();
        int firstSymbolIndex = 0;
        if (x < 0) {
            reversedX.append("-");
            firstSymbolIndex = 1;
        }
        String xStr = String.valueOf(x);
        for (int i = xStr.length() - 1; i >= firstSymbolIndex; i--) {
            reversedX.append(xStr.charAt(i));
        }
        long reversedXLong = Long.parseLong(reversedX.toString());
        return reversedXLong <= Integer.MAX_VALUE && reversedXLong >= Integer.MIN_VALUE ? (int) reversedXLong : 0;
    }
}
