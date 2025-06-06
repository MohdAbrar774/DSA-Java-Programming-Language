import java.util.*;

public class KRUSKALS_ALGO_MST {
    static int n = 4; // Vertices
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {

        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }

    }

    public static void createGraph(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));

    }
     
    //O(V + ElogE)
    public static void kruskalsMST(ArrayList<Edge> graph, int V) {
        init();

        Collections.sort(graph);  //O(ElogE)
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) {//O(V)
            Edge e = graph.get(i);

            int parA = find(e.src); // src = a
            int parB = find(e.dest);// dest = b

            if (par[parA] != par[parB]) {
                union(parA, parB);
                mstCost += e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph = new ArrayList<>();

        createGraph(graph);

        kruskalsMST(graph, V);
    }

}
