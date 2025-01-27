import java.util.*;

public class BinaryTreeC {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){

            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void kLevel(Node root, int level, int k){
        if (level == k ) {
            System.out.print(root.data+" ");
            return;
        }

        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }
      //-------------H.W-------------------//
    public static void kthBylevelOrder(Node root){

        if (root == null) {

            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {

                System.out.println();
                if (q.isEmpty()) {

                    break;
                } else {

                    q.add(null);
                }
            } else {

                System.out.print(currNode.data + " ");
                if (currNode.left != null) {

                    q.add(currNode.left);
                }
                if (currNode.right != null) {

                    q.add(currNode.right);
                }
            }
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft  = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1= new ArrayList<>();
        ArrayList<Node> path2= new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        //lastCommon ancestor
        int i =0;
        for(; i< path1.size() && i<path2.size(); i++){
            if (path1.get(i) != path2.get(i)) {
                break;
                
            }
        }

        //last equal node --> i-1th
        Node lca = path1.get(i-1);
        return lca;
    }
    public static Node lca2(Node root, int n1, int n2){

        if (root == null ||root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);     
        Node rightLca = lca2(root.right, n1, n2);  
        
        
        //leftLCA = val && rightLCA = null
        if (rightLca == null) {
            return leftLca;
        }

        //rightLCA = val && leftLCA = null
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n){
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }else if (leftDist == -1) {
            return rightDist+1;
        }else{
            return leftDist+1;
        }
    }
    public static int minDist(Node root, int n1, int n2){

        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1); 
        int dist2 = lcaDist(lca, n2); 

        return dist1 + dist2;
    }

    public static int KthAncestor(Node root, int n, int k ){

        if (root  == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max+1 == k) {
           System.out.println(root.data);
        }

        return max+1;

    }

    public static int toSumTree(Node root) {
        if (root == null) {
            return 0;

        }

        int leftSum = toSumTree(root.left);
        int rightSum = toSumTree(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight= root.right == null ? 0 : root.right.data;

        root.data = newLeft+ leftSum + newRight+ rightSum;

        return data;
    }   

    public static void preOrder(Node root) {
        if (root == null) {
    
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        /*
         1
        / \
       2   3
      / \ / \
     4  5 6  7
         */

         Node root = new Node(1);
         root.left = new Node(2);
         root.right = new Node(3);
         root.left.right = new Node(5);
         root.left.left = new Node(4);
         root.right.left = new Node(6);
         root.right.right = new Node(7);

         int n1 = 2, n2 =5, k = 2 ;
       toSumTree(root);
       preOrder(root);
    }
}