import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Timetable {

    public static void main(String[] args) throws Exception {
        System.out.println(new Timetable().run(new BufferedReader(new InputStreamReader(System.in))));
    }

    public String run(BufferedReader reader) throws Exception {
        String[] input = reader.readLine().split(" ");
        int amountOfDays = Integer.valueOf(input[0]);
        int amountOfHours = Integer.valueOf(input[1]);
        int lessons = Integer.valueOf(input[2]);
        List<int[]> timetable = new ArrayList<>();
        for (int i = 0; i < amountOfDays; i++) {
            char[] daySchedule = reader.readLine().toCharArray();
            int[] day = new int[amountOfHours];
            for (int j = 0; j < amountOfHours; j++) {
                day[j] = daySchedule[j] == '1' ? 1 : 0;
            }
            timetable.add(day);
        }
        List<Rating> ratings = timetable.stream()
                .peek(ints -> System.err.println(Arrays.toString(ints) + " " + rating(ints)))
                .map(Timetable::rating)
                .sorted(Comparator.comparingInt(Rating::getRating).reversed())
                .collect(Collectors.toList());
        for (Rating rating : ratings) {
            if (rating.sum - 1 <= lessons) {
                rating.distance = 1;
                lessons -= rating.sum - 1;
            }
        }
        int sumDistance = 0;
        for (Rating rating : ratings) {
            if (rating.distance > 1) {
                sumDistance += rating.distance + 1;
            } else if (rating.distance == 1) {
                sumDistance++;
            }
        }
        return String.valueOf(sumDistance - lessons);
    }

    private static Rating rating(int[] day) {
        int distance = distance(day);
        int sum = sum(day);
        return new Rating(sum, distance);
    }

    private static int distance(int[] day) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < day.length; i++) {
            if (day[i] == 1) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        if (first == -1) {
            return 0;
        }
        return last - first;
    }

    private static int sum(int[] day) {
        int sum = 0;
        for (int i : day) {
            sum += i;
        }
        return sum;
    }

    private static class Rating {
        private int sum;
        private int distance;

        private Rating(int sum, int distance) {
            this.sum = sum;
            this.distance = distance;
        }

        private int getRating() {
            return distance - sum;
        }

        @Override
        public String toString() {
            return "Rating{" +
                    "sum=" + sum +
                    ", distance=" + distance +
                    ", rating=" + getRating() +
                    '}';
        }
    }
}
