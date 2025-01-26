import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesA {

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

    static class BinaryTrees {

        static int idx = -1;

        public static Node buildTree(int nodes[]) {

            idx++;
            if (nodes[idx] == -1) {

                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
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

        public static void inOrder(Node root) {
            if (root == null) {
                // System.out.print(-1+" ");
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                // System.out.print(-1+" ");
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder(Node root) {
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

    }

    public static int height(Node root) {
        if (root == null) {

            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    public static int Sum(Node root) {
        if (root == null) {
            return 0;

        }

        int leftSum = Sum(root.left);
        int rightSum = Sum(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {

        /*
         * 1 ---> 1
         * / \
         * 2 3 ---> 5
         * / \ / \
         * 4 5 6 7 ---> 22 (sum=28) / 7(count)
         * 
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(Sum(root));

        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // BinaryTrees trees = new BinaryTrees();
        // Node root = trees.buildTree(nodes);
        // System.out.println(root.data);
        // trees.levelOrder(root);

    }
}