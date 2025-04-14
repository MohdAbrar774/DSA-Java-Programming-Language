import java.util.*;

public class HeapQue {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int k = 3;

    public static ArrayList<Integer> kthLargest(int arr[]) {

        ArrayList<Integer> res = new ArrayList<>();

        for (int val : arr) {

            if (pq.size() < k) {
                pq.add(val);
            } else if (val > pq.peek()) {
                pq.poll();
                pq.add(val);
            }

            if (pq.size() >= k) {
                res.add(pq.peek());
            } else {
                pq.add(-1);
            }
        }

        return res;
    }

    public static void minTimeToFillSlots(int arr[], int k, int n) {
        int time = 0;
        boolean visited[] = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            q.add(arr[i]);

            visited[arr[i]] = true;
        }

        while (q.size() > 0) {

            for (int i = 0; i < q.size(); i++) {
                int val = q.remove();

                if (val + 1 <= n && !visited[val + 1]) {

                    visited[val + 1] = true;
                    q.add(val + 1);
                }
                if (val - 1 >= 1 && !visited[val - 1]) {
                    visited[val - 1] = true;
                    q.add(val - 1);
                }
            }
            time++;
        }
        System.out.println();

        System.out.println(time - 1);
    }

    static class Info implements Comparable<Info> {

        int diff;
        int x;
        int y;

        public Info(int diff, int x, int y) {
            this.diff = diff;
            this.x = x;
            this.y = y;

        }

        @Override
        public int compareTo(Info n2) {
            return Integer.compare(this.diff, n2.diff);
        }
    }

    public static int[][] dirs = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    public static int minEffortPath(int[][] height) {
        int m = height.length;
        int n = height[0].length;

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(0, 0, 0));
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            Info node = pq.poll();
            int diff = node.diff;
            int x = node.x;
            int y = node.y;

            if (x == m - 1 && y == n - 1) {
                return diff;
            }

            for (int[] dir : dirs) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n) {
                    int newDiff = Math.max(diff, Math.abs(height[x][y] - height[x_][y_]));
                    if (result[x_][y_] > newDiff) {
                        result[x_][y_] = newDiff;
                        pq.offer(new Info(newDiff, x_, y_));
                    }
                }
            }
        }

        return result[m - 1][n - 1];

    }

    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));

        for (int num : nums) {
            sum += num;
            pq.offer((double) num);
        }

        double halfSum = sum / 2;
        double reducedSum = sum;
        int steps = 0;

        while (reducedSum > halfSum) {
            double largest = pq.poll();
            double halved = largest / 2;
            reducedSum -= halved;
            pq.offer(halved);
            steps++;
        }

        return steps;
    }

    static Node mergeKList(Node[] arr, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

        Node head = new Node(0);
        Node last = head;

        for (int i = 0; i < K; i++) {
            if (arr[i] != null) {
                pq.add(arr[i]);
            }
        }

        if (pq.isEmpty()) {
            return null;
        }
        while (!pq.isEmpty()) {

            Node curr = pq.poll();
            last.next = curr;
            last = last.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return head.next;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int k = 3, n = 3;
        Node[] arr = new Node[k];

        Node root1 = new Node(1);
        arr[0] = root1;
        root1.next = new Node(3);
        root1.next.next = new Node(7);

        Node root2 = new Node(2);
        arr[1] = root2;
        root2.next = new Node(4);
        root2.next.next = new Node(8);

        Node root3 = new Node(9);
        arr[2] = root3;
        root3.next = new Node(10);
        root3.next.next = new Node(11);

        Node res = mergeKList(arr, n);

        if (res != null) {
            printList(res);
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class NodeComparator implements Comparator<Node> {

    public int compare(Node k1, Node k2) {
        if (k1.data > k2.data) {
            return 1;
        } else if (k1.data < k2.data) {
            return -1;
        }

        return 0;
    }
}