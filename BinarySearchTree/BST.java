public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insertNode(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insertNode(root.left, val);
        } else {
            root.right = insertNode(root.right, val);

        }

        return root;
    }

    public static void inOrder(Node root) {

        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static boolean search(Node root, int key){
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
    public static Node delete(Node root , int val){

        if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else if (root.data > val) {
            
            root.left = delete(root.left, val);
        }else{//voila
            //case -1 Leaf Node
            if (root.left == null && root.right == null) {
            return null;
            }

            //case 2 Single child Node
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            //case 3 Both Children
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }
  
    public static Node inOrderSuccessor(Node root){
        while (root.left != null) {
            
            root = root.left;
        }
        return root;
    }
  
  

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i = 0; i < values.length; i++) {

            root = insertNode(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        
        delete(root, 5);
        System.out.println();
        inOrder(root);
       
    }
}
