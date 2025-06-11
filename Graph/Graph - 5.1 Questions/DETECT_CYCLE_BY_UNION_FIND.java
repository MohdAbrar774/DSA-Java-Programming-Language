import java.util.*;

public class DETECT_CYCLE_BY_UNION_FIND {

    static int V = 5, E = 4;
    static int parent[] = new int[V];

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 2));
        graph.add(new Edge(0, 3));

        graph.add(new Edge(2, 1));

        graph.add(new Edge(3, 4));
    }

    public static int find(int parent[], int x) {

        if (parent[x] == x) {
            return x;
        }

        return find(parent, parent[x]);
    }

    public static void union(int[] parent, int x, int y) {

        parent[x] = y;
    }

    public static int detectCycle(ArrayList<Edge> graph) {

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            Edge e = graph.get(i);

            int x = find(parent, e.dest);
            int y = find(parent, e.src);

            if (x == y) {
                return -1;
            }
            union(parent, x, y);
        }

        return 0;
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();

        createGraph(graph);

        if (detectCycle(graph) == -1) {
            System.out.println("Cycle Found!!!");
        } else {
            System.out.println("No Cycle Found!");

        }

    }

}
