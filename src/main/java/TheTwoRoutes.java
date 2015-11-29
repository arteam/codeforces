import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Date: 11/29/15
 * Time: 4:18 PM
 */
public class TheTwoRoutes {

    private static class Graph {
        private int[][] vertexes;

        public Graph(int size) {
            this.vertexes = new int[size][size];
        }

        public int length() {
            return vertexes.length;
        }

        public int get(int i, int j) {
            return vertexes[i][j];
        }

        public void uSet(int i, int j, int value) {
            set(i, j, value);
            set(j, i, value);
        }

        public void set(int i, int j, int value) {
            vertexes[i][j] = value;
        }

        public Graph copy() {
            Graph copy = new Graph(length());
            for (int i = 0; i < length(); i++) {
                System.arraycopy(vertexes[i], 0, copy.vertexes[i], 0, length());
            }
            return copy;
        }

        public Graph reverse() {
            Graph copy = copy();
            for (int i = 0; i < length(); i++) {
                for (int j = 0; j < length(); j++) {
                    if (i == j || copy.get(i, j) > 0) {
                        copy.set(i, j, 0);
                    } else {
                        copy.set(i, j, Integer.MAX_VALUE);
                    }
                }
            }
            return copy;
        }

        public void print() {
            for (int[] row : vertexes) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    private int breadthFirstSearch(Graph graph, int root) {
        Queue<Integer> candidates = new ArrayDeque<>();
        candidates.add(root);
        while (!candidates.isEmpty()) {
            Integer candidate = candidates.poll();
            for (int i = 0; i < graph.length(); i++) {
                if (graph.get(candidate, i) == Integer.MAX_VALUE) {
                    graph.set(candidate, i, graph.get(root, candidate) + 1);
                    graph.set(i, candidate, graph.get(root, candidate) + 1);
                    if (graph.get(root, i) == 0) {
                        graph.set(root, i, graph.get(root, candidate) + 1);
                        graph.set(i, root, graph.get(root, candidate) + 1);
                    }
                    candidates.add(i);
                }
            }
        }
        return graph.get(0, graph.length() - 1);
    }

    public int shortestPath(int vertexes, int amountEdges, List<String> edges) {
        Graph graph = new Graph(vertexes);
        for (String edge : edges) {
            String[] parts = edge.split(" ");
            int first = Integer.parseInt(parts[0]);
            int second = Integer.parseInt(parts[1]);
            graph.uSet(first - 1, second - 1, Integer.MAX_VALUE);
        }

        Graph reversed = graph.reverse();
        int railroadPath = breadthFirstSearch(graph, 0);
        int roadPath = breadthFirstSearch(reversed, 0);
        return railroadPath == 0 || roadPath == 0 ? -1 : Math.max(railroadPath, roadPath);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        int vertexes = Integer.parseInt(parts[0]);
        int amountEdges = Integer.parseInt(parts[1]);
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < amountEdges; i++) {
            edges.add(reader.readLine());
        }
        int shortestPath = new TheTwoRoutes().shortestPath(vertexes, amountEdges, edges);
        System.out.println(shortestPath);
    }
}
