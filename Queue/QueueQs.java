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

    public static void reversQueue(Queue<Integer> q){
        Stack<Integer> s  = new Stack<>();

        
        while (!q.isEmpty()) {
            
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            
            q.add(s.pop());
        }
        
    }

    //Practice QS.01
    public static void NbinNum(int n){
        Queue<String> q = new LinkedList<String>();
        
        q.add("1");
        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.print(s1+" ");
            
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1" );
            
        }
        
        
    }
    
    //Practice QS.02
    public static int minCost(int arr[], int n){

        Queue<Integer> que = new PriorityQueue<>();

                        for(int i=0; i<n; i++){
                            que.add(arr[i]);
                        }

                        int res =0; 
                        while (que.size() > 1) {
                            
                            int first = que.poll();
                            int second  = que.poll();
                            res += first + second;
                            que.add(first+second);
                        }

                        return res;
    }
    public static void main(String[] args) {
      
      int len[] = {4, 3, 2, 6};
       
      System.out.println("The minimum cost for connecting ropes is: "+ minCost(len, len.length));
      








      //  NbinNum(15);
    
        /*
        Queue<Integer> q  = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        reversQueue(q);
        while (!q.isEmpty()) {
            
        System.out.println(q.peek());
        q.remove();   
    } 
    */


        /*
        interLeave(q);

        while (!q.isEmpty()) {
            
            System.out.println(q.peek());
         q.remove();   
        }*/


        /*
        String str = "aabccxb";
         fstRepeatCh(str);*/
        
    }
}
