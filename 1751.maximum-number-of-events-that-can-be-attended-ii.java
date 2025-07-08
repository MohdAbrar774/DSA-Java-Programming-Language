/*
 * @lc app=leetcode id=1751 lang=java
 *
 * [1751] Maximum Number of Events That Can Be Attended II
 */

// @lc code=start
class Solution {
     int n;
    int[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));  // Sort by start time
        n = events.length;
        dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(events, 0, k);
    }

    private int solve(int[][] events, int i, int k) {
        if (k <= 0 || i >= n) return 0;

        if (dp[i][k] != -1) return dp[i][k];

        int nextIndex = findNext(events, events[i][1], i + 1);
        int take = events[i][2] + solve(events, nextIndex, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    // Optional: Binary Search for efficiency
    private int findNext(int[][] events, int currentEnd, int left) {
        int right = n - 1;
        int answer = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > currentEnd) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
// @lc code=end

