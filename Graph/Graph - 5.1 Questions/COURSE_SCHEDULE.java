import java.util.*;
public class COURSE_SCHEDULE {

    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src =s;
            this.dest=d;
        }
    }

    public static boolean topSortCheck(ArrayList<Edge>[] graph, int n, int[] indeg){

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i=0; i<graph.length; i++){
            if(indeg[i] == 0){
                count++;
                q.add(i);
            }
         
        }

        
        while(!q.isEmpty()){

            int curr = q.remove();

            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);

                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    count++;
                    q.add(e.dest);
                }
            }
        }

        return count == n ? true : false;
    }

    
    public static boolean courseSchedule(int[][] courses, int n){
         
        int[] indeg = new int[n];
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<courses.length; i++){
            int u = courses[i][1];
            int v = courses[i][0];

            graph[u].add(new Edge(u, v));

            indeg[v]++;
        }




        return topSortCheck(graph, n , indeg);
    }
     public static void main(String args[]){

        int numCourses = 2;

        int[][] prerequisites = {{1,0}};

        System.out.println(courseSchedule(prerequisites, numCourses));

     }
    
}
