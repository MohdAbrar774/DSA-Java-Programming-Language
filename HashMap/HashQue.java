import java.util.*;

public class HashQue {

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

    static class info {
        Node node;
        int hd;

        public info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {

                // For Bottom view UpDATE the previous node for the key if exist or add key with
                // its node
                // Same code except this line for the top view
                map.put(curr.hd, curr.node);

                if (curr.node.left != null) {
                    q.add(new info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }

                if (curr.node.right != null) {
                    q.add(new info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> twoSum(int arr[], int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            
            if(map.containsKey(target-arr[i])){
                ans.add(map.get(target-arr[i]));
                ans.add(i);
            }else{
                map.put(arr[i], i);
                
            }
        }

          return ans;
    
    
    
    }

    public static void main(String[] args) {
        int arr[] = {2, 2};
        int target = 4;

        System.out.println(twoSum(arr, target));
    }

}
