import java.util.*;

public class COUNT_SUBARRAY_WHERE_MAX_ELEMENT_APPEARS_K_TIMES {
    // Approach-1 (Classic sliding window)
    // T.C : O(n)
    // S.C : O(1)
    static class Solution1 {
        public long countSubarrays(int[] nums, int k) {
            int maxEle = Arrays.stream(nums).max().getAsInt();

            int n = nums.length;
            int i = 0, j = 0;

            long result = 0;
            int countMax = 0;

            while (j < n) {
                if (nums[j] == maxEle) {
                    countMax++;
                }

                while (countMax >= k) {
                    result += n - j;

                    if (nums[i] == maxEle) {
                        countMax--;
                    }
                    i++;
                }
                j++;
            }

            return result;
        }
    }

    // Approach-2 (Without Sliding Window)
    // T.C : O(n)
    // S.C : O(n)
    static class Solution2 {
        public long countSubarrays(int[] nums, int k) {
            int maxEle = Arrays.stream(nums).max().getAsInt();

            int n = nums.length;

            long result = 0;

            List<Integer> maxIndices = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (nums[i] == maxEle) {
                    maxIndices.add(i);
                }

                int size = maxIndices.size();
                if (size >= k) {
                    int last_i = maxIndices.get(size - k);
                    result += last_i + 1;
                }
            }

            return result;
        }
    }

}