package advent2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task7 {

    private static final Pattern INSTRUCTION = Pattern.compile("Step ([A-Z]) must be finished before step ([A-Z]) can begin.");

    public String solve(BufferedReader reader) throws IOException {
        Map<Character, Set<Character>> outcoming = new HashMap<>();
        Map<Character, Set<Character>> incoming = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Matcher matcher = INSTRUCTION.matcher(line);
            if (matcher.find()) {
                char from = matcher.group(1).charAt(0);
                char to = matcher.group(2).charAt(0);
                outcoming.computeIfAbsent(from, k -> new HashSet<>()).add(to);
                incoming.computeIfAbsent(to, k -> new HashSet<>()).add(from);
            }
        }
        NavigableSet<Character> nodesWithNoIncomingEdges =
                outcoming.keySet().stream().filter(n -> !incoming.containsKey(n)).collect(Collectors.toCollection(TreeSet::new));
        StringBuilder sortedNodes = new StringBuilder();
        while (!nodesWithNoIncomingEdges.isEmpty()) {
            Character firstAvailableNode = nodesWithNoIncomingEdges.first();
            nodesWithNoIncomingEdges.remove(firstAvailableNode);
            sortedNodes.append(firstAvailableNode);
            Set<Character> firstOutcomingNodes = outcoming.getOrDefault(firstAvailableNode, Collections.emptySet());
            Iterator<Character> iterator = firstOutcomingNodes.iterator();
            while (iterator.hasNext()) {
                Character node = iterator.next();
                iterator.remove();
                Set<Character> incomingNodes = incoming.get(node);
                incomingNodes.remove(firstAvailableNode);
                if (incomingNodes.isEmpty()) {
                    nodesWithNoIncomingEdges.add(node);
                }
            }
        }

        return sortedNodes.toString();
    }
}
