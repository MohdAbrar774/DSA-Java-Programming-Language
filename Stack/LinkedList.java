public class LinkedList {
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

    public void addFirst(int data) {

        // Step 1: Create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2: Point the newNode's next to head

        newNode.next = head;

        // Step 3: move the head to new Node

        head = newNode;

    }

    public void addLast(int data) {

        // Step 1: Create a new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Step 2: Point the tail's next to new Node

        tail.next = newNode;

        // Step 3: move the tail to new Node

        tail = newNode;

    }

    public static void printLinkedlist() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {

            System.err.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while (i < idx - 1) {

            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }

    public static int removeFirst() {

        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;

    }

    public static int removeLast() {

        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node pre = head;
        for (int i = 0; i < size - 2; i++) {
            pre = pre.next;
        }
        int val = pre.next.data;
        pre.next = null;
        tail = pre;
        size--;
        return val;

    }

    public static int iterSearch(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {

            if (temp.data == key) {
                return i;
            }

            temp = temp.next;
            i++;

        }
        return -1;
    }

    public static int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public static int recursiveSearch(int key) {

        return helper(head, key);
    }

    public static void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        head = prev;

    }

    public static void deleteNthfromEnd(int n) {

        //To calculate size
        Node temp = head;
        int sz = 0;
        while (temp != null) {

            temp = temp.next;
            sz++;
        }

        if (sz == n) {
            head = head.next;
            return;
        }

        int i = 1;
        int iTofind = sz - n;
        Node prev = head;
        while (i < iTofind) {

            prev = prev.next;
            i++;

        }

        prev.next = prev.next.next;
        return;
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        return slow;
    }

    public static boolean checkPalindrom() {
        // base case
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1 - find mid-Node

        Node midNode = findMid(head);

        // Step 2 - Reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;

        // step 3 -Check 1st half(left) & 2nd half(right)

        while (right != null) {

            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static boolean isCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {

                return true;
            }
        }

        return false;
    }
    public static void removeCycle(){
        //Detect cycle
        Node slow = head;
        Node fast  = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }

        if(cycle == false){
            return;
        }
        //finding meeting point
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //Remove cycle
        prev.next = null;

    }
    private static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null & fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static Node merge(Node head1, Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;

            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }
        return mergeLL.next;
    }
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //Get LL's mid 
        Node mid = getMid(head);
        //left & rigth Merge Sort(M.S)
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //Merge

        return merge(newLeft,newRight);
    }

public static void zigZagLL(Node head){
    //Find Mid node
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
        
        slow = slow.next;
        fast = fast.next.next;
    }

    //Reverse 2nd half
    Node mid = slow;
    Node Rhead = mid.next;
    mid.next = null;
     
    Node curr  = Rhead;
    Node prev = null;
    Node next;
    while (curr != null) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    Node left  = head;
    Node right = prev;
    Node nextL , nextR;
    //Alternate merging
    while (left != null && right != null) {
        nextL = left.next;
        left.next = right;
        nextR = right.next;
        right.next = nextL;

        left = nextL;
        right = nextR;
    }

}
    public  static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        printLinkedlist();
        deleteNthfromEnd(3);
        printLinkedlist();
       // zigZagLL(head);
       // printLinkedlist();
        
        
        
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());
        
        // ll.removeFirst();
        // printLinkedlist();;
        // ll.removeLast();
        // printLinkedlist();

        // System.out.println(recursiveSearch(3));
        // System.out.println(recursiveSearch(31));

        // ll.reverse();
        // printLinkedlist();
    }
}