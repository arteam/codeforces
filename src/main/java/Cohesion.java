import java.io.*;
import java.util.*;

public class Cohesion {

    List<String> volunteer;

    private boolean[][] graph;

    public static void main(String[] args) {
        new Cohesion().run();
    }

    public void run() {
        readDataFromConsole();
        List<Integer> maxSetIndexes = new BronKerbosh().maximumIndependentSet(graph);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            out.write(maxSetIndexes.size() + "\n");
            for (int i = 0; i < maxSetIndexes.size() - 1; i++) {
                out.write(volunteer.get(maxSetIndexes.get(i)) + "\n");
            }
            if (maxSetIndexes.size() > 0) {
                out.write(volunteer.get(maxSetIndexes.get(maxSetIndexes.size() - 1)));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readDataFromConsole() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = in.readLine().split(" ");
            int amountVolunteers = Integer.parseInt(line[0]);
            int amountPairs = Integer.parseInt(line[1]);
            volunteer = new ArrayList<String>(amountVolunteers);
            for (int i = 0; i < amountVolunteers; i++) {
                String name = in.readLine();
                volunteer.add(name);
            }
            Collections.sort(volunteer);
            graph = new boolean[amountVolunteers][amountVolunteers];
            for (int i = 0; i < amountPairs; i++) {
                String[] names = in.readLine().split(" ");
                Integer firstNameIndex = Collections.binarySearch(volunteer, names[0]);
                Integer secondNameIndex = Collections.binarySearch(volunteer, names[1]);
                graph[firstNameIndex][secondNameIndex] =
                        graph[secondNameIndex][firstNameIndex] = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class BronKerbosh {

        private void findMaximumIndependentSet(List<Integer> cur, List<Integer> result,
                                               boolean[][] graph, int[] oldSet,
                                               int ne, int ce) {
            int nod = 0;
            int minnod = ce;
            int fixp = -1;
            int s = -1;

            for (int i = 0; i < ce && minnod != 0; i++) {
                int p = oldSet[i];
                int cnt = 0;
                int pos = -1;

                for (int j = ne; j < ce; j++)
                    if (graph[p][oldSet[j]]) {
                        if (++cnt == minnod)
                            break;
                        pos = j;
                    }

                if (minnod > cnt) {
                    minnod = cnt;
                    fixp = p;
                    if (i < ne) {
                        s = pos;
                    } else {
                        s = i;
                        nod = 1;
                    }
                }
            }

            int[] newSet = new int[ce];

            for (int k = minnod + nod; k >= 1; k--) {
                int sel = oldSet[s];
                oldSet[s] = oldSet[ne];
                oldSet[ne] = sel;

                int newne = 0;
                for (int i = 0; i < ne; i++)
                    if (!graph[sel][oldSet[i]])
                        newSet[newne++] = oldSet[i];

                int newce = newne;
                for (int i = ne + 1; i < ce; i++)
                    if (!graph[sel][oldSet[i]])
                        newSet[newce++] = oldSet[i];

                cur.add(sel);
                if (newce == 0) {
                    if (result.size() < cur.size()) {
                        result.clear();
                        result.addAll(cur);
                    }
                } else if (newne < newce) {
                    if (cur.size() + newce - newne > result.size())
                        findMaximumIndependentSet(cur, result, graph, newSet, newne, newce);
                }

                cur.remove(cur.size() - 1);
                if (k > 1)
                    for (s = ++ne; !graph[fixp][oldSet[s]]; s++)
                        ;
            }
        }

        public List<Integer> maximumIndependentSet(boolean[][] graph) {
            int n = graph.length;
            int[] all = new int[n];
            for (int i = 0; i < n; i++)
                all[i] = i;
            List<Integer> res = new ArrayList<Integer>();
            findMaximumIndependentSet(new ArrayList<Integer>(), res, graph, all, 0, n);
            return res;
        }
    }
}