package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Task_13 {

    record Point(int x, int y) {
    }

    public static void main(String[] args) {
        List<String> lines = new BufferedReader(new InputStreamReader(System.in)).lines().toList();
        Set<Point> points = lines.stream()
                .filter(l -> !l.startsWith("fold"))
                .filter(l -> !l.isEmpty())
                .map(l -> l.split(","))
                .map(e -> new Point(Integer.parseInt(e[0]), Integer.parseInt(e[1])))
                .collect(Collectors.toSet());
        String[] instruction = lines.stream()
                .filter(l -> l.startsWith("fold"))
                .findFirst()
                .orElse("")
                .split(" ")[2]
                .split("=");
        String direction = instruction[0];
        int coordinate = Integer.parseInt(instruction[1]);
        System.out.println(points.stream().map(p -> direction.equals("x") ?
                (p.x > coordinate ? new Point(coordinate - (p.x - coordinate), p.y) : p) :
                (p.y > coordinate ? new Point(p.x, coordinate - (p.y - coordinate)) : p))
                .distinct()
                .count());
    }
}
