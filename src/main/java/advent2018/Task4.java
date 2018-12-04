package advent2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    private static final Pattern GUARD_ON_DUTY_PATTERN = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2}) \\d{2}:(\\d{2})] Guard #(\\d+) begins shift");
    private static final Pattern GUARD_SLEEPS = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2}) \\d{2}:(\\d{2})] falls asleep");
    private static final Pattern GUARD_WAKES_UP = Pattern.compile("\\[(\\d{4}-\\d{2}-\\d{2}) \\d{2}:(\\d{2})] wakes up");

    public int solve(BufferedReader reader) throws IOException {
        String line;
        Set<String> events = new TreeSet<>();
        while ((line = reader.readLine()) != null) {
            events.add(line);
        }
        int guardOnDuty = 0;
        int guardSleepStartTime = 0;
        int[] guardsTotalSleepingTime = new int[10000];
        int[][] guardsSleepingMinutes = new int[10000][60];
        for (String event : events) {
            Matcher guardOnDutyMatcher = GUARD_ON_DUTY_PATTERN.matcher(event);
            if (guardOnDutyMatcher.find()) {
                guardOnDuty = Integer.parseInt(guardOnDutyMatcher.group(3));
                guardSleepStartTime = 0;
                continue;
            }
            Matcher guardSleepsMatcher = GUARD_SLEEPS.matcher(event);
            if (guardSleepsMatcher.find()) {
                guardSleepStartTime = Integer.parseInt(guardSleepsMatcher.group(2));
                continue;
            }
            Matcher guardWakesUpMatcher = GUARD_WAKES_UP.matcher(event);
            if (guardWakesUpMatcher.find()) {
                int guardWakeUpTime = Integer.parseInt(guardWakesUpMatcher.group(2));
                int sleepDuration = guardWakeUpTime - guardSleepStartTime;
                guardsTotalSleepingTime[guardOnDuty] += sleepDuration;
                for (int i = guardSleepStartTime; i < guardWakeUpTime; i++) {
                    guardsSleepingMinutes[guardOnDuty][i]++;
                }
            }
        }
        int theSleepyGuard = 0;
        int longestTotalSleepTime = 0;
        for (int i = 0; i < guardsTotalSleepingTime.length; i++) {
            if (guardsTotalSleepingTime[i] > longestTotalSleepTime) {
                longestTotalSleepTime = guardsTotalSleepingTime[i];
                theSleepyGuard = i;
            }
        }
        int[] sleepMinutes = guardsSleepingMinutes[theSleepyGuard];
        int mostFrequentMinute = 0;
        int mostFrequentMinuteOccurences = 0;
        for (int i = 0; i < sleepMinutes.length; i++) {
            if (sleepMinutes[i] > mostFrequentMinuteOccurences) {
                mostFrequentMinuteOccurences = sleepMinutes[i];
                mostFrequentMinute = i;
            }
        }
        return theSleepyGuard * mostFrequentMinute;
    }
}
