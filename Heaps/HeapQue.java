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

    
    public static void main(String[] args) {
        int arr[] = { 10, 20, 11, 70, 50, 40, 100, 5 };


        ArrayList<Integer>  res = kthLargest(arr);

        for (int val : res) {
            System.out.println(val+" ");
        }

    }
}
