import java.util.*;

public class MINIMUM_ARRAYS_JUMPS {

    public static int minJumps(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int steps = nums[i];

            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }
        return dp[0];

    }


    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 1, 4};

        System.out.println(minJumps(nums));
    }
}
