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

        if (Math.abs(root.data - key) < Math.abs(key - closest)) {
            closest = root.data;
        }
        if (root.data > key) {

            closestElem(root.left, key);
        } else {
            closestElem(root.right, key);

        }

    }

    public static int kthSmallestRecur(Node root, int[] cnt, int k) {
        if (root == null)
            return -1;

        int left = kthSmallestRecur(root.left, cnt, k);

        if (left != -1)
            return left;

        cnt[0]++;

        if (cnt[0] == k)
            return root.data;

        int right = kthSmallestRecur(root.right, cnt, k);
        return right;
    }

    // Function to find kth smallest value in BST.
    static int kthSmallest(Node root, int k) {
        int[] cnt = { 0 };
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

    public static int twoSumBST(Node root1, Node root2, int x) {

        ArrayList<Integer> arr1 = new ArrayList<>();
        getPreorder(root1, arr1);

        return countSumpairs(root2, x, arr1);

    }

    public static int countSumpairs(Node root, int target, ArrayList<Integer> arr) {

        if (root == null) {
            return 0;
        }
        int complement = target - root.data;
        int count = arr.contains(complement) ? 1 : 0;

        count = count + countSumpairs(root.left, target, arr) + countSumpairs(root.right, target, arr);
        return count;
    }
    
    static class Info {
        int max;
        int min;
        boolean isBST;
        int sum;
        int currmax;
        

        Info(int m, int mi, boolean is, int su, int cur) {
            max = m;
            min = mi;
            isBST = is;
            sum = su;
            currmax = cur;
            
        }

        Info() {
        }
    }

    static class INT
    {
        int a;
    }
     
    // Returns information about subtree such as
    // subtree with the maximum sum which is also a BST
    static Info MaxSumBSTUtil( Node root, INT maxsum)
    {
        // Base case
        if (root == null)
            return new Info( Integer.MIN_VALUE, 
                            Integer.MAX_VALUE, true, 0, 0 );
     
        // If current node is a leaf node then
        // return from the function and store
        // information about the leaf node
        if (root.left == null && root.right == null)
        {
            maxsum.a = Math.max(maxsum.a, root.data);
            return new Info( root.data, root.data, 
                            true, root.data, maxsum.a );
        }
     
        // Store information about the left subtree
        Info L = MaxSumBSTUtil(root.left, maxsum);
     
        // Store information about the right subtree
        Info R = MaxSumBSTUtil(root.right, maxsum);
     
        Info BST=new Info();
     
        // If the subtree rooted under the current node
        // is a BST
        if (L.isBST && R.isBST && L.max < root.data && 
                                   R.min > root.data)
        {
     
            BST.max = Math.max(root.data, Math.max(L.max, R.max));
            BST.min = Math.min(root.data, Math.min(L.min, R.min));
     
            maxsum.a = Math.max(maxsum.a, R.sum + root.data + L.sum);
            BST.sum = R.sum + root.data + L.sum;
     
            // Update the current maximum sum
            BST.currmax = maxsum.a;
     
            BST.isBST = true;
            return BST;
        }
     
        // If the whole tree is not a BST then
        // update the current maximum sum
        BST.isBST = false;
        BST.currmax = maxsum.a;
        BST.sum = R.sum + root.data + L.sum;
     
        return BST;
    }
     
    // Function to return the maximum
    // sum subtree which is also a BST
    static int MaxSumBST( Node root)
    {
        INT maxsum = new INT();
        maxsum.a = Integer.MIN_VALUE;
        return MaxSumBSTUtil(root, maxsum).currmax;
    }
     

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.right.right = new Node(3);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        System.out.println(MaxSumBST(root));

    }
}