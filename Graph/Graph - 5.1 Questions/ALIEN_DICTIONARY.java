import java.util.*;

class ALIEN_DICTIONARY {
    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static ArrayList<Integer> topSortCheck(ArrayList<Edge>[] graph, int[] indeg) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topSort = new ArrayList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            topSort.add(curr);

            for (Edge e : graph[curr]) {
                indeg[e.dest]--;
                if (indeg[e.dest] == 0)
                    q.add(e.dest);
            }
        }

        return topSort;
    }

    public static String findOrder(String[] words) {
        Set<Character> charSet = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                charSet.add(ch);
            }
        }

        int k = charSet.size();

        // Map characters to index
        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<Integer, Character> indexToChar = new HashMap<>();
        int idx = 0;
        for (char ch : charSet) {
            charToIndex.put(ch, idx);
            indexToChar.put(idx, ch);
            idx++;
        }

        ArrayList<Edge>[] graph = new ArrayList[k];
        for (int i = 0; i < k; i++)
            graph[i] = new ArrayList<>();
        int[] indeg = new int[k];

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int len = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return ""; // invalid case
            }

            for (int j = 0; j < len; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1 != c2) {
                    int u = charToIndex.get(c1);
                    int v = charToIndex.get(c2);
                    graph[u].add(new Edge(u, v));
                    indeg[v]++;
                    break;
                }
            }
        }

        ArrayList<Integer> topSort = topSortCheck(graph, indeg);
        if (topSort.size() < k)
            return ""; // cycle exists or disconnected

        StringBuilder ans = new StringBuilder();
        for (int i : topSort) {
            ans.append(indexToChar.get(i));
        }

        return ans.toString();
    }


    public static void main(String[] args) {
        String[] alienDict = {"addbb", "dadcc", "cabb", "ba", "a", "a"};

        System.out.println(findOrder(alienDict));
    }
}
