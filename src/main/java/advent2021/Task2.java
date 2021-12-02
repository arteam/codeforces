package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task2 {

    public static void main(String[] args) {
        record Point(int x, int y) {
            int result() {
                return x * -y;
            }
        }
        System.out.println(new BufferedReader(new InputStreamReader(System.in))
                .lines().reduce(new Point(0, 0),
                        (point, instruction) -> {
                            String[] split = instruction.split(" ");
                            String direction = split[0];
                            int step = Integer.parseInt(split[1]);
                            return switch (direction) {
                                case "forward" -> new Point(point.x + step, point.y);
                                case "down" -> new Point(point.x, point.y - step);
                                case "up" -> new Point(point.x, point.y + step);
                                default -> point;
                            };
                        },
                        (a, b) -> b)
                .result());
    }
}
