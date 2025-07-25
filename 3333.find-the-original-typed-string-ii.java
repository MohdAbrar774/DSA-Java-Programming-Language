/*
 * @lc app=leetcode id=3333 lang=java
 *
 * [3333] Find the Original Typed String II
 */

// @lc code=start
class Solution {
   
       int M = (int)1e9 + 7;

    public int possibleStringCount(String word, int k) {
        if (k > word.length()) return 0;

        List<Integer> freq = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                freq.add(count);
                count = 1;
            }
        }
        freq.add(count);

        long P = 1; // total possible strings
        for (int f : freq) {
            P = (P * f) % M;
        }

        if (freq.size() >= k) return (int) P;

        int n = freq.size();
        int[][] dp = new int[n + 1][k + 1];

        for (int i = k - 1; i >= 0; i--) {
            dp[n][i] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] prefix = new int[k + 2];
            for (int h = 1; h <= k; h++) {
                prefix[h] = (prefix[h - 1] + dp[i + 1][h - 1]) % M;
            }

            for (int c = k - 1; c >= 0; c--) {
                int l = c + 1;
                int r = c + freq.get(i);

                if (r + 1 > k) {
                    r = k - 1;
                }

                if (l <= r) {
                    dp[i][c] = (prefix[r + 1] - prefix[l] + M) % M;
                }
            }
        }

        long invalidCount = dp[0][0];
        return (int)((P - invalidCount + M) % M);
    }
    
}
// @lc code=end

