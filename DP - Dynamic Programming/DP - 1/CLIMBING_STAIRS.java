public class CLIMBING_STAIRS {

    // Memoization -->O(n) || recursion-->O(2^n)
    public static int climbStairs(int n, int[] ways) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != 0) {
            return ways[n];
        }

        ways[n] = climbStairs(n - 1, ways) + climbStairs(n - 2, ways);

        return ways[n];
    }

    // Tabulation --> O(n)
    public static int climbStairsTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {

                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String args[]) {
        int n = 5;
        int[] ways = new int[n + 1];
        System.out.println(climbStairs(n, ways));
        System.out.println(climbStairsTab(n));

    }
}
