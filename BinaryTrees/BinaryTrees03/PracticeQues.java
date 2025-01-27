public class PracticeQues {
static class Node{
    int data;
    Node left ;
    Node right;

     Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public static boolean isUnivalued(Node root) {
    if (root == null) {
      
      return true ;
    }
    
    if (root.left  != null &&  root.data != root.left.data ) {
        
        return false;
        
    }

    if (root.right != null && root.data != root.right.data) {
        
        return false;
    }
    
   
   
    
return isUnivalued(root.left) &&  isUnivalued(root.right);

}
public static void mirrorTree(Node root){

    if (root == null) {
        return;
    }

    mirrorTree(root.left);
    mirrorTree(root.right);

    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
}
public static void preOrder(Node root) {
    if (root == null) {
        System.out.print(-1 + " ");
        return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}


    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);     
        root.right = new Node(3);
        root.left.left = new Node(4);   
        root.left.right = new Node(5);   
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    
        mirrorTree(root);
        preOrder(root);
       
       //System.out.println(isUnivalued(root)); //Que.01
        
        
    }
}
