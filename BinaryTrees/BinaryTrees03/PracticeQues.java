public class PracticeQues {
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

    public static boolean isUnivalued(Node root) {
        if (root == null) {

            return true;
        }

        if (root.left != null && root.data != root.left.data) {

            return false;

        }

        if (root.right != null && root.data != root.right.data) {

            return false;
        }

        return isUnivalued(root.left) && isUnivalued(root.right);

    }

    public static void mirrorTree(Node root) {

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

    public static int delLeafNode(Node root, int x) {

        if (root == null) {
            return 0;
        }
        int leftt = delLeafNode(root.left, x);
        int right = delLeafNode(root.right, x);

        if (leftt == -1) {
            root.left = null;
        }
        if (right == -1) {
            root.right = null;
        }
        if (root.data == x && root.left == null && root.right == null) {

            return -1;
        }
        return 0;

    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);

        delLeafNode(root, 3);
        preOrder(root);

    }
}
