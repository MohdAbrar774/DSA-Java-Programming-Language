import java.util.*;

public class MOTHER_VERTEX {
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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }
     public static void motherVertexUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, int visV) {


        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e=  graph[curr].get(i);
            if (!vis[e.dest]) {
               motherVertexUtil(graph, e.dest, vis, visV);
            }

        }



         }    
         public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){

            vis[curr] = true;

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!vis[e.dest]){
                    dfs(graph, e.dest, vis);
                }
            }
         }
         
    public static int motherVertex(ArrayList<Edge>[] graph, int V) {

        int ans = -1;

        boolean[] vis = new boolean[V];

        for(int i=0; i<V; i++){
                if(!vis[i]){
                    dfs(graph, i, vis);
                    ans = i;
                }
            }
        


        boolean[] vis2 = new boolean[V];
        dfs(graph, ans, vis2);
        for(boolean x:  vis2){
            if(!x){
                return -1;
            }
        }

        return ans;

    }

    public static void main(String args[]) {

        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println(motherVertex(graph, V));
    }
}