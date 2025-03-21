import java.util.*;
public class BSTQue {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

    }

    public static int SumInRange(Node root, int k1, int k2) {
        if (root == null) {
            return 0;
        }

        if (root.data >= k2) {
            return SumInRange(root.left, k1, k2);
        } else if (root.data < k1) {
            return SumInRange(root.right, k1, k2);
        }

        int left = SumInRange(root.left, k1, k2);
        int right = SumInRange(root.right, k1, k2);

        return left + right + root.data;
    }

    public static int closest = 0;

    public static void closestElem(Node root, int key) {
        if (root == null) {
            return;
        }
     
        if (Math.abs(root.data - key) <  Math.abs(key- closest)) {
            closest = root.data;
        }
        if (root.data > key) {
            
            closestElem(root.left, key);
        } else{
            closestElem(root.right, key);

        }

    }
   public static int kthSmallestRecur(Node root, int[] cnt, int k) {
        if (root == null) return -1;
        
      
        int left = kthSmallestRecur(root.left, cnt, k);
        
      
        if (left != -1) return left;
        
       
        cnt[0]++;
 
        if (cnt[0] == k) return root.data;
        

        int right = kthSmallestRecur(root.right, cnt, k);
        return right;
    }

    // Function to find kth smallest value in BST.
    static int kthSmallest(Node root, int k) {
        int[] cnt = {0};
        return kthSmallestRecur(root, cnt, k);
    }

    public static void getPreorder(Node root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }

        inOrder.add(root.data);
        getPreorder(root.left, inOrder);
        getPreorder(root.right, inOrder);
    }
    public static int twoSumBST(Node root1, Node root2, int x){

        ArrayList<Integer> arr1 = new ArrayList<>();
        getPreorder(root1, arr1);
    
        return countSumpairs(root2, x, arr1);

    }
    public static int countSumpairs(Node root, int target, ArrayList<Integer> arr){

        if(root == null ){
            return 0;
        }
        int complement = target - root.data;
        int count = arr.contains(complement) ? 1 : 0;
        
        count = count + countSumpairs(root.left, target, arr) + countSumpairs(root.right, target, arr);
        return  count;
    }
   
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
          /*
           5
          / \
         3   7
        / \ / \
       2  4 6  8
         */
        Node root1 = new Node(10);
        root1.left = new Node(6);
        root1.left.left = new Node(3);
        root1.left.right = new Node(8);

        root1.right = new Node(15);
        root1.right.left = new Node(11);
        root1.right.right = new Node(18);

          /*
           10
          /  \
         6   15
        / \ /  \
       3  8 11 18
         */
    System.out.println(twoSumBST(root, root1, 16));
    }
}