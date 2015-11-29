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
                    if (graph.get(root, i) == 0) {
                        graph.set(root, i, graph.get(root, candidate) + 1);
                        graph.set(i, root, graph.get(root, candidate) + 1);
                    }
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
                    if (i == j || copy.get(i, j) == Integer.MAX_VALUE) {
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

    public static void main(String[] args) {
        int size = 5;
        Graph original = new Graph(size);
        original.uSet(0, 1, Integer.MAX_VALUE);
        original.uSet(0, 4, Integer.MAX_VALUE);
        original.uSet(1, 3, Integer.MAX_VALUE);
        original.uSet(2, 4, Integer.MAX_VALUE);
        original.uSet(3, 4, Integer.MAX_VALUE);

        original.print();
        System.out.println("");

        Graph copy = original.copy();
        new TheTwoRoutes().breadthFirstSearch(copy, 0);
        copy.print();

        Graph road = original.reverse();
        System.out.println("");

        new TheTwoRoutes().breadthFirstSearch(road, 0);
        road.print();
    }
}
