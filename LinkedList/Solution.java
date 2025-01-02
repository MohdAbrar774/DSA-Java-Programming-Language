public class Solution {
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
    public static int getIntersect(Node head1, Node head2) {

        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {

                if (temp == head2) {
                    return head2.data;
                }

                temp = temp.next;
            }

            head2 = head2.next;
        }
        return -1;
    }
    public static Node pushNode(Node head_ref,int new_data){
        Node newNode = new Node(new_data);
        newNode.next = head_ref;
        head_ref = newNode;

        return head_ref;
    }

    public static void printLL(Node head){
        Node temp = head;

        while (temp != null) {
            
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void NremoveFromM(Node head,int M, int N){
        Node curr = head , t;
        int count;

        while (curr != null) {
            
            for(count = 1;count < M&& curr!= null; count++){
                curr = curr.next;

                if(curr == null)
                  return;
            }

            t = curr.next;
            for(count =1;count <= N && t != null; count++){

                Node temp = t;
                t = t.next;
            }

            curr.next = t;
            curr = t;
        }
    }
    public static void swappingXandY(Node head, int x, int y){

        
        
        Node currX = head , prevX = null;
        while (currX != null && currX .data != x) {
            prevX = currX;
            currX = currX.next;
        }
        
        Node currY = head , prevY = null;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;

        }

        if(currX == null|| currY == null)
         return;
        
        if(prevX != null)
           prevX.next = currY;
        else
           head = currY;
        
        if(prevY != null)
           prevY.next = currX;
        else
          head = currX;
               
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;


    }
    public static Node seprateEvenOdd(Node head){
        //Pointers for original list
        Node curr = head;
        Node prev = null;

        //Pointers for result LL
        Node resStart = null;
        Node resEnd   = null;

        while(curr != null){

            if(curr.data%2 == 0){
                
                if (prev != null) {
                    prev.next = curr.next;
                }else{

                    head = curr.next;
                }

                if (resStart == null) {
                    resStart = curr;
                    resEnd = resStart;
                }else{
                    resEnd.next = curr;
                    resEnd = resEnd.next;
                }

                curr = curr.next;
            }else{

                prev = curr;
                curr = curr.next;
            }
        }

        if (resStart == null) {
            return head;
        }
        resEnd.next = head;


        return resStart;
        
    }
    
    public static Node SortedMerge(Node a, Node b){
        Node result = null;

        if (a == null) 
           return b;   
        else if (b == null) 
            return a;
        
        if(a.data <= b.data){
            result = a;
            result.next = SortedMerge(a.next,b); 
        }else{
            result = b;
            result.next = SortedMerge(a, b.next);
        }

        return result;

    }
    public static Node mergeKLists(Node arr[], int last){
        
        while (last != 0) {
            int i=0 , j=last;
            while (i< j) {
                arr[i] = SortedMerge(arr[i], arr[j]);
                i++;
                j--;
                if(i>=j){
                    last = j;
                }
            }
        }
        
        return arr[0];
    }

    public static void main(String[] args) {


    int k=3; 
    int n= 4;

    Node arr[] = new Node[k];
      
    arr[0] = new Node(1);
    arr[0].next = new Node(3);
    arr[0].next.next = new Node(5);
    arr[0] .next.next.next = new Node(7);

    arr[1] = new Node(2);
    arr[1].next = new Node(4);
    arr[1].next.next = new Node(6);
    arr[1] .next.next.next = new Node(8);

    arr[2] = new Node(0);
    arr[2].next = new Node(9);
    arr[2].next.next = new Node(10);
    arr[2] .next.next.next = new Node(11);

    printLL(arr[0]);
    printLL(arr[1]);
    printLL(arr[2]);
    Node head = mergeKLists(arr, k-1);
    printLL(head);
    
    
    
    
    
        // Node head = null;
        // int M,N;
        // head = pushNode(head, 10);
        // head = pushNode(head, 2);
        // head = pushNode(head, 3);
        // head = pushNode(head, 8);
        // head = pushNode(head, 7);
        // head = pushNode(head, 6);
        // head = pushNode(head, 5);
        // head = pushNode(head, 4);
        // head = pushNode(head, 9);
        // head = pushNode(head, 1);

//          printLL(head);

        // NremoveFromM(head,1, 1);
        //swappingXandY(head, 4,8);
        
        //printLL(seprateEvenOdd(head));
    
        // Node head1, head2;

        // head1 = new Node(1);
        // head2 = new Node(4);

        // Node newNode = new Node(5);
        // head2.next = newNode;

        // newNode = new Node(2);
        // head1.next = newNode;
        // //head2.next.next.next = null;
        
        // newNode = new Node(3);
        // head1.next.next = newNode;
        // //head2.next.next.next = newNode;
        
        // newNode = new Node(6);
        // head1.next.next.next = newNode;
        // head2.next.next = newNode;
        
        // newNode  = new Node(7);
        // head1.next.next.next.next = newNode;

        
        // int getIntersectNode = getIntersect(head1, head2);

        // if (getIntersectNode == -1) {
        //     System.out.println("No intersect point");
        // } else {
        //     System.out.println("Intersect point: " + getIntersectNode);
        // }
    }
}
