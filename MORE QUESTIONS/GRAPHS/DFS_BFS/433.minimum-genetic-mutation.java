/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start

import java.util.*;

class Solution {

    static class Pair {
        String word;
        int steps;

        public Pair(String str, int s) {
            this.word = str;
            this.steps = s;

        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(startGene, 0));

        Set<String> st = new HashSet<>();

        for (int i = 0; i < bank.length; i++) {
            st.add(bank[i]);
        }
        st.remove(startGene);

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            String str = curr.word;
            int step = curr.steps;

            if (str.equals(endGene) == true) {
                return step;
            }

            for (int i = 0; i < str.length(); i++) {
                for (char ch = 'A'; ch <= 'Z'; ch++) {

                    char[] strToChar = str.toCharArray();

                    strToChar[i] = ch;

                    String replacedStr = new String(strToChar);

                    if (st.contains(replacedStr) == true) {
                        st.remove(replacedStr);
                        q.add(new Pair(replacedStr, step + 1));
                    }

                }
            }
        }
        return -1;

    }
}
// @lc code=end
