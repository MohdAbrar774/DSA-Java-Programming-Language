import java.util.*;

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

    static HashMap<String, Integer> m;

    public static String inOrder(Node node) {
        if (node == null) {
            return "";
        }

        String str = "(";
        str += inOrder(node.left);
        str += Integer.toString(node.data);
        str += inOrder(node.right);
        str = ")";

        if (m.get(str) != null && m.get(str) == 1) {

            System.out.print(node.data + " ");
        }
        if (m.containsKey(str)) {
            m.put(str, m.get(str) + 1);
        } else {
            m.put(str, 1);
        }
        return str;
    }

    public static void duplicateSubTree(Node root) {

        m = new HashMap<>();
        inOrder(root);
    }

    static int sum = 0;

    public static int maxPathSumUtil(Node root, int res[]) {
        if (root == null) {
            return 0;

        }

        int leftSum = Math.max(0, maxPathSumUtil(root.left, res));
        int rightSum = Math.max(0, maxPathSumUtil(root.right, res));

        res[0] = Math.max(res[0], leftSum + rightSum + root.data);

        return root.data + Math.max(leftSum, rightSum);
    }

    public static int maxPathSum(Node root) {
        int res[] = { root.data };

        maxPathSumUtil(root, res);

        return res[0];
    }

    public static void main(String[] args) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(maxPathSum(root));

    }
}
