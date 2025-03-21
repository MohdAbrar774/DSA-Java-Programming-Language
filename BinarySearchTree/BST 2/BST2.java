import java.util.*;

public class BST2 {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

    }

    public static Node mirrorBst(Node root) {
        if (root == null) {
            return null;

        }

        Node leftMirror = mirrorBst(root.left);
        Node rightMirror = mirrorBst(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int arr[], int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node currroot = new Node(arr[mid]);

        currroot.left = createBST(arr, st, mid - 1);
        currroot.right = createBST(arr, mid + 1, end);

        return currroot;
    }

    public static Node createBST2(ArrayList<Integer> inOrder, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        Node currroot = new Node(inOrder.get(mid));

        currroot.left = createBST2(inOrder, st, mid - 1);
        currroot.right = createBST2(inOrder, mid + 1, end);

        return currroot;
    }

    public static void getInorder(Node root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }

        getInorder(root.left, inOrder);
        inOrder.add(root.data);
        getInorder(root.right, inOrder);
    }

    public static Node balancedBST(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInorder(root, inOrder);

        root = createBST2(inOrder, 0, inOrder.size()-1);
        return root;
    }
    static class Info{
       boolean isBst;
       int size; int min , max;

       public Info(boolean isBst, int size, int min, int max){

        this.isBst = isBst;
        this.size = size;
        this.min = min;
        this.max = max;

       }
    }
    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true,0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size +1 ;
        int min = Math.min(root.data,Math.min(leftInfo.min, rightInfo.min)); 
        int max = Math.max(root.data,Math.max(leftInfo.max, rightInfo.max)); 

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
        return new Info(false, size, min, max);
       }

       if(leftInfo.isBst && rightInfo.isBst){
        maxBST = Math.max(maxBST, size);
        return new Info(true, size, min, max);
       }

       return new Info(false, size, min, max);
}

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.right = new Node(70);
        root.right.left = new Node(45);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(65);
        /*
           50
          /  \
         30   60
        /  \ /  \
       5  20 45  70
                /  \
               65  80
         */
       Info node = largestBST(root);
       System.out.print("Largest bst size: " + maxBST);

    }
}