import java.util.*;

public class StackQ {

    //Stack Using Two Queues
    static class Stack {

        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        //O(1)
        public static void push(int data) {

            if (!q1.isEmpty()) {
                q1.add(data);

            } else {
                q2.add(data);
            }
        }

        //O(n)
        public static int pop() {
           
           
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {

                        break;
                    }
                    q2.add(top);
                }

            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {

                        break;
                    }
                    q1.add(top);

                }
            }
            return top;
        }

        public static int peek(){
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            int top = -1;

            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }

            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);

                }
            }
            return top;
        }

    }

    public static void main(String[] args) {
        Stack s  = new  Stack();

        s.push(0);
        s.push(8);
        s.push(9);
        s.push(1);

        while (!s.isEmpty()) {
            
            System.out.println(s.peek());
            s.pop();
        }
    }
    
}
