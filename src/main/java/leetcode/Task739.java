package leetcode;

import java.util.Arrays;

public class Task739 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Task739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysForWarmerWeather = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    daysForWarmerWeather[i] = j - i;
                    break;
                }
            }
        }
        return daysForWarmerWeather;
    }
}
