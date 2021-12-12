package advent2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_12_2 {
    private static final Map<String, List<String>> GRAPH = new BufferedReader(new InputStreamReader(System.in)).lines()
            .map(l -> l.split("-"))
            .flatMap(e -> Stream.of(e, new String[]{e[1], e[0]}))
            .collect(Collectors.groupingBy(e -> e[0], Collectors.mapping(e -> e[1], Collectors.toList())));

    public static void main(String[] args) {
        System.out.println(paths("start", Set.of("start"), false, new AtomicInteger()));
    }

    private static AtomicInteger paths(String cave, Set<String> visitedSmallCaves, boolean visitedSmallCaveTwice, AtomicInteger count) {
        for (String destination : GRAPH.getOrDefault(cave, List.of())) {
            if (destination.equals("start")) {
                continue;
            }
            if (destination.equals("end")) {
                count.incrementAndGet();
                continue;
            }
            if (Character.isUpperCase(destination.charAt(0))) {
                paths(destination, visitedSmallCaves, visitedSmallCaveTwice, count);
                continue;
            }
            if (!visitedSmallCaves.contains(destination)) {
                paths(destination, Stream.concat(visitedSmallCaves.stream(), Stream.of(destination)).collect(
                        Collectors.toSet()), visitedSmallCaveTwice, count);
            } else if (!visitedSmallCaveTwice) {
                paths(destination, visitedSmallCaves, true, count);
            }
        }
        return count;
    }

}
