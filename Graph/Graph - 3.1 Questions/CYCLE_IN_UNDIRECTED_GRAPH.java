import java.util.*;

public class CYCLE_IN_UNDIRECTED_GRAPH {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));

        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 0));
        graph[4].add(new Edge(4, 2));
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int src, int para) {

        int[] parent = new int[graph.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        vis[src] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    q.add(e.dest);
                    parent[e.dest] = curr;
                } else if (parent[curr] != e.dest) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && detectCycleUtil(graph, vis, i, -1)) {
                return true;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean isCycle = detectCycle(graph);
        if (isCycle == true) {
            System.out.println("Yes");
        } else {
            System.out.println("{No}");

        }
    }

}