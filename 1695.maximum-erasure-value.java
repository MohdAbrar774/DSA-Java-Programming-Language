/*
 * @lc app=leetcode id=1695 lang=java
 *
 * [1695] Maximum Erasure Value
 */

// @lc code=start
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
            int n = nums.length;

        Set<Integer> s = new HashSet<>();

        int i = 0, j = 0;

        int Sum = 0;
        int result = 0;

        while (j < n) {
            if (!s.contains(nums[j])) {
                Sum += nums[j];
                s.add(nums[j]);
                result = Math.max(Sum, result);
                j++;
            } else {
                while (i < n && s.contains(nums[j])) {
                    Sum -= nums[i];
                    s.remove(nums[i]);
                    i++;
                }
            }

        }

        return result;
    }
}
// @lc code=end

