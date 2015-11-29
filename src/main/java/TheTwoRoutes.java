import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Date: 11/29/15
 * Time: 4:18 PM
 *
 * @author Artem Prigoda
 */
public class TheTwoRoutes {

    public int breadthFirstSearch(Graph graph, int root) {
        Queue<Integer> candidates = new ArrayDeque<>();
        candidates.add(root);
        while (!candidates.isEmpty()) {
            Integer candidate = candidates.poll();
            for (int i = 0; i < graph.length(); i++) {
                if (graph.get(candidate, i) == Integer.MAX_VALUE) {
                    graph.set(candidate, i, graph.get(root, candidate) + 1);
                    graph.set(i, candidate, graph.get(root, candidate) + 1);
                    candidates.add(i);
                }
            }
        }
        return 0;
    }

    private static class Graph {
        private int[][] vertexes;

        public Graph(int size) {
            this.vertexes = new int[5][5];
        }

        public int length() {
            return vertexes.length;
        }

        public int get(int i, int j) {
            return vertexes[i][j];
        }

        public void set(int i, int j, int value) {
            vertexes[i][j] = value;
        }

        public int[] adjacent(int i) {
            return vertexes[i];
        }

        public Graph copy() {
            Graph copy = new Graph(length());
            for (int i = 0; i < length(); i++) {
                System.arraycopy(vertexes[i], 0, copy.vertexes[i], 0, length());
            }
            return copy;
        }

        public void print() {
            for (int[] row : vertexes) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    public static void main(String[] args) {
        int size = 5;
        Graph original = new Graph(size);
        original.vertexes[0][1] = Integer.MAX_VALUE;
        original.vertexes[0][4] = Integer.MAX_VALUE;
        original.vertexes[1][3] = Integer.MAX_VALUE;
        original.vertexes[2][4] = Integer.MAX_VALUE;
        original.vertexes[3][4] = Integer.MAX_VALUE;

        original.print();
        System.out.println("");

        Graph copy = original.copy();
        new TheTwoRoutes().breadthFirstSearch(copy, 0);
        copy.print();

        Graph road = original.copy();
        for (int i = 0; i < original.length(); i++) {
            for (int j = 0; j < original.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (road.get(i, j) == 0) {
                    road.set(i, j, Integer.MAX_VALUE);
                } else {
                    road.set(i, j, 0);
                }
            }
        }
        System.out.println("");

        new TheTwoRoutes().breadthFirstSearch(road, 0);
        road.print();
    }
}
