/*
 * @lc app=leetcode id=3440 lang=java
 *
 * [3440] Reschedule Meetings for Maximum Free Time II
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {

        // Step 1: Compute freeTime (gaps between events)

        int n = startTime.length;
        int[] freeTime = new int[n + 1];

        freeTime[0] = startTime[0];

        for (int i = 1; i < n; i++) {
            freeTime[i] = startTime[i] - endTime[i - 1];
        }
        freeTime[n] = eventTime - endTime[n - 1];

        int m = freeTime.length;
        int[] maxRightFree = new int[m];
        int[] maxLeftFree = new int[m];

        // Step 2: Precompute max free to the right
        for (int i = m - 2; i >= 0; i--) {
            maxRightFree[i] = Math.max(maxRightFree[i + 1], freeTime[i + 1]);
        }

        // Step 3: Precompute max free to the left
        for (int i = 1; i < m; i++) {
            maxLeftFree[i] = Math.max(maxLeftFree[i - 1], freeTime[i - 1]);
        }

        int result = 0;

        // Step 4: Iterate for each possible movement/shift
        for (int i = 1; i < m; i++) {
            int currEventTime = endTime[i - 1] - startTime[i - 1];

            // Case 1: Move completely out
            if (currEventTime <= Math.max(maxLeftFree[i - 1], maxRightFree[i])) {
                result = Math.max(result, freeTime[i - 1] + currEventTime + freeTime[i]);
            }

            // Case 2: Shift left or right
            result = Math.max(result, freeTime[i - 1] + freeTime[i]);
        }

        return result;
    }
}
// @lc code=end
