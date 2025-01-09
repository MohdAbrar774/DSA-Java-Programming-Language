import java.util.*;

public class QueueS {
    // Queue Using Two Stack
    static class Queue {

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty() && s2.isEmpty();
        }

        // O(1)

        public static void add(int data) {
            s1.push(data);
        }

        // O(n)
        /*
         * public static void add(int data){
         * 
         * while (!s1.isEmpty()) {
         * 
         * s2.push(s1.pop());
         * }
         * 
         * s1.push(data);
         * 
         * while (!s2.isEmpty()) {
         * 
         * s1.push(s2.pop());
         * }
         * }
         */

        // O(1)
        /*
         * public static int remove() {
         * if (isEmpty()) {
         * 
         * System.out.println("Queue is Empty");
         * return -1;
         * }
         * 
         * return s1.pop();
         * }
         */

        // O(n)
        public static int remove() {

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {

                    s2.push(s1.pop());

                }
            }

            return s2.pop();
        }

        public static int peek() {

            if (!s2.isEmpty()) {
                return s2.peek();
            } else {
                return s1.peek();
            }
        }

    }

    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {

            System.out.println(q.remove());
            

        }
    }
}
