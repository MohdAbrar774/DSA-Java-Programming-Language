import java.util.*;

public class HeapQue {

   

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int k = 3;

    public static ArrayList<Integer> kthLargest(int arr[]) {
        
     ArrayList<Integer> res = new ArrayList<>(); 
        
        for (int  val : arr) {
           
            if (pq.size() < k) {
                pq.add(val);
            } else if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }

            if (pq.size() >= k) {
               res.add(pq.peek());
            }else{
                pq.add(-1);
            }
        }

        return res;
    }

    public static void minTimeToFillSlots(int arr[], int k, int n){
         int time = 0; 
         boolean visited[] = new boolean[n+1];


         Queue<Integer> q = new LinkedList<>();


         for(int i=0; i<k; i++){
            q.add(arr[i]);

          visited[arr[i]] = true;
         }

         while(q.size() > 0){

            for(int i=0; i<q.size(); i++){
            int val = q.remove();

            if(val+1 <= n && !visited[val+1]){
                
                visited[val+1] = true;
                    q.add(val+1);
                }
                if(val-1 >= 1 && !visited[val-1]){
                    visited[val-1] = true;
                    q.add(val-1);
                }
            }
            time++;
         }
         System.out.println();

         System.out.println(time-1);
    }

    
    public static void main(String[] args) {
        int arr[] = {2, 6};
        int  k = 2;
        int n = 6;

        minTimeToFillSlots(arr, k , n);


    }
}
