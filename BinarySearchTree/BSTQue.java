
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

   
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(45);

        root.right = new Node(60);
        root.right.right = new Node(70);
        root.right.left = new Node(55);
        root.right.right.right = new Node(80);

          /*
           50
          /  \
         30   60
        /  \ /  \
       5  45 55  70
                   \
                    80
         */
    System.out.println(kthSmallest(root, 5));
    }
}