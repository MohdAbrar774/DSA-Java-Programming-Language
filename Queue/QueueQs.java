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

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int k = 7;
        q.add(6);
        q.add(8);
        q.add(4);
        q.add(7);
        q.add(10);
        q.add(5);
        q.add(3);
        q.add(9);
        q.add(2);
        q.add(1);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

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
