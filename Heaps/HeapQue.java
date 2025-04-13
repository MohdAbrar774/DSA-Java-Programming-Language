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

    static class Info implements Comparable<Info>{
        
        int diff;
         int x;
         int y;

         public Info(int diff, int x, int y){
            this.diff = diff;
            this.x = x;
            this.y = y;

         }

         @Override
         public int compareTo(Info n2){
            return Integer.compare(this.diff, n2.diff);
         }
    }
    public static int[][] dirs = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};


    public static int minEffortPath(int[][] height){
        int m = height.length;
        int n = height[0].length;

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(0, 0, 0));
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            Info node = pq.poll();
            int diff = node.diff;
            int x = node.x;
            int y = node.y;

            if (x == m - 1 && y == n - 1) {
                return diff;
            }

            for (int[] dir : dirs) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n) {
                    int newDiff = Math.max(diff, Math.abs(height[x][y] - height[x_][y_]));
                    if (result[x_][y_] > newDiff) {
                        result[x_][y_] = newDiff;
                        pq.offer(new Info(newDiff, x_, y_));
                    }
                }
            }
        }

        return result[m - 1][n - 1];



    }
    public static void heapify(int i, int arr[], int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {

            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify( maxIdx, arr, size);
        }
    }
    public static int halveArray(int arr[]){
        //step 1 - Create MaxHeap

        int n = arr.length;
        for(int i=n/2; i >= 0; i--){
            heapify(i,arr,n);
        }

        //step 2 - calculate init sum, target sum & track operations, till curr>target

        int currSum = 0;
        for (int i : arr) {
            currSum += i;
        }

        int targetSum = currSum/2;
        int operations = 0;

        while (currSum > targetSum) {
            double curr = Math.floor(arr[0]/2);
            arr[0] = (int)curr;
            currSum = 0;
            for (int i : arr) {
                currSum += i;
            }
            operations++;

            heapify(0,arr,n);

        }
        return operations;
    }
    public static void main(String[] args) {
      int arr[] = {5, 19, 8, 1};

      System.out.println("min Operations to halve array sum "+halveArray(arr));
      System.out.println();
    
    }
}
