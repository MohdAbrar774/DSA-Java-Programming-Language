import java.util.*;

public class StackB {
   

    public static StringBuilder reverseString(String str) {

        Stack<Character> s = new Stack();
        int idx = 0;
        while (idx < str.length()) {

            char str1 = str.charAt(idx);
            s.push(str1);
            idx++;
        }

        StringBuilder str1 = new StringBuilder("");
        while (!s.isEmpty()) {
            str1.append(s.pop());
        }

        return str1;

    }

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {

        while (!s.isEmpty()) {

            System.out.println(s.pop());

        }

    }
    public static void stockSpan(int stock[], int span[]){

        Stack<Integer>  s = new Stack<>();
        span[0] = 1;
        s.push(0);

      for (int i = 1; i < stock.length; i++) {
            
        int currPrice = stock[i];
        while (!s.isEmpty() && currPrice > stock[s.peek()]) {
            s.pop();
        }
        if (s.isEmpty()) {
            
            span[i] = i+1;

        }else{
            int prevHigh= s.peek();
            span[i] = i- prevHigh;
        }
        s.push(i);

        }
    }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {

                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if (ch == ')' && s.peek() == '('
                        || ch == '}' && s.peek() == '{'
                        || ch == ']' && s.peek() == '[') {

                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right
        Stack<Integer> s = new Stack<>();

        for (int i = arr.length-1; i >=0; i--) {
        
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
                
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smaller left
        s = new Stack<>();

        for (int i = 0; i <arr.length; i++){
             while (!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
                
             }
             if (s.isEmpty()){
                nsl[i] = -1;
             }else{
                nsl[i] = s.peek();
             }
             s.push(i);
        }

        //Current Area : Height * width i.e ( = j-i-1   i.e (= nsr[i] - nsl[i] - 1))
         
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i]- nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("Max area in histogram = " + maxArea);
    }



    public static void main(String args[]) {
        
      

       int stock[] = {100, 80, 60, 70, 60, 85, 100};
       int span[] = new int[stock.length];

       stockSpan(stock, span);
       int j =0;
       while (j < span.length) {
        System.out.print(span[j]+" ");
        j++;
       }
       System.out.println();
   
   
   
   
    /*
    int arr[]  = {2, 1, 5, 6, 2, 3};
    maxArea(arr);
    */
    
    //------------------------------------
    
    /*
        String str = "({{[]}})";
        System.out.println(isValid(str));
    */

        /*----------NEXT GREATER----------------------------
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        
        for (int i = arr.length - 1; i >= 0; i--) {
        
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        
        for(int i=0; i<nxtGreater.length; i++){
            System.out.print(nxtGreater[i]+" ");
        }
        System.out.println();
        ------------------------------------------------------------*/
        // Stack<Integer> s = new Stack();

        // s.push(1);
        // s.push(2);
        // s.push(3);
        // //pushAtBottom(s, 4);
        // reverseStack(s);
        // printStack(s);

        // String str = "abc";
        // System.out.println(reverseString(str));
    }
}