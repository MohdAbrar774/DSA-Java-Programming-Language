/*
 * @lc app=leetcode id=3439 lang=java
 *
 * [3439] Reschedule Meetings for Maximum Free Time I
 */

// @lc code=start
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        int freeTime[] = new int[endTime.length + 1];

        freeTime[0] = startTime[0];
        for (int i = 1; i < startTime.length; i++) {

            freeTime[i] = startTime[i] - endTime[i - 1];

        }

        freeTime[startTime.length] = eventTime - endTime[endTime.length - 1];

        int i = 0;
        int j = 0;
        int maxSum = 0;
        int currSum = 0;
        int n = freeTime.length;

        //SLIDING_WINDOW WITH KHANDANI TEMPLATE 
        while (j < n) {
            currSum += freeTime[j];

            while (i < n && j - i + 1 > k + 1) {

                currSum -= freeTime[i];
                i++;
            }

            maxSum = Math.max(maxSum, currSum);
            j++;

        }

        return maxSum;
    }
}
// @lc code=end
