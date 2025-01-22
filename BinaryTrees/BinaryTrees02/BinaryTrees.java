import java.util.*;

public class BinaryTrees {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // public static int height(Node root){
    //     if (root == null) {
            
    //         return 0;
    //     }

    //     int lh = height(root.left);
    //     int rh = height(root.right);

    //     return Math.max(lh, rh)+1;
    // }

    // public static int diameter(Node root){

    //     if (root == null) {
            
    //         return 0;
    //     }

    //     int leftDia =  diameter(root.left);
    //     int leftHt =  height(root.left);
    //     int rightDia =  diameter(root.right);
    //     int rightHt =  height(root.right);

    //     int selfDia = leftHt + rightHt + 1;

    //     return Math.max( selfDia, Math.max(rightDia, leftDia));
    // }

    // static class Info{
        
    //     int diam;
    //     int ht;

    //     public Info(int diam, int ht){
    //         this.diam = diam;
    //         this.ht = ht;
    //     }
    // }
    // public static Info diameter2(Node root){  //O(n)

    //     if (root == null) {
            
    //         return new Info(0, 0);
    //     }

    //     Info leftInfo = diameter2(root.left);
    //     Info rightInfo = diameter2(root.left);
        
    //     int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam),leftInfo.ht+rightInfo.ht+1);
    //     int ht = Math.max(leftInfo.ht, rightInfo.ht) +1;

    //     return new Info(diam, ht);
   
   
   
    // }
    // public static boolean isIdentical(Node node, Node Subroot){
    //     if(node == null & Subroot == null ){
    //         return true;

    //     }else if (node == null || Subroot == null || node.data != Subroot.data) {
            
    //         return false;
    //     }

    //     if (!isIdentical(node.left, Subroot.left)) {
    //         return false;
    //     }
    //     if (!isIdentical(node.right, Subroot.right)) {
    //         return false;
    //     }

    //     return true;
    // }

    // public static boolean isSubtree(Node root, Node Subroot){
    //     if (root == null) {
    //         return false;
    //     }
    //     if (root.data == Subroot.data) {
    //         if(isIdentical(root, Subroot)){
    //             return true;
    //         }
    //     }

    //     return isSubtree(root.left, Subroot) || isSubtree(root.right, Subroot);
    // }

    static class  info{
        Node node;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
        int hd;

        public info(Node node , int hd){
            this.node = node;                                                                               
            this.hd = hd;
        }
    } 
    public static void topView(Node root){   
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new info(root, 0));
        q.add(null); 
        
        
        while (!q.isEmpty()) {
            info curr  = q.remove();
            if (curr == null) {
              if (q.isEmpty()) {
                break;
              }else{
                q.add(null);
              }
            }else{

                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }

                if (curr.node.right != null) {
                    q.add(new info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
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
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
       
        topView(root);
  /* 
                2  
               / \ 
              4  5 
*/
        // Node Subroot = new Node(2);
        // Subroot.left = new Node(4);
        // Subroot.right = new Node(5);

       // System.out.println(isSubtree(root, Subroot));
    }
}