import java.util.*;

public class QueueQs {

    public static void fstRepeatCh(String str) {

        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.println(-1 + " ");
            } else {
                System.out.println(q.peek() + " ");

            }

        }
        System.out.println();
    }
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();

        int size   = q.size();

        for(int i=0; i<size/2; i++){
            firstHalf.add(q.remove());
        }
        
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void reversQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        while (!q.isEmpty()) {

            s.push(q.remove());
        }

        while (!s.isEmpty()) {

            q.add(s.pop());
        }

    }

    // Practice QS.01
    public static void NbinNum(int n) {
        Queue<String> q = new LinkedList<String>();

        q.add("1");
        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.print(s1 + " ");

            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");

        }

    }

    // Practice QS.02
    public static int minCost(int arr[], int n) {

        Queue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            que.add(arr[i]);
        }

        int res = 0;
        while (que.size() > 1) {

            int first = que.poll();
            int second = que.poll();
            res += first + second;
            que.add(first + second);
        }

        return res;
    }

    static class Job {
        char job_id;
        int deadLine;
        int profit;

        Job(char job_id, int deadLine, int profit) {
            this.deadLine = deadLine;
            this.job_id = job_id;
            this.profit = profit;
        }
    }

    // Practice Qs.03 -- Job Sequencing
    public static void printJobSequence(ArrayList<Job> arr) {
        int n = arr.size();

        Collections.sort(arr, (a, b) -> {
            return a.deadLine - b.deadLine;
        });

        ArrayList<Job> result = new ArrayList<>();
        PriorityQueue<Job> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.profit - a.profit;
        });

        for (int i = n - 1; i > -1; i--) {

            int slot_available;

            if (i == 0) {

                slot_available = arr.get(i).deadLine;
            } else {
                slot_available = arr.get(i).deadLine - arr.get(i - 1).deadLine;

            }

            maxHeap.add(arr.get(i));
            while (slot_available > 0 && maxHeap.size() > 0) {

                Job job = maxHeap.remove();
                slot_available--;
                result.add(job);

            }
        }
        Collections.sort(result, (a, b) -> {
            return a.deadLine - b.deadLine;
        });
        for (Job job : result) {
            System.out.print(job.job_id + " ");
        }
        System.out.println();
    }
    
    //Practice Qs.4 --> Reverse the first k Element of the Queue

    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k){
        solve(q,k);

        int size = q.size()- k;

        while (size-- > 0) {
            
            int x = q.poll();
            q.add(x);
        }
        return q;
    }

    public static void solve(Queue<Integer> q, int k){

        if(k == 0) return;
        int e = q.poll();
        solve(q, k-1);
        q.add(e);
    }

     //Practice Qs.5 --> Maximum of all subarrays of size K
     //Solution - 1
     public static void MaxOfkSubarray(int arr[], int k){
         int n = arr.length;
        int sz = n-k+1;
        int result[] = new int[sz];

        int max;
        for(int i=0; i<sz;i++){
           max = 0;
            for(int j=i; j<(i+k)-1; j++){

                if (arr[j] > arr[j+1]) {
                    
                    max = Math.max(max, arr[j]);
                }else{
                    max = Math.max(max, arr[j+1]);

                }
            }
            
            result[i] = max;
            
            
        }
        
        
        for(int i =0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
    }
    //Solution - 2
    public static void printMax(int arr[], int k){

        Deque<Integer> Qi = new LinkedList<Integer>();
        int n = arr.length;
        int i;
        for(i=0; i<k; ++i){

            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.add(i);
            
        }

        for(; i<n; ++i){

            System.out.print(arr[Qi.peek()] + " ");

            while ((!Qi.isEmpty()) && Qi.peek() <= i -k){
                Qi.removeFirst();


            }
            while ((!Qi.isEmpty())
                   && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    
        }


    

    public static void main(String[] args) {
      int arr[] = {1, 2 , 3, 1, 4, 5, 2, 3, 6};
      int k = 3;
printMax(arr, k);
      
      
      
      
      
      
      
        /*  Queue<Integer> q = new LinkedList<>();
        int k = 5;
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        reverseFirstK(q, k);
        
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }*/

        /*
         * ArrayList<Job> arr = new ArrayList<Job>();
         * 
         * arr.add(new Job('a',4,20));
         * arr.add(new Job('b',1,10));
         * arr.add(new Job('c',1,40));
         * arr.add(new Job('d',1,30));
         * // arr.add(new Job('e',3,15));
         * 
         * System.out.println("Following is the maximum profir sequence of Job");
         * printJobSequence(arr);
         */

        // String str = "aabccxb";
        // fstRepeatCh(str);

    }
}
