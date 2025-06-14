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

    public static String findOrder(String[] words, int k, int N) {
        Set<Character> charSet = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                charSet.add(ch);
            }
        }

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

        for (int i = 0; i < N - 1; i++) {
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

    public static boolean isAlienSorted(String[] dict, String order) {
        Map<Character, Integer> rank = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            rank.put(order.charAt(i), i);
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];

            boolean found = false;
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    if (rank.get(c1) > rank.get(c2))
                        return false;
                    found = true;
                    break;
                }
            }

            // Prefix issue: longer word comes before its prefix
            if (!found && word1.length() > word2.length())
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] alienDict = { "addbb", "dadcc", "cabb", "ba", "a", "a" };
        int N = 6, K = 4;

        String order = findOrder(alienDict, K, N);

        boolean isValid = isAlienSorted(alienDict, order);

        System.out.println(isValid ? 1 : 0);

    }
}
