import java.text.BreakIterator;
import java.util.*;

public class PracticeQ {
    public static class Node {

        int data;
        Node next;

        public Node(int data) {

            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void printLinkedlist(Node head) {
        Node temp = head;
        while (temp != null) {

            System.err.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static boolean isPalindrom(Node head) {

        Stack<Integer> s = new Stack<>();
        Node temp = head;
        boolean ispalin = true;

        while (temp != null) {

            s.push(temp.data);
            temp = temp.next;
        }

        while (head != null) {
            int i = s.pop();
            if (head.data == i) {
                ispalin = true;
            } else {
                ispalin = false;
                break;
            }
            head = head.next;
        }
        return ispalin;

    }

    public static String validPath(String path) {

        Vector<String> v = new Vector<>();
        int n = path.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            String dir = "";

            while (i < n && path.charAt(i) != '/') {
                dir += path.charAt(i);
                i++;

            }

            // if "..", we pop
            if (dir.equals("..")) {
                if (v.size() != 0) {

                    v.remove(v.size() - 1);
                }
            } else if (dir.equals(".") || dir.equals("")) {
                // do nothing
            } else {
                // push the curent directory into the vector
                v.add(dir);
            }

        }

        // forming the ans
        for (String i : v) {
            ans += "/" + i;
        }

        // if vector is empty
        if (ans == "") {
            return "/";
        }
        return ans;
    }

    // public static String decodeStr(StringBuilder str, int repetation) {

    // StringBuilder subString = new StringBuilder("");
    // if (str.length() == 1) {

    // return str.toString();
    // }
    // int i = 0;
    // while(str.length() > 0 && str.charAt(i) != '[' && str.charAt(i) != ']') {

    // if (Character.isDigit(str.charAt(i))) {

    // repetation = Character.getNumericValue(str.charAt(i));

    // str.deleteCharAt(i);
    // }else{
    // subString.append(str.charAt(i));
    // str.deleteCharAt(i);

    // }

    // }else{
    // str.deleteCharAt(i);
    // }

    // subString.append(decodeStr(subString, repetation));
    // for(int j = repetation-1 ; j>0; j--){

    // subString = subString.append(subString);
    // }

    // return subString.toString();

    // }

    public static String decode(String str) {
        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "", result = "";

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                integerstack.push(count);
            } else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;
                if (!integerstack.isEmpty()) {
                    count = integerstack.peek();
                    integerstack.pop();
                }
                while (!stringstack.isEmpty() && stringstack.peek() != '[') {
                    temp = stringstack.peek() + temp;
                    stringstack.pop();
                }
                if (!stringstack.empty() && stringstack.peek() == '[')
                    stringstack.pop();

                for (int j = 0; j < count; j++)
                    result = result + temp;

                for (int j = 0; j < result.length(); j++)
                    stringstack.push(result.charAt(j));
                result = "";
            } else if (str.charAt(i) == '[') {
                if (Character.isDigit(str.charAt(i - 1)))
                    stringstack.push(str.charAt(i));
                else {
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            } else
                stringstack.push(str.charAt(i));
        }
        while (!stringstack.isEmpty()) {
            result = stringstack.peek() + result;
            stringstack.pop();
        }
        return result;
    }

    public static int tarppedWater(int heights[]) {
        int n = heights.length;
        Stack<Integer> s = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty()&& heights[s.peek()] < heights[i]) {
                int pop_height = heights[s.peek()];
                s.pop();
                if (s.isEmpty()) {
                    break;
                }
                int dist = i - s.peek() - 1;
                int min_height = Math.min(heights[s.peek()], heights[i]) - pop_height;
                ans += dist * min_height;

            }
            s.push(i);
        }
        return ans;
    }

    public static String decoString(String str){
        StringBuilder result = new StringBuilder();

     for (int i = 0; i < str.length(); i++) {
        
        if (str.charAt(i) != ']') {
            
            result.append(str.charAt(i));
        }else{

            StringBuilder temp = new StringBuilder();

            while (result.length() > 0 && result.charAt(result.length() -1) != '[' ){
                
                result.insert(0,result.charAt(result.length() -1));
                result.deleteCharAt(result.length() -1);
            
            }

            //remove opening bracket
            result.deleteCharAt(result.length() -1);

            StringBuilder num = new StringBuilder();

            while (result.length() > 0 && Character.isDigit(result.charAt(result.length() -1)) ) {
                
                num.insert(0,result.length() -1);
                result.deleteCharAt(result.length() -1);

            }

            int int_num = Integer.parseInt(num.toString());

            while (int_num-- > 0) {
                
                result.append(temp);
            }

        }
     }
     return result.toString();
    }

   
    

    public static void main(String args[]) {

        int heights[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(tarppedWater(heights));

      /*  String str = "3[b2[v]]";
       System.out.println(decode(str)); */

        /*
         * String path = "/a//b//c//////d";
         * System.out.println(validPath(path));
         */

        /*
         * Node head = new Node('a');
         * head.next = new Node('b');
         * head.next.next = new Node('c');
         * head.next.next.next = new Node('b');
         * head.next.next.next.next = new Node('b');
         * head.next.next.next.next.next = new Node('a');
         * //printLinkedlist(head);
         * 
         * boolean isPalindrom = isPalindrom(head);
         * System.out.println("P, indrom: "+ isPalindrom);
         */
    }
}
