public class BST2 {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    
    }
    public static Node mirrorBst(Node root){
    if(root == null){
        return null;
    
    }

    Node leftMirror  = mirrorBst(root.left);
    Node rightMirror  = mirrorBst(root.right);

    root.left = rightMirror;
    root.right = leftMirror;

    return root;
}

public static void  preOrder(Node root){
    if (root == null) {
        return ;
    }

    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);
}
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        /*  8
           / \
          5   10
         / \    \
        3   6    11
         */

         preOrder(root);
         System.out.println();
         mirrorBst(root);
         System.out.println();

    }
}