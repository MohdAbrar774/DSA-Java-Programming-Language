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

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        /*
           8
          / \
         6  10
        /     \
       5      11
      /        \
     3         12
         */

         root = balancedBST(root);
         System.out.println();
         preOrder(root);

    }
}